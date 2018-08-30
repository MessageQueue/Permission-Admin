package com.message.mapper;

import com.message.entity.Dept;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 部门 Mapper 接口
 * </p>
 *
 * @author Liu
 * @since 2018-08-29
 */
public interface DeptMapper extends BaseMapper<Dept> {

    public List<Dept> findDeptWithLevel(Integer level);

}
