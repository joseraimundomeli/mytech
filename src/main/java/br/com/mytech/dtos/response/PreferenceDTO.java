package br.com.mytech.dtos.response;

import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Item;

import java.util.List;

public class PreferenceDTO {
    private String id;
    private String initPoint;
    private String sandBoxInitPoint;
    private Payer payer;
    private List<Item> items;

    public PreferenceDTO(String id, String initPoint, String sandBoxInitPoint, Payer payer, List<Item> items) {
        this.id = id;
        this.initPoint = initPoint;
        this.sandBoxInitPoint = sandBoxInitPoint;
        this.payer = payer;
        this.items = items;
    }

    public static class Builder{
        protected String id;
        protected String initPoint;
        protected String sandBoxInitPoint;
        protected Payer payer;
        protected List<Item> items;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder initPoint(String initPoint){
            this.initPoint = initPoint;
            return this;
        }

        public Builder sandBoxInitPoint(String sandBoxInitPoint){
            this.sandBoxInitPoint = sandBoxInitPoint;
            return this;
        }

        public Builder payer(Payer payer){
            this.payer = payer;
            return this;
        }

        public Builder items(List<Item> items){
            this.items = items;
            return this;
        }

        public PreferenceDTO build() {
            return new PreferenceDTO(id, initPoint, sandBoxInitPoint, payer, items);
        }
    }

    @Override
    public String toString() {
        return "PreferenceDTO{" +
                "initPoint='" + initPoint + '\'' +
                ", sandBoxInitPoint='" + sandBoxInitPoint + '\'' +
                ", payer=" + payer +
                ", items=" + items +
                '}';
    }
}
