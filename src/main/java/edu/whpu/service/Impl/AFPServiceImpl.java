package edu.whpu.service.Impl;

import edu.whpu.dao.AForPDao;
import edu.whpu.dao.FacultyDao;
import edu.whpu.dao.UserDao;
import edu.whpu.pojo.AForP;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.User;
import edu.whpu.service.AFPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AFPServiceImpl implements AFPService {

    @Autowired
    AForPDao aForPDao;

    @Autowired
    UserDao userDao;

    @Autowired
    FacultyDao facultyDao;

    @Override
    public List<AForP> getAFPList() {
        return aForPDao.getAFPList();
    }

    @Override
    public List<User> getAllAdmin() {
        return userDao.getAllAdmin();
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyDao.getAllFaculty();
    }

    @Override
    public int addAFP(AForP aForP) {
        return aForPDao.insertAForP(aForP);
    }

    @Override
    public AForP getAFPById(int afp_ID) {
        return aForPDao.getAForPById(afp_ID);
    }

    @Override
    public int updateAFP(AForP aForP) {
        return aForPDao.updateAForP(aForP);
    }

    @Override
    public List<AForP> getAFPByF(String afp_facultyID) {
        return aForPDao.quaryAFPByF(afp_facultyID);
    }
}
