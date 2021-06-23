package edu.whpu.controller;

import edu.whpu.pojo.AForP;
import edu.whpu.pojo.Faculty;
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
        List<Faculty> facultyList = afpService.getAllFaculty();
        request.setAttribute("afpList", afpList);
        request.setAttribute("facultyList", facultyList);
        if (user.getU_identity().equals("1")) {
            mv.setViewName("/afp/list");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView afpAdd(ModelAndView mv, HttpSession session, HttpServletRequest request) {
        List<User> adminList = afpService.getAllAdmin();
        List<Faculty> facultyList = afpService.getAllFaculty();
        request.setAttribute("adminList", adminList);
        request.setAttribute("facultyList", facultyList);

        User user = (User) session.getAttribute("user");
        if (user.getU_identity().equals("1")) {
            mv.setViewName("afp/add");
            return mv;
        } else {
            mv.setViewName("welcome");
            return mv;
        }
    }

    @RequestMapping("/afpsubmit")
    public ModelAndView afpSubmit(ModelAndView mv, AForP aForP) {
        int i = afpService.addAFP(aForP);
        System.out.println("增加" + i + "张购买申请");
        mv.setViewName("/afp/add");
        return mv;
    }

    @RequestMapping("/permit")
    public ModelAndView afpPermit(ModelAndView mv, String id) {
        int afp_ID = Integer.parseInt(id);
        AForP afp = afpService.getAFPById(afp_ID);
        afp.setAfp_isPermited(1);
        int i = afpService.updateAFP(afp);
        System.out.println("批准" + i + "个购买申请");
        mv.setViewName("/afp/list");
        return mv;
    }

    @RequestMapping("/dispermit")
    public ModelAndView afpDispermit(ModelAndView mv, String id) {
        int afp_ID = Integer.parseInt(id);
        AForP afp = afpService.getAFPById(afp_ID);
        afp.setAfp_isPermited(-1);
        int i = afpService.updateAFP(afp);
        System.out.println("驳回" + i + "个购买申请");
        mv.setViewName("/afp/list");
        return mv;
    }

    @RequestMapping("/quary")
    public ModelAndView quaryAFPByF(ModelAndView mv, String facultyID, HttpServletRequest request) {
        List<AForP> aForPList = afpService.getAFPByF(facultyID);
        List<Faculty> facultyList = afpService.getAllFaculty();
        request.setAttribute("afpList", aForPList);
        request.setAttribute("facultyID", facultyID);
        request.setAttribute("facultyList", facultyList);
        mv.setViewName("/afp/list");
        return mv;
    }
}
