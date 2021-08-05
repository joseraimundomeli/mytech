package br.com.mytech.services.impl;

import br.com.mytech.dtos.response.PreferenceDTO;
import br.com.mytech.models.ItemGeneric;
import br.com.mytech.repositories.ItemRepository;
import br.com.mytech.repositories.impl.ItemRepositoryImpl;
import br.com.mytech.services.PreferenceService;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;

import java.util.List;

public class PreferenceServiceImpl implements PreferenceService {

    private ItemRepository itemRepository;

    public PreferenceServiceImpl(){
        this.itemRepository = new ItemRepositoryImpl();
    }

    @Override
    public PreferenceDTO getPreference() throws MPException {

        List<ItemGeneric> itemGenerics = this.itemRepository.findAll();

        if (itemGenerics == null){
            System.out.println("Error empty item list!");
            // return error
        }

        Preference preference = new Preference();

        for (ItemGeneric itemGeneric : itemGenerics) {
            preference.appendItem(
                    new Item().setId(itemGeneric.getId())
                            .setTitle(itemGeneric.getTitle())
                            .setQuantity(itemGeneric.getQuantity())
                            .setCategoryId(itemGeneric.getCategory())
                            .setUnitPrice((float)itemGeneric.getPrice().floatValue())
            );
        }

        preference.save();

        return new PreferenceDTO
                .Builder()
                .id(preference.getId())
                .initPoint(preference.getInitPoint())
                .sandBoxInitPoint(preference.getSandboxInitPoint())
                .payer(preference.getPayer())
                .items(preference.getItems())
                .build();
    }
}
