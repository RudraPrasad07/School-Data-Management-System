package com.example.demo1.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Service.StudentService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.StudentDao;
import com.example.demo1.entity.Student;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public ResponseStructure<Student> saveStudent(Student s) {
		Student student = dao.saveStudent(s);
		return new ResponseStructure<Student>(201, "Data Svaed Sucessfully", student, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> updateStudent(Student s, int id) {
		Student student = dao.updateStudent(s, id);
		return new ResponseStructure<Student>(200, "Data Updated Sucessfully", student, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> fetchstudentById(int id) {
		Student student = dao.fetchstudentById(id);
		return new ResponseStructure<Student>(200, "Data fetched Sucessfully", student, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> fetchByNumber(String number) {
		Student student = dao.fetchByNumber(number);
		return new ResponseStructure<Student>(200, "Data Updated Sucessfully", student, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Student>> fetchstudentByclassName(String classname) {
		List<Student> list = dao.fetchstudentByclassName(classname);
		return new ResponseStructure<List<Student>>(200, "Data Updated Sucessfully", list, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> deletestudentById(int id) {
		dao.deletestudentById(id);
		return new ResponseStructure<Student>(200, "Data Deleted Sucessfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Student> deleteStudentByNumber(String number) {
		dao.deleteStudentByNumber(number);
		return new ResponseStructure<Student>(200, "Data Deleted Sucessfully", null, LocalDateTime.now());
	}

}
