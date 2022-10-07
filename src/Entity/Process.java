package Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Process {  //CLASS SPECIFIC METHODS AND FIELDS IN PRIVATE

    static double initialBalanceamount = 100;
    static double initialBalanceamountCHECK;
    static double BALANCE_AMOUNT_IN_MACHINE;
    static double BALANCE_AMOUNT_IN_MACHINECHECK;
    static int INVSELECT_VAL;
    static double CHANGE_AMT;
    static double CHANGE_AMTCHECK;
    static int DENOMI=0;
    static int ADDINV=0;
    public static int invSelect(HashMap<Integer, Inventry> product) {//NO NEED USE THROWS FOR  RUNTIMEEXCEPTION

        System.out.println(" Enter productId to select the product = ");

        Scanner inventryselect = new Scanner(System.in);
        INVSELECT_VAL = inventryselect.nextInt();
        //AVOID SWITCH CASE MAKE USE OF
        if(product.containsKey(INVSELECT_VAL) && INVSELECT_VAL==1){
            System.out.println("You have selected Coke ");
        }
        else if(product.containsKey(INVSELECT_VAL) && INVSELECT_VAL==2){
            System.out.println("You have selected pepsi ");
        }
        else if(product.containsKey(INVSELECT_VAL) && INVSELECT_VAL==3){
            System.out.println("You have selected maazza ");
        }
        else {
            throw new UnavialableProduct("Selected productId must be from 1 to 3");
        }

        return INVSELECT_VAL;
    }
    public static double balanceChange(double INCASH, double productprice)  {
        CHANGE_AMT = INCASH - productprice;
        BALANCE_AMOUNT_IN_MACHINE = (initialBalanceamount - CHANGE_AMT);
        initialBalanceamount = BALANCE_AMOUNT_IN_MACHINE;
        initialBalanceamountCHECK=initialBalanceamount;
        return CHANGE_AMT;
    }
    public static double balanceChangeCheck(double INCASH, double productprice)  {
        CHANGE_AMTCHECK = INCASH - productprice;
        BALANCE_AMOUNT_IN_MACHINECHECK = (initialBalanceamountCHECK - CHANGE_AMTCHECK);
        initialBalanceamountCHECK = BALANCE_AMOUNT_IN_MACHINECHECK;
        return CHANGE_AMTCHECK;
    }
    public void inventryCountUpdate(Map<Integer, Inventry> product , Inventry inventry, int invselectvalue) {
        DENOMI = product.get(invselectvalue).getProductinventrycount() - 1;
        inventry.setProductinventrycount(DENOMI);
    }
    public void addInventryCountUpdate(Map<Integer, Inventry> product ,Inventry inventry,int invselectvalue) {
        ADDINV = product.get(invselectvalue).getProductinventrycount() + 1;
        inventry.setProductinventrycount(ADDINV);
        System.out.println(product);
    }








    public void inventryProcess(Map<Integer, Inventry> product , Inventry inventry , double INCASH)  {
        if (inventry.getProductinventrycount() <= 0) {      //adding item to inventry
            System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
            addInventryCountUpdate( product ,inventry, INVSELECT_VAL) ;
        }
        else if (inventry.getProductinventrycount() > 0) {
            if (INCASH == inventry.getProductprice()) {
                System.out.println("Updated balance amount in machine = " + initialBalanceamount);
                System.out.println(" here is your coke,thank you visit again ");
                inventryCountUpdate(product, inventry, INVSELECT_VAL);
            } else if (INCASH > inventry.getProductprice()) {

                System.out.println(" your balance change = " + balanceChangeCheck(INCASH, inventry.getProductprice()));
                if (  balanceChangeCheck(INCASH, inventry.getProductprice())<BALANCE_AMOUNT_IN_MACHINE  ) {
                    throw new InsufficientBalance("Insufficient Balance in the machine to provide balance change ,so insert exact change to purchase the product ");
                }else {
                    System.out.println(" your balance change = " + balanceChange(INCASH, inventry.getProductprice()));
                    System.out.println("Updated balance amount in machine = " + BALANCE_AMOUNT_IN_MACHINE);
                    System.out.println(" here is your coke,thank you visit again ");
                    inventryCountUpdate(product, inventry, INVSELECT_VAL);
                }
            } else if (INCASH < inventry.getProductprice()) {
                throw new InsufficientCash("insufficiant amount entered for the product ");
            }
        }

    }

}
