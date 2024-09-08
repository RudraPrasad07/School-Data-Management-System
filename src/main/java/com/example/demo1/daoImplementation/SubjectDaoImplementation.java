package com.example.demo1.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.ExceptionHandling.EntityAlreadyExistsException;
import com.example.demo1.ExceptionHandling.EntityNotPresentexception;
import com.example.demo1.Repositry.SubjectRepositry;
import com.example.demo1.dao.ClassDao;
import com.example.demo1.dao.StudentDao;
import com.example.demo1.dao.SubjectDao;
import com.example.demo1.entity.Class;
import com.example.demo1.entity.Student;
import com.example.demo1.entity.Subject;

@Repository
public class SubjectDaoImplementation implements SubjectDao {
	@Autowired
	private SubjectRepositry repositry;

	@Autowired
	private ClassDao classDao;
	@Autowired
	private StudentDao dao;

	@Override
	public Subject SaveSubject(Subject s, String className) {
		Class name = classDao.fetchClassByName(className);

		if (repositry.existsByCode(s.getCode())) {
			throw new EntityAlreadyExistsException("Entity Allready Present with The Code" + s.getCode());
		}
		s.setClass_name(name);
		return repositry.save(s);
	}

	@Override
	public Subject UpdateSubject(Subject s, int id) {
		fetchSubjectById(id);
		Optional<Subject> optional = repositry.findByCode(s.getCode());
		if (optional.isPresent()) {
			if (optional.get().getId() != id) {
				throw new EntityNotPresentexception("Entity Not Present In The Data Base");
			}
		}
		s.setId(id);
		return repositry.save(s);
	}

	@Override
	public Subject fetchSubjectById(int id) {
		Optional<Subject> optional = repositry.findById(id);
		return optional.orElseThrow(
				() -> new EntityNotPresentexception("Subject With the id " + id + " Is not present in the database"));
	}

	@Override
	public Subject fetchSubjecBycode(String code) {
		Optional<Subject> optional = repositry.findByCode(code);
		return optional.orElseThrow(() -> new EntityNotPresentexception(
				"Subject With the code " + code + " Is not present in the database"));
	}

	@Override
	public List<Subject> fetchSubjecClassName(String className) {
		Class fetchClassByName = classDao.fetchClassByName(className);
		return fetchClassByName.getSubject();
	}

	@Override
	public List<Subject> fetchSubjecByStudentID(int sId) {
		Student student = dao.fetchstudentById(sId);
		return student.getC().getSubject();
	}

	@Override
	public boolean deleteSubjecByID(int id) {
		fetchSubjectById(id);
		repositry.deleteById(id);
		return true;
	}

}
