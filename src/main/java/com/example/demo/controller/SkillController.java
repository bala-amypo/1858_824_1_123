package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/create")
    public Skill createSkill(@RequestBody Skill skill){
        return skillService.createSkill(skill);
    }

    @PutMapping("/update/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skill){
        return skillService.updateSkill(id, skill);
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id){
        return skillService.getSkillById(id);
    }

    @GetMapping("/all")
    public List<Skill> getAllSkills(){
        return skillService.getAllSkills();
    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateSkill(@PathVariable Long id){
        return skillService.deactivateSkill(id);
    }
}
