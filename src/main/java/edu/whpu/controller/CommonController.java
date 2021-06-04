package edu.whpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CommonController {

    @RequestMapping("/")
    public ModelAndView loginForm(ModelAndView mv) {
        mv.setViewName("loginForm");
        return mv;
    }

    @RequestMapping("/userInfo")
    public ModelAndView userInfo(ModelAndView mv) {
        mv.setViewName("userInfo");
        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/welcome")
    public ModelAndView welcome(ModelAndView mv, HttpSession session) {
        Date currentTime = new Date(System.currentTimeMillis());
        String cTimeStr = new SimpleDateFormat("yyyy-MM-dd").format(currentTime);
        session.setAttribute("currentTime", cTimeStr);
        mv.setViewName("welcome");
        return mv;
    }
}
