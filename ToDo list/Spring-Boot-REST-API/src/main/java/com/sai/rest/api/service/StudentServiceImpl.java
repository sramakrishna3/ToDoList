package com.sai.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.rest.api.entity.Student;
import com.sai.rest.api.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student createStudent(Student student) {
			
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(long id, Student student) {
		student.setId(id);
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(long id) {
		
		studentRepository.deleteById(id);
	}
	
	  @Override
	    public Student getStudentById(long id) {
	        return studentRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
	    }

}
