package br.com.mytech.services;

import br.com.mytech.dtos.response.PreferenceDTO;
import com.mercadopago.exceptions.MPException;

public interface PreferenceService {
    PreferenceDTO getPreference() throws MPException;
}
