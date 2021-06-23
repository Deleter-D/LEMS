package edu.whpu.dao;

import edu.whpu.pojo.AForP;

import java.util.List;

public interface AForPDao {
    public List<AForP> getAllAForP();

    public AForP getAForPById(int afp_ID);

    public int insertAForP(AForP aForP);

    public int deleteAForP(int afp_ID);

    public int updateAForP(AForP aForP);

    public List<AForP> getAFPList();

    public List<AForP> quaryAFPByF(String afp_facultyID);
}
