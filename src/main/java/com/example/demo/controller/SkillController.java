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

    // -------------------------------
    // CREATE SKILL
    // -------------------------------
    @PostMapping("/create")
    public Skill createSkill(@RequestBody Skill skill){
        return skillService.createSkill(skill);
    }

    // -------------------------------
    // UPDATE SKILL
    // -------------------------------
    @PutMapping("/update/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skill){
        return skillService.updateSkill(id, skill);
    }

    // -------------------------------
    // GET SKILL BY ID
    // -------------------------------
    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id){
        return skillService.getSkillById(id);
    }

    // -------------------------------
    // GET ALL SKILLS
    // -------------------------------
    @GetMapping("/all")
    public List<Skill> getAllSkills(){
        return skillService.getAllSkills();
    }

    // -------------------------------
    // DEACTIVATE SKILL
    // -------------------------------
    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateSkill(@PathVariable Long id){
        return skillService.deactivateSkill(id);
    }
}
