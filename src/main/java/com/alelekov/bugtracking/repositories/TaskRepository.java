package com.alelekov.bugtracking.repositories;

import com.alelekov.bugtracking.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks, Integer> {

}
