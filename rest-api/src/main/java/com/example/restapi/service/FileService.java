package com.example.restapi.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    @Value("${image.file.path}")
    private String filePath;

    /**
     * 上传多个文件
     * @return
     */
    public List<String> uploadFiles(MultipartFile[] multipartFiles) throws IOException {
        List<String> fileNames = Lists.newArrayList();
        for (int i = 0 ; i < multipartFiles.length; i++){
             MultipartFile multipartFile = multipartFiles[i];
             if (!multipartFile.isEmpty()){
                 String fileName = this.UploadSimpleFile(multipartFile);
                 fileNames.add(fileName);
             }else {
                 throw new RuntimeException("文件为空,为空上传异常");
             }
        }
        return fileNames;
    }

    /**
     * 上传单个文件
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        return this.UploadSimpleFile(multipartFile);
    }

    /**
     * 上传文件
     * @param multipartFile
     * @return
     * @throws IOException
     */
    private String UploadSimpleFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()){
            throw new RuntimeException("文件为空,文件上传异常");
        }
        String name = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replace("-", "") + name;
        File file = new File(filePath + File.separator + fileName);
        multipartFile.transferTo(file);
        return fileName;
    }


}
