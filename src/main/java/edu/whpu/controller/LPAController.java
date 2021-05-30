package edu.whpu.controller;

import edu.whpu.pojo.LPA;
import edu.whpu.pojo.User;
import edu.whpu.service.LPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lpa")
public class LPAController {

    @Autowired
    LPAService lpaService;

    // 该方法可将 yyyy-MM-dd 格式的字符串转换为Date类型的数据，从而能使springMVC自动将其封装进该实例中
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

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

    @RequestMapping("/add")
    public ModelAndView LPAAdd(ModelAndView mv, String id, HttpSession session, HttpServletRequest request) {
        List<User> adminList = lpaService.getAdminList();
        request.setAttribute("adminList", adminList);

        if (id != null) {
            int lpa_ID = Integer.parseInt(id);
            LPA lpa = lpaService.getLPAById(lpa_ID);
            request.setAttribute("editLPA", lpa);
            mv.setViewName("/lpa/add");
            return mv;
        }

        User user = (User) session.getAttribute("user");
        if (user.getU_identity().equals("1")) {
            mv.setViewName("lpa/add");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping("/lpasubmit")
    public ModelAndView LPASubmit(ModelAndView mv, LPA lpa) {
        int flag = 0;
        List<LPA> lpaList = lpaService.getLPAList();
        for (LPA lpaInList : lpaList) {
            if (lpaInList.getLpa_ID() == lpa.getLpa_ID()) {
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            int i = lpaService.addLPA(lpa);
            System.out.println("添加" + i + "个低值耗材");
            mv.setViewName("/lpa/add");
            return mv;
        } else {
            int i = lpaService.updateLPA(lpa);
            System.out.println("更新" + i + "名用户");
            mv.setViewName("/lpa/list");
            return mv;
        }

    }

    @RequestMapping("/delete")
    public ModelAndView deleteLPA(ModelAndView mv, String id) {
        int lpa_ID = Integer.parseInt(id);
        int i = lpaService.deleteLPA(lpa_ID);
        System.out.println("删除" + i + "个低值耗材");
        mv.setViewName("/lpa/list");
        return mv;
    }
}
