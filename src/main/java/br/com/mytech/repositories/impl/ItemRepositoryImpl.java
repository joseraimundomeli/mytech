package br.com.mytech.repositories.impl;

import br.com.mytech.models.ItemCustom;
import br.com.mytech.repositories.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepositoryImpl implements ItemRepository {

    private List<ItemCustom> itemGenerics;

    public ItemRepositoryImpl() {
        this.itemGenerics = new ArrayList<>();
        itemGenerics.add(
                new ItemCustom("1", "Teste 1", 100.0, 10, "Eletro")
        );
        itemGenerics.add(
                new ItemCustom("2", "Teste 2", 100.0, 10, "Eletro")
        );
        itemGenerics.add(
                new ItemCustom("3", "Teste 3", 100.0, 10, "Eletro")
        );
    }
    public ItemRepositoryImpl(List<ItemCustom> itemGenerics) {
        this.itemGenerics = itemGenerics;
    }

    @Override
    public List<ItemCustom> findAll() {
        return this.itemGenerics;
    }

    @Override
    public Optional<ItemCustom> findById(String id) {
        return this.itemGenerics.stream().filter(itemGeneric -> itemGeneric.getId().equals(id)).findFirst();
    }
}
