package edu.whpu.test.dao;

import edu.whpu.dao.AForLPADao;
import edu.whpu.pojo.AForLPA;
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
public class aflpaDaoTest {
    @Autowired
    private AForLPADao aForLPADao;

    @Test
    public void getAllAForLPATest() {
        List<AForLPA> aForLPAList = aForLPADao.getAllAForLPA();
        for (AForLPA aForLPA : aForLPAList) {
            System.out.println(aForLPA);
        }
    }

    @Test
    public void getAForLPAByIdTest() {
        AForLPA aForLPA = aForLPADao.getAForLPAById(1);
        System.out.println(aForLPA);
    }

    @Test
    public void insertAForLPATest() {
        AForLPA aForLPA = new AForLPA(1, 1, new Date(), "装机", "李四", "18498374592", 3, 0);
        int count = aForLPADao.insertAForLPA(aForLPA);
        System.out.println(count);
    }

    @Test
    public void deleteAForLPATest() {
        int count = aForLPADao.deleteAForLPA(2);
        System.out.println(count);
    }

    @Test
    public void updateAForLPATest() {
        AForLPA aForLPA = aForLPADao.getAForLPAById(1);
        aForLPA.setAflpa_useFor("组装计算机");
        int count = aForLPADao.updateAForLPA(aForLPA);
        System.out.println(count);
    }
}
