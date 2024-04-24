package backend.infrastructure.out.repository.db.contact;

import backend.application.dto.ContactDto;
import backend.infrastructure.out.repository.db.groupET.GroupEtMapper;

public class ContactMapper {

    public static ContactDto toDto(Contact contact) {
        return new ContactDto(
                contact.getId(),
                contact.getName(),
                contact.getPosition(),
                contact.getEmail(),
                GroupEtMapper.toDto(contact.getGroupEts()),
                contact.getPhone());
    }

    public static Contact toEntity(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setId(contactDto.getId());
        contact.setName(contactDto.getName());
        contact.setPosition(contactDto.getPosition());
        contact.setEmail(contactDto.getEmail());
        contact.setGroupEts(GroupEtMapper.toEntity(contactDto.getGroupEts()));
        contact.setPhone(contactDto.getPhone());
        return contact;
    }
}
