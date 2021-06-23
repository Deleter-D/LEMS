package edu.whpu.dao;

import edu.whpu.pojo.LPA;

import java.util.List;

public interface LPADao {
    public List<LPA> getAllLPA();

    public LPA getLPAById(int lpa_ID);

    public int insertLPA(LPA lpa);

    public int deleteLPA(int lpa_ID);

    public int updateLPA(LPA lpa);

    public List<LPA> getLPAList();

    public List<LPA> quaryByName(String lpa_name);
}
