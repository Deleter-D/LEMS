package edu.whpu.controller;

import edu.whpu.pojo.AForB;
import edu.whpu.pojo.Device;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.User;
import edu.whpu.service.AFBService;
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
@RequestMapping("/afb")
public class AFBController {

    @Autowired
    AFBService afbService;

    // 该方法可将 yyyy-MM-dd 格式的字符串转换为Date类型的数据，从而能使springMVC自动将其封装进该实例中
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/list")
    public ModelAndView afbList(ModelAndView mv, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        List<AForB> afbList = afbService.getAFBList();

        request.setAttribute("afbList", afbList);

        if (user.getU_identity().equals("1")) {
            mv.setViewName("/afb/list");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView afbAdd(ModelAndView mv, HttpServletRequest request) {
        List<Device> deviceList = afbService.getAllDevice();
        List<Faculty> facultyList = afbService.getAllFaculty();
        request.setAttribute("deviceList", deviceList);
        request.setAttribute("facultyList", facultyList);


        mv.setViewName("afb/add");
        return mv;
    }

    @RequestMapping("/afbSubmit")
    public ModelAndView afbSubmit(ModelAndView mv, AForB aForB) {
        int i = afbService.addAFB(aForB);
        System.out.println("增加" + i + "张借用申请表");
        mv.setViewName("/afb/add");
        return mv;
    }

    @RequestMapping("/permit")
    public ModelAndView afbPermit(ModelAndView mv, String id) {
        int afb_ID = Integer.parseInt(id);
        AForB afb = afbService.getAFBById(afb_ID);
        afb.setAfb_isPermited(1);
        int i = afbService.updateAFB(afb);
        System.out.println("批准" + i + "张借用申请表");
        mv.setViewName("/afb/list");
        return mv;
    }

    @RequestMapping("/dispermit")
    public ModelAndView afbDispermit(ModelAndView mv,String id){
        int afb_ID = Integer.parseInt(id);
        AForB afb = afbService.getAFBById(afb_ID);
        afb.setAfb_isPermited(-1);
        int i = afbService.updateAFB(afb);
        System.out.println("驳回" + i + "张借用申请表");
        mv.setViewName("/afb/list");
        return mv;
    }
}
