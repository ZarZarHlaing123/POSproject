package com.example.demo.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;
import com.example.demo.model.SubCategory;

import jakarta.validation.Valid;

public interface SubCategoryRepository extends JpaRepository <SubCategory, Integer> {




}
