package com.service;

import com.entity.TsAssetInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by
 *
 * @author :   zhang
 * @date :   2018-08-20
 */

@Repository
public interface TsAssetInfoService {
    Integer insertTsAssetInfo(TsAssetInfo tsAssetInfo);
}
