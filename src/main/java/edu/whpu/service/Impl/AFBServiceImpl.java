package edu.whpu.service.Impl;

import edu.whpu.dao.AForBDao;
import edu.whpu.pojo.AForB;
import edu.whpu.service.AFBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AFBServiceImpl implements AFBService {

    @Autowired
    AForBDao aForBDao;

    @Override
    public List<AForB> getAFBList() {
        return aForBDao.getAFBList();
    }
}
