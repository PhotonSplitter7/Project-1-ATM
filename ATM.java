package Project1;
import java.util.*;

//class header
public class ATM {

    //declare variables for money
    int hundreds, fifties, twenties;

    //default constructor for no arg object creation, initializes ATM to 0
    public ATM()
    {
        hundreds = 0;
        fifties = 0;
        twenties = 0;

    }
    //overloaded constructor for parameters, this offers a starting balance in ATM other than 0
    public ATM(int hundreds, int fifties, int twenties){

        //assign parameter values to instance variables
        this.hundreds = hundreds;
        this.fifties = fifties;
        this.twenties = twenties;

    }

    //overloaded constructor for 'other' ATM parameter - NOTE THIS IS NOT YET STARTED
    public ATM(ATM other){

        if(other != null) {
            //if it is ATM instance, check if equal
            if (other instanceof ATM) {
                //cast to ATM object
                ATM temp = (ATM) other;

                //initialize variables
                this.hundreds = other.hundreds;
                this.fifties = other.fifties;
                this.twenties = other.twenties;
            }
        }
        else
        {
            System.out.println("Null parameter detected");
            throw new IllegalArgumentException();
        }

    }

    //generate setters and getters for variables****************************************************
    //setter and getter for hundreds
    public int getHundreds()
    {
        return hundreds;
    }

    public void setHundreds(int hundreds)
    {
        this.hundreds = hundreds;
    }

    //setter and getter for fifties
    public int getFifties()
    {
        return fifties;
    }

    public void setFifties(int fifties)
    {
        this.fifties = fifties;
    }

    //setter and getter for twenties
    public int getTwenties()
    {
        return twenties;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    //equals method - returns true if 'other' ATM equals 'this' ATM in exact dollar amounts************************
    @Override
    public boolean equals(Object other)
    {
        //variable to pass true false to main
        boolean isEqual = false;
        //check if ATM parameter is valid
        if(other != null)
        {
            //if it is ATM instance, check if equal
            if(other instanceof ATM)
            {
                //cast to ATM object
                ATM temp = (ATM)other;
                if(this.hundreds == ((ATM) other).hundreds && this.fifties == ((ATM) other).fifties)
                {
                    isEqual = true;
                }
                else{
                    isEqual = false;
                }


            }
        }
        //return true/false
    return isEqual;

    }



    //static equals method- returns true if two compared ATM's are same. ATM 1 and ATM 2 are passed into parameters
    public static boolean equals(ATM other1, ATM other2)
    {
        //instance variable for returning true false to main
        boolean isEqual = false;
        //if both ATM's are ATM valid proceed
        if(other1 != null && other2 != null)
        {
            //would this be nesessary becouse parameters are 'ATM other1'?
            if(other1 instanceof ATM && other2 instanceof ATM)
            {
                //if both ATM's have matching money; isEqual is true
                if(other1.hundreds == other2.hundreds && other1.fifties == other2.fifties)
                {
                    isEqual = true;
                }
                else{
                    isEqual = false;
                }


            }

            //if both ATM's are same return true, else return false
            return isEqual;
        }

        //if parameters are invalid, throw exception
        else
        {
            throw new IllegalArgumentException();
        }



    }





    //Method for comparing amounts in ATM's
    public int compareTo(ATM other)
    {
        //declare instance variables for this ATM and other ATM
        int ThisTotal = 0;
        int OtherTotal = 0;

        //if parameter is ATM assign it to temp
        if(other instanceof ATM)
        {
            //cast as ATM object
            ATM temp = (ATM)other;



            //calculate total amount in dollars for each ATM
            ThisTotal = (this.hundreds * 100) + (this.fifties * 50) + (this.twenties * 20);
            OtherTotal = (((ATM) other).hundreds * 100) + (((ATM) other).fifties * 50) + (((ATM) other).twenties * 20);


            //cascaded if else if returns 1 for bigger, 0 for equal, and -1 for smaller
            if(ThisTotal > OtherTotal)
            {
                return 1;
            }
            else if(ThisTotal == OtherTotal)
            {
                return 0;
            }

            else
            {
                return -1;
            }

        }
        //if invalid parameter throw exception
        else
        {
            throw new IllegalArgumentException();
        }
    }



    //static compareTo- compares two ATM's that are inputed into method parameters
    public static int compareTo(ATM other1, ATM other2)
    {

        //declare instance variables for ATM1 and ATM2

        int ATM1_Total = 0;
        int ATM2_Total = 0;
        int i = 0;

        //check to see if parameters are legit
        if (other1 != null && other2 != null)
        {
            if (other1 instanceof ATM && other2 instanceof ATM) {



                    //calculate total value for each ATM in dollars
                    ATM1_Total = (((ATM) other1).hundreds * 100) + (((ATM) other1).fifties * 50) + (((ATM) other1).twenties * 20);
                    ATM2_Total = (((ATM) other2).hundreds * 100) + (((ATM) other2).fifties * 50) + (((ATM) other2).twenties * 20);


                    //cascaded if else if returns 1 for bigger, 0 for equal, and -1 for smaller
                    if(ATM1_Total > ATM2_Total)
                    {
                        i = 1;
                    }
                    else if(ATM1_Total == ATM2_Total)
                    {
                        i = 0;
                    }

                    else
                    {
                        i = -1;
                    }

                }
            //if valid parameters, return value
            return i;
        }

        //throw exception if parameters invalid
        else
        {
            throw new IllegalArgumentException();
        }


    }




    //putIn method adds 'other' ATM's cash to 'this' ATM cash
    public void putIn(ATM other)
    {

        //validate parameter
        if (other != null) {

            //declare instance variables for other ATM
            int OtherATM_hundred, OtherATM_fifty, OtherATM_twenty = 0;

            //if intance of ATM class continue
            if (other instanceof ATM) {
                //cast to ATM object
                ATM temp = (ATM) other;


                //assign 'other' ATM's bil types to variables
                OtherATM_hundred = ((ATM) other).hundreds;
                OtherATM_fifty = ((ATM) other).fifties;
                OtherATM_twenty = ((ATM) other).twenties;


                //add other ATM's dollars to this machines dollars
                this.hundreds = +OtherATM_hundred;
                this.fifties = +OtherATM_fifty;
                this.twenties = +OtherATM_twenty;

            }

        }
        //throw exception if invalid parameter
        else
            {
              throw new IllegalArgumentException();
            }
    }

    //takes arguments for specific amounts to put in 'this' ATM
    public void takeOut(int hundreds, int fifties, int twenties)
    {
        this.hundreds = -hundreds;
        this.fifties = -fifties;
        this.twenties = -twenties;


    }

    //ATM takeout
//    public ATM takeOut(int amount)
//    {
//        int NewHundreds, NewFifties, NewTwenties = 0;
//
//
//
//    }









    //takeout receives ATM as an perameter and takes out amount in 'other' from 'this'
    public void takeOut(ATM other)
        {
        //declare instance variables for this ATM and other ATM
        int ThisATM_hundred, ThisATM_fifty, ThisATM_twenty = 0;
        int OtherATM_hundred, OtherATM_fifty, OtherATM_twenty = 0;

        //if valid parameter continue
        if (other instanceof ATM) {
            //cast ATM object
            ATM temp = (ATM) other;

            //this might be unnessissary
            ThisATM_hundred = this.hundreds;
            ThisATM_fifty = this.fifties;
            ThisATM_twenty = this.twenties;
            
            //calculate this ATM's new value ( subtract other from this)
            this.hundreds = -((ATM)other).hundreds;
            this.fifties = -((ATM)other).fifties;
            this.twenties = -((ATM)other).twenties;


        }
        //throw exception if bad parameters
            else
        {
            throw new IllegalArgumentException();
        }
    }





//NOTE: TWENTY"S ARE SKIPPING OVER> ALSO CHECK MATH
    //ATM takeout returns ATM object with money removed from 'this' ATM***********************************
    public ATM takeOut(int amount)
    {
        //declare Integers for remainder and number of bills(NumBills)
        int remainder = 0;
        int hundreds = 0;
        int fifties = 0;
        int twenties = 0;
        //create new ATM
        ATM newATM = new ATM();

        System.out.println("this.ATM has " + this.hundreds + " H " + this.fifties + " F " + this.twenties + " T ");

       if(amount >= 100)
       {
           // count how many 100 bills************************
           do
           {
               //calculate how many 100's
               ++hundreds;
              //this could be remainder = remainder - 100; could be an issue
               remainder = amount-(hundreds * 100);
           }
           while(remainder >= 100);

           //update amount to be removed
           amount = amount-(hundreds * 100);
           //remove bills from this ATM
           this.hundreds = this.hundreds-hundreds;
           //input bills to new ATM
           newATM.hundreds = hundreds;
       }

       if(amount >= 50)
       {
           // count how many 50 bills************************
           do
           {
               //calculate how many 50's
               ++fifties;
               remainder = amount-(fifties * 50);

           }
           while(remainder >= 50);

           //update amount to be removed
           amount = amount - (fifties * 50);
           //remove bills from this ATM
           this.fifties = this.fifties-fifties;
           //input bills to new ATM
           newATM.fifties = fifties;
       }

       if(amount >= 20)
       {
           // count how many 20 bills************************
           do
           {
               //calculate how many 20's
               ++twenties;
               remainder = amount-(twenties * 20);

           }
           while(remainder >= 20);

           //update amount to be removed
           amount = amount - (twenties * 20);
           //remove bills from this ATM
           this.twenties = this.twenties-twenties;
           //input bills to new ATM
           newATM.twenties = twenties;
       }

//        //if total requested amount is indevisible by 10 and/or is too much to withdraw, throw exception
        if(amount != 0 || this.hundreds < 0 || this.fifties < 0 || this.twenties < 0)
        {
            //warn user if requested amount not divisable by 10
            if(amount != 0)
            {
                System.out.println("amount requested not divisable by 10");
            }
            //warn user if not enough hundreds
            if(this.hundreds < 0)
            {
                System.out.println("not enough hundreds");
            }
            //warn user if not enough fifties
            if(this.fifties < 0)
            {
                System.out.println("not enough fifties");
            }
            //warn user if not enough twenties
            if(this.twenties < 0)
            {
                System.out.println("not enough twenties");
            }
            //put all money back into original ATM (void transaction)
            this.hundreds = this.hundreds + newATM.hundreds;
            this.fifties = this.fifties + newATM.fifties;
            this.twenties = this.twenties + newATM.twenties;
            //wipe new ATM (void transaction)
            newATM.hundreds = 0;
            newATM.fifties = 0;
            newATM.twenties = 0;

            //throw exception (note: here do we have to wipe new ATM? or does the throws exception do that since its never returned to main?
            throw new IllegalArgumentException();

        }


        //return ATM object
        return newATM;
    }




    //toString method returns string amount of money in ATM from which its called
    public String toString()
    {
        //declare ATMstatement variable to return string to main
        String ATMstatement;
        //convert ATM amounts from int to String
        String stringHundreds = Integer.toString(this.hundreds);
        String stringFiftys = Integer.toString(this.fifties);
        String stringTwenties = Integer.toString(this.twenties);


        //debugging
        System.out.println("hundreds are : " + this.hundreds);
    //print hundred statement
        if(this.hundreds > 1)
    {
        stringHundreds = (stringHundreds + " hundred dollar bills, ");
    }
        if(this.hundreds == 1)
    {
        stringHundreds = (stringHundreds + " hundred dollar bill, ");
    }
        if(this.hundreds < 1)
    {
        stringHundreds = (stringHundreds + " hundred dollar bills, ");
    }

        //print 50 statement
        if(this.fifties > 1)
        {
            stringFiftys = (stringFiftys + " fifty dollar bills, ");
        }
        if(this.fifties == 1)
        {
            stringFiftys = (stringFiftys + " fifty dollar bill, ");
        }
        if(this.fifties < 1)
        {
            stringFiftys = (stringFiftys + " fifty dollar bills");
        }
        //print 20 statement
        if(this.twenties > 1)
        {
            stringTwenties = (stringTwenties + " twenty dollar bills, ");
        }
        if(this.twenties == 1)
        {
            stringTwenties = (stringTwenties + " twenty dollar bill, ");
        }
        if(this.twenties < 1)
        {
            stringTwenties = (stringTwenties + " twenty dollar bills");
        }

        ATMstatement = stringHundreds + stringFiftys + stringTwenties;



        return ATMstatement = ATMstatement;

    }














}
