package com.service.impl;

import com.entity.TsAssetInfo;
import com.entity.TsBorrowerInfo;
import com.service.TransactionService;
import com.service.TsAssetInfoService;
import com.service.TsBorrowerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by
 *
 * @author :   zhang
 * @date :   2018-08-21
 */

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TsAssetInfoService tsAssetInfoService;
    @Autowired
    private TsBorrowerInfoService tsBorrowerInfoService;

    @Override
    @Transactional
    public Integer insertAssetAndBorrowerInfo(TsAssetInfo tsAssetInfo, TsBorrowerInfo tsBorrowerInfo) {
        tsBorrowerInfoService.insertTsBorrowerInfo(tsBorrowerInfo);
        tsAssetInfo.setTs_borrower_info_id(tsBorrowerInfo.getId());
        tsAssetInfoService.insertTsAssetInfo(tsAssetInfo);
        return 1;
    }
}
