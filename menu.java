import java.util.ArrayList; //import functions for Array lists
import java.io.*; //import input/output file functions
class menu{

// read inventory file
    public static void readTxt(String file , ArrayList<menuItems> menu){
        try{//if file is readable

//create fle reader
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
//read file
            while((line = br.readLine()) != null){//to see if end of file is reached
                String[] tokens = line.split(", ");

                menu.add(new menuItems(tokens[0] , Double.valueOf(tokens[1])));
            }//end of while
            fr.close();
        }//end of try

        catch(IOException e){//if file isnt readable
            System.out.printf("Error: Cannot read from file");
        }//end of catch
    }//end of readTxt

//to print each menu item in correct format
    public static void printItem(menuItems item){
        String name = item.getItem();
        Double price = item.getPrice();
        System.out.printf("%s " , name);

        for (int i = 0; i < 43 - name.length(); i++){
            System.out.print("=");
        }//end of = for
        System.out.printf(" %.2f\n" , price);
    }//end of print item
    
//to print menu
    public static void printMenu(ArrayList<menuItems> menu){
        for (int i = 0; i < 23; i++){//for correct spacing
            System.out.print(" ");
        }//end of spacing for

        System.out.println("MENU");
        for (int i = 0; i < 52; i++){
            System.out.print("=");

        }//end of for
        System.out.println();
        for (int i = 0; i < menu.size(); i++){//to print each item
            System.out.printf("%d. " , i + 1);
            printItem(menu.get(i));

        }//end of print for
        System.out.printf("%d. Exit\n" , menu.size() + 1);
    }//end of printMenu
}//end of class 