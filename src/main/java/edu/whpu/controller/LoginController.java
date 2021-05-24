package edu.whpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("loginForm");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login()
}
