package com.efectura.task.dto;

import lombok.Data;

import java.util.List;

@Data
public class DocumentDTO {
    private boolean termAgree;
    private String userName;
    private List<String> sectorIds;

    public DocumentDTO() {
    }

    public DocumentDTO(boolean termAgree, String userName, List<String> sectorIds) {
        this.termAgree = termAgree;
        this.userName = userName;
        this.sectorIds = sectorIds;
    }
}
