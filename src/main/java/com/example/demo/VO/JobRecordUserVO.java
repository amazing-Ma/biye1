package com.example.demo.VO;

import com.example.demo.eneity.PartTimeJob;
import com.example.demo.eneity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JobRecordUserVO extends PartTimeJob {

    private List<User> userList = new ArrayList<>();


}
