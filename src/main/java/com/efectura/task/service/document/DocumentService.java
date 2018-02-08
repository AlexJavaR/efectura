package com.efectura.task.service.document;

import com.efectura.task.dto.DocumentDTO;
import com.efectura.task.model.Document;

import java.util.List;

public interface DocumentService {
    DocumentDTO save(DocumentDTO documentDTO, String sessionId);

    Document findOne(Integer id);

    List<Document> findAll();

    Document update(Document document);

    DocumentDTO getBySession(String sessionId);
}
