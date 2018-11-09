package com.service.impl;

import com.dao.TsAssetInfoMapper;
import com.entity.TsAssetInfo;
import com.service.TsAssetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-20
 */

@Service
public class TsAssetInfoServiceImpl implements TsAssetInfoService {
    @Autowired
    private TsAssetInfoMapper tsAssetInfoMapper;
    @Override
    public Integer insertTsAssetInfo(TsAssetInfo tsAssetInfo) {
        return tsAssetInfoMapper.insertTsAssetInfo(tsAssetInfo);
    }

}
