package edu.whpu.dao;

import edu.whpu.pojo.Faculty;

import java.util.List;

public interface FacultyDao {

    public List<Faculty> getAllFaculty();

    public Faculty getFacultyById(int f_ID);

    public int insertFaculty(Faculty faculty);

    public int deleteFaculty(int f_ID);

    public int updateFaculty(Faculty faculty);

}
