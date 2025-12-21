package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skillCategory")
public class SkillCategoryController {

    @Autowired
    SkillCategoryService skillCategoryService;

    @PostMapping("/create")
    public SkillCategory createSkillCategory(@RequestBody SkillCategory skillCategory) {
        return skillCategoryService.createSkillCategory(skillCategory);
    }

    @PutMapping("/update/{id}")
    public SkillCategory updateSkillCategory(@PathVariable Long id,@RequestBody SkillCategory skillCategory) {
        return skillCategoryService.updateSkillCategory(id, skillCategory);
    }

    @GetMapping("/get/{id}")
    public SkillCategory getSkillCategoryById(@PathVariable Long id) {
        return skillCategoryService.getSkillCategoryById(id);
    }

    @GetMapping("/getAll")
    public List<SkillCategory> getAllSkillCategories() {
        return skillCategoryService.getAllSkillCategories();
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateSkillCategory(@PathVariable Long id) {
        return skillCategoryService.deactivateSkillCategory(id);
    }
}
