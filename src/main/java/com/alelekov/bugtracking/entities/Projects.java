package com.alelekov.bugtracking.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "name_project")
    private String nameProject;

    @Column(name = "discription")
    private String discriptionProject;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_update")
    private Date dateUpdate;

    @OneToMany(mappedBy = "projects")
    List<Tasks> tasks;

    public Projects() {
    }

    public Projects(String nameProject, String discriptionProject) {
        this.nameProject = nameProject;
        this.discriptionProject = discriptionProject;
    }

    public Projects(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscriptionProject() {
        return discriptionProject;
    }

    public void setDiscriptionProject(String discriptionProject) {
        this.discriptionProject = discriptionProject;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
