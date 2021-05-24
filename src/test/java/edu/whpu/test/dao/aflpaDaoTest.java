package edu.whpu.test.dao;

import edu.whpu.dao.AForLPADao;
import edu.whpu.pojo.AForLPA;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class aflpaDaoTest {
    @Autowired
    AForLPADao aForLPADao;

    @Test
    public void getAllAForLPATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForLPADao = sqlSession.getMapper(AForLPADao.class);
        List<AForLPA> aForLPAList = aForLPADao.getAllAForLPA();
        for (AForLPA aForLPA : aForLPAList) {
            System.out.println(aForLPA);
        }
        sqlSession.close();
    }

    @Test
    public void getAForLPAByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForLPADao = sqlSession.getMapper(AForLPADao.class);
        AForLPA aForLPA = aForLPADao.getAForLPAById(1);
        System.out.println(aForLPA);
        sqlSession.close();
    }

    @Test
    public void insertAForLPATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForLPADao = sqlSession.getMapper(AForLPADao.class);
        AForLPA aForLPA = new AForLPA("显卡", 1, new Date(), "装机", "李四", "18498374592", 3, 0);
        int count = aForLPADao.insertAForLPA(aForLPA);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteAForLPATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForLPADao = sqlSession.getMapper(AForLPADao.class);
        int count = aForLPADao.deleteAForLPA(2);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void updateAForLPATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForLPADao = sqlSession.getMapper(AForLPADao.class);
        AForLPA aForLPA = aForLPADao.getAForLPAById(1);
        aForLPA.setAflpa_useFor("组装计算机");
        int count = aForLPADao.updateAForLPA(aForLPA);
        System.out.println(count);
        sqlSession.commit();
    }
}
