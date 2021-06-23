package edu.whpu.service;

import edu.whpu.pojo.AForB;
import edu.whpu.pojo.Device;
import edu.whpu.pojo.Faculty;
import edu.whpu.pojo.User;

import java.util.List;

public interface AFBService {
    public List<AForB> getAFBList();

    public List<Device> getAllDevice();

    public List<Faculty> getAllFaculty();

    public int addAFB(AForB aForB);

    public AForB getAFBById(int afb_ID);

    public int updateAFB(AForB aForB);

    public List<AForB> getAFBByF(String afb_facultyID);
}
