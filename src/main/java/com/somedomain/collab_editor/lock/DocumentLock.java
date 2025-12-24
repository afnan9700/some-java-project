package com.somedomain.collab_editor.lock;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "document_locks")
public class DocumentLock {

    @Id
    @Column(name = "document_id")
    private Long documentId; // use document id as PK so there's only one lock row per document

    @Column(name = "locked_by_user_id", nullable = false)
    private Long lockedByUserId;

    private Instant lockedAt = Instant.now();

    private Instant expiresAt;

    public DocumentLock() {}

    public DocumentLock(Long documentId, Long lockedByUserId, Instant expiresAt) {
        this.documentId = documentId;
        this.lockedByUserId = lockedByUserId;
        this.lockedAt = Instant.now();
        this.expiresAt = expiresAt;
    }

    // getters/setters
    public Long getDocumentId() { return documentId; }
    public Long getLockedByUserId() { return lockedByUserId; }
    public Instant getLockedAt() { return lockedAt; }
    public Instant getExpiresAt() { return expiresAt; }

    public void setDocumentId(Long documentId) { this.documentId = documentId; }
    public void setLockedByUserId(Long lockedByUserId) { this.lockedByUserId = lockedByUserId; }
    public void setLockedAt(Instant lockedAt) { this.lockedAt = lockedAt; }
    public void setExpiresAt(Instant expiresAt) { this.expiresAt = expiresAt; }
}
