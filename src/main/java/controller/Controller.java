package controller;

import model.Criteria;
import model.Rubric;
import model.StudentGrade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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

    //  This will add the score to the student grade
    public StudentGrade addScore(Double score, StudentGrade studentGrade, Criteria criteria) throws Exception {

        // throws an error if invalid score has been entered
        if (score < 1 || score > 5) {

            throw new Exception("The score must be between 1 and 5.");

        }
        // throws an error if the criteria does not exist in the rubric
        if (!studentGrade.getRubric().getCriteriaList().contains(criteria)) {

            throw new Exception("The criteria does not exist in the rubric.");

        } //throws an error if the studetGradeList does not contain the passed studentGrade
        if (!studentGradeList.contains(studentGrade)) {
            throw new Exception("Student grade not found.");
        }


        int i = studentGradeList.indexOf(studentGrade);

        //adds the score to the studentGrade and the studentGrade to the studentGradeList
        studentGrade.getScore().put(criteria.getName(), score);
        studentGradeList.set(i, studentGrade);

        return studentGrade;
    }

    public List<StudentGrade> getStudentGrades(String rubricName) throws Exception {

        Rubric rubric = getRubric(rubricName);

        List<StudentGrade> rubricGrades = new ArrayList<>();

        for (StudentGrade grade : studentGradeList) {
            if (grade.getRubric() == rubric)
                rubricGrades.add(grade);
        }
        return rubricGrades;
    }

    private List<Double> getAllScoresByRubric(String rubricName) throws Exception {

        Rubric rubric = getRubric(rubricName);

        List<Double> scores = new ArrayList<>();
        for (StudentGrade studentGrade : studentGradeList) {

            if (studentGrade.getRubric() == rubric && !studentGrade.getScore().isEmpty()) {

                scores.addAll(studentGrade.getScore().values());
            }

        }
        if (scores.isEmpty()) {

            throw new Exception("There are no scores in this rubric.");

        }

        return scores;
    }

    public double getAverageByRubric(String rubricName) throws Exception {

        double total = 0.0;

        List<Double> studentGradeScores = getAllScoresByRubric(rubricName);
        for (Double score : studentGradeScores) {
            total += score;
        }
        return total / studentGradeScores.size();
    }

    public double getStandardDeviationByRubric(String rubricName) throws Exception {

        double average = getAverageByRubric(rubricName);
        double standardDeviation = 0.0;

        List<Double> studentGradeScores = getAllScoresByRubric(rubricName);

        for (double score : studentGradeScores) {

            standardDeviation += Math.pow(score - average, 2);
        }

        return Math.sqrt(standardDeviation / studentGradeScores.size());
    }

    public double getMinimumByRubric(String rubricName) throws Exception {

        return Collections.min(getAllScoresByRubric(rubricName));
    }

    public double getMaximumByRubric(String rubricName) throws Exception {

        return Collections.max(getAllScoresByRubric(rubricName));
    }


}
