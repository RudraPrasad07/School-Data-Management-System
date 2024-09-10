package com.example.demo1.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.ExceptionHandling.EntityAlreadyExistsException;
import com.example.demo1.ExceptionHandling.EntityNotPresentexception;
import com.example.demo1.Repositry.TecherRepositry;
import com.example.demo1.dao.ClassDao;
import com.example.demo1.dao.TeacherDao;
import com.example.demo1.entity.Class;
import com.example.demo1.entity.Teacher;

import jakarta.transaction.Transactional;

@Repository
public class TeacherDaoImplementation implements TeacherDao {
	@Autowired
	public TecherRepositry repositry;
	@Autowired
	public ClassDao dao;

	@Override
	public Teacher saveTeacher(Teacher t) {
		if (repositry.existsByEmail(t.getEmail())) {
			throw new EntityAlreadyExistsException("A Teacher Is Already Present With The Email " + t.getEmail());
		}
		if (repositry.existsByPhoneNo(t.getPhoneNo())) {
			throw new EntityAlreadyExistsException(
					"A Teacher Is Already Present With The PhoneNumber " + t.getPhoneNo());
		}
		return repositry.save(t);
	}

	@Override
	public Teacher UpdateTeacher(Teacher t, int id) {
		Teacher teacher = fetchTeacherById(id);

		Optional<Teacher> optional = repositry.findByEmail(t.getEmail());
		if (optional.isPresent()) {
			if (optional.get().getId() != id) {
				throw new EntityNotPresentexception("Teacher Is Not Present With The Email " + t.getEmail());
			}
		}

		optional = repositry.findByPhoneNo(t.getPhoneNo());
		if (optional.isPresent()) {
			if (optional.get().getId() != id) {
				throw new EntityNotPresentexception("Teacher Is Not Present With The PhoneNumber " + t.getPhoneNo());
			}
		}
		t.setId(id);
		return repositry.save(t);
	}

	@Override
	public Teacher fetchTeacherById(int id) {
		Optional<Teacher> optional = repositry.findById(id);

		return optional.orElseThrow(
				() -> new EntityNotPresentexception("Entity Not present With the id Which You Passed " + id));
	}

	@Override
	public Teacher fetchByNumber(String number) {
		Optional<Teacher> optional = repositry.findByPhoneNo(number);
		return optional.orElseThrow(() -> new EntityNotPresentexception(""));
	}

	@Override
	public List<Teacher> fetchTeacherByclassName(String Classname) {
		Class name = dao.fetchClassByName(Classname);
		return name.getTeachers();
	}

	@Override
	public boolean deleteByID(int id) {
		repositry.delete(fetchTeacherById(id));
		return true;
	}

	@Override
	@Transactional
	public boolean deleteByNumber(String number) {
		repositry.delete(fetchByNumber(number));
		return true;
	}

}
