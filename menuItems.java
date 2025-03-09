class menuItems{
    private double price;
    private String item;
//menu item object

    public menuItems(String item , double price){
        this.item = item;
        this.price = price;
    }//end of menuItems constructor

//to get item name
    public String getItem(){
        return item;
    }//end of getItem
    
//to get item price
    public double getPrice(){
        return price;
    }//end of getPrice
}//end of class menu items