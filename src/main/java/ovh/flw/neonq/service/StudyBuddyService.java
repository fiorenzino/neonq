package ovh.flw.neonq.service;

import ovh.flw.neonq.common.service.GenericService;
import ovh.flw.neonq.model.StudyBuddy;

import javax.inject.Singleton;

@Singleton
public class StudyBuddyService extends GenericService<StudyBuddy> {
    @Override
    public Class<StudyBuddy> getEntityType() {
        return StudyBuddy.class;
    }
}
