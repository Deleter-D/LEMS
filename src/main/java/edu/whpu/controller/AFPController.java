package edu.whpu.controller;

import edu.whpu.pojo.AForP;
import edu.whpu.pojo.User;
import edu.whpu.service.AFPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/afp")
public class AFPController {

    @Autowired
    AFPService afpService;

    // 该方法可将 yyyy-MM-dd 格式的字符串转换为Date类型的数据，从而能使springMVC自动将其封装进该实例中
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/list")
    public ModelAndView afpList(ModelAndView mv, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        List<AForP> afpList = afpService.getAFPList();
        request.setAttribute("afpList", afpList);
        if (user.getU_identity().equals("1")) {
            mv.setViewName("/afp/list");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }
}
