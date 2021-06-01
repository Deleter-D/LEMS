package edu.whpu.controller;

import edu.whpu.pojo.*;
import edu.whpu.service.AFLPAService;
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
@RequestMapping("/aflpa")
public class AFLPAController {

    @Autowired
    AFLPAService aflpaService;

    // 该方法可将 yyyy-MM-dd 格式的字符串转换为Date类型的数据，从而能使springMVC自动将其封装进该实例中
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/list")
    public ModelAndView aflpaList(ModelAndView mv, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        List<AForLPA> aflpaList = aflpaService.getAFLPAList();
        request.setAttribute("aflpaList", aflpaList);
        if (user.getU_identity().equals("1")) {
            mv.setViewName("/aflpa/list");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView aflpaAdd(ModelAndView mv, HttpServletRequest request) {
        List<LPA> LPAList = aflpaService.getAllLPA();
        List<Faculty> facultyList = aflpaService.getAllFaculty();
        request.setAttribute("LPAList", LPAList);
        request.setAttribute("facultyList", facultyList);

        mv.setViewName("/aflpa/add");
        return mv;
    }

    @RequestMapping("/aflpasubmit")
    public ModelAndView aflpaSubmit(ModelAndView mv, AForLPA aForLPA) {
        int i = aflpaService.addAFP(aForLPA);
        System.out.println("增加" + i + "张低值耗材领用申请");
        mv.setViewName("/aflpa/add");
        return mv;
    }

    @RequestMapping("/permit")
    public ModelAndView afbPermit(ModelAndView mv, String id) {
        int aflpa_ID = Integer.parseInt(id);
        AForLPA aflpa = aflpaService.getAFLPAById(aflpa_ID);
        aflpa.setAflpa_isPermited(1);
        int i = aflpaService.updateAFLPA(aflpa);
        System.out.println("批准" + i + "张领用申请表");
        mv.setViewName("/aflpa/list");
        return mv;
    }

    @RequestMapping("/dispermit")
    public ModelAndView afbDispermit(ModelAndView mv, String id) {
        int aflpa_ID = Integer.parseInt(id);
        AForLPA aflpa = aflpaService.getAFLPAById(aflpa_ID);
        aflpa.setAflpa_isPermited(-1);
        int i = aflpaService.updateAFLPA(aflpa);
        System.out.println("驳回" + i + "张借用申请表");
        mv.setViewName("/aflpa/list");
        return mv;
    }

}
