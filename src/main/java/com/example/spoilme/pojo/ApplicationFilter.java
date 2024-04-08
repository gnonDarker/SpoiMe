package com.example.spoilme.pojo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

@Data
public class ApplicationFilter extends Page<AdoptionApplication> {
    private List<String> statusIn;
}
