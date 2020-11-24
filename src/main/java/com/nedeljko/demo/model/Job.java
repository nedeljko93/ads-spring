package com.nedeljko.demo.model;

import javax.persistence.*;
import java.util.UUID;


@Entity
public class Job {

    @Id
    private UUID id;
    private String job_title;
    private String job_type;
    private String job_description;
    private String requred_skills;
    private String job_offer;
    private String location;
    private String company_name;
    private String date;
    private String requred_level;
    private String technologies_requred;
    private String company_email;
    private boolean is_promoted;
    private String bonus_skills;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Job() {
        this.id = UUID.randomUUID();
    }

    public Job(UUID id, String job_title, String job_description, String requred_skills, String job_offer, String location, String company_name, String date,
               String requred_level, String technologies_requred, String company_email,
               Boolean is_promoted, User user, String bonus_skills) {
        this.id = id;
        this.job_title = job_title;
        this.job_description = job_description;
        this.requred_skills = requred_skills;
        this.job_offer = job_offer;
        this.location = location;
        this.company_name = company_name;
        this.date = date;
        this.requred_level = requred_level;
        this.technologies_requred = technologies_requred;
        this.company_email = company_email;
        this.is_promoted = is_promoted;
        this.user = user;
        this.bonus_skills = bonus_skills;
    }

    public Job(UUID id, String job_title, String job_type, String job_description) {
        this.id = id;
        this.job_title = job_title;
        this.job_type = job_type;
        this.job_description = job_description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public void setIs_promoted(Boolean is_promoted) {
        this.is_promoted = is_promoted;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getJob_type() {
        return job_type;
    }

    public String getJob_description() {
        return job_description;
    }

    public String getRequred_skills() {
        return requred_skills;
    }

    public String getJob_offer() {
        return job_offer;
    }

    public String getLocation() {
        return location;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getDate() {
        return date;
    }

    public String getRequred_level() {
        return requred_level;
    }

    public String getTechnologies_requred() {
        return technologies_requred;
    }

    public String getCompany_email() {
        return company_email;
    }

    public Boolean getIs_promoted() {
        return is_promoted;
    }

    public String getBonus_skills() {
        return bonus_skills;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public void setRequred_skills(String requred_skills) {
        this.requred_skills = requred_skills;
    }

    public void setJob_offer(String job_offer) {
        this.job_offer = job_offer;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRequred_level(String requred_level) {
        this.requred_level = requred_level;
    }

    public void setTechnologies_requred(String technologies_requred) {
        this.technologies_requred = technologies_requred;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public void setBonus_skills(String bonus_skills) {
        this.bonus_skills = bonus_skills;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", job_title='" + job_title + '\'' +
                ", job_type='" + job_type + '\'' +
                ", job_description='" + job_description + '\'' +
                ", requred_skills='" + requred_skills + '\'' +
                ", job_offer='" + job_offer + '\'' +
                ", location='" + location + '\'' +
                ", company_name='" + company_name + '\'' +
                ", date='" + date + '\'' +
                ", requred_level='" + requred_level + '\'' +
                ", technologies_requred='" + technologies_requred + '\'' +
                ", company_email='" + company_email + '\'' +
                ", is_promoted=" + is_promoted +
                ", bonus_skills='" + bonus_skills + '\'' +
                ", user=" + user +
                '}';
    }
}
