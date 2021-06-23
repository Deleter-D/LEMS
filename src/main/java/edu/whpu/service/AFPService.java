package edu.whpu.service;

import edu.whpu.pojo.AForP;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.User;

import java.util.List;

public interface AFPService {
    public List<AForP> getAFPList();

    public List<User> getAllAdmin();

    public List<Faculty> getAllFaculty();

    public int addAFP(AForP aForP);

    public AForP getAFPById(int afp_ID);

    public int updateAFP(AForP aForP);

    public List<AForP> getAFPByF(String afp_facultyID);
}
