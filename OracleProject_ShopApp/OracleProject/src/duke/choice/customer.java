package duke.choice;

public class customer {
     private String name;
     private String size;
     private  Clothing[] items;

     public customer(String name, int measurement) {
          this.name = name;
          setSize(measurement);
     }

     public  void addItems(Clothing[] someItems){
          items = someItems;
     }

     public Clothing[] getItems() {
          return items;
     }

     public double getTotalClothingCosts(){
          double total = 0.0;

          for (Clothing item : items){
//       if(c1.getSize().equals(item.getSize())){
                    total = total + item.getPrice();
//                    System.out.println("Items " +  ": " + item.getDescreption() + ", " + item.getPrice() + ", " + item.getSize());
//
//                             total = total + total * tax;
//                    if (total > 15){break;}
          }
          return total;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getSize() {
          return size;
     }

     public void setSize(String size) {
          this.size = size;
     }

     public void setSize(int measurement){

          switch (measurement){
               case 1 , 2 , 3:
                    setSize("S");
                    break;
               case 4,  5, 6:
                    setSize("M");
                    break;
               case  7, 8 , 9:
                    setSize("L");
                    break;
               default:
                    setSize("XL");
          }

     }


}
