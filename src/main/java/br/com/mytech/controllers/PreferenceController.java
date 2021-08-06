package br.com.mytech.controllers;

import br.com.mytech.repositories.impl.ItemRepositoryImpl;
import br.com.mytech.services.ItemService;
import br.com.mytech.services.PreferenceService;
import br.com.mytech.services.impl.ItemServiceImpl;
import br.com.mytech.services.impl.PreferenceServiceImpl;
import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;

import static spark.Spark.before;
import static spark.Spark.post;
import static spark.Spark.get;

public class PreferenceController {

    private static final PreferenceService preferenceService = new PreferenceServiceImpl(new ItemRepositoryImpl());
    private static final ItemService itemService = new ItemServiceImpl(new ItemRepositoryImpl());


    public static void main(String[] args) throws MPConfException {

        MercadoPago.SDK.setAccessToken(System.getenv("USER_CREDENTIAL"));

        before("/*", (request, response) -> response.type("application/json"));


        post("/preferences/id", (request, response) -> {
            return preferenceService.getPreference().getInitPoint();
        });

        post("/preferences", (request, response) -> {
            return preferenceService.getPreference();
        });

        get("/catalog", (request, response) ->{
            return itemService.list();
        });
    }

}
