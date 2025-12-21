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

    @Override
    public Skill createSkill(Skill skill){
        return obj.save(skill);
    }

    @Override
    public Skill updateSkill(Long id, Skill skill){
        Optional<Skill> existing = obj.findById(id);

        if(existing.isPresent()){
            Skill update = existing.get();
            update.setSkillName(skill.getSkillName());
            update.setDescription(skill.getDescription());
            update.setActive(skill.getActive());

            return obj.save(update);
        }
        return null; 
    }
    @Override
    public Skill getSkillById(Long id){
        return obj.findById(id)
                  .orElse(null);
    }

    @Override
    public List<Skill> getAllSkills(){
        return obj.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateSkill(Long id){

        Optional<Skill> skill = obj.findById(id);

        if(skill.isPresent()){
            Skill temp = skill.get();
            temp.setActive(false);
            obj.save(temp);

            return ResponseEntity.ok("Skill Deactivated Successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Skill Not Found");
    }
}
