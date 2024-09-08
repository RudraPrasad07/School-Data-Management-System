package com.example.demo1.daoImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo1.ExceptionHandling.EntityAlreadyExistsException;
import com.example.demo1.ExceptionHandling.EntityNotPresentexception;
import com.example.demo1.Repositry.ClassRepositry;
import com.example.demo1.dao.ClassDao;
import com.example.demo1.entity.Class;

import jakarta.transaction.Transactional;

@Repository
public class ClassDaoImplementation implements ClassDao {

	@Autowired
	public ClassRepositry repositry;

	@Override
	public Class Saveclass(Class c) {
		checkIsPresent(c);
		return repositry.save(c);
	}

	@Override
	public Class Updateclass(Class c, int id) {
		checkIsPresent(c);
		if (repositry.existsById(id)) {
			c.setId(id);
			return repositry.save(c);

		}
		throw new EntityNotPresentexception(
				"Entity Not Present with the id" + id + "So we can Updated this class details");
	}

	@Override
	public Class fetchClassById(int id) {
		Optional<Class> optional = repositry.findById(id);
		return optional.orElseThrow(() -> new EntityNotPresentexception("Class is not present with the Id" + id));
	}

	@Override
	public List<Class> fetchClassesByAcademiCYear(int year) {
		if (!repositry.existsByAcademicYear(year)) {
			throw new EntityNotPresentexception("Class is not Present With year" + year);
		}
		return repositry.findByAcademicYear(year);
	}

	@Override
	public boolean deleteClassById(int id) {

		repositry.delete(fetchClassById(id));
		return true;
	}

	@Override
	@Transactional
	public boolean deleteClassesByAcademiCYear(int year) {
		if (repositry.existsByAcademicYear(year)) {
			repositry.deleteByAcademicYear(year);
			return true;
		}

		throw new EntityNotPresentexception("Entity Not Present With the Year" + year);
	}

	@Override
	public Class fetchClassByName(String name) {
		Optional<Class> nameOptional = repositry.findByname(name);
		return nameOptional.orElseThrow(() -> new EntityNotPresentexception("Entity Not Present With the Name" + name));
	}

	private void checkIsPresent(Class c) {
		boolean year = repositry.existsByAcademicYear(c.getAcademicYear());
		boolean name = repositry.existsByName(c.getName());
		if (year && name) {
			throw new EntityAlreadyExistsException(
					"Class data is already exists with year: " + c.getAcademicYear() + "and the name:" + c.getName());
		}

	}
}
