package edu.whpu.controller;

import edu.whpu.pojo.LPA;
import edu.whpu.pojo.User;
import edu.whpu.service.LPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/lpa")
public class LPAController {

    @Autowired
    LPAService lpaService;

    @RequestMapping("/list")
    public ModelAndView LPAList(ModelAndView mv, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<LPA> lpaList = lpaService.getLPAList();
        request.setAttribute("lpaList", lpaList);
        if (user.getU_identity().equals("1")) {
            mv.setViewName("/lpa/list");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }
}
