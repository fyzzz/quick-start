package cn.fyzzz.quickstart.service.impl;

import cn.fyzzz.quickstart.model.pojo.UserPermission;
import cn.fyzzz.quickstart.mapper.UserPermissionMapper;
import cn.fyzzz.quickstart.service.UserPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 功能表 服务实现类
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-03
 */
@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements UserPermissionService {

}
