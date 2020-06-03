package cn.fyzzz.quickstart.service.impl;

import cn.fyzzz.quickstart.model.pojo.UserMenu;
import cn.fyzzz.quickstart.mapper.UserMenuMapper;
import cn.fyzzz.quickstart.service.UserMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-03
 */
@Service
public class UserMenuServiceImpl extends ServiceImpl<UserMenuMapper, UserMenu> implements UserMenuService {

}
