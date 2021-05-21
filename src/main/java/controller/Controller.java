package controller;

import model.Criteria;
import model.Rubric;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final List<Rubric> rubricList = new ArrayList<>();

    public Rubric addRubric(String rubricTitle) {

        if (rubricTitle == null) {
            System.out.println("Rubric Title cannot be null!");
            return null;
        }

        Rubric rubric = new Rubric(rubricTitle, new ArrayList<>());
        rubricList.add(rubric);
        return rubric;
    }
}
