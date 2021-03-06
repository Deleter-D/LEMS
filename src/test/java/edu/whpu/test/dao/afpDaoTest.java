package edu.whpu.test.dao;

import edu.whpu.dao.AForPDao;
import edu.whpu.pojo.AForP;
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
public class afpDaoTest {
    @Autowired
    private AForPDao aForPDao;

    @Test
    public void getAllAForPTest() {
        List<AForP> aForPList = aForPDao.getAllAForP();
        for (AForP aForP : aForPList) {
            System.out.println(aForP);
        }
    }

    @Test
    public void getAForPByIdTest() {
        AForP aForP = aForPDao.getAForPById(1);
        System.out.println(aForP);
    }

    @Test
    public void insertAForPTest() {
        AForP aForP = new AForP("123", 123, 1, new Date(), "ijfosij", "fsdf", 1, 1, 0);
        int count = aForPDao.insertAForP(aForP);
        System.out.println(count);
    }

    @Test
    public void deleteAForPTest() {
        int count = aForPDao.deleteAForP(2);
        System.out.println(count);
    }

    @Test
    public void updateAForPTest() {
        AForP aForP = aForPDao.getAForPById(1);
        aForP.setAfp_facultyID(5);
        int count = aForPDao.updateAForP(aForP);
        System.out.println(count);
    }
}
