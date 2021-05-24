package edu.whpu.test.dao;

import edu.whpu.dao.AdminDao;
import edu.whpu.pojo.Admin;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class adminDaoTest {
    @Autowired
    AdminDao adminDao;

    @Test
    public void getAllAdminTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        adminDao = sqlSession.getMapper(AdminDao.class);
        List<Admin> adminList = adminDao.getAllAdmin();
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
        sqlSession.close();
    }

    @Test
    public void getAdminByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        adminDao = sqlSession.getMapper(AdminDao.class);
        Admin admin = adminDao.getAdminById(1);
        System.out.println(admin);
        sqlSession.close();
    }

    @Test
    public void insertAdminTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        adminDao = sqlSession.getMapper(AdminDao.class);
        Admin admin = new Admin("654321", "admin02", "刘管理", "18409385843", 2);
        int count = adminDao.insertAdmin(admin);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteAdminTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        adminDao = sqlSession.getMapper(AdminDao.class);
        int count = adminDao.deleteAdmin(2);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void updateAdminTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        adminDao = sqlSession.getMapper(AdminDao.class);
        Admin admin = adminDao.getAdminById(1);
        admin.setA_password("admin007");
        int count = adminDao.updateAdmin(admin);
        System.out.println(count);
        sqlSession.commit();
    }
}
