package com.alelekov.bugtracking.repositories;

import com.alelekov.bugtracking.entities.Projects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Projects, Long> {
    Page<Projects> findByNameProject(String nameProject, Pageable pageable);

    Page<Projects> findAll(Pageable pageable);
}
