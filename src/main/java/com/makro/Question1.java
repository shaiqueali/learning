package com.makro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question1 {

    public static void main(String args[]) {

        // Fruit
        Item item1 = new Item();
        item1.setName("Orange");
        item1.setType("Fruit");

        Item item2 = new Item();
        item2.setName("Apple");
        item2.setType("Fruit");

        Item item3 = new Item();
        item3.setName("Banana");
        item3.setType("Fruit");

        // Animal
        Item item4 = new Item();
        item4.setName("Dog");
        item4.setType("Animal");

        Item item5 = new Item();
        item5.setName("Tiger");
        item5.setType("Animal");

        // Vehicle

        Item item6 = new Item();
        item6.setName("Car");
        item6.setType("Animal");

        Item item7 = new Item();
        item7.setName("Boat");
        item7.setType("Vehicle");

        Item item8 = new Item();
        item8.setName("Plane");
        item8.setType("Vehicle");

        List<Item> items = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8);

        process(items);

    }


    public static double process(double amount, int point) {
        final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        final double total = amount / POWERS_OF_10[point];
        String formatNumber = String.format("%." + point + "f", total);
        return Double.parseDouble(formatNumber);
    }

    public static void process(List<Item> itemList) {
        itemList = itemList.stream().sorted((object1, object2) -> object1.getName().compareTo(object2.getName())).collect(Collectors.toList());
        itemList.stream().collect(Collectors.groupingBy(Item::getType));
        itemList.forEach(item -> System.out.println((item.getType() +" - "+item.getName())));
    }
}
