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
    @PostMapping("/conserve/group/save")
    public Result saveGroup(@RequestBody Group requestParam){
        groupService.saveGroup(requestParam);
        return Result.success();
    }

    /**
     * 获取分组
     */
    @GetMapping("/conserve/group/list")
    public Result listGroup(){
        return Result.success(groupService.listGroup());
    }

    /**
     * 修改分组
     */
    @PostMapping("/conserve/group/update")
    public Result update(@RequestBody Group requestParam){
        groupService.updateGroup(requestParam);
        return Result.success();
    }

    /**
     * 删除分组
     */
    @DeleteMapping("/conserve/group/delete")
    public Result delete(@RequestParam String gid){
        groupService.deleteGroup(gid);
        return Result.success();
    }

    /**
     * 分组排序
     */
    @PostMapping("/conserve/group/sort")
    public Result sort(@RequestBody List<Group> requestParam){
        groupService.sortGroup(requestParam);
        return Result.success();
    }
}
