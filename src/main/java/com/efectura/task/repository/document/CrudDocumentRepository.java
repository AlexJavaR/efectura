package com.efectura.task.repository.document;

import com.efectura.task.model.Document;
import com.efectura.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudDocumentRepository extends JpaRepository<Document, Integer> {
    Document getByUser(User user);
}
