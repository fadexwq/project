package cn.ego.manager.controller;


import cn.ego.base.vo.UploadResult;
import cn.ego.manager.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/pic/upload")
    public UploadResult upload(MultipartFile uploadFile){

        System.out.println("--文件上传--" + uploadFile);

        return uploadService.upload(uploadFile);

    }

}
