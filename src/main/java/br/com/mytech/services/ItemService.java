package br.com.mytech.services;

import br.com.mytech.models.ItemCustom;

import java.util.List;

public interface ItemService {
    List<ItemCustom> list();
    ItemCustom findById(String id);
}
