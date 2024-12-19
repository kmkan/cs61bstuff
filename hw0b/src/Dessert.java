public class Dessert {
    public int flavor;
    public int price;

    public static int numDesserts = 0;

    public Dessert(int flavorIn, int priceIn) {
        flavor = flavorIn;
        price = priceIn;
        numDesserts++;
    }

    public void printDessert() {
        System.out.print(flavor + " " + price + " " + numDesserts);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
