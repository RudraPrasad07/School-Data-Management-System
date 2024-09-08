package com.example.demo1.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.ExceptionHandling.EntityAlreadyExistsException;
import com.example.demo1.ExceptionHandling.EntityNotPresentexception;
import com.example.demo1.Repositry.StudentRepositry;
import com.example.demo1.dao.ClassDao;
import com.example.demo1.dao.StudentDao;
import com.example.demo1.entity.Class;
import com.example.demo1.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImplementation implements StudentDao {
	@Autowired
	public StudentRepositry repositry;

	@Autowired
	public ClassDao classDao;

	@Override
	public Student saveStudent(Student s) {
		if (repositry.existsByEmail(s.getEmail())) {
			throw new EntityAlreadyExistsException("Student is Already present with the email " + s.getEmail());
		}
		if (repositry.existsByPhoneno(s.getPhoneno())) {
			throw new EntityAlreadyExistsException("Student is Already present with the PhoneNumber " + s.getPhoneno());
		}

		return repositry.save(s);
	}

	@Override
	public Student updateStudent(Student s, int id) {
		Student student = fetchstudentById(id);
		Optional<Student> optional = repositry.findByEmail(s.getEmail());
		if (optional.isPresent()) {
			if (optional.get().getId() != id) {
				throw new EntityAlreadyExistsException("Student is already present with email" + s.getEmail());
			}
		}

		Optional<Student> optional2 = repositry.findByPhoneno(s.getPhoneno());
		if (optional2.isPresent()) {
			if (optional2.get().getId() != id) {
				throw new EntityAlreadyExistsException(
						"Student is already present with this PhoneNumber" + s.getPhoneno());
			}
		}
		s.setId(id);
		return repositry.save(s);
	}

	@Override
	public Student fetchstudentById(int id) {
		Optional<Student> optional = repositry.findById(id);
		return optional.orElseThrow(
				() -> new EntityNotPresentexception("Student with the id " + id + " is not present in the database "));
	}

	@Override
	public Student fetchByNumber(String number) {
		Optional<Student> optional = repositry.findByPhoneno(number);
		return optional.orElseThrow(() -> new EntityNotPresentexception(
				"Student with the number " + number + "Is not Present in the Database"));

	}

	@Override
	public List<Student> fetchstudentByclassName(String classname) {
		Class name = classDao.fetchClassByName(classname);
		return name.getStudents();
	}

	@Override
	public boolean deletestudentById(int id) {
		Student student = fetchstudentById(id);
		repositry.delete(student);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteStudentByNumber(String number) {
		if (!repositry.existsByPhoneno(number)) {
			throw new EntityNotPresentexception("Student with the number " + number + " is not available to delete");
		}
		repositry.deleteByPhoneno(number);
		return true;
	}

}
