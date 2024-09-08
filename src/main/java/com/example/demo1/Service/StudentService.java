package com.example.demo1.Service;

import java.util.List;

import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Student;

public interface StudentService {
	ResponseStructure<Student> saveStudent(Student s);

	ResponseStructure<Student> updateStudent(Student s, int id);

	ResponseStructure<Student> fetchstudentById(int id);

	ResponseStructure<Student> fetchByNumber(String number);

	ResponseStructure<List<Student>> fetchstudentByclassName(String classname);

	ResponseStructure<Student> deletestudentById(int id);

	ResponseStructure<Student> deleteStudentByNumber(String number);

}
