package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long,TimeEntry> repo = new HashMap<>();

    private Long currentId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(currentId);
        repo.put(currentId,timeEntry);
        currentId++;
        return timeEntry;
    }


    @Override
    public void delete(long id) {
       repo.remove(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(find(id) == null)return null;

        timeEntry.setId(id);
        repo.replace(id,timeEntry);
        return timeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(repo.values());
    }


    @Override
    public TimeEntry find(long timeEntryId) {

        return repo.get(timeEntryId);
    }
}
