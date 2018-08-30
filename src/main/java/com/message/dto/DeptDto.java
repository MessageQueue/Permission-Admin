package com.message.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * describe:
 *
 * @author Liu
 * @since 2018/08/30
 */


@Data
public class DeptDto {
    /**
     * 名称
     */
    @NotBlank(message = "部门名称不能为空")
    @Length(min = 2, max = 25, message = "部门名称在2~25个字符之间")
    private String name;
    /**
     * 全称
     */
    @NotBlank(message = "部门全称不能为空")
    @Length(min = 4, max = 25, message = "部门全称在4~25个字符之间")
    private String fullname;

    /**
     * 上级部门
     */
    @JsonProperty("pId")
    @Min(value = 0, message = "上级部门格式不正确")
    private Integer pId = 0;

    /**
     * 状态
     */
    @Max(value = 1, message = "部门状态不正确")
    @Min(value = 0, message = "部门状态不正确")
    private Integer status = 1;

    /**
     * 备注
     */
    @NotBlank(message = "部门备注不能为空")
    @Length(min = 4, max = 50, message = "部门备注在4~50个字符之间")
    private String remark;

}
