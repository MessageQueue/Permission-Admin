package com.message.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import com.message.service.IResourceService;
import com.message.entity.Resource;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.message.common.BaseResponse;

import java.util.List;

/**
 * <p>
 * 资源 前端控制器
 * </p>
 *
 * @author Liu
 * @since 2018-08-29
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {



    private IResourceService targetService;

    @Autowired
    public ResourceController(IResourceService targetService){
        this.targetService = targetService;
    }


    /**
     * 获取数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResponse findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex,@RequestParam(name = "rows", defaultValue = "20") int step){
        Page page = new Page(pageIndex,step);
        targetService.selectPage(page);
        return BaseResponse.onSuccess(page);
    }


    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public BaseResponse findAll(){
        Page page = new Page();
        targetService.selectPage(page);
        return BaseResponse.onSuccess(page);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public BaseResponse find(@RequestParam("id") Long id){
        Resource Resource = targetService.selectById(id);
        if(Resource==null){
            return BaseResponse.onFail("尚未查询到此ID");
        }
        return BaseResponse.onSuccess(Resource);
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse addItem(@RequestBody Resource Resource){
        boolean isOk = targetService.insert(Resource);
        if(isOk){
            return BaseResponse.onSuccess("数据添加成功！");
        }
        return BaseResponse.onFail("数据添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateItem(@RequestBody Resource Resource){
        boolean isOk = targetService.updateAllColumnById(Resource);
        if(isOk){
            return BaseResponse.onSuccess("数据更改成功！");
        }
        return BaseResponse.onFail("数据更改失败");
     }


    /**
     * 删除数据
     */
    @RequestMapping("/del")
    @ResponseBody
    public BaseResponse deleteItems(@RequestParam("ids") List<Long> ids){
        boolean isOk = targetService.deleteBatchIds(ids);
        if(isOk){
            return BaseResponse.onSuccess("数据删除成功！");
        }
        return BaseResponse.onFail("数据删除失败");
        }
    }

