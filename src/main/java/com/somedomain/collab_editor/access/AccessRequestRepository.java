package com.somedomain.collab_editor.access;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somedomain.collab_editor.auth.User;
import com.somedomain.collab_editor.document.Document;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
    List<AccessRequest> findByDocument(Document document);
    List<AccessRequest> findByRequester(User requester);
    Optional<AccessRequest> findByDocumentAndRequester(Document document, User requester);
    List<AccessRequest> findByDocumentAndStatus(Document doc, AccessRequestStatus status);
    List<AccessRequest> findByRequesterAndStatus(User requester, AccessRequestStatus status);
}
