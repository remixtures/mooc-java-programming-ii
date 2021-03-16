
public class Human implements Comparable<Human> {

    private int wage;
    private String name;

    public Human(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public int getWage() {
        return wage;
    }


    @Override
    public String toString() {
        return name + " " + wage;
    }

    @Override
    public int compareTo(Human human) {
        if (this.wage == human.getWage()) {
            return 0;
        } else if (this.wage < human.getWage()) {
            return 1;
        } else {
            return -1;
        }
    } 
}
