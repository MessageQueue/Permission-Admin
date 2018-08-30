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

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author Liu
 * @since 2018-08-29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("sys_dept")
public class Dept extends Model<Dept> {

    private static final long serialVersionUID = 1L;

    /**
     * #
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 全称
     */
    private String fullname;
    /**
     * 序列
     */
    private String sequeen;
    /**
     * 上级部门
     */
    @TableField("p_id")
    @JsonProperty("pId")
    private Integer pId;
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
    /**
     * 等级
     */
    private String levels;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
