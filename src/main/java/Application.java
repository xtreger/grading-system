import controller.Controller;
import model.Criteria;
import model.Rubric;
import model.StudentGrade;

import java.util.ArrayList;
import java.util.HashMap;

public class Application {

    public static void execute() throws Exception {

        Controller controller = new Controller();

        Rubric mathsRubric = controller.addRubric(new Rubric("Maths Rubric", new ArrayList<>()));


        controller.addCriteriaToRubric(mathsRubric.getTitle(), new Criteria("Algebra"));
        controller.addCriteriaToRubric(mathsRubric.getTitle(), new Criteria("Geometry"));
        controller.addCriteriaToRubric(mathsRubric.getTitle(), new Criteria("Calculus"));

        System.out.println(controller.getRubric(mathsRubric.getTitle()));
        System.out.println();

        StudentGrade mihelloCarare = controller.addStudentGrade(mathsRubric.getTitle(), new StudentGrade("Mihello Carare", null, new HashMap<>()));
        StudentGrade justinBieber = controller.addStudentGrade(mathsRubric.getTitle(), new StudentGrade("Justin Bieber", null, new HashMap<>()));

        controller.addScore(2.0, mihelloCarare, mathsRubric.getCriteriaList().get(0));
        controller.addScore(3.0, mihelloCarare, mathsRubric.getCriteriaList().get(1));
        controller.addScore(5.0, mihelloCarare, mathsRubric.getCriteriaList().get(2));
        controller.addScore(5.0, justinBieber, mathsRubric.getCriteriaList().get(0));
        controller.addScore(4.0, justinBieber, mathsRubric.getCriteriaList().get(1));
        controller.addScore(1.0, justinBieber, mathsRubric.getCriteriaList().get(2));

        for (StudentGrade studentGrade : controller.getStudentGrades(mathsRubric.getTitle())) {

            System.out.println(studentGrade.toString());

        }

        System.out.println();
        System.out.println("Average of Maths Rubric: " + controller.getAverageByRubric(mathsRubric.getTitle()));
        System.out.println("Standard Deviation of Maths Rubric: " + controller.getStandardDeviationByRubric(mathsRubric.getTitle()));
        System.out.println("Minimum of Maths Rubric: " + controller.getMinimumByRubric(mathsRubric.getTitle()));
        System.out.println("Maximum of Maths Rubric: " + controller.getMaximumByRubric(mathsRubric.getTitle()));

        System.out.println();
        System.out.println("Average of Algebra Criteria: " + controller.getAverageByCriteria(mathsRubric.getCriteriaList().get(0).getName()));
        System.out.println("Standard Deviation of Algebra Criteria: " + controller.getStandardDeviationByCriteria(mathsRubric.getCriteriaList().get(0).getName()));
        System.out.println("Minimum of Algebra Criteria: " + controller.getMinimumByCriteria(mathsRubric.getCriteriaList().get(0).getName()));
        System.out.println("Maximum of Algebra Criteria: " + controller.getMaximumByCriteria(mathsRubric.getCriteriaList().get(0).getName()));

    }

    public static void main(String[] args) throws Exception {
        execute();
    }
}
