package edu.whpu.service.Impl;

import edu.whpu.dao.AForPDao;
import edu.whpu.pojo.AForP;
import edu.whpu.service.AFPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AFPServiceImpl implements AFPService {

    @Autowired
    AForPDao aForPDao;

    @Override
    public List<AForP> getAFPList() {
        return aForPDao.getAFPList();
    }
}
