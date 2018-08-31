package com.message.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.message.entity.Dept;
import com.message.mapper.DeptMapper;
import com.message.service.IDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.message.vo.DeptTreeVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author Liu
 * @since 2018-08-29
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {


    @Override
    public List<DeptTreeVo> findDeptWithLevel(Integer level) {
        List<Dept> models = baseMapper.findDeptWithLevel(level);
        List<DeptTreeVo> vos = new ArrayList<>();
        models.forEach(dept -> {
            DeptTreeVo vo = DeptTreeVo.builder().id(dept.getId()).name(dept.getName()).build();
            Wrapper wrapper = Condition.create().eq("p_id", dept.getId());
            Page page = new Page();
            baseMapper.selectPage(page, wrapper);
            vo.setHasChild(page.getTotal() > 0);
            vos.add(vo);
        });
        return vos;
    }


    @Override
    public DeptTreeVo findAllDeptTree() {
        List<Dept> models = baseMapper.selectList(null);
        ListMultimap<String, Dept> values = LinkedListMultimap.create();
        for (Dept dept : models) {
            values.put(String.valueOf(dept.getPId()), dept);
        }
        DeptTreeVo dept = DeptTreeVo.builder().name("顶级部门").id(0).build();
        loopAllTreeNode(dept, values);
        return dept;
    }


    /**
     * 递归算法
     */
    private void loopAllTreeNode(DeptTreeVo parentNode, ListMultimap<String, Dept> values) {
        List<Dept> levelDept = values.get(String.valueOf(parentNode.getId()));
        List<DeptTreeVo> childNodes = new ArrayList<>();
        levelDept.forEach(value -> {
            DeptTreeVo vo = DeptTreeVo.builder().id(value.getId()).name(value.getName()).build();
            childNodes.add(vo);
        });
        parentNode.setHasChild(!childNodes.isEmpty());
        parentNode.setChilds(childNodes);
        childNodes.forEach(value -> {
            loopAllTreeNode(value, values);
        });
    }


}
