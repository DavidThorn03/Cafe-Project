class cash extends transaction{
    private double payed; 
    private double change;
//child object to transaction for cash transactions

    public cash(menuItems item , double payed){
        super(item);
        this.payed = payed;
        change = payed - item.getPrice();
    }//end of cash

//reciept message with cash payment detail
    public String transactionMessage(){
        if(change > 0){//if change is given
            return super.transactionMessage() + " with " + String.format("%.2f" , change) + " change";
        }//end of change if
        else{//if no change is given
            return super.transactionMessage();
        }//end of no change else
    }//end of transactionMessage

//transaction file text with cash details
    public String transactionRecord(){
        return super.transactionRecord() + ", " + String.format("%.2f" , payed) + ", " + String.format("%.2f" , change);
    }//end of transactionRecord
}//end of class