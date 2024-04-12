package com.example.spoilme.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spoilme.mapper.GroupMapper;
import com.example.spoilme.pojo.Conserve;
import com.example.spoilme.pojo.Group;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.service.GroupService;
import com.example.spoilme.utils.RandomIdentifierGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 短连接分组接口实现层
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

    @Override
    public void saveGroup(Group requestParm) {
        String gid;
        gid = RandomIdentifierGenerator.generateGroupID();

        Group group=Group.builder()
                .gid(gid)
                .name(requestParm.getName())
                .background(requestParm.getBackground())
                .sortOrder(0)
                .build();
        baseMapper.insert(group);
    }

    @Override
    public List<Group> listGroup() {
        LambdaQueryWrapper<Group> queryWrapper = Wrappers.<Group>lambdaQuery()
                .eq(Group::getDelFlag, 0)
                .orderByDesc(Group::getSortOrder, Group::getUpdateTime);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public void updateGroup(Group requestParam) {
        LambdaQueryWrapper<Group> queryWrapper = Wrappers.<Group>lambdaQuery().eq(Group::getGid, requestParam.getGid())
                .eq(Group::getDelFlag, 0);
        Group Group = baseMapper.selectOne(queryWrapper);
        Group.setName(requestParam.getName());
        baseMapper.update(Group,queryWrapper);

    }

    @Override
    public void deleteGroup(String gid) {
        LambdaQueryWrapper<Group> queryWrapper = Wrappers.<Group>lambdaQuery().eq(Group::getGid, gid)
                .eq(Group::getDelFlag, 0);
        Group Group = baseMapper.selectOne(queryWrapper);
        Group.setDelFlag(1);
        baseMapper.update(Group,queryWrapper);
    }

    @Override
    public void sortGroup(List<Group> requestParam) {
        requestParam.forEach(each -> {
            LambdaUpdateWrapper<Group> updateWrapper = Wrappers.lambdaUpdate(Group.class)
                    .set(Group::getSortOrder, each.getSortOrder())
                    .eq(Group::getGid, each.getGid())
                    .eq(Group::getDelFlag, 0);
            update(updateWrapper);
        });
    }

    @Override
    public boolean hasGoup(String gid) {
        Group group = baseMapper.selectOne(Wrappers.lambdaUpdate(Group.class).eq(Group::getGid, gid).eq(Group::getDelFlag, 0));
        return group != null;
    }
}
