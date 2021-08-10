package br.com.mytech.models;

import java.util.Objects;

public class ItemCustom {
    private String id;
    private String title;
    private Double price;
    private Integer quantity;
    private String category;


    public ItemCustom(String id, String title, Double price, Integer quantity, String category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.category = category;

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public static class Builder {
        protected String id;
        protected String title;
        protected Double price;
        protected Integer quantity;
        protected String category;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder price(Double price){
            this.price = price;
            return this;
        }

        public Builder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder category(String category){
            this.category = category;
            return this;
        }

        public ItemCustom build(){
            return new ItemCustom(id, title, price, quantity, category);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(id, builder.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
