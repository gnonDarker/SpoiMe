package com.example.spoilme.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.spoilme.pojo.AdoptionApplication;
import com.example.spoilme.pojo.ApplicationFilter;

public interface AdoptionApplicationService extends IService<AdoptionApplication> {
    void apply(AdoptionApplication adoptionApplication);
    void rejectApply(Integer id,String cause);
    void approveApply(Integer id);
    Page<AdoptionApplication> queryApplication(ApplicationFilter filter);
    void cancelApplication(Integer id);
}
