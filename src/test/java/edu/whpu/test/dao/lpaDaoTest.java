package edu.whpu.test.dao;

import edu.whpu.dao.LPADao;
import edu.whpu.pojo.LPA;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class lpaDaoTest {
    @Autowired
    private LPADao lpaDao;

    @Test
    public void getAllLPATest() {
        List<LPA> lpaList = lpaDao.getAllLPA();
        for (LPA lpa : lpaList) {
            System.out.println(lpa);
        }
    }

    @Test
    public void getLPAByIdTest() {
        LPA lpa = lpaDao.getLPAById(1);
        System.out.println(lpa);
    }

    @Test
    public void insertLPATest() {
        LPA lpa = new LPA("显卡", 3099f, 3, new Date(), "XXX电子厂", "2年", 1);
        int count = lpaDao.insertLPA(lpa);
        System.out.println(count);
    }

    @Test
    public void deleteLPATest() {
        int count = lpaDao.deleteLPA(2);
        System.out.println(count);
    }

    @Test
    public void updateLPATest() {
        LPA lpa = lpaDao.getLPAById(1);
        lpa.setLpa_number(10);
        int count = lpaDao.updateLPA(lpa);
        System.out.println(count);
    }

    @Test
    public void getLPAListTest() {
        List<LPA> lpaList = lpaDao.getLPAList();
        for (LPA lpa : lpaList) {
            System.out.println(lpa);
        }
    }
}
