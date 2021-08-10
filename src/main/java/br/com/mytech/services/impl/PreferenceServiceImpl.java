package br.com.mytech.services.impl;

import br.com.mytech.dtos.response.PreferenceDTO;
import br.com.mytech.factory.PreferenceFactory;
import br.com.mytech.factory.impl.PreferenceFactoryImpl;
import br.com.mytech.models.ItemCustom;
import br.com.mytech.repositories.ItemRepository;
import br.com.mytech.repositories.impl.ItemRepositoryImpl;
import br.com.mytech.services.PreferenceService;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;

import java.util.List;

public class PreferenceServiceImpl implements PreferenceService {

    private static ItemRepository itemRepository;
    private static PreferenceFactory preferenceFactory;

    public PreferenceServiceImpl(ItemRepository itemRepository, PreferenceFactory preferenceFactory){
        this.itemRepository = itemRepository;
        this.preferenceFactory = preferenceFactory;
    }

    public PreferenceServiceImpl(){
        this.itemRepository = new ItemRepositoryImpl();
        this.preferenceFactory = new PreferenceFactoryImpl();
    }

    @Override
    public PreferenceDTO getPreference() throws MPException {

        List<ItemCustom> itemGenerics = this.itemRepository.findAll();

        if (itemGenerics == null){
            throw new RuntimeException("Item list is empty!");
        }

        Preference preference =  preferenceFactory.createPreferenceCustom(itemGenerics);

        preference.save();

        return new PreferenceDTO
                .Builder()
                .initPoint(preference.getInitPoint())
                .sandBoxInitPoint(preference.getSandboxInitPoint())
                .build();
    }
}
