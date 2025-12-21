package com.example.demo.service.impl;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.SkillRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class SkillServiceImpl implements SkillService{

    @Autowired
    SkillRepository obj;

   public Skill createSkill(Skill skill){
    return obj.save(skill);
   }
public Skill updateSkill(Long id,Skill skill){
    Skill exi=obj.getById(id);
    exi.setId(Skill.getId());
    exi.setName(Skill.getName());
    exi.setCategory(Skill.getCategory());
    exi.setDescription(Skill.getDescription());
    exi.setActive(Skill.getActive());
}
public Skill getSkillById(Long id){
    return obj.findById(id);
}
public List<Skill> getAllSkills(){
    return obj.findAll();
}
public void deactiveSkill(Long id){
    Skill jk=obj.getById(id);
    obj.delete(jk);
}
}
