package com.example.spoilme.service;

import com.example.spoilme.pojo.Adoption;

public interface AdoptionService {
    void publish(Adoption adoption);
    void modify(Adoption adoption);
    void delete(Integer id);
    void apply();
    void reject(Integer id,String cause);
    void approve(Integer id);
}
