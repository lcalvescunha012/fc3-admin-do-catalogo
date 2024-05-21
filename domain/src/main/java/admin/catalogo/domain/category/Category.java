package admin.catalogo.domain.category;

import admin.catalogo.domain.AggregateRoot;
import admin.catalogo.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> {

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
        final var deletedAt = isActive ? null : now;
        return new Category(id, aName, aDescription, isActive, now, now, deletedAt);
    }


    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Instant getDeleteAt() {
        return deleteAt;
    }
}