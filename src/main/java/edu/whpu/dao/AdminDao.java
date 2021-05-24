package edu.whpu.dao;

import edu.whpu.pojo.Admin;

import java.util.List;

public interface AdminDao {
    public List<Admin> getAllAdmin();

    public Admin getAdminById(int a_ID);

    public int insertAdmin(Admin admin);

    public int deleteAdmin(int a_ID);

    public int updateAdmin(Admin admin);
}
