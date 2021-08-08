package br.com.mytech.services.impl;

import br.com.mytech.models.ItemCustom;
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

    public ItemServiceImpl(){
        this.itemRepository = new ItemRepositoryImpl();
    }

    @Override
    public List<ItemCustom> list() {
        List<ItemCustom> itens = itemRepository.findAll();
        if (itens == null){
            throw new RuntimeException("Error list item is empty!");
        }
        return itens;
    }

    @Override
    public ItemCustom findById(String id) {
        Optional<ItemCustom> item = itemRepository.findById(id);
        if (!item.isPresent()){
            throw new RuntimeException("Error list item is empty!");
        }
        return item.get();
    }
}
