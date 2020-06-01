package cn.fyzzz.quickstart.service.impl;

import cn.fyzzz.quickstart.service.UserInfoService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author fyzzz
 * 2020/6/1 10:49
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
