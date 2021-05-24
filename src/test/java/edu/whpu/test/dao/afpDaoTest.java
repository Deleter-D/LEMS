package edu.whpu.test.dao;

import edu.whpu.dao.AForPDao;
import edu.whpu.pojo.AForP;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class afpDaoTest {
    @Autowired
    AForPDao aForPDao;

    @Test
    public void getAllAForPTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForPDao = sqlSession.getMapper(AForPDao.class);
        List<AForP> aForPList = aForPDao.getAllAForP();
        for (AForP aForP : aForPList) {
            System.out.println(aForP);
        }
        sqlSession.close();
    }

    @Test
    public void getAForPByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForPDao = sqlSession.getMapper(AForPDao.class);
        AForP aForP = aForPDao.getAForPById(1);
        System.out.println(aForP);
        sqlSession.close();
    }

    @Test
    public void insertAForPTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForPDao = sqlSession.getMapper(AForPDao.class);
        AForP aForP = new AForP("123", 123, 1, new Date(), "ijfosij", "fsdf", 1, 1, 0);
        int count = aForPDao.insertAForP(aForP);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteAForPTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForPDao = sqlSession.getMapper(AForPDao.class);
        int count = aForPDao.deleteAForP(2);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void updateAForPTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForPDao = sqlSession.getMapper(AForPDao.class);
        AForP aForP = aForPDao.getAForPById(1);
        aForP.setAfp_facultyID(5);
        int count = aForPDao.updateAForP(aForP);
        System.out.println(count);
        sqlSession.commit();
    }
}
