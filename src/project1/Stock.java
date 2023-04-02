package project1;

import java.io.Serializable;

public class Stock implements Serializable, Comparable {
    private String stockID;
    private Company company;
    private String name;
    private int price;

    public Stock() {
    }

    public Stock( String stockId,Company company, String name, int price) {
        this.stockID =stockId;
        this.company = company;
        this.name = name;
        this.price = price;
    }

    public void setStockID(String stockID) {
        this.stockID = stockID;
    }

    public String getStockID() {
        return stockID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return this.name.length();
    }

    @Override
    public boolean equals(Object obj) {
        String s = ((Stock) obj).getName();
        return this.name.equals(s);
    }

    @Override
    public int compareTo(Object o) {
        String s = ((Stock) o).getName();
        return this.name.compareTo(s);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "company=" + company +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}