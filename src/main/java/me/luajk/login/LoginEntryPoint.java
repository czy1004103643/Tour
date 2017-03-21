package me.luajk.login;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public LoginEntryPoint() {
        super("/login.jsp");
        super.setUseForward(true);
    }

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (request.getSession().getAttribute("flag") == null) {
            request.setAttribute("msg", "请先登录");
        } else {
            request.getSession().removeAttribute("flag");
        }
        super.commence(request, response, authException);
    }
}
