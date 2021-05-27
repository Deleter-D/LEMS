package edu.whpu.controller;

import edu.whpu.pojo.Device;
import edu.whpu.pojo.User;
import edu.whpu.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Target;
import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping("/list")
    public ModelAndView deviceList(ModelAndView mv, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Device> deviceList = deviceService.getDeviceList();
        request.setAttribute("devicelist", deviceList);
        if (user.getU_identity().equals("1")) {
            mv.setViewName("device/list");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping("/add")
    public ModelAndView deviceAdd(ModelAndView mv, HttpSession session, HttpServletRequest request) {
        List<User> adminList = deviceService.getAllAdmin();
        request.setAttribute("adminList", adminList);

        User user = (User) session.getAttribute("user");
        if (user.getU_identity().equals("1")) {
            mv.setViewName("device/add");
        } else {
            mv.setViewName("welcome");
        }
        return mv;
    }

    @RequestMapping(value = "/divicesubmit",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deviceaddSubmit(ModelAndView mv, Device device) {
        int flag = 0;

        if (flag == 0) {
            int i = deviceService.addDevice(device);
            System.out.println("添加" + i + "个设备");
            mv.setViewName("/device/add");
            return mv;
        } else {
            return mv;
        }
    }
}

