package br.com.mytech.factory;

import br.com.mytech.models.ItemCustom;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;

import java.util.List;

public interface PreferenceFactory {
    Preference createPreferenceCustom(List<ItemCustom> itens) throws MPException;
}
