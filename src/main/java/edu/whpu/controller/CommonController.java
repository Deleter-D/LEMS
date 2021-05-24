package edu.whpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

    @RequestMapping("/")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/loginForm")
    public ModelAndView loginForm(ModelAndView mv) {
        mv.setViewName("loginForm");
        return mv;
    }


}
