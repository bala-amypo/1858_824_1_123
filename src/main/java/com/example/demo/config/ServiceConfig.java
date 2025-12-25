package com.example.demo.config;

import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.service.impl.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public EmployeeService employeeService(EmployeeRepository repo) {
        return new EmployeeServiceImpl(repo);
    }

    @Bean
    public SkillService skillService(SkillRepository repo) {
        return new SkillServiceImpl(repo);
    }

    @Bean
    public EmployeeSkillService employeeSkillService(
            EmployeeSkillRepository esRepo,
            EmployeeRepository eRepo,
            SkillRepository sRepo) {

        return new EmployeeSkillServiceImpl(esRepo, eRepo, sRepo);
    }

    @Bean
    public SkillCategoryService skillCategoryService(SkillCategoryRepository repo) {
        return new SkillCategoryServiceImpl(repo);
    }

    @Bean
    public SearchQueryService searchQueryService(
            SearchQueryRecordRepository sqRepo,
            EmployeeSkillRepository esRepo) {

        return new SearchQueryServiceImpl(sqRepo, esRepo);
    }
}
