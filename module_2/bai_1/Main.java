package bai_1;

import utils.PlantUML;

public class Main {
    public static void main(String[] args) {
        Coordinates point = new Coordinates("A", 5, 8);

        System.out.println(point.toString());

        PlantUML plant = new PlantUML();
        plant.printUML(Coordinates.class);
    }
}