package cn.fyzzz.quickstart.model.pojo;

import cn.fyzzz.quickstart.common.constant.GlobalConstant;
import lombok.Data;

/**
 * @author fyzzz
 * 2020/6/1 10:46
 */
@Data
public class SysResult {

    private Integer status;

    private String message;

    private Object data;

    private SysResult(){}

    public static SysResult ok(){
        SysResult ok = new SysResult();
        ok.setStatus(GlobalConstant.SUCCESS);
        return ok;
    }

    public static SysResult ok(Object data){
        SysResult ok = ok();
        ok.setData(data);
        return ok;
    }

    public static SysResult error(String message){
        SysResult error = new SysResult();
        error.setStatus(GlobalConstant.FAILURE);
        error.setMessage(message);
        return error;
    }

}
