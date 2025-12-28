package com.somedomain.collab_editor.access;

import com.somedomain.collab_editor.document.Document;
import com.somedomain.collab_editor.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "access_requests",
       indexes = { @Index(columnList = "document_id"), @Index(columnList = "requester_id") })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccessRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // the document being requested
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    // the user requesting access
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccessRequestStatus status = AccessRequestStatus.PENDING;

    // metadata for auditing
    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    private Instant processedAt;

    // processedBy is the owner (or an admin) who approved/rejected
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processed_by")
    private User processedBy;

    public AccessRequest() {}

    public AccessRequest(Document document, User requester) {
        this.document = document;
        this.requester = requester;
        this.createdAt = Instant.now();
        this.status = AccessRequestStatus.PENDING;
    }

    // getters / setters
    public Long getId() { return id; }
    public Document getDocument() { return document; }
    public User getRequester() { return requester; }
    public AccessRequestStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getProcessedAt() { return processedAt; }
    public User getProcessedBy() { return processedBy; }

    public void setId(Long id) { this.id = id; }
    public void setDocument(Document document) { this.document = document; }
    public void setRequester(User requester) { this.requester = requester; }
    public void setStatus(AccessRequestStatus status) { this.status = status; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setProcessedAt(Instant processedAt) { this.processedAt = processedAt; }
    public void setProcessedBy(User processedBy) { this.processedBy = processedBy; }
}
