package com.nedeljko.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    private final UUID id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private UUID token;

    @OneToMany
    private List<Job> jobs_list = new ArrayList<>();


    public User() {
        this.id = UUID.randomUUID();
    }

    public User(UUID id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("last_name") String lastName,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("token") UUID token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.password = password;
        this.token = token;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UUID getToken() {
        return token;
    }

    public void generateToken() {
        this.token = UUID.randomUUID();
    }

    public void deletToken() {
        this.token = null;
    }

    public List<Job> getJobs_list() {
        return jobs_list;
    }

    public void setJobs_list(List<Job> jobs_list) {
        this.jobs_list = jobs_list;
    }
}
