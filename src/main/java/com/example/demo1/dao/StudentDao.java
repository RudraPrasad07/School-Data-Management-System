package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.entity.Student;

public interface StudentDao {
	Student saveStudent(Student s);

	Student updateStudent(Student s, int id);

	Student fetchstudentById(int id);

	Student fetchByNumber(String number);

	List<Student> fetchstudentByclassName(String classname);

	boolean deletestudentById(int id);

	boolean deleteStudentByNumber(String number);

}
