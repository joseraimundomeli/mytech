package br.com.mytech.factory.impl;

import br.com.mytech.dtos.response.PreferenceDTO;
import br.com.mytech.factory.PreferenceFactory;
import br.com.mytech.models.ItemCustom;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Item;

import java.util.List;

public class PreferenceFactoryImpl implements PreferenceFactory {
    @Override
    public Preference createPreferenceCustom(List<ItemCustom> itens){
        Preference preference = new Preference();
        for (ItemCustom itemCustom : itens) {
            preference.appendItem(
                    new Item().setId(itemCustom.getId())
                            .setTitle(itemCustom.getTitle())
                            .setQuantity(itemCustom.getQuantity())
                            .setCategoryId(itemCustom.getCategory())
                            .setUnitPrice(itemCustom.getPrice().floatValue())
            );
        }
        return preference;
    }
}
