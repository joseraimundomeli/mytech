package br.com.mytech.dtos.response;

import br.com.mytech.factory.PreferenceCuston;

public class PreferenceDTO extends PreferenceCuston {
    private String sandBoxInitPoint;


    public PreferenceDTO(String initPoint, String sandBoxInitPoint) {
        super(initPoint);
        this.sandBoxInitPoint = sandBoxInitPoint;
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
                "initPoint='" + this.getInitPoint() + '\'' +
                ", sandBoxInitPoint='" + sandBoxInitPoint + '\'' +
                '}';
    }
}
