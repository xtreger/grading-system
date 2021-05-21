import controller.Controller;
import model.Criteria;
import model.Rubric;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        Exception exception = assertThrows(Exception.class, () -> controller.addCriteriaToRubric( "Name" , new Criteria("")));

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

}
