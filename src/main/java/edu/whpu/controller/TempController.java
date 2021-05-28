package edu.whpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TempController {

    /*@RequestMapping("user/list")
    public ModelAndView userlist(ModelAndView mv) {
        mv.setViewName("user/list");
        return mv;
    }*/

//    @RequestMapping("/user/add")
//    public ModelAndView useradd(ModelAndView mv) {
//        mv.setViewName("/user/add");
//        return mv;
//    }

//    @RequestMapping("/dept/list")
//    public ModelAndView deptlist(ModelAndView mv) {
//        mv.setViewName("/dept/list");
//        return mv;
//    }
//
//    @RequestMapping("/dept/add")
//    public ModelAndView deptadd(ModelAndView mv) {
//        mv.setViewName("/dept/add");
//        return mv;
//    }

//    @RequestMapping("/job/list")
//    public ModelAndView joblist(ModelAndView mv) {
//        mv.setViewName("/job/list");
//        return mv;
//    }
//
//    @RequestMapping("/job/add")
//    public ModelAndView jobadd(ModelAndView mv) {
//        mv.setViewName("/job/add");
//        return mv;
//    }

    @RequestMapping("/employee/list")
    public ModelAndView employeelist(ModelAndView mv) {
        mv.setViewName("/employee/list");
        return mv;
    }

    @RequestMapping("/employee/add")
    public ModelAndView employeeadd(ModelAndView mv) {
        mv.setViewName("/employee/add");
        return mv;
    }

    @RequestMapping("/notice/list")
    public ModelAndView noticelist(ModelAndView mv) {
        mv.setViewName("/notice/list");
        return mv;
    }

    @RequestMapping("/notice/add")
    public ModelAndView noticeadd(ModelAndView mv) {
        mv.setViewName("/notice/add");
        return mv;
    }

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
