package model;

// this class contains the Criteria model with constructors, getters and setters
public class Criteria {
    private String name;

    public Criteria(String name) throws Exception {

        this.name = name;
    }

    public Criteria() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "name='" + name + '\'' +
                '}';
    }
}