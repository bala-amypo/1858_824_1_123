package com.example.demo.service;

import com.example.demo.model.SkillCategory;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface SkillCategoryService {
    public SkillCategory createSkillCategory(SkillCategory skillCategory);
    public SkillCategory updateSkillCategory(Long id, SkillCategory skillCategory);
    public SkillCategory getSkillCategoryById(Long id);
    public List<SkillCategory> getAllSkillCategories();
    public ResponseEntity<String> deactivateSkillCategory(Long id);
}
