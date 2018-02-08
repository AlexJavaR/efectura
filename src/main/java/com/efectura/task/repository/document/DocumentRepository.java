package com.efectura.task.repository.document;

import com.efectura.task.model.Document;
import com.efectura.task.model.User;

import java.util.List;

public interface DocumentRepository {
    Document update(Document document);

    Document save(Document document);

    Document findOne(Integer documentId);

    List<Document> findAll();

    Document getByUser(User user);
}
