package com.mdev.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mdev.spring.entites.Student;
import com.mdev.spring.entites.Teacher;
import com.mdev.spring.services.StudentServiceImp;
import com.mdev.spring.services.TeacherServiceImp;

@Controller
public class MainController {
	
	
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

//	@RequestMapping("/indexTeacher")
//	public ModelAndView userDashboard() {
//		return new ModelAndView("homeTeacher");
//	}
//
//	@RequestMapping("/indexStudent")
//	public ModelAndView adminDashboard() {
//		return new ModelAndView("homeStudent");
//	}
//	***********************************

	@Autowired
	private StudentServiceImp studentServiceImp;

	@RequestMapping(value = "/indexStudent", method = RequestMethod.GET)
	public String indexStudent(Model model) {
//		model.addAttribute("students", this.studentServiceImp.getAllStudent());
//		return "homeStudent";
		
		return findPage(1, "fristName", "asc", model);
	}

	@GetMapping("/addStud")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("studentObj", student);
		return "addStudent";
	}

	@PostMapping("/saveStud")
	public String saveStudent(@ModelAttribute("student") Student student) {
		this.studentServiceImp.saveStudent(student);
		return "redirect:/indexStudent";
	}

	@RequestMapping(value = "/updateStud/{id}", method = RequestMethod.GET)
	public String updateStudent(@PathVariable(value = "id") Long id, Model model) {
		Student student = this.studentServiceImp.findStudentById(id);

		model.addAttribute("updateById", student);
		return "updateStudent";
	}

	@RequestMapping("/deleteStud/{id}")
	public String deleteStudent(@PathVariable(value = "id") Long id) {

		this.studentServiceImp.deleteStudentById(id);
		return "redirect:/indexStudent";

	}

	// Pagination:
	@RequestMapping(value = "/page/{pageNo}", method = RequestMethod.GET)
	public String findPage(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {

		int pageSize = 5;
		Page<Student> page = this.studentServiceImp.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Student> students = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("students", students);
		return "homeStudent";

	}
	
//	****************************************
	
	@Autowired
	private TeacherServiceImp teacherServiceImp;
	
	@RequestMapping(value ="/indexTeacher", method = RequestMethod.GET)
	public String indexTeacher(Model model) {
		
		model.addAttribute("listTeachers", this.teacherServiceImp.getAllTeacher());
		return "homeTeacher";
	}
	
	@RequestMapping(value = "/addTeach", method = RequestMethod.GET)
	public String addTeacher(Model model) {
		
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "addTeacher";
	}
	
	@RequestMapping(value ="/saveTeacher", method = RequestMethod.POST)
	public String saveTeacher(@ModelAttribute("theacherObj") Teacher teacher) {
		
		this.teacherServiceImp.saveTeacher(teacher);
		return "redirect:/indexTeacher";
		
	}
	
	@RequestMapping(value = "/updateTeach/{id}", method = RequestMethod.GET)
	public String updateTeacher(@PathVariable(value = "id") Long id, Model model) {
		
		Teacher teacher = this.teacherServiceImp.findTeacherById(id);
		model.addAttribute("teacherO",teacher);
		return "updateTeacher";
	}
	@GetMapping("/deleteTeach/{id}")
	public String deleteTeach(@PathVariable(value = "id") Long id) {
		this.teacherServiceImp.deleteTeacherById(id);
		return "redirect:/indexTeacher";
	}
}
