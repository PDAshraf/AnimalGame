import java.util.Scanner;

public class Store {
    //Animals
    //Food
    public void animalVendor(){

    }

    public void foodVendor(){
        Scanner myScan = new Scanner(System.in);
        int budget = 5000,item;
        int basket,summa;
        int antal[];
        antal= new int[6];
        System.out.println("\nDin budget:"+budget);
        System.out.println("Vad vill du köpa?");
        System.out.println("Navigera med tangenterna 1-6" +
                "\n1.Hö - 100kr/st\n2.Hästfoder- 100kr/st\n3.Frö- 100kr/st\n" +
                "4.Kött- 100kr/st\n5.Hundmat- 100kr/st\n6.Kattmat- 100kr/st");
        item= myScan.nextInt();
        if (item<1 || item>6)
        {
            System.out.println("Fel!! Välj mellan 1-6");
        }
        else if(item==1)
        {
            System.out.println("Hur mycket hö vill du köpa?");
            antal[0]=myScan.nextInt();
        }
        else if(item==2)
        {
            System.out.println("Hur mycket hästfoder vill du köpa?");
            antal[1]=myScan.nextInt();
        }
        else if(item==3)
        {
            System.out.println("Hur mycket frö vill du köpa?");
            antal[2]=myScan.nextInt();
        }
        else if(item==4)
        {
            System.out.println("Hur mycket kött vill du köpa?");
            antal[3]=myScan.nextInt();
        }
        else if(item==5)
        {
            System.out.println("Hur mycket hundmat vill du köpa?");
            antal[4]=myScan.nextInt();
        }
        else
        {
            System.out.println("Hur mycket kattmat vill du köpa?");
            antal[5]=myScan.nextInt();
        }
        basket=foodVendor(antal[0],antal[1],antal[2],antal[3],antal[4],antal[5]);
        summa=budget-basket;
        System.out.println("Budget: "+summa);


        /**Summa är min budget minus det vi köpt**/
        //summa=budget-basket;
        //System.out.println("Pengar kvar:"+summa);
    }

    public static int foodVendor(int hay, int horsefeed,int seeds,int meat, int dogfood,int catfood)
    {

        int basketPrice;
        /***********Priser*************/
        hay=hay*100;
        horsefeed=horsefeed*100;
        seeds=seeds*100;
        meat=meat*100;
        dogfood=dogfood*100;
        catfood=catfood*100;
        /***********Priser*************/

        basketPrice=hay+horsefeed+seeds+meat+dogfood+catfood;
        System.out.println("Totalt köp:  "+basketPrice);
        return hay+horsefeed+seeds+meat+dogfood+catfood;


    }
}



