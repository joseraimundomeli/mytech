package br.com.mytech.models;

public class ItemGeneric {
    private String id;
    private String title;
    private Double price;
    private Integer quantity;
    private String category;


    public ItemGeneric(String id, String title, Double price, Integer quantity, String category) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.category = category;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

        public ItemGeneric build(){
            return new ItemGeneric(id, title, price, quantity, category);
        }

    }

    @Override
    public String toString() {
        return "GenericItem{" +
                " title='" + title + '\'' +
                ", price=" + price + '\'' +
                ", quantity=" + quantity + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
