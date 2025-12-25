package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-categories")
public class SkillCategoryController {

    private final SkillCategoryService service;

    public SkillCategoryController(SkillCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public SkillCategory create(@RequestBody SkillCategory c) {
        return service.createCategory(c);
    }

    @PutMapping("/{id}")
    public SkillCategory update(@PathVariable Long id, @RequestBody SkillCategory c) {
        return service.updateCategory(id, c);
    }

    @GetMapping("/{id}")
    public SkillCategory get(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @GetMapping
    public List<SkillCategory> list() {
        return service.getAllCategories();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateCategory(id);
    }
}
