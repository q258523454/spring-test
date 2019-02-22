package com.service;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-22
 */
public interface TransactionalService {
    void publicMethod();

    void callOwnPublicMethod();

    void transInMethod();
}
