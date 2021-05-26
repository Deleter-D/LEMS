package edu.whpu.controller;

import edu.whpu.pojo.User;
import edu.whpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public ModelAndView userlist(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<User> userList = userService.getUserList();
        request.setAttribute("userlist", userList);
        if (user.getU_identity().equals("1")) {
            mv.setViewName("user/list");
        } else {
            /*PrintWriter out = null;
            try {
                out = response.getWriter();
                out.print("<script>alert('对不起，您没有权限！')</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView useradd(ModelAndView mv, HttpServletResponse response, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user.getU_identity().equals("1")) {
            mv.setViewName("user/add");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }
}
