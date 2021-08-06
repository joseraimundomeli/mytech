package br.com.mytech.services;

import br.com.mytech.models.ItemGeneric;

import java.util.List;

public interface ItemService {
    List<ItemGeneric> list();
    ItemGeneric findById(String id);
}
