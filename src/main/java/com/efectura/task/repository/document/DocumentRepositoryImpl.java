package com.efectura.task.repository.document;

import com.efectura.task.model.Document;
import com.efectura.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    private final CrudDocumentRepository crudDocumentRepository;

    @Autowired
    public DocumentRepositoryImpl(CrudDocumentRepository crudDocumentRepository) {
        this.crudDocumentRepository = crudDocumentRepository;
    }

    @Override
    public Document update(Document document) {
        return crudDocumentRepository.save(document);
    }

    @Override
    public Document save(Document document) {
        return crudDocumentRepository.save(document);
    }

    @Override
    public Document findOne(Integer documentId) {
        return crudDocumentRepository.findOne(documentId);
    }

    @Override
    public List<Document> findAll() {
        return crudDocumentRepository.findAll();
    }

    @Override
    public Document getByUser(User user) {
        return crudDocumentRepository.getByUser(user);
    }
}
