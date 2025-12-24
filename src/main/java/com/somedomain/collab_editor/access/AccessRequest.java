package com.somedomain.collab_editor.access;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "access_requests",
       indexes = @Index(columnList = "invite_id"))
public class AccessRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invite_id", nullable = false)
    private Long inviteId;

    @Column(name = "requester_id", nullable = false)
    private Long requesterId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status = RequestStatus.PENDING;

    private String message; // optional message the requester can attach

    private Instant createdAt = Instant.now();
    private Instant processedAt;

    public AccessRequest() {}

    public AccessRequest(Long inviteId, Long requesterId, String message) {
        this.inviteId = inviteId;
        this.requesterId = requesterId;
        this.message = message;
        this.createdAt = Instant.now();
        this.status = RequestStatus.PENDING;
    }

    // getters/setters
    public Long getId() { return id; }
    public Long getInviteId() { return inviteId; }
    public Long getRequesterId() { return requesterId; }
    public RequestStatus getStatus() { return status; }
    public String getMessage() { return message; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getProcessedAt() { return processedAt; }

    public void setId(Long id) { this.id = id; }
    public void setInviteId(Long inviteId) { this.inviteId = inviteId; }
    public void setRequesterId(Long requesterId) { this.requesterId = requesterId; }
    public void setStatus(RequestStatus status) { this.status = status; }
    public void setMessage(String message) { this.message = message; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public void setProcessedAt(Instant processedAt) { this.processedAt = processedAt; }

    public enum RequestStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}
