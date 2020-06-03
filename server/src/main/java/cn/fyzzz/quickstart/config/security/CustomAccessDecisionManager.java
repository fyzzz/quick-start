package cn.fyzzz.quickstart.config.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 *  访问权限控制
 *  判断登录用户是否有此url需要的角色
 * @author fyzzz
 * 2020/6/3 9:34
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication auth,
                       Object object,
                       Collection<ConfigAttribute> ca) throws AccessDeniedException, InsufficientAuthenticationException {

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for(ConfigAttribute configAttribute : ca){
            if("ROLE_NO_ROLE".equals(configAttribute.getAttribute())){
                throw new AccessDeniedException("权限不足");
            }
            if("ROLE_LOGIN".equals(configAttribute.getAttribute())
                    && auth instanceof UsernamePasswordAuthenticationToken){
                return;
            }
            for(GrantedAuthority authority : authorities){
                if(configAttribute.getAttribute().equals(authority.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
