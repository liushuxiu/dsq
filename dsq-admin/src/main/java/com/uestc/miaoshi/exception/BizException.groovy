package com.uestc.miaoshi.exception

import groovy.transform.CompileStatic

/**
 * 业务异常类
 *
 * @Project: billing-center
 * @Author: Guankai.Feng on 2019-07-15
 * */
@CompileStatic
class BizException extends RuntimeException {

    BizException() {
    }

    BizException(String message) {
        super(message)
    }
}
