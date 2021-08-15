package com.test.test.controller;


import com.test.test.dto.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@Slf4j
public class Testcontroller {

    private final Map<String, Board> map;

    @Value("${file.dir}")
    private String fileDir;

    public Testcontroller() {
        map = new HashMap<>();

        for(int i = 0; i < 20; i++) {
            Board board = Board.builder()
                                    .id(i)
                                    .title("title" + i)
                                    .content("content" + i)
                                    .date(new Date()).build();
            map.put(String.valueOf(i), board);
        }
    }

    @GetMapping("/test")
    public Map test() {
        return map;
    }

    @PostMapping("/upload")
    public void upload(@RequestParam(required = false) MultipartFile files, HttpServletRequest request) throws IOException {

        log.info(files.getName());


        String fullPath = fileDir + files.getOriginalFilename();

        log.info(fullPath);

        File file = new File(fullPath);
        files.transferTo(file);

//        //root path
//        String root = request.getSession().getServletContext().getRealPath("resources");
//
//        String filePath = root + "/uploadFiles";
//
//        log.info("root : {}", root);
//        log.info("filepath : {}", filePath);
//
//        File mkdir = new File(filePath); //해당 경로에 file 객체 생성
//        if(!mkdir.exists()) {
//            mkdir.mkdirs(); //해당 경로까지의 폴더 생성
//        }
//
//        //파일명 변경 처리
//        String originFileName = files.getOriginalFilename();
//        //확장자
//        String ext = originFileName.substring(originFileName.lastIndexOf("."));
//        String savedName = UUID.randomUUID().toString().replace("-", "") + ext; //저장할 파일 이름
//
//        log.info(originFileName);
//        log.info(savedName);
//
//        //파일 저장
//        try {
//            files.transferTo(new File(filePath + "/" + savedName));
//            return "upload 성공";
//        } catch (IOException e) {
//            e.printStackTrace();
//            //실패 시 파일 삭제
//            new File(filePath + "/" + savedName).delete();
//            return "업로드 실패";
    }
}
