package com.example.springboot;

import jakarta.persistence.*;

@Entity
@Table(name = "updates")
public class Update {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "affected_team", nullable = false)
    private String affected_team;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "submited_by", nullable = false)
    private String submited_by;
    public Update(){

    }
    public Update(String title, String affected_team, String description, String submited_by) {
        this.title = title;
        this.affected_team = affected_team;
        this.description = description;
        this.submited_by = submited_by;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAffected_team() {
        return affected_team;
    }

    public void setAffected_team() {
        this.affected_team = affected_team;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmited_by() {
        return submited_by;
    }

    public void setSubmited_by() {
        this.submited_by = submited_by;
    }


}