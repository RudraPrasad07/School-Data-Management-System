package com.example.demo1.Service;

import java.util.List;

import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Teacher;

public interface TeacherService {
	ResponseStructure<Teacher> saveTeacher(Teacher t);

	ResponseStructure<Teacher> UpdateTeacher(Teacher t, int id);

	ResponseStructure<Teacher> fetchTeacherById(int id);

	ResponseStructure<Teacher> fetchByNumber(String number);

	ResponseStructure<List<Teacher>> fetchTeacherByclassName(String Classname);

	ResponseStructure<Teacher> deleteByID(int id);

	ResponseStructure<Teacher> deleteByNumber(String number);
}
