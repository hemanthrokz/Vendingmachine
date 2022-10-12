package Entity;

import java.util.*;

public class Main  {
    public static double INCASH;
    public static void incashAmount(){
        Scanner input_cash = new Scanner(System.in);
        System.out.println("enter the cash amount to purchase ");
        INCASH = input_cash.nextDouble();
    }
    public static void main(String[] args) {
    AdminProcess ap=new AdminProcess();
    Process process=new Process();
        Inventry p1=ap.getProduct().get(1);
        Inventry p2=ap.getProduct().get(2);
        Inventry p3=ap.getProduct().get(3);
        Process ms=new Process();
        while (true) {


            Scanner adminProcess = new Scanner(System.in);
            System.out.println("enter 1 to login as admin or enter 2 to continue as coustomer");
            int choice = adminProcess.nextInt();

            if (choice == 1) {

                if (ap.adminValidator()==true)
                {
                ap.adminOptions();
                int adminCase = adminProcess.nextInt();
                switch (adminCase) {
                    case 1:
                        ap.addNewProduct(ap);
                        break;
                    case 2:
                        ap.removeProduct(ap);
                        break;
                    default:
                        System.out.println("************* invalid input *************");

                }

                }
                else{
                    System.out.println("******************* Incorrect password *****************");
                }
            } else if (choice == 2) {


                System.out.println("Logged in as Customer \n ****************** list of products avialiable *******************\n");
                for (Integer key : ap.getProduct().keySet()) {
                    System.out.println(key + " = " + ap.getProduct().get(key));
                }
                try {                                                            //inventery select
                    process.invSelect(ap.getProduct());
                } catch (Exception e) {
                    System.out.println("a problem occured " + e);
                }
                //////////////////////////////////////////////////////
                if (ap.getProduct().get(process.INVSELECT_VAL).getProductinventrycount() > 0) {
                    incashAmount();
                    try {
                        ms.inventryProcess(ap.getProduct(), ap.getProduct().get(process.INVSELECT_VAL), INCASH);
                    } catch (RuntimeException e) {
                        System.out.println("a problem occured " + e);
                    }
                }
                //////////////////////////////////////////////////////
//                if (process.INVSELECT_VAL == 1 && ap.getProduct().get(1).getProductinventrycount() > 0) {
//                    incashAmount();
//                    try {
//                        ms.inventryProcess(ap.getProduct(), p1, INCASH);
//                    } catch (RuntimeException e) {
//                        System.out.println("a problem occured " + e);
//                    }
//                } else if (process.INVSELECT_VAL == 2 && ap.getProduct().get(2).getProductinventrycount() > 0) {
//                    incashAmount();
//                    try {
//                        ms.inventryProcess(ap.getProduct(), p2, INCASH);
//                    } catch (RuntimeException e) {
//                        System.out.println("a problem occured " + e);
//                    }
//                } else if (process.INVSELECT_VAL == 3 && ap.getProduct().get(3).getProductinventrycount() > 0) {
//                    incashAmount();
//                    try {
//                        ms.inventryProcess(ap.getProduct(), p3, INCASH);
//                    } catch (RuntimeException e) {
//                        System.out.println("a problem occured " + e);
//                    }
//                }
                else {
                    throw new UnavialableProduct("\n Currently the selected product is unavailable ");
                }
            }
                else{
                System.out.println("Sorry invalid input entered");
            }
        }
        }

    }

