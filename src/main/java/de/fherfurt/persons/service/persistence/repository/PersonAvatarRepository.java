package de.fherfurt.persons.service.persistence.repository;

public interface PersonAvatarRepository {
    byte [] findPersonAvatarByPersonId(long personId);
    byte [] findPersonAvatarById(long avatarId);
}
