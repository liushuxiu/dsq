package com.uestc.miaoshi.exception

import groovy.transform.CompileStatic

/**
 * @project billing-center
 * @author zhaoguiyang on 2019-07-22.
 */
@CompileStatic
class RefundException extends BizException {

    RefundException(String message) {
        super(message)
    }

}
