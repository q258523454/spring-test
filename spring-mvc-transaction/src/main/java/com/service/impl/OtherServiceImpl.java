package com.service.impl;

import com.service.OtherService;
import com.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-22
 */
@Service
public class OtherServiceImpl implements OtherService {
    @Autowired
    private TransactionalService transactionalService;


    @Override
    public void publicCallPrivateWhichCallSpringBeanTrans() {
        privateMethodCallSpringBeanTrans();
    }

    private void privateMethodCallSpringBeanTrans() {
        transactionalService.publicMethod();
    }
}
