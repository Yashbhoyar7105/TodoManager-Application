package com.lcwd.TodoManager.Controllers;


import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger= LoggerFactory.getLogger(FileController.class);

    @PostMapping("/single")
    public String uploadfile(@RequestParam("image") MultipartFile file){

        logger.info("file name  {}  ", file.getName());
        logger.info("file content{}  ", file.getContentType());
        logger.info(" original file name{}  ", file.getOriginalFilename());
        logger.info("file size{}  ", file.getSize());
        return "succesfully uploaded";
    }

    @PostMapping("/multiple")
    public String uploadMultiple(@RequestParam("files") MultipartFile[] files){
        Arrays.stream(files).forEach(file->{
            logger.info("File name  {}", file.getName());
            logger.info("File content  {}", file.getContentType());
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        });

        return "handling mulitiple file";
    }

    @GetMapping("/serve-image")
    public void imageUpload(HttpServletResponse response){

        try{
            FileInputStream fileInputStream = new FileInputStream("images/Screenshot (2).png");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream,response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
