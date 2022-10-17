package Entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class AdminProcess {

   private HashMap<Integer, Inventry> product = new HashMap<Integer, Inventry>();
   Scanner input=new Scanner(System.in);
   private BigDecimal BalanceAmount;

   private int passcode=94443;
    public AdminProcess() {
        product.put(1,new Inventry("coke", 1, 3, 3.0));
        product.put(2,new Inventry("pepsi", 2, 7, 2.0));
        product.put(3,new Inventry("mazza", 3, 4, 5.0));
        BalanceAmount=new BigDecimal(100);
    }

    public HashMap<Integer, Inventry> getProduct() {
        return product;
    }
    public BigDecimal getBalanceAmount() {
        return BalanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        BalanceAmount = balanceAmount;
    }

    public void setProduct(HashMap<Integer, Inventry> product) {
        this.product = product;
    }
    public void removeProduct(){
        System.out.println("Enter product code to remove item ");
        int removeItemProductCode=input.nextInt();
        if(this.getProduct().containsKey(removeItemProductCode)){
            this.getProduct().remove(removeItemProductCode);
            System.out.println("Item with Product code = "+removeItemProductCode +" ,Has been sucessfully removed from inventry list");
        }
        else {
            System.out.println("entered value does't match with the product code");
        }

    }

    public void inventryProductCountAdd() {
        System.out.println("Enter product code to add product count ");
        int invselectvalue= input.nextInt();
        if(this.getProduct().containsKey(invselectvalue)) {
            System.out.println("Enter no of product to be added to inventry : ");
            int addInventryValue = input.nextInt();
            int addition = product.get(invselectvalue).getProductinventrycount() + addInventryValue;
            product.get(invselectvalue).setProductinventrycount(addition);
            System.out.println("************* product count added sucessfully *************");

        }
        else {
            System.out.println("entered value does't match with the product code");
        }

    }
    public void productListView() {
        System.out.println(" ****************** list of products avialiable *******************");
        for (Integer key : this.getProduct().keySet()) {
            System.out.println(key + " = " + this.getProduct().get(key));
        }

    }
    public void addNewProductOrUpdate(){                                     ///inventey admin process
        System.out.println("Enter details of new product to be added to inventry : ");
        System.out.println("Enter productCode : ");
        int productCode=input.nextInt();
        System.out.println("Enter productName : ");
        input.nextLine();
        String productName=input.nextLine();
        System.out.println("Enter productId : ");
        int productId=input.nextInt();
        System.out.println("Enter productInventryCount : ");
        int productInventryCount=input.nextInt();
        System.out.println("Enter productPrice : ");
        double productPrice=input.nextDouble();
        this.newProductToInventry(productCode,productName,productId,productInventryCount,productPrice);
    }

    public void newProductToInventry(int productCode,String productName,int productId,int productInventryCount,double productPrice ){
        product.put(productCode,new Inventry(productName,productId,productInventryCount,productPrice));
        System.out.println("Item with Product code = "+productCode +" ,Has been sucessfully added to inventry list");
    }
    public boolean adminValidator(){
        System.out.println("Enter the passcode to access admin panel " );
        int value= input.nextInt();
        if (passcode==value){
            return true;
        }else
            return false;
    }
    public void adminOptions(){
        System.out.println("Enter 1 ------> To view the list of product in the inventry \n  Enter 2 ------> Add new product to inventry \n   Enter 3 ------> Remove existing product from inventry \n    Enter 4 ------> To update balance inventy amount \n     Enter 5 ------> To update product inventry count " );
    }
}
