package com.message.service.impl;

import com.message.entity.Dept;
import com.message.mapper.DeptMapper;
import com.message.service.IDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    public List<Dept> findDeptWithLevel(Integer level) {
        return baseMapper.findDeptWithLevel(level);
    }
}
