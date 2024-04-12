package com.example.spoilme.controller;

import com.example.spoilme.pojo.Group;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分组控制层
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 创建分组
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result saveGroup(@RequestBody Group requestParam){
        groupService.saveGroup(requestParam);
        return Result.success();
    }

    /**
     * 获取分组
     */
    @GetMapping("/api/short-link/admin/v1/group")
    public Result listGroup(){
        return Result.success(groupService.listGroup());
    }

    /**
     * 修改分组
     */
    @PutMapping("/api/short-link/admin/v1/group")
    public Result update(@RequestBody Group requestParam){
        groupService.updateGroup(requestParam);
        return Result.success();
    }

    /**
     * 删除分组
     */
    @DeleteMapping("/api/short-link/admin/v1/group")
    public Result delete(@RequestParam String gid){
        groupService.deleteGroup(gid);
        return Result.success();
    }

    /**
     * 分组排序
     */
    @PostMapping("/api/short-link/admin/v1/group/sort")
    public Result sort(@RequestBody List<Group> requestParam){
        groupService.sortGroup(requestParam);
        return Result.success();
    }
}
