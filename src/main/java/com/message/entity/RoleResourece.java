package com.message.entity;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色资源
 * </p>
 *
 * @author Liu
 * @since 2018-08-29
 */
@Data
@Accessors(chain = true)
@TableName("sys_role_resourece")
public class RoleResourece extends Model<RoleResourece> {

    private static final long serialVersionUID = 1L;

    /**
     * #
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色编号
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 资源编号
     */
    @TableField("resource_id")
    private Integer resourceId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private Date createDate;
    /**
     * 更新时间
     */
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;
    /**
     * 操作者
     */
    private Integer operator;
    /**
     * 备注
     */
    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
