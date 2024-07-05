package duke.choice;


import java.util.Arrays;

public class ShopApp {
    public static void main(String[] args) {


        double tax = 0.2;
        double total = 0.0;

        System.out.println("Welcome to Duke Choice Shop");

        customer c1 = new customer("pinky", 14);

//        c1.setName("Pinky");
//        c1.setSize("S");


        System.out.println("min price " + Clothing.MinPrice);

        Clothing item1 = new Clothing("blue jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-shirt", 10.5, "S");

        Clothing[] items = {item1, item2, new Clothing("Green scarf",5.0, "S" ), new Clothing("Blue T-Shirt", 10.5, "S")};



        //it's upgraded by using loop
//        System.out.println("Item 1 " +  ": " + item1.descreption + ", " + item1.price + ", " + item1.size);
//        System.out.println("Item 2 " +  ": " + item2.descreption + ", " + item2.price + ", " + item2.size);
//        total = (item1.price + item2.price * 2 )* (1 + tax);


        int measurement = 8;

        c1.addItems(items);
        System.out.println("Customer is " + c1.getName() + "," + c1.getSize() + "," + c1.getTotalClothingCosts());
        for (Clothing item : c1.getItems()){
//            System.out.println("Itemns " + item.getDescreption() + "," + item.getPrice());
            System.out.println("Item output " + item);
        }

        int Average =0;
        int count =0;

        for (Clothing item : c1.getItems()) {
            if (item.getSize().equals("L")){
                count ++;
                Average += item.getPrice();
            }
        }

        try{
            Average = Average/ count;
            System.out.println("Average price " + Average + ", Count " + count );
        } catch (ArithmeticException e) {
            System.out.println("Dont divide by 0");
        }

        Arrays.sort(c1.getItems());
        for (Clothing item : c1.getItems()){
            System.out.println("Item output " + item);
        }

    }

}