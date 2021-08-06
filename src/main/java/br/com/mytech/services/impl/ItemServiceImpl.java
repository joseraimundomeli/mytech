package br.com.mytech.services.impl;

import br.com.mytech.models.ItemGeneric;
import br.com.mytech.repositories.ItemRepository;
import br.com.mytech.repositories.impl.ItemRepositoryImpl;
import br.com.mytech.services.ItemService;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {
    private static ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemGeneric> list() {
        List<ItemGeneric> itens = itemRepository.findAll();
        if (itens == null){
            throw new RuntimeException("Error list item is empty!");
        }
        return itens;
    }

    @Override
    public ItemGeneric findById(String id) {
        Optional<ItemGeneric> item = itemRepository.findById(id);
        if (!item.isPresent()){
            throw new RuntimeException("Error list item is empty!");
        }
        return item.get();
    }
}
