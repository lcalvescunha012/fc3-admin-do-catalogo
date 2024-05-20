package admin.catalogo.application;

import admin.catalogo.domain.category.Category;

public class UseCase {
    public Category execute(){
        return new Category();
    }
}