package com.example.demo1.Service;

import java.util.List;

import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Subject;

public interface SubjectService {
	ResponseStructure<Subject> SaveSubject(Subject s, String className);

	ResponseStructure<Subject> UpdateSubject(Subject s, int id);

	ResponseStructure<Subject> fetchSubjectById(int id);

	ResponseStructure<Subject> fetchSubjecBycode(String code);

	ResponseStructure<List<Subject>> fetchSubjecClassName(String className);

	ResponseStructure<List<Subject>> fetchSubjecByStudentID(int sId);

	ResponseStructure<Subject> deleteSubjecByID(int id);

}
