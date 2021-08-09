package br.com.mytech.repositories;

import br.com.mytech.models.ItemCustom;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    List<ItemCustom> findAll();
    Optional<ItemCustom> findById(String id);
}
