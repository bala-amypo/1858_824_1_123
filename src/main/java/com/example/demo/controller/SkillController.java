package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public Skill create(@RequestBody Skill s) {
        return skillService.createSkill(s);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill s) {
        return skillService.updateSkill(id, s);
    }

    @GetMapping("/{id}")
    public Skill get(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @GetMapping
    public List<Skill> list() {
        return skillService.getAllSkills();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        skillService.deactivateSkill(id);
    }
}
