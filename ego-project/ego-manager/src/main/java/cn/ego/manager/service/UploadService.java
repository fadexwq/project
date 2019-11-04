package cn.ego.manager.service;

import cn.ego.base.vo.UploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    /**
     * 上传文件到Ftp服务器
     * @param file
     * @return
     */
    UploadResult upload(MultipartFile file);
}
