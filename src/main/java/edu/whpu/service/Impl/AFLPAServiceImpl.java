package edu.whpu.service.Impl;

import edu.whpu.dao.AForLPADao;
import edu.whpu.dao.FacultyDao;
import edu.whpu.dao.LPADao;
import edu.whpu.pojo.AForLPA;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.LPA;
import edu.whpu.service.AFLPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AFLPAServiceImpl implements AFLPAService {

    @Autowired
    AForLPADao aForLPADao;

    @Autowired
    LPADao lpaDao;

    @Autowired
    FacultyDao facultyDao;

    @Override
    public List<AForLPA> getAFLPAList() {
        return aForLPADao.getAFLPAList();
    }

    @Override
    public List<LPA> getAllLPA() {
        return lpaDao.getAllLPA();
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyDao.getAllFaculty();
    }

    @Override
    public int addAFP(AForLPA aForLPA) {
        return aForLPADao.insertAForLPA(aForLPA);
    }

    @Override
    public AForLPA getAFLPAById(int aflpa_ID) {
        return aForLPADao.getAForLPAById(aflpa_ID);
    }

    @Override
    public int updateAFLPA(AForLPA aForLPA) {
        return aForLPADao.updateAForLPA(aForLPA);
    }

    @Override
    public List<AForLPA> getAFLPAByF(String aflpa_facultyID) {
        return aForLPADao.quaryAFLPAByF(aflpa_facultyID);
    }
}
