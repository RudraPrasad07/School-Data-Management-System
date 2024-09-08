package com.example.demo1.dao;

import java.util.List;

import com.example.demo1.entity.Mark;

public interface MarksDao {
	Mark saveMark(Mark m, int studentId, int subjectID);

	Mark upDateMark(Mark m, int id);

	Mark fetchBymarkByID(int id);

	List<Mark> fetchMarkByStudentId(int Id);

	boolean deleteByID(int Id);

	List<Mark> fetchMarkBySubjectId(int Id);

}
