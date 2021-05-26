package edu.whpu.controller;

import edu.whpu.pojo.Device;
import edu.whpu.pojo.User;
import edu.whpu.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

}

