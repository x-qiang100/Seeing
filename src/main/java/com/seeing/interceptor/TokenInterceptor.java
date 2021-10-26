package com.seeing.interceptor;

import com.seeing.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TokenInterceptor implements HandlerInterceptor {

    private Logger logger =  LoggerFactory.getLogger(TokenInterceptor.class);

    /***
     * token设置
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        String token = request.getHeader("token");
        if(token == null){
                request.getRequestDispatcher("/user/tokenExpire").forward(request,response);
        }else {
            //验证
            boolean r = TokenUtil.verify(token);

            if(r){
                logger.info("已经通过拦截器");
                return true;
            }
        }
        return false;
    }


}
