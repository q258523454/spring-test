package com.dao;

import com.entity.TsAssetInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface TsAssetInfoMapper {
    Integer insertTsAssetInfo(TsAssetInfo tsAssetInfo);
}