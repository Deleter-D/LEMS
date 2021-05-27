package edu.whpu.controller;

import edu.whpu.pojo.User;
import edu.whpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public ModelAndView userList(ModelAndView mv, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<User> userList = userService.getUserList();
        request.setAttribute("userlist", userList);
        if (user.getU_identity().equals("1")) {
            mv.setViewName("user/list");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping(value = "/add")
    public ModelAndView userAdd(ModelAndView mv, String id, HttpSession session, HttpServletRequest request) {
        if (id != null) {
            int u_ID = Integer.parseInt(id);
            User user = userService.getUserById(u_ID);
            request.setAttribute("editUser", user);
            mv.setViewName("user/add");
            return mv;
        }
        User user = (User) session.getAttribute("user");
        if (user.getU_identity().equals("1")) {
            mv.setViewName("user/add");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping(value = "/usersubmit")
    @ResponseBody
    public ModelAndView useraddSubmit(ModelAndView mv, User user) {
        int flag = 0;
        List<User> userList = userService.getUserList();
        for (User userInList : userList) {
            if (userInList.getU_account().equals(user.getU_account())) {
                // 1为更新
                flag = 1;
            }
        }
        if (flag == 0) {
            int i = userService.addUser(user);
            System.out.println("添加" + i + "名用户");
            mv.setViewName("/user/add");
            return mv;
        } else {
            int i = userService.updateUser(user);
            System.out.println("更新" + i + "名用户");
            mv.setViewName("/user/list");
            return mv;
        }
    }

    @RequestMapping("/deleteuser")
    public ModelAndView deleteUser(ModelAndView mv, String id) {
        int u_ID = Integer.parseInt(id);
        int i = userService.deleteUser(u_ID);
        System.out.println("删除" + i + "名用户");
        mv.setViewName("/user/list");
        return mv;
    }
}
