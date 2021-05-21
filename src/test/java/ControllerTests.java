import controller.Controller;
import model.Criteria;
import model.Rubric;
import model.StudentGrade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class ControllerTests {

    private Controller controller;
    private List<Criteria> criteriaList;


    @BeforeEach
    public void init() throws Exception {
        controller = new Controller();
        criteriaList = new ArrayList<>(Arrays.asList(
                new Criteria("Criteria Unu"),
                new Criteria("Criteria Doi"),
                new Criteria("Criteria Trei"),
                new Criteria("Criteria Patru"),
                new Criteria("Criteria Cinci"),
                new Criteria("Criteria Sase")));
    }


    @Test
    public void testAddRubricWithNullTitle() {

        Exception exception = assertThrows(Exception.class, () -> controller.addRubric(new Rubric(null, new ArrayList<>())));

        String expectedMessage = "Rubric Title cannot be null!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAddRubricWithValidTitle() throws Exception {
        Rubric rubric = new Rubric("RubricTitle", criteriaList);

        assertEquals("RubricTitle", controller.addRubric(rubric).getTitle());
    }

    @Test
    public void testAddCriteriaWithTenExisting() throws Exception {

        criteriaList.add(new Criteria("Criteria Sapte"));
        criteriaList.add(new Criteria("Criteria Opt"));
        criteriaList.add(new Criteria("Criteria Noua"));
        criteriaList.add(new Criteria("Criteria Zece"));

        Rubric rubric = new Rubric("Name", criteriaList);
        controller.addRubric(rubric);

        Exception exception = assertThrows(Exception.class, () -> controller.addCriteriaToRubric("Name", new Criteria("Criteria Unsprezece")));

        String expectedMessage = "You already have the maximum number of criteria.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAddCriteriaWithEmptyCriteriaName() throws Exception {

        Rubric rubric = new Rubric("Name", criteriaList);
        controller.addRubric(rubric);

        Exception exception = assertThrows(Exception.class, () -> controller.addCriteriaToRubric("Name", new Criteria("")));

        String expectedMessage = "You cannot add an empty criteria.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetRubricWithNonExistingName() throws Exception {
        Rubric rubric = new Rubric("Name", criteriaList);
        controller.addRubric(rubric);

        Exception exception = assertThrows(Exception.class, () -> controller.getRubric("LOL"));

        String expectedMessage = "Rubric does not exist.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void testAddStudentGradeWithEmptyStudentName() {

        Exception exception = assertThrows(Exception.class, () -> controller.addStudentGrade("Name", new StudentGrade("", null, new HashMap<>())));

        String expectedMessage = "You cannot add an empty Student Name.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAddInvalidScore() throws Exception {

        Rubric rubric = new Rubric("Name", criteriaList);
        controller.addRubric(rubric);

        StudentGrade studentGrade = controller.addStudentGrade("Name", new StudentGrade("Mihello", rubric, new HashMap<>()));

        Exception exception = assertThrows(Exception.class, () -> controller.addScore(6.0, studentGrade, criteriaList.get(0)));

        String expectedMessage = "The score must be between 1 and 5.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAddScoreNonExistingCriteria() throws Exception {

        Rubric rubric = new Rubric("Name", criteriaList);
        controller.addRubric(rubric);

        StudentGrade studentGrade = controller.addStudentGrade("Name", new StudentGrade("Mihello", rubric, new HashMap<>()));

        Exception exception = assertThrows(Exception.class, () -> controller.addScore(4.9, studentGrade, new Criteria("Criteria Douazeci")));

        String expectedMessage = "The criteria does not exist in the rubric.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAddScoreNonExistingStudentGrade() throws Exception {

        Rubric rubric = new Rubric("Name", criteriaList);
        controller.addRubric(rubric);

        StudentGrade studentGrade = new StudentGrade("Mihello", rubric, new HashMap<>());

        Exception exception = assertThrows(Exception.class, () -> controller.addScore(4.9, studentGrade, criteriaList.get(0)));

        String expectedMessage = "Student grade not found.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testGetAverageByRubric() throws Exception {

        initialiseData();

        assertEquals(3.0, controller.getAverageByRubric("Name"));

    }

    @Test
    public void testStandardDeviationByRubric() throws Exception {

        initialiseData();

        assertEquals(1.4142135623730951, controller.getStandardDeviationByRubric("Name"));

    }

    @Test
    public void testGetMinimumByRubric() throws Exception {

        initialiseData();

        assertEquals(1, controller.getMinimumByRubric("Name"));

    }

    @Test
    public void testGetMaximumByRubric() throws Exception {

        initialiseData();

        assertEquals(5, controller.getMaximumByRubric("Name"));

    }

    @Test
    public void testGetAverageByCriteria() throws Exception {

        initialiseDataForCriteria();

        assertEquals(3.3333333333333335, controller.getAverageByCriteria("Criteria Doi"));

    }

    @Test
    public void testStandardDeviationByCriteria() throws Exception {

        initialiseDataForCriteria();

        assertEquals(1.247219128924647, controller.getStandardDeviationByCriteria("Criteria Doi"));

    }

    @Test
    public void testGetMinimumByCriteria() throws Exception {

        initialiseDataForCriteria();

        assertEquals(2, controller.getMinimumByCriteria("Criteria Doi"));

    }

    @Test
    public void testGetMaximumByCriteria() throws Exception {

        initialiseDataForCriteria();

        assertEquals(5, controller.getMaximumByCriteria("Criteria Doi"));

    }

    private void initialiseData() throws Exception {
        Rubric rubric = new Rubric("Name", criteriaList);
        controller.addRubric(rubric);

        List<StudentGrade> studentGradeList = new ArrayList<>(Arrays.asList(
                new StudentGrade("Mihai", null, new HashMap<>()),
                new StudentGrade("Mihai1", null, new HashMap<>()),
                new StudentGrade("Mihai2", null, new HashMap<>()),
                new StudentGrade("Mihai3", null, new HashMap<>()),
                new StudentGrade("Mihai4", null, new HashMap<>()),
                new StudentGrade("Mihai5", null, new HashMap<>())));


        Map<String, Double> scores = new HashMap<>();


        for (int i = 1; i < 6; i++) {
            scores.put(criteriaList.get(i).getName(), (double) i);
        }

        for (StudentGrade studentGrade : studentGradeList) {
            studentGrade.setScore(scores);
            controller.addStudentGrade(rubric.getTitle(), studentGrade);
        }
    }

    private void initialiseDataForCriteria() throws Exception {
        Rubric rubric = new Rubric("Name", criteriaList);
        controller.addRubric(rubric);

        List<StudentGrade> studentGradeList = new ArrayList<>(Arrays.asList(
                new StudentGrade("Mihai", null, new HashMap<>()),
                new StudentGrade("Mihai1", null, new HashMap<>()),
                new StudentGrade("Mihai2", null, new HashMap<>())));

        Map<String, Double> score1 = new HashMap<>() {{
            put(criteriaList.get(1).getName(), 3.0);
        }};
        Map<String, Double> score2 = new HashMap<>() {{
            put(criteriaList.get(1).getName(), 2.0);
        }};
        Map<String, Double> score3 = new HashMap<>() {{
            put(criteriaList.get(1).getName(), 5.0);
        }};

        studentGradeList.get(0).setScore(score1);
        controller.addStudentGrade(rubric.getTitle(), studentGradeList.get(0));
        studentGradeList.get(1).setScore(score2);
        controller.addStudentGrade(rubric.getTitle(), studentGradeList.get(1));
        studentGradeList.get(2).setScore(score3);
        controller.addStudentGrade(rubric.getTitle(), studentGradeList.get(2));

    }


}
