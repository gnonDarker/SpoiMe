package com.example.spoilme.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spoilme.pojo.AdoptionApplication;
import com.example.spoilme.pojo.ApplicationFilter;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.AdoptionApplicationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdoptionApplicationController {

    @Resource
    AdoptionApplicationService adoptionApplicationService;

    @PostMapping("/adoption/apply")
    public Result apply(@RequestBody AdoptionApplication requestParam){
        adoptionApplicationService.apply(requestParam);
        return Result.success();
    }

    @PostMapping("/adoption/rejectApply")
    public Result rejectApply(@RequestParam("applicationId") Integer id, @RequestParam("cause") String cause){
        adoptionApplicationService.rejectApply(id,cause);
        return Result.success();
    }

    @PostMapping("/adoption/approveApply")
    public Result approveApply(@RequestParam("applicationId") Integer id){
        adoptionApplicationService.approveApply(id);
        return Result.success();
    }

    @PostMapping("/adoption/queryApplication")
    public Result queryApplication(@RequestBody ApplicationFilter filter){
        return Result.success(adoptionApplicationService.queryApplication(filter));
    }

    @PostMapping("/adoption/cancelApplication")
    public Result cancelApplication(@RequestParam("applicationId") Integer id){
        adoptionApplicationService.cancelApplication(id);
        return Result.success();
    }
}
