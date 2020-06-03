package cn.fyzzz.quickstart.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer roleId;

    /**
     * 创建人id
     */
    private Integer createUserId;

    private LocalDateTime createTime;


}
