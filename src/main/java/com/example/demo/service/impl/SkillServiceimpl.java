package com.example.demo.service.impl;

import com.example.demo.service.SkillService;
import com.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.SkillRepository;
import jakarta.stereotype.Service;
import java.util.List;
import com.springframework.http.ResponseEntity;

@Service
public class SkillServiceimpl implements SkillService{
    @Autowired
    SkillRepository obj;
    Skill createSkill(Skill skill){
        return obj.save(skill);
    }
    Skill updateSkill(Long id,Skill skill){
        
    }
    Skill getSkillById(Long id);
    List<Skill> getAllSkills();
    ResponseEntity<String> deactivateSkill(Long id);
}