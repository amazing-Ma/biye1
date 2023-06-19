package com.example.demo.VO;

import com.example.demo.eneity.PartTimeJob;
import com.example.demo.eneity.User;
import lombok.Data;

import java.util.List;

@Data
public class JobCreaterVO extends User {

    List<PartTimeJob> partTimeJobList;

    int jobNumber;


}
