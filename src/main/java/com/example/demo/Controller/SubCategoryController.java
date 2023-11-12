package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.SubCategoryRepository;
import com.example.demo.model.Category;
import com.example.demo.model.SubCategory;

import jakarta.validation.Valid;


@Controller
public class SubCategoryController {
	@Autowired 
	private SubCategoryRepository subcategoryRepo;
	
	@GetMapping("/subcategory")
	public String subCategoryPage(Model model) {
		List<SubCategory> subCategories = subcategoryRepo.findAll();
		model.addAttribute("subCategories", subCategories);
		return "admin/subCategory/index";
	}
	
	
	@GetMapping("/subcategory/add")
	public String ShowSubCategory(Model model) {
		SubCategory subcategory = new SubCategory();
		model.addAttribute("subcategory", subcategory);
		return "admin/subcategory/add";
	}
	
	@PostMapping("/subcategory/add")
	public String AddSubCategory(SubCategory subcategory,RedirectAttributes redirectAttributes) {
		
		subcategoryRepo.save(subcategory);
		redirectAttributes.addFlashAttribute("success","SubCategory Add successful!!");
		return "redirect:/subcategory";
	}
	
}
