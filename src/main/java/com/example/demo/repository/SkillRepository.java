package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.SkillCategory;

public interface Skill extends JpaRepository<SkillCategory,Long>{

}