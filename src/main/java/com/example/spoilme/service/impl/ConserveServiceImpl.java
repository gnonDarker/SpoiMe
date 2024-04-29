package com.example.spoilme.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spoilme.common.user.UserContext;
import com.example.spoilme.exception.ServiceException;
import com.example.spoilme.mapper.ConserveMapper;
import com.example.spoilme.pojo.Conserve;
import com.example.spoilme.service.ConserveService;
import com.example.spoilme.service.GroupService;
import com.example.spoilme.service.RescueStationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ConserveServiceImpl extends ServiceImpl<ConserveMapper, Conserve> implements ConserveService {

    @Resource
    GroupService groupService;

    @Resource
    RescueStationService rescueStationService;


    @Override
    public void saveConserve(Conserve resquestParam) {
        if(!groupService.hasGoup(resquestParam.getGid())){
            throw new ServiceException("-1", "分组不存在");
        }
        if (!rescueStationService.hasRescueStation(resquestParam.getRescueId())){
            throw new ServiceException("-1", "救助站不存在");
        }
        resquestParam.setUserId(UserContext.getUserId());
        baseMapper.insert(resquestParam);
    }

    @Override
    public void updateConserve(Conserve resquestParam) {
        baseMapper.update(resquestParam, Wrappers.lambdaUpdate(Conserve.class).eq(Conserve::getId, resquestParam.getId()));
    }

    @Override
    public void deleteConserve(String conserveId) {
        Conserve conserve = Conserve.builder().delFlag(1).build();
        baseMapper.update(conserve, Wrappers.lambdaUpdate(Conserve.class).eq(Conserve::getId, conserveId));
    }

    @Override
    public Page<Conserve> listConserve(Page<Conserve> page, String gid) {
        return baseMapper.selectPage(page, Wrappers.lambdaQuery(Conserve.class).eq(Conserve::getGid, gid).eq(Conserve::getDelFlag, 0));
    }

    @Override
    public Conserve detailConserve(Integer conserveId) {
        Conserve conserve = baseMapper.selectOne(Wrappers.lambdaQuery(Conserve.class).eq(Conserve::getId, conserveId).eq(Conserve::getDelFlag, 0));
        conserve.setRescueStation(rescueStationService.getRescueStation(conserve.getRescueId()));
        return conserve;
    }


}
