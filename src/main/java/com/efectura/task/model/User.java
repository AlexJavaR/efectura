package com.efectura.task.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String sessionId;

    @NotNull
    private String name;

    public User() {
    }
}
