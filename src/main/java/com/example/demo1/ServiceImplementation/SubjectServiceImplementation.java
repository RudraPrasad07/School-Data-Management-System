package com.example.demo1.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Service.SubjectService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.SubjectDao;
import com.example.demo1.entity.Subject;

@Service
public class SubjectServiceImplementation implements SubjectService {

	@Autowired
	private SubjectDao dao;

	@Override
	public ResponseStructure<Subject> SaveSubject(Subject s, String className) {
		Subject subject = dao.SaveSubject(s, className);
		return new ResponseStructure<Subject>(201, "Data Saved Sucessfully inside The Data Base", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Subject> UpdateSubject(Subject s, int id) {
		Subject subject = dao.UpdateSubject(s, id);
		return new ResponseStructure<Subject>(200, "Data Updated Sucessfully in the data Base", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Subject> fetchSubjectById(int id) {
		Subject subject = dao.fetchSubjectById(id);
		return new ResponseStructure<Subject>(200, "Data Fetched Sucessfully from the data Base", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Subject> fetchSubjecBycode(String code) {
		Subject subject = dao.fetchSubjecBycode(code);
		return new ResponseStructure<Subject>(200, "Data Fetched Sucessfully from the data Base", subject,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Subject>> fetchSubjecClassName(String className) {
		List<Subject> name = dao.fetchSubjecClassName(className);
		return new ResponseStructure<List<Subject>>(200, "Data fetched sucessfully From The DataBase", name,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Subject>> fetchSubjecByStudentID(int sId) {
		List<Subject> studentID = dao.fetchSubjecByStudentID(sId);
		return new ResponseStructure<List<Subject>>(200, "Data fetched sucessfully From The DataBase", studentID,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Subject> deleteSubjecByID(int id) {
		dao.deleteSubjecByID(id);
		return new ResponseStructure<Subject>(204, "Data deleted Sucessfully from the data Base", null,
				LocalDateTime.now());
	}

}
