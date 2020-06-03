package cn.fyzzz.quickstart.config.security;

import cn.fyzzz.quickstart.common.enumeration.ResultEnum;
import cn.fyzzz.quickstart.model.pojo.SysResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.FilterInvocationSecurityMetadataSourceParser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.io.PrintWriter;

/**
 * @author fyzzz
 * 2020/6/1 10:45
 */
@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value = "userInfoService")
    private UserDetailsService userInfoService;

    @Autowired
    private AccessDecisionManager accessDecisionManager;
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userInfoService);
    }

    /**
     * 验证所有请求
     * 开放/login接口,参数 username password 类型post
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                        object.setAccessDecisionManager(accessDecisionManager);
                        return object;
                    }
                }).and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and()
                .formLogin()
                //自定义登录的url method=post
                .loginProcessingUrl("/login")
                //登录接口参数配置
                .usernameParameter("username")
                .passwordParameter("password")
                //自定义登录失败返回的json
                .failureHandler((request,response,e) -> {
                    ObjectMapper mapper = new ObjectMapper();
                    //先设置编码，再获取输出流
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    PrintWriter out = response.getWriter();
                    out.write(mapper.writeValueAsString(SysResult.getInstance(ResultEnum.LOGIN_FAILURE)));
                    out.flush();
                    out.close();
                })
                //自定义登录成功返回的json
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    ObjectMapper mapper = new ObjectMapper();
                    //先设置编码，再获取输出流
                    httpServletResponse.setStatus(HttpStatus.OK.value());
                    httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    PrintWriter out = httpServletResponse.getWriter();
                    out.write(mapper.writeValueAsString(SysResult.ok(authentication != null ? authentication.getPrincipal() : null)));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                //是否清除认证信息
                .clearAuthentication(true)
                //是否使session失效
                .invalidateHttpSession(true)
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    ObjectMapper mapper = new ObjectMapper();
                    //先设置编码，再获取输出流
                    httpServletResponse.setStatus(HttpStatus.OK.value());
                    httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    PrintWriter out = httpServletResponse.getWriter();
                    out.write(mapper.writeValueAsString(SysResult.ok()));
                    out.flush();
                    out.close();
                })
                .and()
                .sessionManagement()
                .invalidSessionStrategy((request,response) -> {
                    ObjectMapper mapper = new ObjectMapper();
                    //先设置编码，再获取输出流
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    PrintWriter out = response.getWriter();
                    out.write(mapper.writeValueAsString(SysResult.getInstance(ResultEnum.PERMISSION_DENIED)));
                    out.flush();
                    out.close();
                })
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((request,response,authException) -> {
                    ObjectMapper mapper = new ObjectMapper();
                    //先设置编码，再获取输出流
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    PrintWriter out = response.getWriter();
                    out.write(mapper.writeValueAsString(SysResult.getInstance(ResultEnum.NOT_LOGIN)));
                    out.flush();
                    out.close();
                })
                .and()
                .csrf().disable();
    }

    /**
     * 开放url
     * swagger页面不需要登录
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/swagger-ui.html")
                .antMatchers("/v2/**")
                .antMatchers("/webjars/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers(
                        "/index.html",
                        "/js/**",
                        "/css/**",
                        "/fonts/**",
                        "/image/**",
                        "/favicon.ico",
                        "/",
                        "/error");
    }

}
