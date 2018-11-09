package com.service.impl;

import com.dao.TsBorrowerInfoMapper;
import com.entity.TsBorrowerInfo;
import com.service.TsBorrowerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-20
 */

@Service
public class TsBorrowerInfoServiceImpl implements TsBorrowerInfoService{
    @Autowired
    private TsBorrowerInfoMapper tsBorrowerInfoMapper;

    @Override
    public Integer insertTsBorrowerInfo(TsBorrowerInfo tsBorrowerInfo) {
        return tsBorrowerInfoMapper.insertTsBorrowerInfo(tsBorrowerInfo);
    }
}
