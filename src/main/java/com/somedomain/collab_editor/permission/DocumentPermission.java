package com.somedomain.collab_editor.permission;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "document_permissions",
       uniqueConstraints = @UniqueConstraint(columnNames = {"document_id", "user_id"}))
public class DocumentPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_id", nullable = false)
    private Long documentId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermissionRole role;

    private Instant grantedAt = Instant.now();

    public DocumentPermission() {}

    public DocumentPermission(Long documentId, Long userId, PermissionRole role) {
        this.documentId = documentId;
        this.userId = userId;
        this.role = role;
        this.grantedAt = Instant.now();
    }

    // getters/setters
    public Long getId() { return id; }
    public Long getDocumentId() { return documentId; }
    public Long getUserId() { return userId; }
    public PermissionRole getRole() { return role; }
    public Instant getGrantedAt() { return grantedAt; }

    public void setId(Long id) { this.id = id; }
    public void setDocumentId(Long documentId) { this.documentId = documentId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setRole(PermissionRole role) { this.role = role; }
    public void setGrantedAt(Instant grantedAt) { this.grantedAt = grantedAt; }

    public enum PermissionRole {
        VIEWER,
        EDITOR
    }
}
