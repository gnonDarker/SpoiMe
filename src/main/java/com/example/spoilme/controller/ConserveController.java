package com.example.spoilme.controller;

import afu.org.checkerframework.checker.igj.qual.I;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spoilme.pojo.Adoption;
import com.example.spoilme.pojo.Conserve;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.ConserveService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * 养护服务控制层
 */
@RestController
public class ConserveController {

    @Resource
    ConserveService conserveService;

    /**
     * 创建服务
     */
    @PostMapping("/conserve/save")
    public Result saveConserve(@RequestBody Conserve resquestParam){
        conserveService.saveConserve(resquestParam);
        return Result.success();
    }
    /**
     * 修改服务
     */
    @PostMapping("/conserve/update")
    public Result updateConserve(@RequestBody Conserve resquestParam){
        conserveService.updateConserve(resquestParam);
        return Result.success();
    }
    /**
     * 删除服务
     */
    @GetMapping("/conserve/delete")
    public Result deleteConserve(@RequestParam("conserveId") String conserveId){
        conserveService.deleteConserve(conserveId);
        return Result.success();
    }
    /**
     * 分页查询分组下服务
     */
    @GetMapping("/conserve/list")
    public Result listConserve(@RequestParam long size,
                               @RequestParam long current,
                               @RequestParam String gid){
        Page<Conserve> page=new Page<>(current,size);
        return Result.success(conserveService.listConserve(page, gid));
    }

    /**
     *获取服务详情
     */
    @GetMapping("/conserve/detail")
    public Result detailConserve(@RequestParam("conserveId") Integer conserveId){
        return Result.success(conserveService.detailConserve(conserveId));
    }
}
