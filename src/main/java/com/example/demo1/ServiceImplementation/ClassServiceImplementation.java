package com.example.demo1.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Service.ClassService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.ClassDao;
import com.example.demo1.entity.Class;

@Service
public class ClassServiceImplementation implements ClassService {

	@Autowired
	public ClassDao dao;

	@Override
	public ResponseStructure<Class> Saveclass(Class c) {
		Class saveclass = dao.Saveclass(c);
		return createResponseStructure(201, "Class details are saved inside the Database Sucessfully", saveclass);
	}

	@Override
	public ResponseStructure<Class> Updateclass(int id, Class c) {
		Class updateclass = dao.Updateclass(c, id);
		return createResponseStructure(200, "Class details are Updated inside the Database Sucessfully ", updateclass);
	}

	@Override
	public ResponseStructure<Class> fetchClassById(int id) {
		Class fetchClassById = dao.fetchClassById(id);
		return createResponseStructure(200, "Class details are Fetched Sucessfully", fetchClassById);
	}

	@Override
	public ResponseStructure<List<Class>> fetchClassesByAcademiCYear(int year) {
		List<Class> fetchClassesByAcademiCYear = dao.fetchClassesByAcademiCYear(year);
		return new ResponseStructure<List<Class>>(200, "Data FetchClassesByAcademicYear Sucessfully",
				fetchClassesByAcademiCYear, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Class> deleteClassById(int id) {
		dao.deleteClassById(id);
		return createResponseStructure(204, "Data Deleted Sucessfully Inside The Database", null);
	}

	@Override
	public ResponseStructure<Class> deleteClassesByAcademiCYear(int year) {
		dao.deleteClassesByAcademiCYear(year);

		return createResponseStructure(204, "Data Deleted Sucessfully Inside The Database", null);
	}

	private ResponseStructure<Class> createResponseStructure(int statusCode, String msg, Class data) {
		return new ResponseStructure<>(statusCode, msg, data, LocalDateTime.now());
	}
}
