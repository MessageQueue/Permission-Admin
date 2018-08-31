package com.message.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * describe:
 *
 * @author Liu
 * @since 2018/08/31
 */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptTreeVo {
    /**
     * 主键
     */
    private long id;

    /**
     * 节点名称
     */
    private String name;
    /**
     * 是否包含下级
     */
    private boolean hasChild;


    private List<DeptTreeVo> childs;
}
