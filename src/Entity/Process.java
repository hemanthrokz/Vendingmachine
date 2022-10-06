package Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Process {  //CLASS SPECIFIC METHODS AND FIELDS IN PRIVATE

     static double initialBalanceamount = 100;
    static double BALANCE_AMOUNT_IN_MACHINE;
    static int INVSELECT_VAL;
    static double CHANGE_AMT;
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
        return CHANGE_AMT;
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
    public void inventry1Process(Map<Integer, Inventry> product , Inventry inventry1 , double INCASH)  {
        if (inventry1.getProductinventrycount() <= 0) {      //adding item to inventry
            System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
            addInventryCountUpdate( product ,inventry1, INVSELECT_VAL) ;
        }
        else if (inventry1.getProductinventrycount() > 0) {
            if (INCASH == inventry1.getProductprice()) {
                System.out.println("Updated balance amount in machine = " + initialBalanceamount);
                System.out.println(" here is your coke,thank you visit again ");
                inventryCountUpdate(product, inventry1, INVSELECT_VAL);
            } else if (INCASH > inventry1.getProductprice()) {

                System.out.println(" your balance change = " + balanceChange(INCASH, inventry1.getProductprice()));
                if (BALANCE_AMOUNT_IN_MACHINE <0) {
                    throw new InsufficientBalance("Insufficient Balance in the machine to provide balance change ,so insert exact change to purchase the product ");
                }else {
                    System.out.println("Updated balance amount in machine = " + BALANCE_AMOUNT_IN_MACHINE);
                    System.out.println(" here is your coke,thank you visit again ");
                    inventryCountUpdate(product, inventry1, INVSELECT_VAL);
                }
            } else if (INCASH < inventry1.getProductprice()) {
                throw new InsufficientCash("insufficiant amount entered for the product ");
            }
        }
//        } else

    }


    public void inventry2Process(Map<Integer, Inventry> product , Inventry inventry2, double INCASH)  {
        if(inventry2.getProductinventrycount() <=0) {  //adding item to inventry
            System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
            addInventryCountUpdate(product, inventry2, INVSELECT_VAL);
        }
       else if(inventry2.getProductinventrycount() >0)
        {
            if (INCASH == inventry2.getProductprice()) {
                System.out.println("Updated balance amount in machine = " + initialBalanceamount);
                System.out.println(" here is your coke,thank you visit again ");
                inventryCountUpdate( product ,inventry2, INVSELECT_VAL) ;
            } else if (INCASH > inventry2.getProductprice()) {

                System.out.println(" your balance change = " + balanceChange(INCASH, inventry2.getProductprice()));
                if (BALANCE_AMOUNT_IN_MACHINE <0) {
                    throw new InsufficientBalance("Insufficient Balance in the machine to provide balance change ,so insert exact change to purchase the product ");
                }else {
                    System.out.println("Updated balance amount in machine = " + BALANCE_AMOUNT_IN_MACHINE);
                    System.out.println(" here is your coke,thank you visit again ");
                    inventryCountUpdate(product, inventry2, INVSELECT_VAL);
                }
            } else if (INCASH < inventry2.getProductprice()) {
                throw new InsufficientCash("insufficiant amount entered for the product ");
            }
        }

        }
    public void inventry3Process(Map<Integer, Inventry> product , Inventry inventry3, double INCASH) {
        if(inventry3.getProductinventrycount() <=0) {  //adding item to inventry
            System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
            addInventryCountUpdate(product, inventry3, INVSELECT_VAL);
        }
        else if(inventry3.getProductinventrycount() >0)
        {
            if (INCASH == inventry3.getProductprice()) {
                System.out.println("Updated balance amount in machine = " + initialBalanceamount);
                System.out.println(" here is your coke,thank you visit again ");
                inventryCountUpdate( product ,inventry3, INVSELECT_VAL) ;
            } else if (INCASH > inventry3.getProductprice()) {

                System.out.println(" your balance change = " + balanceChange(INCASH, inventry3.getProductprice()));
                if (BALANCE_AMOUNT_IN_MACHINE <0) {
                    throw new InsufficientBalance("Insufficient Balance in the machine to provide balance change ,so insert exact change to purchase the product ");
                }else {
                    System.out.println("Updated balance amount in machine = " + BALANCE_AMOUNT_IN_MACHINE);
                    System.out.println(" here is your coke,thank you visit again ");
                    inventryCountUpdate(product, inventry3, INVSELECT_VAL);
                }
            } else if (INCASH < inventry3.getProductprice()) {
                throw new InsufficientCash("insufficiant amount entered for the product ");
            }
        }

    }
    }

