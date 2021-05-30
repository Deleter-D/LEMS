package edu.whpu.service;

import edu.whpu.pojo.LPA;
import edu.whpu.pojo.User;

import java.util.List;

public interface LPAService {
    public List<LPA> getLPAList();

    public int addLPA(LPA lpa);

    public List<User> getAdminList();

    public LPA getLPAById(int lpa_ID);

    public int updateLPA(LPA lpa);

    public int deleteLPA(int lpa_ID);
}
