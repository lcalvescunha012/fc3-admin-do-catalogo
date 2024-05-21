package admin.catalogo.domain.category;

import admin.catalogo.domain.AgreagteRoot;

import java.time.Instant;
import java.util.UUID;

public class Category extends AgreagteRoot<CategoryID> {

    private String name;
    private String description;
    private boolean active;
    private Instant createAt;
    private Instant updateAt;
    private Instant deleteAt;


    private Category(final CategoryID anId,
                     final String aName,
                     final String aDescription,
                     final boolean isActive,
                     final Instant aCreateAt,
                     final Instant aUpdateAt,
                     final Instant aDeleteAt) {
        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createAt = aCreateAt;
        this.updateAt = aUpdateAt;
        this.deleteAt = aDeleteAt;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
        final var id = CategoryID.unique();
        final var now = Instant.now();
        return new Category(id, aName, aDescription, isActive, now, now, null);
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public Instant getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Instant deleteAt) {
        this.deleteAt = deleteAt;
    }
}