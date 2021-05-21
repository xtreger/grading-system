package model;

import java.util.List;

// this class contains the Rubric model with constructors, getters and setters
public class Rubric {
    private String title;
    private List<Criteria> criteriaList;

    public Rubric(String title, List<Criteria> criteriaList) {
        this.title = title;
        this.criteriaList = criteriaList;
    }

    public String getTitle() {
        return title;
    }

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    @Override
    public String toString() {
        return "Rubric{" +
                "title='" + title + '\'' +
                ", criteriaList=" + criteriaList +
                '}';
    }
}
