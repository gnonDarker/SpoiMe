package com.example.spoilme.controller;


import com.example.spoilme.config.MinioProp;
import com.example.spoilme.mapper.UploadFileMapper;
import com.example.spoilme.pojo.Result;
import com.example.spoilme.pojo.UploadFile;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/minio")
public class MinioController {
    @Autowired
    private MinioClient minioClient;

    @Resource
    UploadFileMapper uploadFileMapper;

    @Autowired
    MinioProp minioProp;


    @PostMapping("/upload")
    public Result upload(@RequestParam(name = "file", required = false) MultipartFile[] file){
        if (file == null || file.length == 0) {
            return  Result.error("上传文件不能为空");
        }
        List<String> orgfileNameList = new ArrayList<>(file.length);
 
        for (MultipartFile multipartFile : file) {
            String timeStr = (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());
            String orgfileName = timeStr+"_"+multipartFile.getOriginalFilename();
            orgfileNameList.add(minioProp.getEndpoint()+"/"+minioProp.getBucket()+"/"+orgfileName);
 
            try {
                InputStream in = multipartFile.getInputStream();
                minioClient.putObject(minioProp.getBucket(), orgfileName, in, new PutObjectOptions(in.available(), -1));
                in.close();
            } catch (Exception e) {
                log.error(e.getMessage());
                return Result.error("上传失败");
            }
            UploadFile uploadFile=new UploadFile();
            uploadFile.setId(UUID.randomUUID().toString().replace("-",""));
            uploadFile.setUploadTime(new Date());
            uploadFile.setUrl(minioProp.getEndpoint()+"/"+minioProp.getBucket()+"/"+orgfileName);
            uploadFile.setFileName(orgfileName);
            uploadFileMapper.insert(uploadFile);
        }
 
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("fileUrl", orgfileNameList);
        return Result.success(data);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String fileName) {
        try {
            minioClient.removeObject(minioProp.getBucket(), fileName);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error("删除失败");
        }
        return Result.success();
    }

}