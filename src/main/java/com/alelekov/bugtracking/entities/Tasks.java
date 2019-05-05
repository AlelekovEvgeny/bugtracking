package com.alelekov.bugtracking.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameTask;

    @Column(name = "discription")
    private String discriptionTask;

    @Column(name = "priority")
    private int priorityTask;

    @Column(name = "date_create")
    private Date dateCreateTask;

    @Column(name = "date_update")
    private Date dateUpdateTask;

    @Column(name = "status")
    private int statusTask;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull
    Projects projects;

    public Tasks() {
    }
    public Tasks(String nameTask, String discriptionTask, int priorityTask, int statusTask, String dateCreateTask, String dateUpdateTask) {
    }

    public Tasks(String nameTask, String discriptionTask) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDiscriptionTask() {
        return discriptionTask;
    }

    public void setDiscriptionTask(String discriptionTask) {
        this.discriptionTask = discriptionTask;
    }

    public int getPriorityTask() {
        return priorityTask;
    }

    public void setPriorityTask(int priorityTask) {
        this.priorityTask = priorityTask;
    }

    public Date getDateCreateTask() {
        return dateCreateTask;
    }

    public void setDateCreateTask(Date dateCreateTask) {
        this.dateCreateTask = dateCreateTask;
    }

    public Date getDateUpdateTask() {
        return dateUpdateTask;
    }

    public void setDateUpdateTask(Date dateUpdateTask) {
        this.dateUpdateTask = dateUpdateTask;
    }

    public int getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(int statusTask) {
        this.statusTask = statusTask;
    }

    public Projects getProjects() {
        return projects;
    }

    public void setProjects(Projects projects) {
        this.projects = projects;
    }
}
