package com.example.spoilme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.spoilme.pojo.Group;


import java.util.List;

/**
 * 短连接分组接口层
 */
public interface GroupService extends IService<Group> {
    /**
     * 新增分组
     */
    void saveGroup(Group groupName);

    /**
     * 查询用户分组集合
     */
    List<Group> listGroup();

    /**
     * 修改分组名
     */
    void updateGroup(Group requestParam);

    void deleteGroup(String gid);

    void sortGroup(List<Group> requestParam);
}
