package com.message.service;

import com.message.entity.Dept;
import com.baomidou.mybatisplus.service.IService;

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


    public List<Dept> findDeptWithLevel(Integer level);

}
