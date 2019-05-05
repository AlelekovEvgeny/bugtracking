package com.alelekov.bugtracking.repositories;

import com.alelekov.bugtracking.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Projects, Long> {
    List<Projects> findByNameProject(String nameProject);

    //Projects findById(int id);
}
