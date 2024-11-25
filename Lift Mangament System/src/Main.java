public class Main {
    public static void main(String[] args) {

        Building buildingLift = new Building();

        buildingLift.init(6, 2);

        System.out.println(buildingLift.requestLift(0,3));

        buildingLift.printMap();
        System.out.println("---------------------------------");

        System.out.println();

        buildingLift.tick();

        buildingLift.printMap();
        System.out.println("---------------------------------");

        System.out.println();

        System.out.println(buildingLift.requestLift(0,2));

        buildingLift.printMap();
        System.out.println("---------------------------------");

        System.out.println();

        buildingLift.tick();

        buildingLift.printMap();
        System.out.println("---------------------------------");

        System.out.println();

        System.out.println(buildingLift.requestLift(0,5));
        buildingLift.printMap();
        System.out.println("---------------------------------");

        System.out.println();

        System.out.println(buildingLift.requestLift(1,0));

        buildingLift.printMap();
        System.out.println("---------------------------------");

        System.out.println();

        buildingLift.tick();
        buildingLift.tick();
        buildingLift.tick();
        buildingLift.tick();
        buildingLift.tick();

        buildingLift.printMap();
        System.out.println("---------------------------------");

        System.out.println();

    }
}