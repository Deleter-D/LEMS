package edu.whpu.service.Impl;

import edu.whpu.dao.AForBDao;
import edu.whpu.dao.DeviceDao;
import edu.whpu.dao.FacultyDao;
import edu.whpu.dao.UserDao;
import edu.whpu.pojo.AForB;
import edu.whpu.pojo.Device;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.User;
import edu.whpu.service.AFBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AFBServiceImpl implements AFBService {

    @Autowired
    AForBDao aForBDao;

    @Autowired
    DeviceDao deviceDao;

    @Autowired
    FacultyDao facultyDao;

    @Override
    public List<AForB> getAFBList() {
        return aForBDao.getAFBList();
    }

    @Override
    public List<Device> getAllDevice() {
        return deviceDao.getAllDevice();
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyDao.getAllFaculty();
    }

    @Override
    public int addAFB(AForB aForB) {
        return aForBDao.insertAForB(aForB);
    }

    @Override
    public AForB getAFBById(int afb_ID) {
        return aForBDao.getAForBById(afb_ID);
    }

    @Override
    public int updateAFB(AForB aForB) {
        return aForBDao.updateAForB(aForB);
    }
}
