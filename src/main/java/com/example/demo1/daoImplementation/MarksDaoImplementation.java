package com.example.demo1.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.ExceptionHandling.EntityNotPresentexception;
import com.example.demo1.Repositry.MarkRepositry;
import com.example.demo1.dao.MarksDao;
import com.example.demo1.dao.StudentDao;
import com.example.demo1.dao.SubjectDao;
import com.example.demo1.entity.Mark;
import com.example.demo1.entity.Student;
import com.example.demo1.entity.Subject;

@Repository
public class MarksDaoImplementation implements MarksDao {
	@Autowired
	public MarkRepositry repositry;

	@Autowired
	public StudentDao dao;
	@Autowired
	private SubjectDao subjectDao;

	@Override
	public Mark saveMark(Mark m, int studentId, int subjectID) {
		Student student = dao.fetchstudentById(subjectID);
		Subject subject = subjectDao.fetchSubjectById(subjectID);
		List<Subject> list = student.getC().getSubject();
		long count = list.stream().filter(s -> s.getId() == subjectID).count();
		if (count == 0) {
			throw new EntityNotPresentexception(
					"Student with The ID" + studentId + " Is Not associated with the subject id " + subjectID);
		}
		m.setStudent(student);
		m.setSubject(subject);
		return repositry.save(m);

	}

	@Override
	public Mark upDateMark(Mark m, int id) {
		Mark mark = fetchBymarkByID(id);
		m.setId(id);
		return repositry.save(m);
	}

	@Override
	public Mark fetchBymarkByID(int id) {
		Optional<Mark> optional = repositry.findById(id);
		return optional.orElseThrow(() -> new EntityNotPresentexception("Entity Not present with the Id " + id));
	}

	@Override
	public List<Mark> fetchMarkByStudentId(int Id) {
		Student student = dao.fetchstudentById(Id);
		return student.getMarks();
	}

	@Override
	public boolean deleteByID(int Id) {
		repositry.delete(fetchBymarkByID(Id));
		return true;
	}

	@Override
	public List<Mark> fetchMarkBySubjectId(int Id) {
		Subject subject = subjectDao.fetchSubjectById(Id);
		return subject.getMarks();
	}

}
