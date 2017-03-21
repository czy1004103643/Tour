package me.luajk.user.service;

import me.luajk.user.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public interface UserService {

    User getUserByUsername(String username);

    User addUser(String username, String password, String nickName) throws Exception;

    User modifyUser(String id, String username, String realName, String nickName,
                    int sex, String phone, String email, String birthDate, MultipartFile photo) throws IOException, ParseException;

    void modifyPassword(String id, String password);
}
