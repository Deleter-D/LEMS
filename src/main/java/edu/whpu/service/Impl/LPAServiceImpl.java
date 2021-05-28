package edu.whpu.service.Impl;

import edu.whpu.dao.LPADao;
import edu.whpu.pojo.LPA;
import edu.whpu.service.LPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LPAServiceImpl implements LPAService {

    @Autowired
    LPADao lpaDao;

    @Override
    public List<LPA> getLPAList() {
        return lpaDao.getLPAList();
    }
}
