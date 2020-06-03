package cn.fyzzz.quickstart.model.pojo;

import cn.fyzzz.quickstart.common.constant.GlobalConstant;
import cn.fyzzz.quickstart.common.enumeration.ResultEnum;
import lombok.Data;

/**
 * @author fyzzz
 * 2020/6/1 10:46
 */
@Data
public class SysResult {

    private Integer status;

    private String errorCode;

    private String errorInfo;

    private Object data;

    private SysResult(){}

    public static SysResult ok(){
        return getInstance(ResultEnum.SUCCESS);
    }

    public static SysResult ok(Object data){
        SysResult ok = ok();
        ok.setData(data);
        return ok;
    }

    public static SysResult error(String errorInfo){
        return error(ResultEnum.SYSTEM_ERROR.getErrorCode(),errorInfo);
    }

    public static SysResult error(String errorCode,String errorInfo){
        SysResult error = new SysResult();
        error.setStatus(GlobalConstant.FAILURE);
        error.setErrorCode(errorCode);
        error.setErrorInfo(errorInfo);
        return error;
    }

    public static SysResult getInstance(ResultEnum resultEnum){
        SysResult instance = new SysResult();
        instance.setStatus(resultEnum.getStatus());
        instance.setErrorCode(resultEnum.getErrorCode());
        instance.setErrorInfo(resultEnum.getErrorInfo());
        return instance;
    }


}
