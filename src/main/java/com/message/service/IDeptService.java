package com.message.service;

import com.message.entity.Dept;
import com.baomidou.mybatisplus.service.IService;
import com.message.vo.DeptTreeVo;

import java.util.List;

/**
 * <p>
 * 部门 服务类
 * </p>
 *
 * @author Liu
 * @since 2018-08-29
 */
public interface IDeptService extends IService<Dept> {


    /**
     * 根据等级，获取当前等级的节点
     */
    public List<DeptTreeVo> findDeptWithLevel(Integer level);


    /**
     * 获取所有层级节点
     */
    public DeptTreeVo findAllDeptTree();

}
