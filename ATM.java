package Project1;
import java.util.*;

//class header
public class ATM {

    //declare variables for money
    int hundreds, fifties, twenties;

    //default constructor (no parameter) for no arg object creation, initializes ATM to 0
    public ATM()
    {
        //initialize ATM variables to 0 if no parameters provided
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

    //overloaded constructor for 'other' ATM parameter
    public ATM(ATM other){

       //if parameter is not null proceed
        if(other != null) {
            //if it is ATM instance continue
            if (other instanceof ATM) {
                //cast to ATM object
                ATM temp = (ATM) other;

                //initialize variables
                this.hundreds = other.hundreds;
                this.fifties = other.fifties;
                this.twenties = other.twenties;
            }
        }
        //if parameter is null throw exception and alert user
        else
        {
            System.out.println("Null parameter detected");
            throw new IllegalArgumentException();
        }

    }


    //generate setters and getters for variables****************************************************
    //getter for hundreds
    public int getHundreds()
    {
        return hundreds;
    }

    //set hundreds method
    public void setHundreds(int hundreds)
    {
        this.hundreds = hundreds;
    }

    //getter for fifties
    public int getFifties()
    {
        return fifties;
    }
    //setter for fifties
    public void setFifties(int fifties)
    {
        this.fifties = fifties;
    }

    //getter for twenties
    public int getTwenties()
    {
        return twenties;
    }

    //setter for twenties
    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    //equals method - compares values of two ATM's dollars amounts: true if types of bills exact same
    @Override
    public boolean equals(Object other)
    {
        //variable to pass true false to main
        boolean isEqual = false;
        //check if ATM parameter is null
        if(other != null)
        {
            //if it is ATM instance, check if equal
            if(other instanceof ATM)
            {
                //cast to ATM object
                ATM temp = (ATM)other;
                //if hundreds and fifties same isEqual = true
                if(this.hundreds == ((ATM) other).hundreds && this.fifties == ((ATM) other).fifties)
                {
                    isEqual = true;
                }
                //if not equal isEqual = false
                else{
                    isEqual = false;
                }


            }
        }
        //if parameter is null throw exception
        else
        {
            System.out.println("Null parameter detected");
            throw new IllegalArgumentException();
        }
    //return true/false through isEqual
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
            //cast to ATM object1
            ATM temp1 = (ATM)other1;
            //cast to ATM object2
            ATM temp2 = (ATM)other2;

            //if both ATM's instance of ATM class proceed
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
        }

        //if parameters are null, throw exception and warn user
        else
        {
            System.out.println("null parameters detected");
            throw new IllegalArgumentException();
        }

        //if both ATM's are same return true, else return false
        return isEqual;



    }





    //Method for comparing amounts in ATM's
    public int compareTo(ATM other)
    {
        //declare instance variables for this ATM and other ATM
        int ThisTotal = 0;
        int OtherTotal = 0;
        int returnValue = 0;

        //check if Parameter is null
        if(other != null)
        {
            //cast as ATM object
            ATM temp = (ATM)other;

            //if parameter is ATM continue
            if(other instanceof ATM)
            {

                //calculate total amount in dollars for each ATM
                ThisTotal = (this.hundreds * 100) + (this.fifties * 50) + (this.twenties * 20);
                OtherTotal = (((ATM) other).hundreds * 100) + (((ATM) other).fifties * 50) + (((ATM) other).twenties * 20);


                //cascaded if else if returns 1 for bigger, 0 for equal, and -1 for smaller
                if(ThisTotal > OtherTotal)
                {
                    returnValue = 1;
                }
                if(ThisTotal == OtherTotal)
                {
                    returnValue = 0;
                }

                else
                {
                    returnValue = -1;
                }

            }
        }

        //if invalid parameter throw exception
        else
        {
            System.out.println("null parameter detected");
            throw new IllegalArgumentException();
        }

        //return value
        return returnValue;
    }



    //static compareTo- compares two ATM's that are inputed into method parameters
    public static int compareTo(ATM other1, ATM other2)
    {

        //declare instance variables for ATM1 and ATM2
        int ATM1_Total = 0;
        int ATM2_Total = 0;
        int returnValue = 0;

        //check to see if parameters are null
        if (other1 != null && other2 != null)
        {
           //caste to ATM
            ATM temp1 = (ATM)other1;
            ATM temp2 = (ATM)other2;

            //if both are ATM instances proceed
            if (other1 instanceof ATM && other2 instanceof ATM)
            {
                    //calculate total value for each ATM in dollars
                    ATM1_Total = (((ATM) other1).hundreds * 100) + (((ATM) other1).fifties * 50) + (((ATM) other1).twenties * 20);
                    ATM2_Total = (((ATM) other2).hundreds * 100) + (((ATM) other2).fifties * 50) + (((ATM) other2).twenties * 20);


                    //cascaded if else if returns 1 for bigger, 0 for equal, and -1 for smaller
                    if(ATM1_Total > ATM2_Total)
                    {
                        returnValue = 1;
                    }
                    if(ATM1_Total == ATM2_Total)
                    {
                        returnValue = 0;
                    }

                    if(ATM1_Total < ATM2_Total)
                    {
                        returnValue = -1;
                    }

                }

        }

        //throw exception if parameters invalid and warn user
        else
        {
            System.out.println("null parameter detected");
            throw new IllegalArgumentException();
        }

        //if valid parameters, return value
        return returnValue;

    }


    //putIn method adds 'other' ATM's cash to 'this' ATM cash
    public void putIn(ATM other)
    {

        //declare instance variables for other ATM
        int OtherATM_hundred, OtherATM_fifty, OtherATM_twenty = 0;

        //validate parameter
        if (other != null) {

            //cast to ATM object
            ATM temp = (ATM)other;

            //if instance of ATM class continue
            if (other instanceof ATM)
            {
                //assign 'other' ATM's bil types to variables
                OtherATM_hundred = ((ATM) other).hundreds;
                OtherATM_fifty = ((ATM) other).fifties;
                OtherATM_twenty = ((ATM) other).twenties;

                //add other ATM's dollars to this machines dollars
                this.hundreds = this.hundreds + OtherATM_hundred;
                this.fifties = this.fifties + OtherATM_fifty;
                this.twenties = this.twenties + OtherATM_twenty;
            }

        }
        //throw exception if invalid parameter
        else
            {
                System.out.println("Null parameter");
                throw new IllegalArgumentException();
            }
    }

    //takes arguments for specific amounts to put in 'this' ATM
    public void takeOut(int hundreds, int fifties, int twenties)
    {
        //take out money from this ATM using parameters
        this.hundreds = this.hundreds - hundreds;
        this.fifties = this.fifties - fifties;
        this.twenties = this.twenties - twenties;
    }


    //takeout receives ATM as an perameter and takes out amount in 'other' from 'this'
    public void takeOut(ATM other)
        {
        //check to see if parameter 'other' is null
            if(other != null)
            {
                //cast ATM object
                ATM temp = (ATM) other;

                //if valid parameter continue
                if (other instanceof ATM) {

                    //calculate this ATM's new value ( subtract other from this)
                    this.hundreds = this.hundreds - ((ATM)other).hundreds;
                    this.fifties = this.fifties - ((ATM)other).fifties;
                    this.twenties =this.twenties - ((ATM)other).twenties;
                }
            }

            //if parameter null throw exception and warn user
            else
        {
            System.out.println("null parameter detected");
            throw new IllegalArgumentException();
        }
    }


    //ATM takeout returns ATM object with money removed from 'this' ATM. takes out amount specified in parameter
    public ATM takeOut(int amount)
    {
        //declare Integers for remainder and number of bills(NumBills)
        int remainder = 0;
        int hundreds = 0;
        int fifties = 0;
        int twenties = 0;
        //create new ATM
        ATM newATM = new ATM();

        //if amount requested can be covered by $100 bill
       if(amount >= 100)
       {
           // count how many 100 bills can cover amount
           do
           {
               //add 1 $100 bill
               ++hundreds;
              //update remainder
               remainder = amount-(hundreds * 100);
           }
           //continue adding $100 dollar bills untill remainder is smaller than $100
           while(remainder >= 100);

           //once large bills maximized subtract $100 bills removed from amount. the rest will be removed by $50's and $20's
           amount = amount-(hundreds * 100);
           //update this ATM's $100 balance
           this.hundreds = this.hundreds - hundreds;
           //input $100 bills to new ATM
           newATM.hundreds = hundreds;
       }
        //if amount to be removed can be covered by $50 proceed
       if(amount >= 50)
       {
           // count how many 50 bills can cover 'amount'
           do
           {
               //add $50 bill
               ++fifties;
               //update remainder
               remainder = amount - (fifties * 50);

           }
           //while remainder can be covered by $50 bills continue
           while(remainder >= 50);

           //update amount to be removed
           amount = amount - (fifties * 50);
           //remove bills from this ATM
           this.fifties = this.fifties - fifties;
           //input $50 bills to new ATM
           newATM.fifties = fifties;
       }
        //if amount to be removed can be covered by $20 bill continue
       if(amount >= 20)
       {
           // count how many 20 bills
           do
           {
               //add $20 bill
               ++twenties;
               //update remainder
               remainder = amount - (twenties * 20);
           }
           //while remainder can be covered by $20's continue
           while(remainder >= 20);

           //update amount to be removed (amount should be 0 by now)
           amount = amount - (twenties * 20);
           //remove bills from this ATM
           this.twenties = this.twenties - twenties;
           //input bills to new ATM
           newATM.twenties = twenties;
       }

        //if total requested amount is in-divisible by 10 and/or is too much to withdraw, throw exception
        //$100, $50, and $20 are all divisible by 10, so if amount left to withdraw isn't 0 it isn't /10
        if(amount != 0 || this.hundreds < 0 || this.fifties < 0 || this.twenties < 0)
        {
            //warn user if requested amount not divisible by 10
            if(amount != 0)
            {
                System.out.println("amount requested not divisible by 10");
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



    //choose hundred statement based on amount
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

        //choose fifty statement based on amount
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
        //choose twenty statement based on amount
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


        //return string statement on amount in ATM
        return ATMstatement = ATMstatement;

    }














}
