package edu.whpu.test.dao;


import edu.whpu.dao.FacultyDao;
import edu.whpu.pojo.Faculty;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class facultyDaoTest {

    @Autowired
    private FacultyDao facultyDao;

    @Test
    public void getAllFacultyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        facultyDao = sqlSession.getMapper(FacultyDao.class);
        List<Faculty> facultyList = facultyDao.getAllFaculty();
        for (Faculty faculty : facultyList) {
            System.out.println(faculty);
        }
        sqlSession.close();
    }

    @Test
    public void getFacultyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String statement = "edu.whpu.dao.FacultyDao.getFacultyById";
        Faculty faculty = sqlSession.selectOne(statement, 3);
        System.out.println(faculty);
        sqlSession.close();
    }

    @Test
    public void getFacultyTest02() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        facultyDao = sqlSession.getMapper(FacultyDao.class);
        Faculty faculty = facultyDao.getFacultyById(1);
        System.out.println(faculty);
        sqlSession.close();
    }

    @Test
    public void insertFacultyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        facultyDao = sqlSession.getMapper(FacultyDao.class);
        Faculty faculty = new Faculty();
        faculty.setF_name("外国语学院");
        faculty.setF_deanName("宋外语");
        faculty.setF_deanTele("18700000005");
        int count = facultyDao.insertFaculty(faculty);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteFacultyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        facultyDao = sqlSession.getMapper(FacultyDao.class);
        int count = facultyDao.deleteFaculty(7);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void updateFacultyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        facultyDao = sqlSession.getMapper(FacultyDao.class);
        Faculty faculty = facultyDao.getFacultyById(1);
        faculty.setF_deanTele("18711110001");
        int count = facultyDao.updateFaculty(faculty);
        System.out.println(count);
        sqlSession.commit();
    }
}
