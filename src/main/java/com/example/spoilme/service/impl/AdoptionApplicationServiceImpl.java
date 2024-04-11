package com.example.spoilme.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spoilme.exception.ServiceException;
import com.example.spoilme.mapper.AdoptionApplicationMapper;
import com.example.spoilme.pojo.AdoptionApplication;
import com.example.spoilme.pojo.ApplicationFilter;
import com.example.spoilme.service.AdoptionApplicationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdoptionApplicationServiceImpl extends ServiceImpl<AdoptionApplicationMapper, AdoptionApplication> implements AdoptionApplicationService {



    @Override
    public void apply(AdoptionApplication adoptionApplication) {
        adoptionApplication.setStatus("unaudited");
        adoptionApplication.setCreateTime(new Date());
        adoptionApplication.setDelFlag(0);
        baseMapper.insert(adoptionApplication);
    }

    @Override
    public void rejectApply(Integer id, String cause) {
        LambdaQueryWrapper<AdoptionApplication> queryWrapper = Wrappers.<AdoptionApplication>lambdaQuery().eq(AdoptionApplication::getId, id);
        AdoptionApplication aa = baseMapper.selectOne(queryWrapper);
        if(aa==null){
            throw new ServiceException("-1","领养申请不存在");
        }
        aa.setStatus("reject");
        aa.setCause(cause);
        aa.setUpdateTime(new Date());
        baseMapper.update(aa,queryWrapper);
    }

    @Override
    public void approveApply(Integer id) {
        LambdaQueryWrapper<AdoptionApplication> queryWrapper = Wrappers.<AdoptionApplication>lambdaQuery().eq(AdoptionApplication::getId, id);
        AdoptionApplication aa = baseMapper.selectOne(queryWrapper);
        if(aa==null){
            throw new ServiceException("-1","领养申请不存在");
        }
        aa.setStatus("audited");
        aa.setUpdateTime(new Date());
        baseMapper.update(aa,queryWrapper);
    }

    @Override
    public Page<AdoptionApplication> queryApplication(ApplicationFilter filter) {
        LambdaQueryWrapper<AdoptionApplication> queryWrapper = Wrappers.lambdaQuery(AdoptionApplication.class)
                .in(AdoptionApplication::getStatus, filter.getStatusIn())
                .eq(AdoptionApplication::getDelFlag, 0)
                .orderByDesc(AdoptionApplication::getCreateTime);
        return baseMapper.selectPage(filter, queryWrapper);
    }

    @Override
    public void cancelApplication(Integer id) {
        LambdaQueryWrapper<AdoptionApplication> queryWrapper = Wrappers.lambdaQuery(AdoptionApplication.class)
                .in(AdoptionApplication::getId, id)
                .eq(AdoptionApplication::getDelFlag, 0);
        AdoptionApplication adoptionApplication = baseMapper.selectOne(queryWrapper);
        if(adoptionApplication == null){
            throw new ServiceException("-1","领养申请不存在");
        }
        adoptionApplication.setDelFlag(1);
        baseMapper.update(adoptionApplication,queryWrapper);
    }
}
