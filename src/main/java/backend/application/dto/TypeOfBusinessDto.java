package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class TypeOfBusinessDto implements Serializable {
    private Long id;
    private String typeName;

    public TypeOfBusinessDto() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}