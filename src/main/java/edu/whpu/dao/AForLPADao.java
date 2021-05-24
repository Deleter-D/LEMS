package edu.whpu.dao;

import edu.whpu.pojo.AForLPA;

import java.util.List;

public interface AForLPADao {
    public List<AForLPA> getAllAForLPA();

    public AForLPA getAForLPAById(int aflpa_ID);

    public int insertAForLPA(AForLPA aForLPA);

    public int deleteAForLPA(int aflpa_ID);

    public int updateAForLPA(AForLPA aForLPA);
}
