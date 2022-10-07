package Entity;

import java.util.*;

public class Main extends Process {
    public static double INCASH =0;
    public static void incashAmount(){
        Scanner input_cash = new Scanner(System.in);
        System.out.println("enter the cash amount to purchase ");
        INCASH = input_cash.nextDouble();
    }
    public static void main(String[] args) {

        HashMap<Integer, Inventry> product = new HashMap<Integer, Inventry>();
        product.put(1,new Inventry("coke", 1, 3, 3.0));
        product.put(2,new Inventry("pepsi", 2, 7, 2.0));
        product.put(3,new Inventry("mazza", 3, 4, 5.0));

        Inventry p1=product.get(1);
        Inventry p2=product.get(2);
        Inventry p3=product.get(3);
        Process ms=new Process();
        while (true) {

            System.out.println("list of products avialiable = ");
            for (Integer key: product.keySet()){
                System.out.println(key+ " = " + product.get(key));
            }
            //inventery select
            try {
                invSelect(product);
            } catch (Exception e) {
                System.out.println("a problem occured "+ e);
            }
                if (INVSELECT_VAL == 1 && product.get(1).getProductinventrycount()>0) {
                    incashAmount();
                    try {
                        ms.inventryProcess(product, p1, INCASH);
                    } catch (RuntimeException e) {
                        System.out.println("a problem occured "+ e);
                    }
                }
                else if (INVSELECT_VAL == 2 && product.get(2).getProductinventrycount()>0) {
                    incashAmount();
                    try {
                        ms.inventryProcess(product, p2, INCASH);
                    } catch (RuntimeException e) {
                        System.out.println("a problem occured "+ e);
                    }
                }
                  else if (INVSELECT_VAL == 3  && product.get(3).getProductinventrycount()>0) {
                        incashAmount();
                        try {
                            ms.inventryProcess(product, p3, INCASH);
                        } catch (RuntimeException e) {
                            System.out.println("a problem occured "+ e);
                        }
                    }
                else {
                    System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
                   // ms.addInventryCountUpdate(product, p1, INVSELECT_VAL);
                }
            }

        }

    }

