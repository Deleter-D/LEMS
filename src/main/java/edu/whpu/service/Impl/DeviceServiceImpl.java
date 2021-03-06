package edu.whpu.service.Impl;

import edu.whpu.dao.DeviceDao;
import edu.whpu.dao.UserDao;
import edu.whpu.pojo.Device;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.User;
import edu.whpu.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceDao deviceDao;

    @Autowired
    UserDao userDao;

    @Override
    public List<Device> getDeviceList() {
        return deviceDao.getDeviceList();
    }

    @Override
    public List<User> getAllAdmin() {
        return userDao.getAllAdmin();
    }

    @Override
    public Device getDeviceById(int d_ID) {
        return deviceDao.getDeviceById(d_ID);
    }

    @Override
    public int addDevice(Device device) {
        return deviceDao.insertDevice(device);
    }

    @Override
    public int deleteDevice(int d_ID) {
        return deviceDao.deleteDevice(d_ID);
    }

    @Override
    public int updateDevice(Device device) {
        return deviceDao.updateDevice(device);
    }

    @Override
    public List<Device> getDeviceByName(String d_name) {
        return deviceDao.quaryByName(d_name);
    }
}