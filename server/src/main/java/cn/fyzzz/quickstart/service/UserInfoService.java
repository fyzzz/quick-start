package cn.fyzzz.quickstart.service;

import cn.fyzzz.quickstart.model.pojo.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-02
 */
public interface UserInfoService extends IService<UserInfo>, UserDetailsService {

}
