package com.aiden.kpcon.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/uploadFile")
public class FilesUploadController {
    /**
     * 上传到本地
     * @param fileName old文件名
     * @param file 文件信息
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping(value = "/toLocalStorage",method = RequestMethod.POST)
    @ResponseBody
    public Object localStorage(String fileName,@RequestParam(value = "file") MultipartFile file) throws IllegalStateException,IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (file != null) {
            // 设置文件名称
            map.put("nameParam", fileName);
            // 设置文件名称
            map.put("filename", file.getName());
            // 设置文件类型
            map.put("contentType", file.getContentType());
            // 设置文件大小
            map.put("fileSize", file.getSize());
            // 创建文件名称
            String newFileName = UUID.randomUUID() + "."
                    + file.getContentType().substring(file.getContentType().lastIndexOf("/") + 1);
            // 设置本地路径
            String filePath = "D:"+File.separator+"wxImg"+File.separator+newFileName;
            // 打印保存路径
            System.out.println(filePath);
            // 创建文件
            File saveFile = new File(filePath);
            if(!saveFile.exists()){
                saveFile.mkdir();
            }
            // 保存文件的路径信息
            map.put("filePath", filePath);
            // 文件保存
            file.transferTo(saveFile);
            // 返回信息
            return map;
        } else {
            return "no file ";
        }
    }
}
