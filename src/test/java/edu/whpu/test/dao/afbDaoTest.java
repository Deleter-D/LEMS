package edu.whpu.test.dao;

import edu.whpu.dao.AForBDao;
import edu.whpu.pojo.AForB;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;

public class afbDaoTest {
    @Autowired
    AForBDao aForBDao;

    @Test
    public void getAllAForBTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForBDao = sqlSession.getMapper(AForBDao.class);
        List<AForB> aForBList = aForBDao.getAllAForB();
        for (AForB aForB : aForBList) {
            System.out.println(aForB);
        }
        sqlSession.close();
    }

    @Test
    public void getAForBById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForBDao = sqlSession.getMapper(AForBDao.class);
        AForB aForB = aForBDao.getAForBById(1);
        System.out.println(aForB);
        sqlSession.close();
    }

    @Test
    public void insertAForB() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForBDao = sqlSession.getMapper(AForBDao.class);
        AForB aForB = new AForB("粒子对撞机", 1, new Date(), new Date(), "对撞", "李四", "17462634758", 6, 0);
        int count = aForBDao.insertAForB(aForB);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteAForBTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForBDao = sqlSession.getMapper(AForBDao.class);
        int count = aForBDao.deleteAForB(2);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void updateAForBTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        aForBDao = sqlSession.getMapper(AForBDao.class);
        AForB aForB = aForBDao.getAForBById(1);
        aForB.setAfb_usefor("超级计算");
        int count = aForBDao.updateAForB(aForB);
        System.out.println(count);
        sqlSession.commit();


    }
}
