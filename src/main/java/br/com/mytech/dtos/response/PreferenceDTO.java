package br.com.mytech.dtos.response;

import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Item;

import java.util.List;

public class PreferenceDTO {
    private String initPoint;
    private String sandBoxInitPoint;


    public PreferenceDTO(String initPoint, String sandBoxInitPoint) {
        this.initPoint = initPoint;
        this.sandBoxInitPoint = sandBoxInitPoint;
    }

    public String getInitPoint() {
        return initPoint;
    }

    public void setInitPoint(String initPoint) {
        this.initPoint = initPoint;
    }

    public static class Builder{
        private String initPoint;
        private String sandBoxInitPoint;

        public Builder initPoint(String initPoint){
            this.initPoint = initPoint;
            return this;
        }

        public Builder sandBoxInitPoint(String sandBoxInitPoint){
            this.sandBoxInitPoint = sandBoxInitPoint;
            return this;
        }

        public PreferenceDTO build() {
            return new PreferenceDTO(initPoint, sandBoxInitPoint);
        }
    }

    @Override
    public String toString() {
        return "PreferenceDTO{" +
                "initPoint='" + initPoint + '\'' +
                ", sandBoxInitPoint='" + sandBoxInitPoint + '\'' +
                '}';
    }
}
