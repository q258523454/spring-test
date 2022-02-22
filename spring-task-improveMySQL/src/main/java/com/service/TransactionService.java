package com.service;

import com.entity.TsAssetInfo;
import com.entity.TsBorrowerInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by
 *
 * @author :   zhang
 * @date :   2018-08-21
 */

@Repository
public interface TransactionService {
    Integer insertAssetAndBorrowerInfo(TsAssetInfo tsAssetInfo, TsBorrowerInfo tsBorrowerInfo);
}
