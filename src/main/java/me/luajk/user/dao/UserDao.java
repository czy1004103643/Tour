package me.luajk.user.dao;

import me.luajk.user.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    User getUserById(String id);

    User getUserByUsername(String username);

    boolean isExist(String username);

    void addUser(User user);

    void updateUser(User user);

    void updatePassword(User user);
}
