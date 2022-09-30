import java.util.*;

public class Main extends Process {

    public static void main(String[] args) {
      //  initialBalanceamount = 100;
        double incash=0;

        Inventry inventry1 = new Inventry("coke", 1, 1, 3.0);
        Inventry inventry2 = new Inventry("pepsi", 2, 10, 2.0);



        HashMap<Integer, Inventry> product = new HashMap<Integer, Inventry>();
        product.put(1,inventry1);
        product.put(2,inventry2);

        System.out.println("list of products avialiable = ");
        for (Integer key: product.keySet()){
            System.out.println(key+ " = " + product.get(key));
        }
        Process ms=new Process();
        while (true) {

            //inventery select
            int invselectvalue = InvSelect();

            //insert cash


            Scanner input_cash = new Scanner(System.in);


            // for inventry value 1
            if (invselectvalue == 1  ) {
                if (inventry1.productinventrycount>0) {
                    System.out.println("enter the cash amount to purchase ");
                    incash = input_cash.nextDouble();
                    ms.Inventry1Process(product, inventry1, incash);
                }
                else {
                    System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
                    ms.addInventrycountUpdate(product, inventry1, invselectvalue);
                }
            }

            // for inventry value 2
            else if (invselectvalue == 2 ) {
                if (inventry2.productinventrycount>0) {
                    System.out.println("enter the cash amount to purchase ");
                    incash = input_cash.nextDouble();
                    ms.Inventry2Process(product, inventry2, incash);
                }
                else {
                    System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
                    ms.addInventrycountUpdate(product, inventry2, invselectvalue);
                }
            }

        }

    }
}

