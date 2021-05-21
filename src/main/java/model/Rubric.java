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

    public Rubric() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }
}
