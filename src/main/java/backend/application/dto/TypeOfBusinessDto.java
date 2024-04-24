package backend.application.dto;

import backend.infrastructure.out.repository.db.typeOfBusiness.TypeOfBusiness;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link TypeOfBusiness}
 */
public class TypeOfBusinessDto implements Serializable {
    private final Long id;
    private final String typeName;

    public TypeOfBusinessDto(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TypeOfBusinessDto entity = (TypeOfBusinessDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.typeName, entity.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "typeName = " + typeName + ")";
    }
}