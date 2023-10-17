package studentmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import studentmvc.dao.StudentDao;
import studentmvc.dto.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentDao dao;

	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("register.jsp");
		return modelAndView;
	}
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView=new ModelAndView();
		
		Student dbStudent=dao.saveStudent(student);
		
		List<Student> list=dao.getAllStudents();
		
		modelAndView.addObject("list", list);
		modelAndView.setViewName("display.jsp");
		return modelAndView;
	}
	
	
}
