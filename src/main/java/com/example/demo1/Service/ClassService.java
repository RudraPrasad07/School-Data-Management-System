package com.example.demo1.Service;

import java.util.List;

import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Class;

public interface ClassService {
	ResponseStructure<Class> Saveclass(Class c);

	ResponseStructure<Class> Updateclass(int id, Class c);

	ResponseStructure<Class> fetchClassById(int id);

	ResponseStructure<List<Class>> fetchClassesByAcademiCYear(int year);

	ResponseStructure<Class> deleteClassById(int id);

	ResponseStructure<Class> deleteClassesByAcademiCYear(int yearF);

}
