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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "my_sequence", initialValue = 1000, allocationSize = 10)
    private Integer id;

    @NotNull
    private boolean termAgree;

    @OneToOne(cascade = {CascadeType.ALL})
    private User user;

    private String sectorIds;

    public Document() {
    }

    public Document(boolean termAgree, User user, String sectorIds) {
        this.termAgree = termAgree;
        this.user = user;
        this.sectorIds = sectorIds;
    }
}
