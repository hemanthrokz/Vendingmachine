package Entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class AdminProcess {

   private HashMap<Integer, Inventry> product = new HashMap<Integer, Inventry>();
    Scanner input=new Scanner(System.in);
private int passcode=94443;

    public AdminProcess() {
        product.put(1,new Inventry("coke", 1, 3, 3.0));
        product.put(2,new Inventry("pepsi", 2, 7, 2.0));
        product.put(3,new Inventry("mazza", 3, 4, 5.0));
    }

    public HashMap<Integer, Inventry> getProduct() {
        return product;
    }

    public void setProduct(HashMap<Integer, Inventry> product) {
        this.product = product;
    }
    public void removeProduct(AdminProcess adminProcess){
        System.out.println("Enter product code to remove item ");
        Scanner input=new Scanner(System.in);

        int removeItemProductCode=input.nextInt();
        if(adminProcess.getProduct().containsKey(removeItemProductCode)){
            adminProcess.getProduct().remove(removeItemProductCode);
        }
        else {
            System.out.println("entered value does't match with the product code");
        }

    }


    public void addNewProduct(AdminProcess adminProcess){                                     ///inventey admin process
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
        adminProcess.newProductToInventry(productCode,productName,productId,productInventryCount,productPrice);

    }

    public void newProductToInventry(int productCode,String productName,int productId,int productInventryCount,double productPrice ){
        product.put(productCode,new Inventry(productName,productId,productInventryCount,productPrice));
        System.out.println(" ****************** Updated product list *******************\n");

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
        System.out.println("Enter 1 ------> Add new product to inventry \n  Enter 2 ------> Remove existing product from inventry " );
    }
}
