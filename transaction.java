import java.io.*; //import input/output file functions
import java.util.Date;//import time and date functions
import java.text.SimpleDateFormat;
import java.util.ArrayList; //import functions for Array lists

//transaction object
class transaction{
    private String name;
    private double price;
    private String date;
    private String time;
    public transaction(menuItems item){
        name = item.getItem();
        price = item.getPrice();

        Date now = new Date();
        long simpleTime = now.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String formatedTime = dateFormat.format(now);
        String[] dateTime = formatedTime.split(" ");
        date = dateTime[0];
        time = dateTime[1];
    }//end of transaction

//reciept message
    public String transactionMessage(){
        return "Here is your " + name + " for " + String.format("%.2f" , price);
    }//end of transactionMessage

//text to write to transaction file for each transaction
    public String transactionRecord(){
        return time + ", " + name + ", " + String.format("%.2f" , price);
    }//end of transactionFile

//to write transaction array to transaction file
    public static void writeTransaction(String fileDirect  , ArrayList<transaction> transactions){
        try{//if file is writeable
            for(int i = 0; i < transactions.size(); i++){
//create file writer
            FileWriter fw = new FileWriter(fileDirect + transactions.get(i).date + ".txt", true);
            PrintWriter pw = new PrintWriter(fw);

//write transactions
            pw.println(transactions.get(i).transactionRecord());

            pw.close();
            }//end of print loop
        }//end of try

        catch(IOException e){//if file isnt writeable
            System.out.printf("Cannot write to file transaction file\n" );
        }//end of catch
    }//end of writeTransaction
}//end of class