package model;

import java.util.Map;

// this class contains the StudentGrade model with constructors, getters and setters
public class StudentGrade {
    private String studentName;
    private Rubric rubric;
    private Map<String, Double> score;

    public StudentGrade(String studentName, Rubric rubric, Map<String, Double> score) {
        this.studentName = studentName;
        this.rubric = rubric;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }

    public Map<String, Double> getScore() {
        return score;
    }

    public void setScore(Map<String, Double> score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "Student Name='" + studentName + '\'' +
                ", Rubric=" + rubric +
                ", Score=" + score +
                '}';
    }
}


