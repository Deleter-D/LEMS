package edu.whpu.test.dao;

import edu.whpu.dao.AForBDao;
import edu.whpu.pojo.AForB;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class afbDaoTest {
    @Autowired
    private AForBDao aForBDao;

    @Test
    public void getAllAForBTest() {
        List<AForB> aForBList = aForBDao.getAllAForB();
        for (AForB aForB : aForBList) {
            System.out.println(aForB);
        }
    }

    @Test
    public void getAForBById() {
        AForB aForB = aForBDao.getAForBById(1);
        System.out.println(aForB);
    }

    @Test
    public void insertAForB() {
        AForB aForB = new AForB(5, 1, new Date(), new Date(), "对撞", "李四", "17462634758", 6, 0);
        int count = aForBDao.insertAForB(aForB);
        System.out.println(count);
    }

    @Test
    public void deleteAForBTest() {
        int count = aForBDao.deleteAForB(2);
        System.out.println(count);
    }

    @Test
    public void updateAForBTest() {
        AForB aForB = aForBDao.getAForBById(1);
        aForB.setAfb_usefor("超级计算");
        int count = aForBDao.updateAForB(aForB);
        System.out.println(count);
    }

    @Test
    public void getAFBListTest() {
        List<AForB> afbList = aForBDao.getAFBList();
        for (AForB aForB : afbList) {
            System.out.println(aForB);
        }
    }
}
