package br.com.mytech.factory;

import br.com.mytech.dtos.response.PreferenceDTO;
import br.com.mytech.models.ItemCustom;
import com.mercadopago.exceptions.MPException;

import java.util.List;

public interface PreferenceFactory {
    PreferenceDTO createPreferenceCustom(List<ItemCustom> itens) throws MPException;
}
