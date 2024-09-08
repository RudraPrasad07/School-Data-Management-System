package com.example.demo1.Service;

import java.util.List;

import com.example.demo1.Utility.ResponseStructure;
import com.example.demo1.entity.Mark;

public interface MarksService {

	ResponseStructure<Mark> saveMark(Mark m, int studentId, int subjectID);

	ResponseStructure<Mark> upDateMark(Mark m, int id);

	ResponseStructure<Mark> fetchBymarkByID(int id);

	ResponseStructure<List<Mark>> fetchMarkByStudentId(int Id);

	ResponseStructure<Mark> deleteByID(int Id);

	ResponseStructure<List<Mark>> fetchMarkBySubjectId(int Id);
}
