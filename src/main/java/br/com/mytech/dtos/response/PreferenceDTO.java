package br.com.mytech.dtos.response;

import java.util.Objects;

public class PreferenceDTO  {
    private String initPoint;
    private String sandBoxInitPoint;


    public PreferenceDTO(String initPoint, String sandBoxInitPoint) {
        this.initPoint = initPoint;
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
                "initPoint='" + initPoint + '\'' +
                ", sandBoxInitPoint='" + sandBoxInitPoint + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PreferenceDTO that = (PreferenceDTO) o;
        return Objects.equals(initPoint, that.initPoint) && Objects.equals(sandBoxInitPoint, that.sandBoxInitPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initPoint, sandBoxInitPoint);
    }
}
