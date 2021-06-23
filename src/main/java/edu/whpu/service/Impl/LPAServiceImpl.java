package edu.whpu.service.Impl;

import edu.whpu.dao.LPADao;
import edu.whpu.dao.UserDao;
import edu.whpu.pojo.LPA;
import edu.whpu.pojo.User;
import edu.whpu.service.LPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LPAServiceImpl implements LPAService {

    @Autowired
    LPADao lpaDao;

    @Autowired
    UserDao userDao;

    @Override
    public List<LPA> getLPAList() {
        return lpaDao.getLPAList();
    }

    @Override
    public int addLPA(LPA lpa) {
        return lpaDao.insertLPA(lpa);
    }

    @Override
    public List<User> getAdminList() {
        return userDao.getAllAdmin();
    }

    @Override
    public LPA getLPAById(int lpa_ID) {
        return lpaDao.getLPAById(lpa_ID);
    }

    @Override
    public int updateLPA(LPA lpa) {
        return lpaDao.updateLPA(lpa);
    }

    @Override
    public int deleteLPA(int lpa_ID) {
        return lpaDao.deleteLPA(lpa_ID);
    }

    @Override
    public List<LPA> getLPAByName(String lpa_name) {
        return lpaDao.quaryByName(lpa_name);
    }
}
