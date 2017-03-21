package me.luajk.user.service.impl;

import me.luajk.user.dao.UserDao;
import me.luajk.user.model.User;
import me.luajk.user.service.UserService;
import me.luajk.utils.FileUtils;
import me.luajk.utils.IdGenerator;
import me.luajk.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public User addUser(String username, String password, String nickName) throws Exception {
        if (userDao.isExist(username)) {
            throw new Exception("用户名已存在");
        }
        String id = IdGenerator.getId();
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setNickName(nickName);
        userDao.addUser(user);
        return userDao.getUserById(id);
    }

    public User modifyUser(String id, String username, String realName, String nickName, int sex,
                           String phone, String email, String birthDate, MultipartFile photo) throws IOException, ParseException {
        String filename = null;
        if (photo != null) {
            if (StringUtils.isNotEmpty(photo.getOriginalFilename()))
                filename = FileUtils.transferFile(photo);
        }
        Date date = null;
        if (StringUtils.isNotEmpty(birthDate))
            date = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
//        User user = new User(id, null, username, realName, nickName, sex, phone, email, date, filename, 0);
//        userDao.updateUser(user);
        return userDao.getUserById(id);
    }

    public void modifyPassword(String id, String password) {
//        User user = new User(id, password, null, null, null, 0, null, null, null, null, 0);
//        userDao.updatePassword(user);
    }
}
