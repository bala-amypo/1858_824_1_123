package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/skill-categories")
public class SkillCategoryController {

    private final SkillCategoryService skillCategoryService;

    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }

    @PostMapping
    public ResponseEntity<SkillCategory> create(
            @RequestBody SkillCategory category
    ) {
        return ResponseEntity.ok(skillCategoryService.createCategory(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillCategory> update(
            @PathVariable Long id,
            @RequestBody SkillCategory category
    ) {
        return ResponseEntity.ok(
                skillCategoryService.updateCategory(id, category)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillCategory> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                skillCategoryService.getCategoryById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<SkillCategory>> getAll() {
        return ResponseEntity.ok(skillCategoryService.getAllCategories());
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        skillCategoryService.deactivateCategory(id);
        return ResponseEntity.ok().build();
    }
}
