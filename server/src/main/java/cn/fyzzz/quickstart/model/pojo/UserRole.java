package cn.fyzzz.quickstart.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色信息
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer createUserId;

    private Integer updateUserId;


}
