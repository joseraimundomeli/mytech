package br.com.mytech.services.impl;

import br.com.mytech.dtos.response.PreferenceDTO;
import br.com.mytech.models.ItemGeneric;
import br.com.mytech.repositories.ItemRepository;
import br.com.mytech.services.PreferenceService;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;

import java.util.List;

public class PreferenceServiceImpl implements PreferenceService {

    private static ItemRepository itemRepository;

    public PreferenceServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public PreferenceServiceImpl(){

    }

    @Override
    public PreferenceDTO getPreference() throws MPException {

        List<ItemGeneric> itemGenerics = this.itemRepository.findAll();

        if (itemGenerics == null){
            throw new RuntimeException("Item list is empty!");
        }

        Preference preference = new Preference();

        for (ItemGeneric itemGeneric : itemGenerics) {
            preference.appendItem(
                    new Item().setId(itemGeneric.getId())
                            .setTitle(itemGeneric.getTitle())
                            .setQuantity(itemGeneric.getQuantity())
                            .setCategoryId(itemGeneric.getCategory())
                            .setUnitPrice(itemGeneric.getPrice().floatValue())
            );
        }

        preference.save();

        return new PreferenceDTO
                .Builder()
                .initPoint(preference.getInitPoint())
                .sandBoxInitPoint(preference.getSandboxInitPoint())
                .build();
    }
}
