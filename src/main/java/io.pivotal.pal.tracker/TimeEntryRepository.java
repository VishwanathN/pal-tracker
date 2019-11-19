package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.sql.Time;
import java.util.List;

public interface TimeEntryRepository {

    void delete(long id);

    TimeEntry update(long id,TimeEntry timeEntry);

    List<TimeEntry> list();

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(long timeEntryId);
}
