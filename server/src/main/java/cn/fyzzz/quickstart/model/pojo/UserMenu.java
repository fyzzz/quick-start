package cn.fyzzz.quickstart.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author fyzzz
 * @since 2020-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单路径
     */
    private String menuUrl;

    /**
     * 排序字段
     */
    private Integer menuSort;

    /**
     * 菜单icon路径
     */
    private String menuIcon;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    private LocalDateTime createTime;


}
