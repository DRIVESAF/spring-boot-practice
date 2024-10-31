package io.drivesaf.springboot.file.controller;

import io.drivesaf.springboot.file.utils.OssTemplate;
import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import io.drivesaf.springboot.file.utils.MinIoTemplate;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 * @author: DRIVESAF
 * @createTime: 2024/10/31 16:12
 * @description:
 **/
@RestController
@RequestMapping(value = "/file")
@Slf4j
public class FileUploadController {
    @Value("${file.upload-path}")
    private String uploadPath;

    private DateFormat df = new SimpleDateFormat("yyyyMMdd");

    @Resource
    private MinIoTemplate minIoTemplate;

    @Resource
    private OssTemplate ossTemplate;

    /**
     * 本地文件上传
     *
     * @param file    文件对象
     * @param request 请求对象
     * @return 文件上传后的地址
     */
    @PostMapping("/native")
    public String nativeUpload(MultipartFile file, HttpServletRequest request) {
        if (file != null) {
            String today = df.format(new Date());
            // 创建上传的子目录
            File folder = new File(uploadPath + "/" + today);
            if (!folder.exists()) {
                boolean flag = folder.mkdirs();
                log.info(String.valueOf(flag));
            }
            // 对上传的文件重命名，例如 abc.123.jpg > rjksjfkdjfdfdffkdsa.jpg
            String oldFileName = file.getOriginalFilename();
            assert oldFileName != null;
            int index = oldFileName.lastIndexOf(".");
            String suffixName = oldFileName.substring(index);
            log.info("文件后缀名：{}", suffixName);
            String newFileName = UUID.randomUUID() + suffixName;
            log.info("新的文件名：{}", newFileName);
            // 文件上传
            try {
                file.transferTo(new File(folder, newFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 拼接访问地址
            return request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/" + today + "/" + newFileName;
        } else {
            return "文件不能为空";
        }
    }

    /**
     * MinIO 文件上传
     *
     * @param file 文件对象
     * @return 文件地址
     */
    @PostMapping("/minio")
    public String minioUpload(MultipartFile file) {
        if (file != null) {
            String url;
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            try {
                url = minIoTemplate.putObject("mqxu", "img/" + UUID.randomUUID() + suffixName, file.getInputStream());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return url;
        } else {
            return "文件不能为空";
        }
    }

    /**
     * oss
     ⽂件上传     * @param file
     ⽂件对象     * @return
     ⽂件上传后的地址     */
    @PostMapping("/oss")
    public String ossUpload(MultipartFile file) {
        return ossTemplate.ossUpload(file);
    }
}