package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.entity.Teacher;

public interface TeacherDao {

	Teacher saveTeacher(Teacher t);

	Teacher UpdateTeacher(Teacher t, int id);

	Teacher fetchTeacherById(int id);

	Teacher fetchByNumber(String number);

	List<Teacher> fetchTeacherByclassName(String Classname);

	boolean deleteByID(int id);

	boolean deleteByNumber(String number);
}
