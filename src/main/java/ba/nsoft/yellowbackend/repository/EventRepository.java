package ba.nsoft.yellowbackend.repository;

import ba.nsoft.yellowbackend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {}
