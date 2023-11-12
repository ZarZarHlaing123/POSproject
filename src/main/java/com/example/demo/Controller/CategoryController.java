package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Category;

import jakarta.validation.Valid;

import java.util.List;

import com.example.demo.dto.CategoryRepository;



@Controller

public class CategoryController {
	@Autowired 
	private CategoryRepository categoryRepository;
	
	
	@GetMapping("/category/add")
	public String ShowCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "admin/category/add";
	}
	
	@PostMapping("/category/add")
	public String AddCategory(@Valid Category category,BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return "admin/category/add";
		}
		categoryRepository.save(category);
		redirectAttributes.addFlashAttribute("success","Category Add successful!!");
		return "redirect:/category";
	}
	

	@GetMapping("/category")
	public String viewCategory(Model model) {
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		return "admin/category/index";
	}
	
	@GetMapping("/category/delete/{id}")
	public String deleteCategory(@PathVariable("id") Integer id,Model model,RedirectAttributes redirectAttributes) {
		categoryRepository.deleteById(id); 
		redirectAttributes.addFlashAttribute("success","Category Delete successful!!");
		return "redirect:/category";
	}
	
	@GetMapping("/category/update/{id}")
	public String editCategory(@PathVariable("id") Integer id, Model model) {
		Category category = categoryRepository.getReferenceById(id);
		model.addAttribute("category",category);
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		return "admin/category/update";
	}
	@PostMapping("/category/update/{id}")
	public String updateCategory(Category category, @PathVariable ("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
		
		categoryRepository.save(category);
		model.addAttribute("category", category);
		redirectAttributes.addFlashAttribute("success","Category Upddate successful!!");
		return "redirect:/category";
	}
	
}
