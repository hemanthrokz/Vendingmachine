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
        AdminProcess ap = new AdminProcess();
        Process process = new Process();



        Process ms = new Process();
        while (true) {


            Scanner adminProcess = new Scanner(System.in);
            System.out.println("enter 1 to login as admin or enter 2 to continue as coustomer");
            int choice = adminProcess.nextInt();

            if (choice == 1) {

                if (ap.adminValidator() == true) {
                    ap.adminOptions();
                    int adminCase = adminProcess.nextInt();
                    switch (adminCase) {
                        case 1:
                            ap.addNewProductOrUpdate(ap);
                            break;
                        case 2:
                            ap.removeProduct(ap);
                            break;
                        case 3:
                            process.addMachineBalance(ap);
                            break;
                        default:
                            System.out.println("************* invalid input *************");
                            break;

                    }

                } else {
                    System.out.println("******************* Incorrect password *****************");
                }
            } else if (choice == 2) {


                System.out.println("Logged in as Customer \n ****************** list of products avialiable *******************\n");
                for (Integer key : ap.getProduct().keySet()) {
                    System.out.println(key + " = " + ap.getProduct().get(key));
                }
                System.out.println(" Enter productId to select the product = ");
                Scanner inventrySelect = new Scanner(System.in);

                int INVSELECT_VAL = inventrySelect.nextInt();
                //////////////////////////////////////////////////////
                try {
                    if (ap.getProduct().containsKey(INVSELECT_VAL)) {
                       process.invSelect(ap.getProduct(),INVSELECT_VAL);
                        if (ap.getProduct().get(INVSELECT_VAL).getProductinventrycount() > 0) {
                            incashAmount();
                            ms.inventryProcess(ap.getProduct(), ap.getProduct().get(INVSELECT_VAL), INCASH,ap,INVSELECT_VAL);

                        }
                    }else {
                        throw new UnavialableProduct("\n Currently the selected product is unavailable ");
                    }
                } catch (UnavialableProduct e)
                {
                  System.out.println("iam here.........."+e);

                }


            }
            else {
                System.out.println("************* invalid input *************");
            }
        }
    }
    }

