package me.luajk.login;

import com.google.gson.Gson;
import me.luajk.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginFailHandler implements AuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        response.setContentType("application/json");

        PrintWriter writer;
        String result = new Gson().toJson(new Result(false, "账户或密码错误"));
        writer = response.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}