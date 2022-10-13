package Entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Process {  //CLASS SPECIFIC METHODS AND FIELDS IN PRIVATE

    Scanner balance=new Scanner(System.in);




    static int invSelect(HashMap<Integer, Inventry> product,int INVSELECT_VAL) {//NO NEED USE THROWS FOR  RUNTIMEEXCEPTION


        try {
            if (product.containsKey(INVSELECT_VAL)){
                System.out.println("u have selected "+product.get(INVSELECT_VAL).getName() );
            }
        }
        catch (RuntimeException e) {
            throw new UnavialableProduct("Entered product id don't match with the existing one,Enter a valid product code");
        }

        return INVSELECT_VAL;
    }
    private   void  balanceChange(double change ,AdminProcess adminProcess)  {

       adminProcess.setBalanceAmount(adminProcess.getBalanceAmount().subtract(BigDecimal.valueOf(change)));
    }

    public void addMachineBalance(AdminProcess ap){
        System.out.println("enter the value to update Balance change in machine");
        BigDecimal updatedValue=balance.nextBigDecimal();
        ap.setBalanceAmount(ap.getBalanceAmount().add(updatedValue));
        System.out.println("Amount credited Sucessfully.Updated balance amount in Vending machine is : "+ap.getBalanceAmount());


    }

    private void inventryCountUpdate(HashMap<Integer, Inventry> product , Inventry inventry, int invselectvalue) {
        int DENOMI =  product.get(invselectvalue).getProductinventrycount()-1;
        inventry.setProductinventrycount(DENOMI);
    }


    public void inventryProcess(HashMap<Integer, Inventry> product , Inventry inventry , double INCASH,AdminProcess adminProcess,int INVSELECT_VAL)  {
        if (inventry.getProductinventrycount() <= 0) {
            throw new UnavialableProduct("\n Currently the selected product is unavailable ");
        }
        else if (inventry.getProductinventrycount() > 0)
        {
            if (INCASH == inventry.getProductprice()) {
                System.out.println("Updated balance amount in machine = " + adminProcess.getBalanceAmount());
                System.out.println(" here is your "+inventry.getName()+" ---->  thank you visit again ");
                inventryCountUpdate(product, inventry, INVSELECT_VAL);
            }
            else if (INCASH > inventry.getProductprice())
            {
                double change =INCASH - inventry.getProductprice();
                if (BigDecimal.valueOf(change).compareTo(adminProcess.getBalanceAmount()) > 0){
                    throw new InsufficientBalance("Insufficient Balance in the machine to provide balance change ,so insert exact change to purchase the product");
                }
                else
                {
                    balanceChange(change,adminProcess);
                    System.out.println("YOUR CHANGE AMOUNT == " +change );
                    System.out.println("Balance AMOUNT in machine == " + adminProcess.getBalanceAmount());
                    System.out.println(" here is your "+inventry.getName()+" ---->  thank you visit again ");
                    inventryCountUpdate(product, inventry,INVSELECT_VAL);
                }
            }
            else if (INCASH < inventry.getProductprice())
            {
                throw new InsufficientCash("/n insufficiant amount entered for the product ");
            }
        }

    }

}

