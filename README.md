# Documentation


## Scrum Sprint Backlog and Task Estimation
___
Estimating the sprint backlog benefits the team because it allows them to efficiently manage their workload by breaking down product backlog items into small, distinct tasks and then rough estimating them during sprint planning. This increases the likelihood that the team will complete the task at hand. Additionally, through sprint planning, identifying tasks and predicting them allows team members to work more cooperatively. For example, if sprint backlog items are not estimated, a team will overlook a critical path through the work or the possibility that the person planning the backlog will be the busiest individual during the following iteration.

### Sprint Backlog

| ID        | Task           | Story Points | Justification | 
| :-------------: |:------------| :-----:|:----|
| 01 | Create Models | 1 | This focuses on the project's modelling process by adding Rubric StudentGrade and Criteria models. The estimation of this task is low as it involves short and non-complex implementation.  |
| 02 | Create Controller & Main Class | 1 | Two separate classes must be developed which contain no logic. This task is estimated at one story point as it contains similar complexity as the previous task which should take the same amount of time to complete. |
| 03 | Add logic for adding rubric in Controller  | 2 | This requires creating a new rubric and adding it to the rubric list in the controller. The story points estimation for this task relatively low but higher than the previous two tasks as it involves extensive implementation at a low level of complexity.|
| 04 | Create logic for adding criteria into rubric | 2 | This part involves defining a criteria and subsequently inputting it into a rubric. Due to the similarity in difficulty, the story point calculation is identical to task 3.|
| 05 | Create functionality for retrieving rubrics as a list | 1 | This will involve returning the list of rubrics in the controller class. This is calculated as one story point because, in comparison to tasks 3 and 4, it's completion can be a clear few lines of logic.|
| 06 | Implement getting rubric by name | 3 | This includes accepting a name and checking the list of rubrics to retrieve a match. Error handling should also be included if rubric does not exist. As a result, the estimation is greater than for previous tasks.|
| 07 | Implement creating StudentGrade | 2 | This will involve creating a method that accepts a student name and a rubric to create a StudentGrade. This task has a smaller story point estimate than the previous one and it its estimated at 2 story points because it needs thorough implementation at a low degree of difficulty.|
| 08 | Add logic to add score of criteria into StudentGrade | 5 | This requires the creation of a system that accepts grade criteria and a grade score. Along with the criteria, the score should be added to the grade. This process is more complex than previous tasks since it includes implementation for determining the existence of a grade, the existence of criteria in a rubric, and determining whether the score falls within accepted limits.|
| 09 | Add implementation for getting all the StudentGrades by rubric | 3 | This involves adding a method that accepts a rubric name and returns grades associated with the rubric. It's estimation is 3 story points because it should have some functionality to filter the student grades by rubric. |
| 10 | Implement retrieving summary calculation for rubric | 5 | This will involve creating four methods that return the average, standard deviation, minimum and maximum scores respectively. In contrast to other tasks with a lower estimate, this one will require the implementation of several methods, which explains the high story point estimate.|
| 11 | Implement retrieving summary calculation for criteria | 3 | This task contains similar logic as task 10 but it is sorted differently. This task has less story points since the logic for this task has already been implemented in task 10.|
| 12 | Add implementation of all functionality in the main class | 2 | This will involve simulating a working project by creating a controller with sample data in the main class. The estimation of this task is based on the similarity in assumed time and level of difficulty of tasks 2 and 3. |

Following the completion of tasks Test-Driven Development approach will be used. A test or tests, as well as the code for the task that supports such tests, will be included with the commit to the repository.

&nbsp;

### Velocity Metric

The key metric in Scrum is velocity, which is an indicator of how much work a team can complete in a single Sprint. Velocity is determined by adding the story points for all entirely finished User Stories at the conclusion of the Sprint. Since the metric measures predicted and finished progress over many iterations, the pace will be used to estimate how fast a team can work through the backlog of upcoming sprints. The more sprints the team completes, the more reliable the prediction.

It is critical to monitor the development of velocity over time. New teams will anticipate a boost of velocity when they improve their partnerships and work processes. Existing teams will monitor their velocity to ensure stable results over time and to determine whether or not a specific process adjustment resulted in success. A drop in average velocity is typically indicative of an inadequate aspect of the team's growth phase that can be addressed during the next retrospective.