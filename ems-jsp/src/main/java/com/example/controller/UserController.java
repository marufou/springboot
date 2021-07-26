package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.parsing.GenericTokenParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    /**
     * 用户登录
     *
     */
    @RequestMapping("login")
    public String login(String username,String password,String code,HttpSession session) throws UnsupportedEncodingException {
        log.debug("接受验证码",code);
        log.debug("接收到的用户名：{},接收到的密码:{}",username,password);
        try {
            String sessionCode = session.getAttribute("code").toString();
            if(!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("验证码错误");
            User user = userService.login(username, password);
            //登录成功 保存用户信息
            session.setAttribute("user",user);

        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/login.jsp?msg="+URLEncoder.encode(e.getMessage(),"UTF8");
        }
        return "redirect:/index.jsp";
    }

    /**
     * 用来生成随机验证码方法
     */
    @RequestMapping("generateImageCode")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws IOException {
//        1.生成随机字符串
        String code = VerifyCodeUtils.generateVerifyCode(4);
//        2.保存到session
        session.setAttribute("code",code);
//        3.将随机字符串生成图片
//        4.通过response相应图片
        response.setContentType("image/png");//指定相应类型
        ServletOutputStream os = response.getOutputStream();
        VerifyCodeUtils.outputImage(200,80,os,code);
//        换一张
//        ${pageContext.request.contextPath}/user/generateImageCode?+(new Date()).getTime()
    }

    @RequestMapping("register")
    public String register(User user, String code, HttpSession session) throws UnsupportedEncodingException {
        log.debug("接收到验证码",code);
        log.debug("用户名：{}  ,真实姓名：{},密码：{},性别：{}",user.getUsername(),user.getRealname(),user.getPassword(),user.getGender());
        try {
            //1.比较验证是否一致
            String sessionCode = session.getAttribute("code").toString();
            if(!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("输入验证码错误 ");
            //注册用户
            userService.register(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/register.jsp?msg=" + URLEncoder.encode(e.getMessage(),"UTF-8");
        }
        return "redirect:/login.jsp";

    }

}
