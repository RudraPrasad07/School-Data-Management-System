package com.example.demo1.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Service.TeacherService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.TeacherDao;
import com.example.demo1.entity.Teacher;

@Service
public class TeacherServiceImplementation implements TeacherService {

	@Autowired
	public TeacherDao dao;

	@Override
	public ResponseStructure<Teacher> saveTeacher(Teacher t) {
		Teacher teacher = dao.saveTeacher(t);
		return new ResponseStructure<Teacher>(201, "Teacher Data Saved Sucessfullyin the Database", teacher,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> UpdateTeacher(Teacher t, int id) {
		Teacher teacher = dao.UpdateTeacher(t, id);
		return new ResponseStructure<Teacher>(200, "Teacher data Updated Sucessfully in the Database", teacher,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> fetchTeacherById(int id) {
		Teacher teacher = dao.fetchTeacherById(id);
		return new ResponseStructure<Teacher>(200, "Teacher data Fetched Sucessfully from the Database", teacher,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> fetchByNumber(String number) {
		Teacher teacher = dao.fetchByNumber(number);
		return new ResponseStructure<Teacher>(200, "Teacher Data Fetched Sucessfully from the Database", teacher,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Teacher>> fetchTeacherByclassName(String Classname) {
		List<Teacher> list = dao.fetchTeacherByclassName(Classname);
		return new ResponseStructure<List<Teacher>>(200, "Teacher Data Saved Sucessfullyin the Database", list,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> deleteByID(int id) {
		dao.deleteByID(id);
		return new ResponseStructure<Teacher>(204,"Teacher Data Saved Sucessfullyin the Database",null,LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Teacher> deleteByNumber(String number) {
		dao.deleteByNumber(number);
		return new ResponseStructure<Teacher>(204,"Teacher Data Saved Sucessfullyin the Database",null,LocalDateTime.now());
	}

}
