package duke.choice;

public class Clothing implements Comparable<Clothing> {
     private String descreption;

     public Clothing(String descreption, double price, String aSize) {
          this.descreption = descreption;
          this.price = price;
          size = aSize;
     }

     private double price;
     private String size = "M";
     public final static double MinPrice = 10;
     public final static double TAX_RATE = 0.2;

     public String getDescreption() {
          return descreption;
     }

     public void setDescreption(String descreption) {
          this.descreption = descreption;
     }

     public double getPrice() {
          return price + (price * TAX_RATE) ;
     }

     public void setPrice(double price) {

          this.price =  (price > MinPrice) ? price : MinPrice;
     }

     public String getSize() {
          return size;
     }

     public void setSize(String size) {
          this.size = size;
     }

     @Override

     public String toString(){

          return  getDescreption() + "," + getSize() + "," + getPrice();
     }
     @Override
     public int compareTo(Clothing c) {
          return this.descreption.compareTo(c.descreption);
     }

}
