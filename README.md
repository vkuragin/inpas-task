# Home task from some company
## Task
In a two-dimensional world, we begin with any bar-chart (or row of close-packed 'towers', each of unit width), and then it rains, completely filling all convex enclosures in the chart with water.
  
    9               ██           9               ██    
    8               ██           8               ██    
    7     ██        ██           7     ██≈≈≈≈≈≈≈≈██    
    6     ██  ██    ██           6     ██≈≈██≈≈≈≈██    
    5 ██  ██  ██  ████           5 ██≈≈██≈≈██≈≈████    
    4 ██  ██  ████████           4 ██≈≈██≈≈████████    
    3 ██████  ████████           3 ██████≈≈████████    
    2 ████████████████  ██       2 ████████████████≈≈██
    1 ████████████████████       1 ████████████████████

In the example above, a bar chart representing the values [5, 3, 7, 2, 6, 4, 5, 9, 1, 2] has filled, collecting 14 units of water.

Write a function that will calculate volume of water that can be held in this way. 
Write simple web application that will take array of values as input params, calculate result using function written before and show this result to user.  

### Additional terms:
- use maven as a build tool
- use spring framework
- output format - war
- can be deployed to one of app servers: Weblogic, Glassfish

# Implementation
## Requirements:
    - Java 1.8
    - Maven 3.3+
## Installation:
    - build: mvn clean package
    - deploy to application server
    - open in browser: http://yourdomain/inpas/
    
  