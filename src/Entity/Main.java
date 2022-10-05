package Entity;

import java.util.*;

public class Main extends Process {
   public static double incash=0;
public static void incashAmount(){
    Scanner input_cash = new Scanner(System.in);
    System.out.println("enter the cash amount to purchase ");
    incash = input_cash.nextDouble();
}
    public static void main(String[] args) throws RuntimeException {
      //  initialBalanceamount = 100;

        Inventry inventry1 = new Inventry("coke", 1, 3, 3.0);
        Inventry inventry2 = new Inventry("pepsi", 2, 7, 2.0);
        Inventry inventry3 = new Inventry("mazza", 3, 4, 5.0);


        HashMap<Integer, Inventry> product = new HashMap<Integer, Inventry>();
        product.put(1,inventry1);
        product.put(2,inventry2);
        product.put(3,inventry3);

        Process ms=new Process();
        while (true) {

            System.out.println("list of products avialiable = ");
            for (Integer key: product.keySet()){
                System.out.println(key+ " = " + product.get(key));
            }
            //inventery select
            try {
                int invselectvalue = InvSelect();
            } catch (Exception e) {
                System.out.println("a problem occured "+ e);;
            }

            // for inventry value 1
            if (invselectvalue == 1  ) {
                if (inventry1.productinventrycount>0) {
                    incashAmount();
                    try {
                        ms.Inventry1Process(product, inventry1, incash);
                    } catch (Exception e) {
                        System.out.println("a problem occured "+ e);;
                    }
                  }
                else {
                    System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
                    ms.addInventrycountUpdate(product, inventry1, invselectvalue);
                }
            }
            // for inventry value 2
            else if (invselectvalue == 2 ) {
                if (inventry2.productinventrycount>0) {
                    incashAmount();
                    try {
                        ms.Inventry2Process(product, inventry2, incash);
                    } catch (Exception e) {
                        System.out.println("a problem occured "+ e);;
                    }
                  }
                else {
                    System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
                    ms.addInventrycountUpdate(product, inventry2, invselectvalue);
                }
            }
            // for inventry value 3
            else if (invselectvalue == 3 ) {
                if (inventry3.productinventrycount>0) {
                    incashAmount();
                    try {
                        ms.Inventry3Process(product, inventry3, incash);
                    } catch (Exception e) {
                        System.out.println("a problem occured "+ e);;
                    }
                }
                else {
                    System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
                    ms.addInventrycountUpdate(product, inventry3, invselectvalue);
                }
            }
        }

    }
}

