package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.entity.Subject;

public interface SubjectDao {

	Subject SaveSubject(Subject s, String className);

	Subject UpdateSubject(Subject s, int id);

	Subject fetchSubjectById(int id);

	Subject fetchSubjecBycode(String code);

	List<Subject> fetchSubjecClassName(String className);

	List<Subject> fetchSubjecByStudentID(int sId);

	boolean deleteSubjecByID(int id);

}
