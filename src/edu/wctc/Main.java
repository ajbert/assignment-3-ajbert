package edu.wctc;

public class Main {

    public static void main(String[] args) {

        String evens = "evens";
        String primes = "primes";
        String fibonaccis = "Fibonaccis";

        VennDiagram<Integer> numberFun = new VennDiagram<>(evens, primes, fibonaccis);

        numberFun.add(1, fibonaccis);
        numberFun.add(2, evens, primes, fibonaccis);
        numberFun.add(3, primes, fibonaccis);
        numberFun.add(4, evens);
        numberFun.add(5, primes, fibonaccis);
        numberFun.add(6, evens);
        numberFun.add(7, primes);
        numberFun.add(8, evens, fibonaccis);
        numberFun.add(9);
        numberFun.add(10, evens);

        System.out.println(numberFun.unionOf(primes, evens));
        System.out.println(numberFun.intersectionOf(primes, fibonaccis));
        System.out.println(numberFun.complementOf(fibonaccis, evens));
        System.out.println(numberFun.diagramCenter());
    }

    public static void mostDelicious() {

        String carby = "carby";
        String tomatoey = "tomatoey";
        String cheesy = "cheesy";


        VennDiagram<String> foodDiagram = new VennDiagram<>(carby, tomatoey, cheesy);

        foodDiagram.add("Croissant", carby);
        foodDiagram.add("Roll", carby);
        foodDiagram.add("Toast", carby);
        foodDiagram.add("Grilled Cheese", carby, cheesy);
        foodDiagram.add("Mac and Cheese", carby, cheesy);
        foodDiagram.add("Cheese and Crackers", carby, cheesy);
        foodDiagram.add("Bagel and Cream Cheese", carby, cheesy);
        foodDiagram.add("Spaghetti Marinara", carby, tomatoey);
        foodDiagram.add("Tomato Sandwich", carby, tomatoey);
        foodDiagram.add("Lasagna", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Soup and Goldfish Crackers", carby, tomatoey, cheesy);
        foodDiagram.add("Pizza Margherita", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato and Mozzarella Sandwich", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Slices", tomatoey);
        foodDiagram.add("Tomato Wedges", tomatoey);
        foodDiagram.add("Grape Tomatoes", tomatoey);
        foodDiagram.add("Caprese Salad", tomatoey, cheesy);
        foodDiagram.add("Greek Salad", tomatoey, cheesy);
        foodDiagram.add("Mozzarella Sticks", cheesy);
        foodDiagram.add("String Cheese", cheesy);
        foodDiagram.add("Cheese Cubes", cheesy);
        foodDiagram.add("Fresh Mozzarella", cheesy);

        // carby //OR tomatoey
        System.out.println(foodDiagram.unionOf(carby, tomatoey));
        // tomatoey AND cheesy
        System.out.println(foodDiagram.intersectionOf(tomatoey, cheesy));
        // cheesy but NOT carby
        System.out.println(foodDiagram.complementOf(cheesy, carby));
        // all three
        System.out.println(foodDiagram.diagramCenter());


    }

}
