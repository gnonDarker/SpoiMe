package com.example.spoilme.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AdoptionFilter {
    private String petNameLike;
    private String sexEq;
    private String sterilizationEq;
    private String areaLike;
    private String varietyLike;
    private String vaccinationLike;
    private List<String> statusIn;
    private Date timeStart;
    private Date timeEnd;
}
