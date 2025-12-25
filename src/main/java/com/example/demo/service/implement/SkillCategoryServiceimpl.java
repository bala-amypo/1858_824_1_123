package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SkillCategoryRepository;

import java.util.List;
import org.springframework.http.ResponseEntity;

@Service
public class SkillCategoryServiceimpl implements SkillCategoryService {

    @Autowired
    SkillCategoryRepository obj;

    @Override
    public SkillCategory createSkillCategory(SkillCategory skillCategory){
        return obj.save(skillCategory);
    }

    @Override
    public SkillCategory updateSkillCategory(Long id, SkillCategory skillCategory){

        SkillCategory exi = obj.findById(id).orElse(null);

        if(exi != null){
            exi.setId(skillCategory.getId());
            exi.setCategoryName(skillCategory.getCategoryName());
            exi.setDescription(skillCategory.getDescription());
            exi.setActive(skillCategory.getActive());

            return obj.save(exi);
        }

        return null;
    }

    @Override
    public SkillCategory getSkillCategoryById(Long id){
        return obj.findById(id).orElse(null);
    }

    @Override
    public List<SkillCategory> getAllSkillCategories(){
        return obj.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateSkillCategory(Long id){

        SkillCategory jk = obj.findById(id).orElse(null);

        jk.setActive(false);
        obj.save(jk);

        return ResponseEntity.ok("Skill Category Deactivated");
    }
}
