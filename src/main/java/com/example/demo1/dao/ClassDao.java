package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.entity.Class;

public interface ClassDao {
	Class Saveclass(Class c);

	Class Updateclass(Class c, int id);

	Class fetchClassById(int id);

	List<Class> fetchClassesByAcademiCYear(int year);

	Class fetchClassByName(String name);

	boolean deleteClassById(int id);

	boolean deleteClassesByAcademiCYear(int year);

}
