package me.luajk.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUtils {

    public static String getExtension(String filename) {
        return FilenameUtils.getExtension(filename);
    }

    public static String transferFile(MultipartFile file) throws IOException {
//        String dir = "E:\\Workspace\\IDEA_Workspace\\travelGuide\\travelGuideManage\\src\\main\\webapp\\";
//        String dir1 = "E:\\Workspace\\IDEA_Workspace\\travelGuide\\travelGuide\\src\\main\\webapp\\";
//        String filename = null;
//        if (StringUtils.isNotEmpty(file.getOriginalFilename())) {
//            filename = "photo/" + new Date().getTime() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
//            File targetFile = new File(dir, filename);
//            file.transferTo(targetFile);
//            File targetFile1 = new File(dir1, filename);
//            file.transferTo(targetFile1);
//        }
        return file.getName();
    }
}
