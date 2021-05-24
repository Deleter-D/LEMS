package edu.whpu.controller;

import edu.whpu.pojo.User;
import edu.whpu.service.Impl.LoginServiceImpl;
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
    LoginServie loginService;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("loginname") String loginname, @RequestParam("password") String password, HttpSession session, ModelAndView mv) {
        User user = loginService.login(loginname, password);
        if (user != null) {
            session.setAttribute("user", user);
            mv.setViewName("redirect:/");
        } else {
            System.out.println("登录失败");
            mv.addObject("message", "账号或密码错误，请重新输入");
            mv.setViewName("forward:/loginForm");
        }

        return mv;
    }
}
