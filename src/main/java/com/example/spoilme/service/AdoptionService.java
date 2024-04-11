package com.example.spoilme.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.spoilme.pojo.Adoption;
import com.example.spoilme.pojo.AdoptionFilter;

import java.util.List;

public interface AdoptionService {
    void publish(Adoption adoption);
    void modify(Adoption adoption);
    void delete(Integer id);
    void reject(Integer id,String cause);
    void approve(Integer id);
    Adoption getDetails(Integer id);
    Page<Adoption> pageList(Page<Adoption> page,AdoptionFilter adoptionFilter);
}
