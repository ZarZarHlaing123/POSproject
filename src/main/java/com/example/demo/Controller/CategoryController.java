package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Category;
import java.util.List;

import com.example.demo.dto.CategoryRepository;



@Controller

public class CategoryController {
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@GetMapping("/category")
	public String viewCategory(Model model) {
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		return "admin/category/index";
	}
	
	@GetMapping("/category/add")
	public String ShowCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "admin/category/add";
	}
	
	@PostMapping("/category/add")
	public String AddCategory(Category category) {
		categoryRepository.save(category);
		return "redirect:/category";
	}
	
	
}
