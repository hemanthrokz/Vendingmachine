package Entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Process {  //CLASS SPECIFIC METHODS AND FIELDS IN PRIVATE

    private BigDecimal BalanceAmount=new BigDecimal(100);



    public static int INVSELECT_VAL;

    private static int DENOMI=0;
    static int invSelect(HashMap<Integer, Inventry> product) {//NO NEED USE THROWS FOR  RUNTIMEEXCEPTION

        System.out.println(" Enter productId to select the product = ");

        Scanner inventrySelect = new Scanner(System.in);
        INVSELECT_VAL = inventrySelect.nextInt();
        //AVOID SWITCH CASE MAKE USE OF
        if (product.containsKey(INVSELECT_VAL)){
            System.out.println("u have selected "+product.get(INVSELECT_VAL).getName() );
        }
        else
        {
            throw new UnavialableProduct("Entered product id don't match with the existing one,Enter a valid product code");
        }

        return INVSELECT_VAL;
    }
    private   void  balanceChange(double change )  {
        BalanceAmount=BalanceAmount.subtract(BigDecimal.valueOf(change));
    }

    private void inventryCountUpdate(Map<Integer, Inventry> product , Inventry inventry, int invselectvalue) {
        DENOMI = product.get(invselectvalue).getProductinventrycount() - 1;
        inventry.setProductinventrycount(DENOMI);
    }


    public void inventryProcess(Map<Integer, Inventry> product , Inventry inventry , double INCASH)  {
        if (inventry.getProductinventrycount() <= 0) {
            throw new UnavialableProduct("\n Currently the selected product is unavailable ");
        }
        else if (inventry.getProductinventrycount() > 0)
        {
            if (INCASH == inventry.getProductprice()) {
                System.out.println("Updated balance amount in machine = " + BalanceAmount);
                System.out.println(" here is your "+inventry.getName()+" ---->  thank you visit again ");
                inventryCountUpdate(product, inventry, INVSELECT_VAL);
            }
            else if (INCASH > inventry.getProductprice())
            {
                double change =INCASH - inventry.getProductprice();
                if (BigDecimal.valueOf(change).compareTo(BalanceAmount) > 0){
                    throw new InsufficientBalance("Insufficient Balance in the machine to provide balance change ,so insert exact change to purchase the product");
                }
                else
                {
                    balanceChange(change);
                    System.out.println("YOUR CHANGE AMOUNT == " +change );
                    System.out.println("Balance AMOUNT in machine == " +BalanceAmount );
                    System.out.println(" here is your "+inventry.getName()+" ---->  thank you visit again ");
                    inventryCountUpdate(product, inventry, INVSELECT_VAL);
                }
            }
            else if (INCASH < inventry.getProductprice())
            {
                throw new InsufficientCash("/n insufficiant amount entered for the product ");
            }
        }

    }

}

