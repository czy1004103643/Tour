package me.luajk.user.controller;

import me.luajk.user.model.User;
import me.luajk.user.service.UserService;
import me.luajk.utils.Result;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Resource
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping("userDetail")
    public ModelAndView userDetail() {
        return new ModelAndView("user/detail");
    }

    @RequestMapping("userInsertResult")
    @ResponseBody
    public Result userInsertResult(String rusername, String rpassword, String rnickName, HttpServletRequest request) {
        User user;
        try {
            user = userService.addUser(rusername, rpassword, rnickName);
            //自动登录
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        } catch (Exception e) {
            e.printStackTrace();
            if (e.getMessage().equals("用户名已存在")) {
                return new Result(false, "用户名已存在");
            }
            return new Result(false, "注册过程发生了错误，请联系管理员");
        }
        request.getSession().setAttribute("user", user);
        return new Result(true, "");
    }

    @RequestMapping("userModifyResult")
    @ResponseBody
    public Result userModifyResult(String id, String username, String realName, String nickName,
                                   int sex, String phone, String email, String birthDate, MultipartFile photo, HttpServletRequest request) {
        User user;
        try {
            user = userService.modifyUser(id, username, realName, nickName, sex, phone, email, birthDate, photo);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, "文件上传过程发生错误");
        } catch (ParseException e) {
            e.printStackTrace();
            return new Result(false, "日期格式转换发生错误");
        }
        request.getSession().setAttribute("user", user);
        return new Result(true, "修改成功");
    }

    @RequestMapping("pwdModify")
    public ModelAndView pwdModify() {
        return new ModelAndView("user/modify");
    }

    @RequestMapping("pwdModifyResult")
    @ResponseBody
    public Result userModifyResult(String id, String password, HttpServletRequest request) {
        try {
            userService.modifyPassword(id, password);
            request.getSession().removeAttribute("user");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
        SecurityContextHolder.getContext().setAuthentication(null);
        SecurityContextHolder.clearContext();
        request.getSession().setAttribute("flag","请重新登录");
        return new Result(true, "修改成功，请重新登录");
    }
}
