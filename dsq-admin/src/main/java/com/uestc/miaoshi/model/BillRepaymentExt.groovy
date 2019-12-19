package com.uestc.miaoshi.model

import groovy.transform.CompileStatic

@CompileStatic
class BillRepaymentExt {
    public static final String REBALANCE_SUFFIX = '-V'
    public static final String COUPON_SUFFIX = '-D'
    public static final String REFUND_SUFFIX = '-C'
    public static final String UPFRONT_SERVICE_FEE_SUFFIX = '-S'
    public static final String WRITE_OFF_SUFFIX = '-N'

    String repaymentId
    String billId
    BigDecimal amount = BigDecimal.ZERO
    BigDecimal principalAmount = BigDecimal.ZERO
    BigDecimal insuranceFee = BigDecimal.ZERO
    BigDecimal interestAmount = BigDecimal.ZERO
    BigDecimal serviceFee = BigDecimal.ZERO
    BigDecimal overpaidAmount = BigDecimal.ZERO

    /** 逾期滞纳金滞纳金 */
    BigDecimal overdueFee = BigDecimal.ZERO
    /** 逾期期间利息 */
    BigDecimal overdueInterest = BigDecimal.ZERO
    Boolean deleted
    Long repaymentTimestamp
    Long createTimestamp
    Long updateTimestamp

    /** 还款类型 */
    RepaymentType repaymentType

    BigDecimal calculateAndSetAmountByDetailAmounts() {
        amount = principalAmount + insuranceFee + interestAmount + serviceFee + overdueFee + overdueInterest + overpaidAmount
    }

    boolean isNormalRepayment() {
        return !repaymentId.contains('-')
    }

    boolean isFromWriteOff() {
        return repaymentId.endsWith(WRITE_OFF_SUFFIX)
    }

    boolean isFromCoupon() {
        return repaymentId.endsWith(COUPON_SUFFIX)
    }

    boolean isFromUpfrontServiceFee() {
        return repaymentId.endsWith(UPFRONT_SERVICE_FEE_SUFFIX)
    }

    boolean isFromRefund() {
        return repaymentId.endsWith(REFUND_SUFFIX)
    }

    boolean isFromRebalance() {
        return repaymentId.endsWith(REBALANCE_SUFFIX)
    }

    enum RepaymentType {
        NORMAL,
        COUPON,
        REFUND,
        REBALANCE,
        UPFRONT_SERVICE_FEE,
        WRITE_OFF
    }

}
