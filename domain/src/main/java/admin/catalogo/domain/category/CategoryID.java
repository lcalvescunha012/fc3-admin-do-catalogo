package admin.catalogo.domain.category;


import admin.catalogo.domain.Identifier;

import javax.swing.plaf.PanelUI;
import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {
    private final String value;

    private CategoryID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static CategoryID unique(){
        return CategoryID.from(UUID.randomUUID());
    }

    public static CategoryID from(final String anID){
        return new CategoryID(anID);
    }

    public static CategoryID from(final UUID anID){
        return new CategoryID(anID.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
