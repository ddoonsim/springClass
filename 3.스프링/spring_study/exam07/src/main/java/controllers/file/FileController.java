package controllers.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping("/upload")
    public String upload() {

        return "file/upload" ;
    }

    @PostMapping("/upload")
    public String uploadPs(@RequestParam("file") MultipartFile[] files) {

        for (MultipartFile file : files) {
            File uploadPath = new File("C:/uploads/" + file.getOriginalFilename());
            try {
                file.transferTo(uploadPath);  // 파일 지정 폴더로 업로드
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "file/upload" ;
    }
}
