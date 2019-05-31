package com.project.mall.controller;

import com.project.mall.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {
    @ResponseBody
    @PostMapping("/file/upload")
    public String uploadPicture(@RequestParam(value = "file")MultipartFile file){
       /* String result="";
        if(file.isEmpty())
            System.out.println("文件为空");
        else {
            String filename=file.getOriginalFilename();
            String suffername=filename.substring(filename.lastIndexOf('.'));
            String path="F:\\java\\javaWorkplace\\project\\mall\\src\\main\\resources\\static\\img\\";
            filename=UUID.randomUUID()+suffername;
            File dest=new File(path+filename);
            result=filename;
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return  result;*/
        String path="F:\\java\\javaWorkplace\\project\\mall\\src\\main\\resources\\static\\img\\";
       String result=FileUtils.upload(file,path);
       return result;
    }
}
