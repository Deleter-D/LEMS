package edu.whpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TempController {

    @RequestMapping("/document/list")
    public ModelAndView documentlist(ModelAndView mv) {
        mv.setViewName("/document/list");
        return mv;
    }

    @RequestMapping("/document/add")
    public ModelAndView documentadd(ModelAndView mv) {
        mv.setViewName("/document/add");
        return mv;
    }
}
