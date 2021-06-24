# CircumferenceToPoint

This application determines the distance between a circumference and a given point that lies outside of the circumference using Pythagoras' theorem. 

## Description

This application determines the distance between a circumference and a given point that lies outside of the circumference. Four points are given as the input for this problem. The first three points are given to define a circumference, whilst the last point is the point outside of the circumference. In order to solve this problem, the problem is broken down into different parts.

The first part involves the analysis of the three circumference points. In order to create a circumference from three points, the points must form a right-angle triangle (see the triangle formed by the two yellow points and one blue point in figure 1). The three points are therefore first analysed to ensure that they are valid points (non-colinear and unique) and that they form a right-angle triangle. Following this, the right-angle vertex (blue point in figure 1) is identified from the three points using Pythagoras' Theorem. This step is crucial for the calculation of midpoints (marked by red x's in figure 1) and for the construction of the perpendicular bisector.


![Image showing calculation of the distance from a circumference to a point](https://github.com/ZoeZinovia/CircumferenceToPoint/blob/master/CircumferenceToPoint.png)

The second part comprises of the construction of line-segments and the respective perpendicular bisectors (mediatriz). Two line-segments are constructed between the right-angle vertex and the other two points (in yellow in figure 1). The midpoints of these line segments are then calculated, which are shown as red crosses in figure 1. Using the gradient of the line-segments and their midpoints, the mediatriz lines are then constructed (shown as green lines in figure 1). Finally, the center of the circumference is determined by the point of intersection of the two perpendicular bisectors, shown as the green point. The radius of the circumference is calculated as the distance between the center and the right-angle vertex.

The third, and final, part calculates the distance between the circumference and the point outside of the circle. This is done by subtracting the radius from the distance between the center of the circumference and the point outside of the circle. This value is then returned as output.

### Dependencies

* Java 8 is the only requirement. 

### Installing and using

* Simply clone the code from this repository. If using Eclipe, IntelliJ or another IDE, Client.java can be run. 
* If running on terminal, src code needs to be compiled before running client. This can be done by navigating into the src directory of the cloned the repository. Then run: ```javac -d ./../bin -sourcepath . Client.java ```. Then the application can be run from the bin directory with the following command: ```java Client```
* The following command arguments are expected: Three lines to define the circumference and a fourth line to give the coordinate of the point outside of the circumference. The coordinates of the points are given in 2-dimensional space with a double value for the x-coordinate and a double value for the y-coordinate. See below for an example:
  ```
  >> java Client
  >> 0.0 0.0  
  >> 0.0 2.0  
  >> 2.0 2.0  
  >> 5.0 3.0
  ```
* This yields the following distance as a double:
  ```
    3.06
  ```
