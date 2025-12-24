package com.somedomain.collab_editor.lock;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentLockRepository extends JpaRepository<DocumentLock, Long> {
    Optional<DocumentLock> findByDocumentId(Long documentId);
}
