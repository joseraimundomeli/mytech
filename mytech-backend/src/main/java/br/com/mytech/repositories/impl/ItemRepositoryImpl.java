package br.com.mytech.repositories.impl;

import br.com.mytech.models.ItemGeneric;
import br.com.mytech.repositories.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {

    private List<ItemGeneric> itemGenerics = new ArrayList<>();

    public ItemRepositoryImpl() {
        itemGenerics.add(
                new ItemGeneric("1", "Teste 1", 100.0, 10, "Eletro")
        );
        itemGenerics.add(
                new ItemGeneric("2", "Teste 2", 100.0, 10, "Eletro")
        );
        itemGenerics.add(
                new ItemGeneric("3", "Teste 3", 100.0, 10, "Eletro")
        );
    }

    @Override
    public List<ItemGeneric> findAll() {
        return this.itemGenerics;
    }
}
