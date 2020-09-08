package Project1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ATM ATM1 = new ATM(0,1,2);


       ATM ATM2 = ATM1.takeOut(90);
        System.out.println(ATM1.toString());

        System.out.println("ATM2 is : " + ATM2.toString());




// ***************************************************************
//        for(int i = 1; remainder < 100; i++)
//        {
//            //remainder checks if remainder is > 100, if not then max amount of 100's are reached
//            remainder = amount % (i * 100);
//            NumBills = i-1;
//        }
//        //Update Standing Total
//        amount = -(NumBills * 100);
//        //subtract number of 100 bills removed from this ATM
//        this.hundreds = -(NumBills);
//        //add 100s to new ATM
//        newATM.hundreds = NumBills;




    }
}
