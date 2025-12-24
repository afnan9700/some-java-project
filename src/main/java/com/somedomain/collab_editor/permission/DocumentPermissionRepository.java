package com.somedomain.collab_editor.permission;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentPermissionRepository extends JpaRepository<DocumentPermission, Long> {
    Optional<DocumentPermission> findByDocumentIdAndUserId(Long documentId, Long userId);
    List<DocumentPermission> findByUserId(Long userId);
    List<DocumentPermission> findByDocumentId(Long documentId);
    boolean existsByDocumentIdAndUserId(Long documentId, Long userId);
}
