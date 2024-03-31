package com.example.spoilme.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.spoilme.exception.ServiceException;
import com.example.spoilme.mapper.AdoptionMapper;
import com.example.spoilme.pojo.Adoption;
import com.example.spoilme.service.AdoptionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
