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
public class SkillServiceimpl implements SkillService{

    @Autowired
    SkillRepository obj;

    @Override
    public Skill createSkill(Skill skill){
        return obj.save(skill);
    }

    @Override
    public Skill updateSkill(Long id,Skill skill){

        Skill exi = obj.findById(id).orElse(null); 

        if(exi != null){
            exi.setId(skill.getId());              
            exi.setName(skill.getName());
            exi.setCategory(skill.getCategory());
            exi.setDescription(skill.getDescription());
            exi.setActive(skill.getActive());
            
            return obj.save(exi);                  
        }

        return null;                               
    }

    @Override
    public Skill getSkillById(Long id){
        return obj.findById(id).orElse(null);      
    }

    @Override
    public List<Skill> getAllSkills(){
        return obj.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateSkill(Long id){

        Skill jk = obj.findById(id).orElse(null);   

            jk.setActive(false);
            obj.save(jk);
            return ResponseEntity.ok("Skill Deactivated");
    }
}
