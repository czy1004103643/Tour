package me.luajk.login;

import me.luajk.user.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthValidator implements AuthenticationProvider {

    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        me.luajk.user.model.User user;
        try {
            user = userService.getUserByUsername(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select error");
        }
        if (user == null) {
            throw new UsernameNotFoundException("user found error");
        }
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("password error");
        }
        int role = user.getRole();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (role == 0) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if (role == 1) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        } else if (role == 2) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ROOT"));
        }
        return new UsernamePasswordAuthenticationToken(new User(username, password, true, true, true, true, grantedAuthorities), password, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> arg) {
        return true;
    }
}
