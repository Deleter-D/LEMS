package edu.whpu.dao;

import edu.whpu.pojo.AForB;

import java.util.List;

public interface AForBDao {
    public List<AForB> getAllAForB();

    public AForB getAForBById(int afb_ID);

    public int insertAForB(AForB aForB);

    public int deleteAForB(int afb_ID);

    public int updateAForB(AForB aForB);

    public List<AForB> getAFBList();

    public List<AForB> quaryAFBByF(String afb_facultyID);
}
