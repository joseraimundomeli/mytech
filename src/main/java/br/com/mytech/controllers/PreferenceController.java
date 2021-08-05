package br.com.mytech.controllers;

import br.com.mytech.services.PreferenceService;
import br.com.mytech.services.impl.PreferenceServiceImpl;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;

import static spark.Spark.before;
import static spark.Spark.post;

public class PreferenceController {

    private static final PreferenceService preferenceService = new PreferenceServiceImpl();


    public static void main(String[] args) throws MPConfException {

        MercadoPago.SDK.setAccessToken(System.getenv("USER_CREDENTIAL"));

        before("/*", (request, response) -> response.type("application/json"));

        post("/preferences", (request, response) -> {
            return preferenceService.getPreference();
        });
    }

}
