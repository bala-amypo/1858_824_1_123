package com.example.demo.service;

import com.example.demo.model.Skill;
import java.util.List;
import org.springframework.ResponseEntity;
public interface SkillService{
    Skill createSkill(Skill skill);
    Skill updateSkill(Long id,Skill skill);
    Skill getSkillById(Long id);
    List<Skill> getAllSkills();
    ResponseEntity<String> deactivateSkill(Long id);
}