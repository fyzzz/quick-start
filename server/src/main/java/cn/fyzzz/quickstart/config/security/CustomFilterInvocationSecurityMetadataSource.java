package cn.fyzzz.quickstart.config.security;

import cn.fyzzz.quickstart.model.pojo.UserPermission;
import cn.fyzzz.quickstart.model.pojo.UserRole;
import cn.fyzzz.quickstart.service.UserPermissionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author fyzzz
 * 2020/6/3 10:10
 */
@Component
@AllArgsConstructor
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    private final UserPermissionService userPermissionService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        int index = requestUrl.indexOf('?');
        if(index>0){
            requestUrl = requestUrl.substring(0, index);
        }
        List<UserPermission> allPermissions = userPermissionService.list();
        for(UserPermission func : allPermissions){
            if(antPathMatcher.match(func.getPermissionUrl(),requestUrl)){
                // todo 获取权限的角色
                List<UserRole> roles = new ArrayList<>();
                if(roles.size() == 0){
                    return SecurityConfig.createList("ROLE_NO_ROLE");
                }
                String[] roleArr = new String[roles.size()];
                for(int i=0; i<roleArr.length; i++){
                    roleArr[i] = roles.get(i).getRoleName();
                }
                return SecurityConfig.createList(roleArr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
