package com.example.spoilme.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spoilme.pojo.Adoption;
import com.example.spoilme.pojo.AdoptionFilter;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.AdoptionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdoptionController {

    @Resource
    AdoptionService adoptionService;

    @PostMapping("/adoption/publish")
    public Result publish(@RequestBody Adoption adoption){
        adoptionService.publish(adoption);
        return Result.success();
    }

    @PostMapping("/adoption/modify")
    public Result modify(Adoption adoption){
        adoptionService.modify(adoption);
        return Result.success();
    }

    @PostMapping("/adoption/delete")
    public Result delete(Integer id){
        adoptionService.delete(id);
        return Result.success();
    }

    @PostMapping("/adoption/audit/show/reject")
    public Result reject(Integer id,String cause){
        adoptionService.reject(id,cause);
        return Result.success();
    }

    @PostMapping("/adoption/audit/show/approve")
    public Result approve(Integer id){
        adoptionService.approve(id);
        return Result.success();
    }

    @PostMapping("/adoption/getDetails")
    public Result getDetails(Integer id){
        return Result.success(adoptionService.getDetails(id));
    }

    @PostMapping("/adoption/query")
    public Result query(@RequestParam long pageSize,
                        @RequestParam long pageNum,
                        @RequestBody AdoptionFilter adoptionFilter){
        Page<Adoption> page=new Page<>(pageNum,pageSize);
        return Result.success(adoptionService.pageList(page,adoptionFilter));
    }
}
