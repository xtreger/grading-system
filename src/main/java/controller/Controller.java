package controller;

import model.Criteria;
import model.Rubric;
import model.StudentGrade;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final List<Rubric> rubricList = new ArrayList<>();
    private final List<StudentGrade> studentGradeList = new ArrayList<>();

    public Rubric addRubric(Rubric rubric) throws Exception {

        if (rubric.getTitle() == null) {
            throw new Exception("Rubric Title cannot be null!");
        }

        rubricList.add(rubric);
        return rubric;
    }


    public void addCriteriaToRubric(String rubricName, Criteria criteria) throws Exception {
        Rubric rubric = getRubric(rubricName);


        if (rubric.getCriteriaList().size() == 10) {

            throw new Exception("You already have the maximum number of criteria.");

        } else if (criteria.getName() == null || criteria.getName().isEmpty()) {

            throw new Exception("You cannot add an empty criteria.");
        } else {

            rubric.getCriteriaList().add(criteria);

        }

    }

    public List<Rubric> getListOfRubrics() {
        return rubricList;
    }

    public Rubric getRubric(String title) throws Exception {

        for (Rubric rubric : rubricList) {
            if (rubric.getTitle().equals(title))
                return rubric;
        }

        throw new Exception("Rubric does not exist.");
    }

    public StudentGrade addStudentGrade(String rubricName, StudentGrade studentGrade) throws Exception {

        if (studentGrade.getStudentName() == null || studentGrade.getStudentName().isEmpty()) {

            throw new Exception("You cannot add an empty Student Name.");

        }

        Rubric rubric = getRubric(rubricName);
        studentGrade.setRubric(rubric);
        studentGradeList.add(studentGrade);
        return studentGrade;
    }

    public StudentGrade addScore(Double score, StudentGrade studentGrade, Criteria criteria) throws Exception {

        if (score < 1 || score > 5) {

            throw new Exception("The score must be between 1 and 5.");

        }
        if (!studentGrade.getRubric().getCriteriaList().contains(criteria)) {

            throw new Exception("The criteria does not exist in the rubric.");

        }
        if (!studentGradeList.contains(studentGrade)) {
            throw new Exception("Student grade not found.");
        }

        int i = studentGradeList.indexOf(studentGrade);

        studentGrade.getScore().put(criteria.getName(), score);
        studentGradeList.set(i, studentGrade);

        return studentGrade;
    }


}
