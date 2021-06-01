package edu.whpu.service;

import edu.whpu.pojo.AForLPA;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.LPA;

import java.util.List;

public interface AFLPAService {
    public List<AForLPA> getAFLPAList();

    public List<LPA> getAllLPA();

    public List<Faculty> getAllFaculty();

    public int addAFP(AForLPA aForLPA);

    public AForLPA getAFLPAById(int aflpa_ID);

    public int updateAFLPA(AForLPA aForLPA);
}
