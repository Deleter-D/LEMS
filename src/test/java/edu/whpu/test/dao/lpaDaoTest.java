package edu.whpu.test.dao;

import edu.whpu.dao.LPADao;
import edu.whpu.pojo.LPA;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class lpaDaoTest {
    @Autowired
    LPADao lpaDao;

    @Test
    public void getAllLPATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lpaDao = sqlSession.getMapper(LPADao.class);
        List<LPA> lpaList = lpaDao.getAllLPA();
        for (LPA lpa : lpaList) {
            System.out.println(lpa);
        }
        sqlSession.close();
    }

    @Test
    public void getLPAByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lpaDao = sqlSession.getMapper(LPADao.class);
        LPA lpa = lpaDao.getLPAById(1);
        System.out.println(lpa);
        sqlSession.close();
    }

    @Test
    public void insertLPATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lpaDao = sqlSession.getMapper(LPADao.class);
        LPA lpa = new LPA("显卡", 3099f, 3, new Date(), "XXX电子厂", "2年", 1);
        int count = lpaDao.insertLPA(lpa);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteLPATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lpaDao = sqlSession.getMapper(LPADao.class);
        int count = lpaDao.deleteLPA(2);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void updateLPATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        lpaDao = sqlSession.getMapper(LPADao.class);
        LPA lpa = lpaDao.getLPAById(1);
        lpa.setLpa_number(10);
        int count = lpaDao.updateLPA(lpa);
        System.out.println(count);
        sqlSession.commit();
    }
}
