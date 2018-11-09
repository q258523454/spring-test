package com.service;

import com.entity.TsBorrowerInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-20
 */

@Repository
public interface TsBorrowerInfoService {
    Integer insertTsBorrowerInfo(TsBorrowerInfo tsBorrowerInfo);
}
