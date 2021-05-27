package edu.whpu.service;

import edu.whpu.pojo.Device;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.User;

import java.util.List;

public interface DeviceService {
    public List<Device> getDeviceList();

    public List<User> getAllAdmin();

    public int addDevice(Device device);
}
