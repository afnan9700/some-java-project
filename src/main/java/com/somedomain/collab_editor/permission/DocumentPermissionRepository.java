package com.somedomain.collab_editor.permission;

import com.somedomain.collab_editor.document.Document;
import com.somedomain.collab_editor.auth.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentPermissionRepository extends JpaRepository<DocumentPermission, Long> {
    Optional<DocumentPermission> findByDocumentAndUser(Document document, User user);
    List<DocumentPermission> findByUser(User user);
    List<DocumentPermission> findByDocument(Document document);
    boolean existsByDocumentAndUser(Document document, User user);
}
