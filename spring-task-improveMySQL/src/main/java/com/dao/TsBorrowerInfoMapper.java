package com.dao;

import com.entity.TsBorrowerInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface TsBorrowerInfoMapper {

    Integer insertTsBorrowerInfo(TsBorrowerInfo tsBorrowerInfo);

}