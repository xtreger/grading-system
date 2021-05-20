# Sprint Backlog

| ID        | Task           | Story Points | Justification | 
| ------------- |:-------------| :-----:|:----:|
| 01 | Create Models | 1 | This involves creating models for the project which include Rubric StudentGrade and Criteria. |
| 02 | Create Controller & Main Class | 1 | This necessitates the development of two classes with no logic.|
| 03 | Add logic for adding rubric in Controller  | 2 | This involves creating a new rubric and adding it to the rubric list in the controller. |
| 04 | Create logic for adding criteria into rubric  | 2 | This will involve creating a criteria and adding it into a rubric. The story points estimation is the same as task 03 because of their similar complexity.|
| 05 | Create functionality for retrieving rubrics as a list  | 1 | This will involve returning the list of rubrics in the controller class. This is estimated as one story point because it should be a simple few lines of logic compared to task 03 and 04.|
| 06 | Implement getting rubric by name | 3 | This involves accepting a name and searching through the rubrics list to retrieve matching rubric. Error handling should also be included if rubric does not exist. Thus, the estimation is higher than previous tasks.|
| 07 | Implement creating StudentGrade   | 2 | This will involve creating a method that accepts a student name and a rubric to create a StudentGrade.|
| 08 | Add logic to add score of criteria into StudentGrade   | 6 | This will involve creating a method that accepts a grade criteria and score. The score should bee added to the grade along with the criteria. The complexity of this method is higher than previous tasks because it involves logic of checking the existence of grade, existence of criteria in a rubric and checking if the score is withing the accepted limits. |
| 09 | Add implementation for getting all the StudentGrades by rubric   | 3 | This involves adding a method that accepts a rubric name and returns grades associated with the rubric. It's estimation is 3 story points because |
| 10 | Implement retrieving summary calculation for rubric   | 5 | This will involve creating four methods that return the average, standard deviation, minimum and maximum scores respectively. Compared to other tasks which have a lower estimation this will involve creating multiple methods.|
| 11 | Implement retrieving summary calculation for criteria   | 4 | This task contains similar logic as task 10 but it is sorted differently. This task has lower story points as the complexity of of the logic is already implemented in task 10.|
| 12 | Add implementation of all functionality in the main class   | 3 | This will involve simulating a working project by creating a controller with sample data in the main class.|

