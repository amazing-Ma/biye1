package com.example.demo.VO;

import com.example.demo.eneity.PartTimeJob;
import lombok.Data;

@Data
public class PartTimeJobVO extends PartTimeJob {

    private String userName;

    private int jobNumber;
}
