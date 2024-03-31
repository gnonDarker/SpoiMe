package com.example.spoilme.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spoilme.exception.ServiceException;
import com.example.spoilme.mapper.AdoptionMapper;
import com.example.spoilme.pojo.Adoption;
import com.example.spoilme.pojo.AdoptionFilter;
import com.example.spoilme.service.AdoptionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdoptionServiceImpl implements AdoptionService {

    @Resource
    AdoptionMapper adoptionMapper;


    @Override
    public void publish(Adoption adoption) {
        adoption.setStatus("unaudited");
        adoption.setTime(new Date());
        adoptionMapper.insert(adoption);
    }


    @Override
    public void modify(Adoption adoption) {
        adoptionMapper.update(adoption, Wrappers.<Adoption>lambdaQuery().eq(Adoption::getId,adoption.getId()));
    }

    @Override
    public void delete(Integer id) {
        adoptionMapper.delete(Wrappers.<Adoption>lambdaQuery().eq(Adoption::getId,id));
    }

    @Override
    public void apply() {

    }

    @Override
    public void reject(Integer id, String cause) {
        Adoption adoption=adoptionMapper.selectOne(Wrappers.<Adoption>lambdaQuery().eq(Adoption::getId,id));
        if(adoption==null){
            throw new ServiceException("-1","领养信息不存在");
        }
        adoption.setStatus("reject");
        adoption.setCause(cause);
        adoptionMapper.update(adoption, Wrappers.<Adoption>lambdaQuery().eq(Adoption::getId,adoption.getId()));
    }

    @Override
    public void approve(Integer id) {
        Adoption adoption=adoptionMapper.selectOne(Wrappers.<Adoption>lambdaQuery().eq(Adoption::getId,id));
        if(adoption==null){
            throw new ServiceException("-1","领养信息不存在");
        }
        adoption.setStatus("audited");
        adoptionMapper.update(adoption, Wrappers.<Adoption>lambdaQuery().eq(Adoption::getId,adoption.getId()));
    }

    @Override
    public Adoption getDetails(Integer id) {
        Adoption adoption=adoptionMapper.selectOne(Wrappers.<Adoption>lambdaQuery().eq(Adoption::getId,id));
        if(adoption==null){
            throw new ServiceException("-1","领养信息不存在");
        }
        return adoption;
    }

    @Override
    public Page<Adoption> pageList(Page<Adoption> page,AdoptionFilter adoptionFilter) {
        QueryWrapper<Adoption> queryWrapper=new QueryWrapper<>();
        if(adoptionFilter!=null){
            if(adoptionFilter.getPetNameLike()!=null){
                queryWrapper.like("pet_name",adoptionFilter.getPetNameLike());
            }
            if(adoptionFilter.getSterilizationEq()!=null){
                queryWrapper.eq("sterilization",adoptionFilter.getSterilizationEq());
            }
            if(adoptionFilter.getSexEq()!=null){
                queryWrapper.eq("sex",adoptionFilter.getSexEq());
            }
            if(adoptionFilter.getAreaLike()!=null){
                queryWrapper.like("area",adoptionFilter.getAreaLike());
            }
            if(adoptionFilter.getVarietyLike()!=null){
                queryWrapper.like("variety",adoptionFilter.getVarietyLike());
            }
            if(adoptionFilter.getVaccinationLike()!=null){
                queryWrapper.like("vaccination",adoptionFilter.getVaccinationLike());
            }
            if(adoptionFilter.getAreaLike()!=null){
                queryWrapper.like("area",adoptionFilter.getAreaLike());
            }
            if(adoptionFilter.getTimeStart()!=null){
                queryWrapper.ge("time",adoptionFilter.getTimeStart());
            }
            if(adoptionFilter.getTimeEnd()!=null){
                queryWrapper.lt("time",adoptionFilter.getTimeEnd());
            }
            if(adoptionFilter.getStatusIn()!=null){
                queryWrapper.in("status",adoptionFilter.getStatusIn());
            }
        }
        return adoptionMapper.selectPage(page,queryWrapper);
    }
}
