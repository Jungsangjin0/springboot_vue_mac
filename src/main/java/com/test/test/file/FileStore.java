package com.test.test.file;

import com.test.test.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileStore {

   @Value("${file.dir}")
    private String fileDir;

   //full 경로 반환
   public String getFullPath(String fileName) {
       return fileDir + fileName;
   }

   

    /**
     * 파일 저장
     * @param file multipartFile
     * @return
     */
   public UploadFile storeFile(MultipartFile file) throws IOException {
       //multipartfile를 받아 직접 저장 후 upload file return

       if(file.isEmpty()) {
           return null;
       }

       //upload 파일 실제 이름
       String originFileName = file.getOriginalFilename();

       //확장자 추출
       String storeFileName = createStroeFileName(originFileName);
       //파일 저장
       file.transferTo(new File(getFullPath(storeFileName)));

       return new UploadFile(originFileName, storeFileName);

   }

    private String createStroeFileName(String originFileName) {
        String ext = extractExt(originFileName);
        //서버에 저장하는 파일명
        return UUID.randomUUID().toString().replace("-", "") + ext;
    }

    private String extractExt(String originFileName) {
        int pos = originFileName.lastIndexOf(".");
        return originFileName.substring(pos); // ex) .png, .gif ...

    }


}
