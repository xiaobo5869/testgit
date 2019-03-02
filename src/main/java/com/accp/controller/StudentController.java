package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Student;
import com.accp.service.impl.StudentServiceImpl;
import com.fasterxml.jackson.annotation.JsonAlias;

@Controller
public class StudentController {
	
	@Autowired
	StudentServiceImpl stu;
	
	@RequestMapping("/query")
	public String query(Model model){
		List<Student> list=stu.query();
		model.addAttribute("list", list);
		return "query";
	}
	
	@RequestMapping("/queryById")
	public String queryById(Model model,Integer id) {
		Student slist=stu.queryById(id);
		model.addAttribute("slist", slist);
		return "update";
	}
	
	@RequestMapping("/update")
	public String update(@RequestBody Student record) {
		System.out.println("sadasdas");
		int i=stu.updateById(record);
		return "redirect:query";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		int i=stu.delete(id);
		return "redirect:query";
	}
	
	@RequestMapping("/insert")
	public String insert(Student record) {
		int i=stu.insert(record);
		return "redirect:query";
	}
	
	@RequestMapping("/toinsert")
	public String toinsert() {
		return "insert";
	}
}
