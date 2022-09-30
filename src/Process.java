import java.util.Map;
import java.util.Scanner;

public class Process extends Inventry {

    static double initialBalanceamount = 100;
    static double balanceamountinmachine = 0;
    static int invselectvalue;
    static double changeamt;
    static int denomi=0;
    static int addinv=0;
    public static int InvSelect() {

        System.out.println(" Enter productId to select the product = ");

        Scanner inventryselect = new Scanner(System.in);
         invselectvalue = inventryselect.nextInt();
        switch (invselectvalue) {
            case 1:
                System.out.println("You have selected Coke ");
                break;
            case 2:
                System.out.println("you have selected Pepsi ");
                break;
        }
        return invselectvalue;
    }
    public static double balanceChange(double incash, double productprice) {
        changeamt = incash - productprice;
        balanceamountinmachine = (initialBalanceamount - changeamt);
        initialBalanceamount = balanceamountinmachine;
        return changeamt;
    }
    public void InventrycountUpdate(Map<Integer, Inventry> product ,Inventry inventry,int invselectvalue) {
        denomi = product.get(invselectvalue).getProductinventrycount() - 1;
        inventry.setProductinventrycount(denomi);
        System.out.println(product);
    }
    public void addInventrycountUpdate(Map<Integer, Inventry> product ,Inventry inventry,int invselectvalue) {
        addinv = product.get(invselectvalue).getProductinventrycount() + 1;
        inventry.setProductinventrycount(addinv);
        System.out.println(product);
    }
    public void Inventry1Process(Map<Integer, Inventry> product ,Inventry inventry1 ,double incash) {
        if (inventry1.productinventrycount <= 0) {      //adding item to inventry
            System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
            addInventrycountUpdate( product ,inventry1,invselectvalue) ;
        }
        else if (inventry1.productinventrycount > 0) {
            if (incash == inventry1.productprice) {
                System.out.println("Updated balance amount in machine = " + initialBalanceamount);
                System.out.println(" here is your coke,thank you visit again ");
                InventrycountUpdate(product, inventry1, invselectvalue);
            } else if (incash > inventry1.productprice) {
                System.out.println(" your balance change = " + balanceChange(incash, inventry1.productprice));
                System.out.println("Updated balance amount in machine = " + balanceamountinmachine);
                System.out.println(" here is your coke,thank you visit again ");
                InventrycountUpdate(product, inventry1, invselectvalue);
            } else if (incash < inventry1.productprice) {
                System.out.println("insufficiant amount entered for the product ");
            }
        }
//        } else

    }


    public void Inventry2Process(Map<Integer, Inventry> product ,Inventry inventry2,double incash)
    {
        if(inventry2.productinventrycount >0)
        {
            if (incash == inventry2.productprice) {
                System.out.println("Updated balance amount in machine = " + initialBalanceamount);
                System.out.println(" here is your coke,thank you visit again ");
                InventrycountUpdate( product ,inventry2,invselectvalue) ;
            } else if (incash > inventry2.productprice) {
                System.out.println(" your balance change = " + balanceChange(incash, inventry2.productprice));
                System.out.println("Updated balance amount in machine = " + balanceamountinmachine);
                System.out.println(" here is your coke,thank you visit again ");
                InventrycountUpdate( product ,inventry2,invselectvalue) ;
            } else if (incash < inventry2.productprice) {
                System.out.println("insufficiant amount entered for the product ");
            }
        }
//        else if(inventry2.productinventrycount <=0) {  //adding item to inventry
//            System.out.println("Sorry item unavialiable ,adding item to inventry try again sometime");
//            addInventrycountUpdate(product, inventry2, invselectvalue);
//        }
        }
    }

