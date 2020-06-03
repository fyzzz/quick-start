package cn.fyzzz.quickstart.service.impl;

import cn.fyzzz.quickstart.model.pojo.UserUserRole;
import cn.fyzzz.quickstart.mapper.UserUserRoleMapper;
import cn.fyzzz.quickstart.service.UserUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-03
 */
@Service
public class UserUserRoleServiceImpl extends ServiceImpl<UserUserRoleMapper, UserUserRole> implements UserUserRoleService {

}
