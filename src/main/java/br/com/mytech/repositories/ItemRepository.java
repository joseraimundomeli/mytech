package br.com.mytech.repositories;

import br.com.mytech.models.ItemGeneric;

import java.util.List;

public interface ItemRepository {
    List<ItemGeneric> findAll();
}
