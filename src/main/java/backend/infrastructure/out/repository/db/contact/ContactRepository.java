package backend.infrastructure.out.repository.db.contact;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.ContactDto;

@Stateless
public class ContactRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createContact(ContactDto contactDto) {
        Contact contact = ContactMapper.toEntity(contactDto);
        entityManager.persist(contact);
    }

    public ContactDto getContactById(Long id) {
        Contact contact = entityManager.find(Contact.class, id);
        return ContactMapper.toDto(contact);
    }

    public List<ContactDto> getAllContacts() {
        List<Contact> contacts = entityManager.createQuery("SELECT c FROM Contact c", Contact.class).getResultList();
        return contacts.stream()
                .map(ContactMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateContact(ContactDto contactDto) {
        Contact contact = ContactMapper.toEntity(contactDto);
        entityManager.merge(contact);
    }

    public void deleteContact(ContactDto contactDto) {
        Contact contact = ContactMapper.toEntity(contactDto);
        entityManager.remove(entityManager.contains(contact) ? contact : entityManager.merge(contact));
    }
}
