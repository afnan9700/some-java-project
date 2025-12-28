package com.somedomain.collab_editor.document;

import com.somedomain.collab_editor.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByOwner(User owner);
    // other query methods can be added as needed, e.g. findByTitleContaining(...)
}
