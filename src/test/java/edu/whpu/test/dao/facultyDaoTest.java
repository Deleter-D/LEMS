package edu.whpu.test.dao;


import edu.whpu.dao.FacultyDao;
import edu.whpu.pojo.Faculty;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class facultyDaoTest {

    @Autowired
    private FacultyDao facultyDao;

    @Test
    public void getAllFacultyTest() {
        List<Faculty> facultyList = facultyDao.getAllFaculty();
        for (Faculty faculty : facultyList) {
            System.out.println(faculty);
        }
    }

    @Test
    public void getFacultyByIdTest() {
        Faculty faculty = facultyDao.getFacultyById(1);
        System.out.println(faculty);
    }

    @Test
    public void insertFacultyTest() {
        Faculty faculty = new Faculty();
        faculty.setF_name("外国语学院");
        faculty.setF_deanName("宋外语");
        faculty.setF_deanTele("18700000005");
        int count = facultyDao.insertFaculty(faculty);
        System.out.println(count);
    }

    @Test
    public void deleteFacultyTest() {
        int count = facultyDao.deleteFaculty(7);
        System.out.println(count);
    }

    @Test
    public void updateFacultyTest() {
        Faculty faculty = facultyDao.getFacultyById(1);
        faculty.setF_deanTele("18711110001");
        int count = facultyDao.updateFaculty(faculty);
        System.out.println(count);
    }
}
