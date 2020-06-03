package cn.fyzzz.quickstart.config.security;

import cn.fyzzz.quickstart.common.enumeration.ResultEnum;
import cn.fyzzz.quickstart.model.pojo.SysResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fyzzz
 * 2020/6/3 9:36
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler  {


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //先设置编码，再获取输出流
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        PrintWriter out = response.getWriter();
        out.write(mapper.writeValueAsString(SysResult.getInstance(ResultEnum.PERMISSION_DENIED)));
        out.flush();
        out.close();
    }

}
