package com.example.spoilme.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.spoilme.pojo.Conserve;

public interface ConserveService extends IService<Conserve> {
    void saveConserve(Conserve resquestParam);

    void updateConserve(Conserve resquestParam);

    void deleteConserve(String conserveId);

    Page<Conserve> listConserve(Page<Conserve> page, String gid);

    Conserve detailConserve(Integer conserveId);
}
