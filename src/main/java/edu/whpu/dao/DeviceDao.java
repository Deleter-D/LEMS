package edu.whpu.dao;

import edu.whpu.pojo.Device;

import java.util.List;

public interface DeviceDao {

    public List<Device> getAllDevice();

    public Device getDeviceById(int d_ID);

    public int insertDevice(Device device);

    public int deleteDevice(int d_ID);

    public int updateDevice(Device device);
}
