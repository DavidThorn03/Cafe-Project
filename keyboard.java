import java.util.Scanner; //import scanner function
class keyboard{

//for user input with high and low values
    public static int validator(String prompt, String errorMsg, int low , int high){
        Scanner in = new Scanner(System.in);
        int num = 0;
        String userInput;
        boolean valid = false;

        while(valid == false){//to repeat till valid entry is recieved

//prompt user input
            System.out.print(prompt);
            userInput = in.nextLine();

            try{//if input is a number
                num = Integer.parseInt(userInput);

                if(num <= high && num >= low){//if input is within range
                    valid = true;
                }//end of if

                else{//if input is out of range
                    System.out.println(errorMsg);
                }//end of else 
            }//end of try

            catch(NumberFormatException e){//if input isnt a number
                System.out.println(errorMsg);
            
            }//end of catch
        }//end of while
        return num;

    }//end of validator

//for user input of double
    public static double validator(String prompt, String errorMsg){
        Scanner in = new Scanner(System.in);
        double num = 0;
        String userInput;
        boolean valid = false;

        while(valid == false){//to repeat till valid entry is recieved

//prompt user input
            System.out.print(prompt);
            userInput = in.nextLine();

            try{//if input is a number
                num = Double.parseDouble(userInput); 
                valid = true;
            }//end of try

            catch(NumberFormatException e){//if input isnt a number
                System.out.println(errorMsg);
            }//end of catch
        }//end of while
        return num;
    }//end of validator
}//end of class