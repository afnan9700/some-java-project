package com.somedomain.collab_editor.access;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
    List<AccessRequest> findByInviteIdAndStatus(Long inviteId, AccessRequest.RequestStatus status);
    List<AccessRequest> findByRequesterId(Long requesterId);
    Optional<AccessRequest> findByInviteIdAndRequesterId(Long inviteId, Long requesterId);
    List<AccessRequest> findByStatus(AccessRequest.RequestStatus status);
}
