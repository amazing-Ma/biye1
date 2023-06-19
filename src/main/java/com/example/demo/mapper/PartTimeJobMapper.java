package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.eneity.PartTimeJob;

import java.util.List;

public interface PartTimeJobMapper extends BaseMapper<PartTimeJob> {

    int getJobCountInt(Long id);

    List<PartTimeJob> getJobByCreater(String id);
}
