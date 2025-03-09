import java.util.ArrayList; //import functions for Array lists
public class cafe {
    public static void main(String[] args){
        
        keyboard kb = new keyboard();//for keyboard functions
        menu m = new menu();//for menu functions

//declaring variables
        int coffee;
        int cashCard;
        int cardT;
        double payed;
        String readFile = "Inventory.txt";
        String fileDirect = "Transactions\\";
        boolean exit = false;
        ArrayList<menuItems> menu = new ArrayList<menuItems>();
        ArrayList<transaction> transactions = new ArrayList<transaction>();

//read array from text file
        m.readTxt(readFile , menu);

        while (exit == false){//to repeat until exit is selected

//print menu
            m.printMenu(menu);

//get user coffee choice
            coffee = kb.validator("Enter coffee choice: " , "Invalid choice entered" , 1 , menu.size() + 1);
            
            if (coffee <= menu.size()){//to see if coffee is selected

//cash or card transaction
                cashCard = kb.validator("Payment method (Cash: 1 or Card: 2): " , "Invalid entry, enter Cash (1) or Card (2) only" , 1 , 2);
                        
                if(cashCard == 1){//cash payment
//payment given
                    payed = kb.validator("Quantity payed: ", "Invalid payment amount, please enter amount payed");
                    
                    if(payed < menu.get(coffee - 1).getPrice()){//to see if sufficient funds are given
                        System.out.printf("Insuficient funds tendered, %.2f missing\n" , menu.get(coffee - 1).getPrice() - payed);
                    }//end of valid if

                    else{

//create new cash transaction
                        cash newTransaction = new cash(menu.get(coffee - 1) , payed);
//print transaction message
                        System.out.println(newTransaction.transactionMessage());
//add to transactions array
                        transactions.add(newTransaction);
                    }//end of else
                }//end of cash payment if
                                    
                if(cashCard == 2){//card payment

//card type choosen
                        cardT = kb.validator("Card type used (Mastercard: 1 or Visa: 2): " , "Invalid card entry, enter Mastercard (1) or Visa (2)", 1 , 2);
//create new card transaction
                        card newTransaction = new card(menu.get(coffee - 1) , cardT);
//print transaction message
                        System.out.println(newTransaction.transactionMessage());
//add to transaction array
                        transactions.add(newTransaction);
                }//end of card payment if
                System.out.println();
            }//end of repeat if

            else if (coffee == menu.size() + 1){//to see if exit was selected
                exit = true;
            }//end of exit if 
        }//end of reload while
        
//write transaction to transaction file
        transaction.writeTransaction(fileDirect ,transactions);
        System.out.print("Exit selected. Program has been ended.");
    }//end of main
}//end of class