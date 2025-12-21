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

    // CREATE SkillCategory
    @PostMapping("/create")
    public SkillCategory createSkillCategory(@RequestBody SkillCategory skillCategory) {
        return skillCategoryService.createSkillCategory(skillCategory);
    }

    // UPDATE SkillCategory
    @PutMapping("/update/{id}")
    public SkillCategory updateSkillCategory(@PathVariable Long id,
                                             @RequestBody SkillCategory skillCategory) {
        return skillCategoryService.updateSkillCategory(id, skillCategory);
    }

    // GET BY ID
    @GetMapping("/get/{id}")
    public SkillCategory getSkillCategoryById(@PathVariable Long id) {
        return skillCategoryService.getSkillCategoryById(id);
    }

    // GET ALL
    @GetMapping("/getAll")
    public List<SkillCategory> getAllSkillCategories() {
        return skillCategoryService.getAllSkillCategories();
    }

    // DEACTIVATE (SOFT DELETE)
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateSkillCategory(@PathVariable Long id) {
        return skillCategoryService.deactivateSkillCategory(id);
    }
}
