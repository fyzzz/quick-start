package cn.fyzzz.quickstart.config.exception;

import cn.fyzzz.quickstart.model.pojo.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获
 * @author fyzzz
 * 2020/6/3 10:23
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    public SysResult errorHandler(Exception e){
        log.error(e.getMessage(),e);
        return SysResult.error(e.getMessage());
    }

}
