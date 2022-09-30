import java.math.BigDecimal;
import java.util.*;

public class Inventry {
    String name;
    int productid;
    int productinventrycount;
    Double productprice;

    public void setName(String name) {
        this.name = name;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public boolean setProductinventrycount(int productinventrycount) {
        this.productinventrycount = productinventrycount;
        return true;
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