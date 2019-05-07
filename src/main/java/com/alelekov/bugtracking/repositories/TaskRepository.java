package com.alelekov.bugtracking.repositories;

import com.alelekov.bugtracking.entities.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Tasks, Integer> {

    @Query("SELECT t FROM Tasks t WHERE t.projects.id=:idProject")
    List<Tasks> getAll(@Param("idProject") Long idProject);

    Page<Tasks> findByNameTask(String filter, Pageable pageable);
}