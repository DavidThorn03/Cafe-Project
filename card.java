class card extends transaction{
    private String cardT;

//child object to transaction for card details
    public card(menuItems item , int cardT){
        super(item);

//string for card type selected
        if(cardT == 1){
            this.cardT = "MasterCard";
        }//end of card type if

        else{
            this.cardT = "VISA";
        }//end of card type if
    }//end of card

//reciept message with card payment details
    public String transactionMessage(){
        return super.transactionMessage() + " and your " + cardT;
        
    }//end of transactionMessage
    
//transaction file text with card details
    public String transactionRecord(){
        return super.transactionRecord() + ", " + cardT;
    }//end of transactionRecord
}//end of class