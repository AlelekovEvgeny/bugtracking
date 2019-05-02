package com.alelekov.bugtracking.repositories;

import com.alelekov.bugtracking.entities.Projects;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Projects, Long> {
}
