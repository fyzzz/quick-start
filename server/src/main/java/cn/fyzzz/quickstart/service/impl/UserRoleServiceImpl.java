package cn.fyzzz.quickstart.service.impl;

import cn.fyzzz.quickstart.model.pojo.UserRole;
import cn.fyzzz.quickstart.mapper.UserRoleMapper;
import cn.fyzzz.quickstart.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-03
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
