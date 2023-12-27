package org.choongang.repositories;

import org.choongang.entities.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository extends JpaRepository<Hashtag, String> {
}
