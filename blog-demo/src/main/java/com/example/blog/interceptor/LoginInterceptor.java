package com.example.blog.interceptor;

import com.example.blog.constant.Constants;
import com.example.blog.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constants.REQUEST_HEADER_TOKEN);
        Claims claims = JwtUtils.parseToken(token);
        if (claims==null){
            //校验失败
            response.setStatus(401);
            return false;
        }
        return true;
    }

}
