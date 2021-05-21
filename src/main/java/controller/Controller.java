package controller;

import model.Criteria;
import model.Rubric;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final List<Rubric> rubricList = new ArrayList<>();

    public Rubric addRubric(Rubric rubric) throws Exception {

        if (rubric.getTitle() == null) {
            throw new Exception("Rubric Title cannot be null!");
        }

        rubricList.add(rubric);
        return rubric;
    }


    public void addCriteriaToRubric(Rubric rubric, Criteria criteria) throws Exception {

        if (rubric.getCriteriaList().size() == 10) {

            throw new Exception("You already have the maximum number of criteria.");

        } else if (criteria.getName() == null || criteria.getName().isEmpty()) {

            throw new Exception("You cannot add an empty criteria.");
        } else {

            rubric.getCriteriaList().add(criteria);

        }

    }

}
