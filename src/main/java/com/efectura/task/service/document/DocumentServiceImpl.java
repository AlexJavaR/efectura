package com.efectura.task.service.document;

import com.efectura.task.dto.DocumentDTO;
import com.efectura.task.model.Document;
import com.efectura.task.model.Sector;
import com.efectura.task.model.User;
import com.efectura.task.repository.document.DocumentRepository;
import com.efectura.task.repository.sector.SectorRepository;
import com.efectura.task.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;
    private final SectorRepository sectorRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, UserRepository userRepository,
                               SectorRepository sectorRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
        this.sectorRepository = sectorRepository;
    }

    @Override
    public DocumentDTO save(DocumentDTO documentDTO, String sessionId) {
        User user = userRepository.getBySessionId(sessionId);

        if (user != null) {
            Document document = documentRepository.getByUser(user);
            if (document != null) {
                document.getUser().setName(documentDTO.getUserName());
                document.setTermAgree(documentDTO.isTermAgree());
                document.setSectorIds(listToStringSeparateComa(documentDTO.getSectorIds()));
                document = documentRepository.update(document);
                return new DocumentDTO(document.isTermAgree(), document.getUser().getName(), new ArrayList<>(Arrays.asList(document.getSectorIds().split(","))));
            }
        } else {
            user = new User(sessionId, documentDTO.getUserName());
//            user = userRepository.save(user);
            Document document = new Document(documentDTO.isTermAgree(), user, listToStringSeparateComa(documentDTO.getSectorIds()));
            document = documentRepository.save(document);
            return new DocumentDTO(document.isTermAgree(), document.getUser().getName(), new ArrayList<>(Arrays.asList(document.getSectorIds().split(","))));
        }
        return null;
    }

    @Override
    public Document update(Document document) {
        return documentRepository.update(document);
    }

    @Override
    public Document findOne(Integer documentId) {
        return documentRepository.findOne(documentId);
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public DocumentDTO getBySession(String sessionId) {
        User user = userRepository.getBySessionId(sessionId);
        if (user != null) {
            Document document = documentRepository.getByUser(user);
            return new DocumentDTO(document.isTermAgree(), user.getName(), new ArrayList<>(Arrays.asList(document.getSectorIds().split(","))));
        } else return null;
    }

    public String listToStringSeparateComa(List<String> sectorIds) {
        if (sectorIds == null || sectorIds.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String id : sectorIds) {
            stringBuilder.append(id).append(",");
        }
        return String.valueOf(stringBuilder.substring(0, stringBuilder.length() - 1));
    }
}
