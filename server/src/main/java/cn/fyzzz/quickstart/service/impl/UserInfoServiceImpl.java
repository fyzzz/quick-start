package cn.fyzzz.quickstart.service.impl;

import cn.fyzzz.quickstart.model.pojo.UserInfo;
import cn.fyzzz.quickstart.mapper.UserInfoMapper;
import cn.fyzzz.quickstart.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-02
 */
@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo query = new UserInfo();
        query.setUsername(username);
        UserInfo user = baseMapper.selectOne(new QueryWrapper<>(query));
        if(user == null){
            throw new UsernameNotFoundException("帐号不存在！");
        }
        return user;
    }
}
