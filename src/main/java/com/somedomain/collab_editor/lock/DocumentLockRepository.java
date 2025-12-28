package com.somedomain.collab_editor.lock;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somedomain.collab_editor.document.Document;

public interface DocumentLockRepository extends JpaRepository<DocumentLock, Document> {
    Optional<DocumentLock> findByDocument(Document document);
    void deleteByDocument(Document document);
}
