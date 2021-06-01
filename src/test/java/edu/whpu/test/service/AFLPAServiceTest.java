package edu.whpu.test.service;

import edu.whpu.pojo.AForLPA;
import edu.whpu.pojo.LPA;
import edu.whpu.service.AFLPAService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class AFLPAServiceTest {

    @Autowired
    AFLPAService aflpaService;

    @Test
    public void getLPATest() {
        List<LPA> allLPA = aflpaService.getAllLPA();
        for (LPA lpa : allLPA) {
            System.out.println(lpa);
        }
    }

}
