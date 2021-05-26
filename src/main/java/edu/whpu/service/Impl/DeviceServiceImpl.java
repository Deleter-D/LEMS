package edu.whpu.service.Impl;

import edu.whpu.dao.DeviceDao;
import edu.whpu.pojo.Device;
import edu.whpu.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceDao deviceDao;

    @Override
    public List<Device> getDeviceList() {
        return deviceDao.getDeviceList();
    }
}
