package me.luajk.login;

import com.google.gson.Gson;
import me.luajk.utils.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginDeniedHandler implements AccessDeniedHandler {

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setContentType("application/json");

        PrintWriter writer;
        String result = new Gson().toJson(new Result(false, "您没有权限"));
        writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}