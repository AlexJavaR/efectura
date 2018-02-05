package com.efectura.task.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "documents")
@Data
public class Document {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private boolean termAgree;

    @OneToOne
    private User user;

    @OneToMany
    private List<Sector> sectors;

    public Document() {
    }
}
