package com.util.ExceptionHandler;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.entity.ErrorMsgObject;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-17
 */


/*** 所有的 Controller 层的异常的日志记录，都是在这个 GlobalExceptionHandler 中进行记录
 * 优点：将 Controller 层的异常和数据校验的异常进行统一处理，减少模板代码，减少编码量，提升扩展性和可维护性。
 * 缺点：只能处理 Controller 层未捕获（往外抛）的异常，对于 Interceptor（拦截器）层的异常，Spring 框架层的异常，就无能为力了。
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * 设置要捕获的异常，并作出处理
     * 注意：这里可以返回试图，也可以放回JSON，这里就当做一个Controller使用
     * 接口有参数未传
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public JSONObject missActionParam(HttpServletRequest req, MissingServletRequestParameterException e) throws Exception {
        return errorMsg("接口有参数未传", req, e);
    }

    /**
     * 数字格式错误
     */
    @ExceptionHandler(value = NumberFormatException.class)
    @ResponseBody
    public JSONObject numberFormatError(HttpServletRequest req, NumberFormatException e) throws Exception {
        return errorMsg("数字格式错误", req, e);
    }

    /**
     * JSON格式解析错误
     */
    @ExceptionHandler(value = JSONException.class)
    @ResponseBody
    public JSONObject jsonError(HttpServletRequest req, JSONException e) throws Exception {
        return errorMsg("JSON格式解析错误", req, e);
    }

    /**
     * 服务器内部错误
     */
    @ExceptionHandler(value = NullPointerException.class)
    public String nullError(HttpServletRequest req, NullPointerException e) throws Exception {
        return "error"; // webapp/WEB-INF/html/views/error.jsp
    }


    /***
     * ResponseStatus: 指定网络状态码, 这里如果不指定, 那么HttpStatus=200
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public JSONObject scheduleError(HttpServletRequest req, Exception e) throws Exception {
        return errorMsg("数字格式错误", req, e);
    }

    /**
     * 构造错误信息
     *
     * @param msg 错误描述
     * @param e   异常信息
     * @return
     */
    private JSONObject errorMsg(String msg, HttpServletRequest req, Exception e) {

        ErrorMsgObject errorMsgObject = new ErrorMsgObject(msg, req, e);
        errorMsgObject.setStatus("failed");

        ErrorMsgObject logErrorMsgObejct = new ErrorMsgObject(msg, req, e);
        logErrorMsgObejct.setStatus("failed");
        logErrorMsgObejct.setUrl(req.getRequestURL().toString());
        logErrorMsgObejct.setField(req.getParameterMap());
        logErrorMsgObejct.setErrorMsg(e.getMessage());

        logger.error(JSONObject.toJSONString(logErrorMsgObejct), e);

        return JSONObject.parseObject(JSONObject.toJSONString(errorMsgObject));
    }

}
