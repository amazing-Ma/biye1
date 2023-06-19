package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.service.UploadService;
import com.example.demo.utilsEneity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    UploadService uploadService;


    @PostMapping("/upload")
    public R<String> uploadFile(@RequestBody MultipartFile file){
        String filePath = uploadService.upload(file);
        return R.ok(filePath);
    }


}
