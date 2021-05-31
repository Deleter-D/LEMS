package edu.whpu.controller;

import edu.whpu.pojo.Device;
import edu.whpu.pojo.User;
import edu.whpu.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    // 该方法可将 yyyy-MM-dd 格式的字符串转换为Date类型的数据，从而能使springMVC自动将其封装进该实例中
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

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
    public ModelAndView deviceAdd(ModelAndView mv, String id, HttpSession session, HttpServletRequest request) {
        List<User> adminList = deviceService.getAllAdmin();
        request.setAttribute("adminList", adminList);

        if (id != null) {
            int d_ID = Integer.parseInt(id);
            Device editDevice = deviceService.getDeviceById(d_ID);
            request.setAttribute("editDevice", editDevice);
            mv.setViewName("/device/add");
            return mv;
        }

        User user = (User) session.getAttribute("user");
        if (user.getU_identity().equals("1")) {
            mv.setViewName("device/add");
            return mv;
        } else {
            mv.setViewName("welcome");
            return mv;
        }
    }

    @RequestMapping(value = "/divicesubmit", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deviceaddSubmit(ModelAndView mv, Device device) {
        int flag = 0;

        List<Device> deviceList = deviceService.getDeviceList();
        for (Device deviceInList : deviceList) {
            if (deviceInList.getD_ID() == device.getD_ID()) {
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            int i = deviceService.addDevice(device);
            System.out.println("添加" + i + "个设备");
            mv.setViewName("/device/add");
        } else {
            int i = deviceService.updateDevice(device);
            System.out.println("更新" + i + "个设备");
            mv.setViewName("/device/list");
        }
        return mv;
    }

    @RequestMapping("/deletedevice")
    public ModelAndView deleteDevice(ModelAndView mv, String id) {
        int d_ID = Integer.parseInt(id);
        int i = deviceService.deleteDevice(d_ID);
        System.out.println("删除" + i + "个设备");
        mv.setViewName("/device/list");
        return mv;
    }
}

