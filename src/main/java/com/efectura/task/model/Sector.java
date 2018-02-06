package com.efectura.task.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "sectors")
@Data
public class Sector {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    @OneToMany
    @JoinColumn(name = "parent_id")
    @OrderColumn
    private List<Sector> children = new LinkedList<>();

    public Sector() {
    }
}
