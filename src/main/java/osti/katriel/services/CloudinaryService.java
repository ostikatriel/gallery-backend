package osti.katriel.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    Cloudinary cloudinary;
    Map<String, String> values=new HashMap<>();

    public CloudinaryService() {
        values.put("cloud_name", "dsw0ofipj");
        values.put("api_key", "411657742478133");
        values.put("api_secret", "R41GHSEn28Az4TWo1dIUb-O55zE");
        this.cloudinary = new Cloudinary(values);
    }

    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException {
        Map result=cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    public File convert(MultipartFile multipartFile) throws IOException {
        File file=new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }
}
