package br.com.mytech.repositories;

import br.com.mytech.models.ItemGeneric;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    List<ItemGeneric> findAll();
    Optional<ItemGeneric> findById(String id);
}
