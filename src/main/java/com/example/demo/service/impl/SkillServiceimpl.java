package com.example.demo.service.impl;

import com.example.demo.service.SkillService;
import com.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.SkillRepository;
import jakarta.stereotype.Service;
import java.util.List;
import com.springframework.http.

@Service
public class SkillServiceimpl implements SkillService{

    Skill createSkill(Skill skill){
        
    }
    Skill updateSkill(Long id,Skill skill);
    Skill getSkillById(Long id);
    List<Skill> getAllSkills();
    ResponseEntity<String> deactivateSkill(Long id);
}