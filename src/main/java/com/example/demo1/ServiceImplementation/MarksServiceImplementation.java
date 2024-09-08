package com.example.demo1.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.Service.MarksService;
import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.dao.MarksDao;
import com.example.demo1.entity.Mark;

@Service
public class MarksServiceImplementation implements MarksService {

	@Autowired
	public MarksDao dao;

	@Override
	public ResponseStructure<Mark> saveMark(Mark m, int studentId, int subjectID) {
		Mark mark = dao.saveMark(m, studentId, subjectID);
		return new ResponseStructure<Mark>(201, "Marks Are Saved Sucessfully", mark, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Mark> upDateMark(Mark m, int id) {
		Mark mark = dao.upDateMark(m, id);
		return new ResponseStructure<Mark>(200, "Marks Are Updated Sucessfully", mark, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Mark> fetchBymarkByID(int id) {
		Mark mark = dao.fetchBymarkByID(id);
		return new ResponseStructure<Mark>(200, "Marks Are Fetched Sucessfully", mark, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Mark>> fetchMarkByStudentId(int Id) {
		List<Mark> studentId = dao.fetchMarkByStudentId(Id);
		return new ResponseStructure<List<Mark>>(200, "Student Details Are Fetched Sucessfully", studentId,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<List<Mark>> fetchMarkBySubjectId(int Id) {
		List<Mark> subjectId = dao.fetchMarkBySubjectId(Id);
		return new ResponseStructure<List<Mark>>(200, "Subject Details Are Fetched Sucessfully", subjectId,
				LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Mark> deleteByID(int Id) {
		dao.deleteByID(Id);
		return new ResponseStructure<Mark>(204, "Marks Are Updated Sucessfully", null, LocalDateTime.now());
	}

}
