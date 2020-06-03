package cn.fyzzz.quickstart.common.enumeration;

import cn.fyzzz.quickstart.common.constant.GlobalConstant;

/**
 * @author fyzzz
 * 2020/6/3 9:39
 */
public enum  ResultEnum {
    /**
     * 成功
     */
    SUCCESS(GlobalConstant.SUCCESS,"",""),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(GlobalConstant.FAILURE,"500","系统错误"),

    /**
     * 登录失败
     */
    LOGIN_FAILURE(GlobalConstant.FAILURE,"401","登录失败"),
    /**
     * 未登录
     */
    NOT_LOGIN(GlobalConstant.FAILURE,"401","您未登录，请先登录。"),
    /**
     * 登录超时
     */
    LOGIN_TIMEOUT(GlobalConstant.FAILURE,"401","登录信息过期，请重新登录。"),

    /**
     * 权限不足
     */
    PERMISSION_DENIED(GlobalConstant.FAILURE,"401","权限不足");

    private Integer status;
    private String errorCode;
    private String errorInfo;

    ResultEnum(Integer status, String errorCode, String errorInfo) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }
}
