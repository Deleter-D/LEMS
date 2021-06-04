package edu.whpu.controller;

import edu.whpu.pojo.User;
import edu.whpu.service.LoginServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginServie loginServie;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("loginname") String loginname, @RequestParam("password") String password, @RequestParam("identity") String identity, HttpSession session, ModelAndView mv) {
        User user = loginServie.login(loginname, password, identity);
        if (user != null) {
            session.setAttribute("user", user);
            mv.setViewName("/index");
        } else {
            System.out.println("登录失败");
            mv.addObject("message", "账号或密码错误，请重新输入");
            mv.setViewName("loginForm");
        }

        return mv;
    }

}
