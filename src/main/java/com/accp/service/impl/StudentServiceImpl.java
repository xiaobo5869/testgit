package com.accp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.domain.Student;
import com.accp.mapper.StudentMapper;

@Service
public class StudentServiceImpl {
	
	@Autowired
	StudentMapper stu;
	
	public List<Student> query(){
		List<Student> list=stu.selectByExample(null);
		return list;
	}
	
	public Student queryById(Integer id) {
		Student slist=stu.selectByPrimaryKey(id);
		return slist;
	}
	
	public int updateById(Student record) {
		int i=stu.updateByPrimaryKey(record);
		return 0;
	}
	
	public int delete(Integer id) {
		int i=stu.deleteByPrimaryKey(id);
		return 0;
	}
	
	public int insert(Student record) {
		int i=stu.insert(record);
		return 0;
	}
}
