package me.luajk.login;

import com.google.gson.Gson;
import me.luajk.user.service.UserService;
import me.luajk.utils.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private UserService userService;

    private RequestCache requestCache = new HttpSessionRequestCache();

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        String username = authentication.getName();
        request.getSession().setAttribute("user", userService.getUserByUsername(username));
        request.getSession().removeAttribute("flag");
        if (savedRequest == null) {
            String result = new Gson().toJson(new Result(true, ""));
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            writer.write(result);
            writer.flush();
            writer.close();
        } else {
            String url = savedRequest.getRedirectUrl();
            String result = new Gson().toJson(new Result(true, url));
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            writer.write(result);
            writer.flush();
            writer.close();
        }
    }
}