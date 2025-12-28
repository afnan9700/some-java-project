package com.somedomain.collab_editor.invite;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;
import java.util.Optional;

public interface InviteRepository extends JpaRepository<Invite, Long> {
    Optional<Invite> findByToken(String token);
    // convenience to only find non-expired invites:
    Optional<Invite> findByTokenAndExpiresAtAfter(String token, Instant now);
}
