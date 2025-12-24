package com.somedomain.collab_editor.invite;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "invites", indexes = @Index(columnList = "token"))    // for quick lookup by token
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // the doc this invite is for
    @Column(nullable = false)
    private Long documentId;

    @Column(nullable = false)
    private Long ownerId; // convenience: who created the invite (should equal document.ownerId)

    @Column(nullable = false, unique = true)
    private String token; // random token used in invite link

    private boolean autoApprove = false; // if true, redeeming the invite grants permission immediately

    private Instant expiresAt; // optional expiry

    private Instant createdAt = Instant.now();

    public Invite() {}

    public Invite(Long documentId, Long ownerId, boolean autoApprove, Instant expiresAt) {
        this.documentId = documentId;
        this.ownerId = ownerId;
        this.token = UUID.randomUUID().toString();
        this.autoApprove = autoApprove;
        this.expiresAt = expiresAt;
        this.createdAt = Instant.now();
    }

    // getters/setters
    public Long getId() { return id; }
    public Long getDocumentId() { return documentId; }
    public Long getOwnerId() { return ownerId; }
    public String getToken() { return token; }
    public boolean isAutoApprove() { return autoApprove; }
    public Instant getExpiresAt() { return expiresAt; }
    public Instant getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setDocumentId(Long documentId) { this.documentId = documentId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    public void setToken(String token) { this.token = token; }
    public void setAutoApprove(boolean autoApprove) { this.autoApprove = autoApprove; }
    public void setExpiresAt(Instant expiresAt) { this.expiresAt = expiresAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
