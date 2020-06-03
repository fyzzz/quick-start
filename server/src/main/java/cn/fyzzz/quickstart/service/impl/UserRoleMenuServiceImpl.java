package cn.fyzzz.quickstart.service.impl;

import cn.fyzzz.quickstart.model.pojo.UserRoleMenu;
import cn.fyzzz.quickstart.mapper.UserRoleMenuMapper;
import cn.fyzzz.quickstart.service.UserRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单表 服务实现类
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-03
 */
@Service
public class UserRoleMenuServiceImpl extends ServiceImpl<UserRoleMenuMapper, UserRoleMenu> implements UserRoleMenuService {

}
