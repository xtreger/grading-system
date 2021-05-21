package model;

// this class contains the Criteria model with constructors, getters and setters
public class Criteria {
    private String name;

    public Criteria(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "name='" + name + '\'' +
                '}';
    }
}