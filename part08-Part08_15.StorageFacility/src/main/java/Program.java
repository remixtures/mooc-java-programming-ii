
public class Program {

    public static void main(String[] args) {
        // Test your program here
//        StorageFacility facility = new StorageFacility();
//        facility.add("a14", "ice skates");
//        facility.add("a14", "ice hockey stick");
//        facility.add("a14", "ice skates");
//
//        facility.add("f156", "rollerblades");
//        facility.add("f156", "rollerblades");
//
//        facility.add("g63", "six");
//        facility.add("g63", "pi");
//
//        facility.remove("f156", "rollerblades");
//
//        System.out.println(facility.contents("f156"));
//        System.out.println(facility.storageUnits());
        
        StorageFacility unit = new StorageFacility();
        unit.add("a111","mouse");
        unit.add("a111","cheese");
        unit.add("a111","cheese");
        unit.add("b123","projector");
        unit.add("g63","ice skates");
        unit.remove("b123","projector");
        System.out.println(unit.storageUnits());
    }
}
