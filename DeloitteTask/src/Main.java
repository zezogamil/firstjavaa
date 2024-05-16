public class Main {
    public static void main(String[] args) {

        int[] Num = {3,2,-2,5,-3};
        int[] NumTwo = {1,1,2,-1,2,-1};
        int[] NumThree = {1,2,3,-4};
        int[] NumFour = {1,1};



       int MaxVal = Math.max(Num[0], Num[1]);
       int secandValue = Math.min(Num[0],Num[1]);

       for(int i = 0; i < Num.length; i++){
           if(Num[i] > MaxVal){
               secandValue = MaxVal;
               MaxVal = Num[i];
           }else if (Num[i] > secandValue){
               secandValue = Num[i];
           }


       }
        int calc = MaxVal + secandValue;
        System.out.println("First array" );
           System.out.println("First max Value is : " + MaxVal + " Second max Value is : " + secandValue);
           System.out.println("=" + calc);
           System.out.println("_________________________________________________________________________");
//______________________________________________________________________________________________________________

        int maxArrTwo = Math.max(NumTwo[0], NumTwo[1]);
        int minArrTwo = Math.min(NumTwo[0], NumTwo[1]);

        for(int j =0; j < NumTwo.length; j++) {
            if(NumTwo[j] > maxArrTwo){
                minArrTwo = maxArrTwo;
                maxArrTwo = NumTwo[j];
            } else if (NumTwo[j] > minArrTwo) {
                minArrTwo = NumTwo[j];
            }
        }
        int Calc = maxArrTwo + minArrTwo;
        System.out.println("Second array");
        System.out.println("First high value is : " + maxArrTwo);
        System.out.println("Second high value is : " + minArrTwo);
        System.out.println("the sum of two value = " + Calc);


//--------------------------------------------------------------------------------------------
        System.out.println("_________________________________________________________________________");
        for(int k = 0; k < NumFour.length; k ++){
            System.out.println("forth array");
            if(NumFour.length < 3){
                System.out.println("The Array is small amd there's no pair");
            }

        }
//--------------------------------------------------------------------------------------------------------------


        


    }
}