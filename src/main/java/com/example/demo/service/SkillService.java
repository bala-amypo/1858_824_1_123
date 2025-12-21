package com.example.demo.service;

import com.example.demo.model.Skill;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface SkillService{
   public  Skill createSkill(Skill skill);
    public Skill updateSkill(Long id,Skill skill);
    public Skill getSkillById(Long id);
    public List<Skill> getAllSkills();
    public ResponseEntity<String> deactivateSkill(Long id);
}
