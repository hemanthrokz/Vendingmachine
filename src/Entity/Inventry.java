package Entity;

import java.util.*;

public class Inventry {
   private String name;
    private int productid;
    private int productinventrycount;
    private Double productprice;



    public Double getProductprice() {
        return productprice;
    }

    public boolean setProductinventrycount(int productinventrycount) {
        this.productinventrycount = productinventrycount;
        return true;
    }

    public String getName() {
        return name;
    }

    public int getProductinventrycount() {
        return productinventrycount;
    }

    public Inventry(){

    }
    public Inventry(String name, int productid, int productinventrycount, Double productprice) {
        this.name = name;
        this.productid = productid;
        this.productinventrycount = productinventrycount;
        this.productprice = productprice;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventry that = (Inventry) o;
        return productid == that.productid && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, productid);
    }


    @Override
    public String toString() {
        return
                "Product name='" + name +
                ", productid=" + productid +
                ", productinventrycount=" + productinventrycount +
                ", productprice=" + productprice +"\n"
                ;
    }


}