package com.project.mall.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
    public static String upload(MultipartFile file, String destinationPath){
        String filename=file.getOriginalFilename();
        String suffix=filename.substring(filename.lastIndexOf('.'));
        String prefix=UUID.randomUUID().toString();
        prefix.replace("-","");
        filename=prefix+suffix;
        File dest=new File(destinationPath+filename);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        else {
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                return "upload failed";
            }
        }
        return filename;
    }
}
