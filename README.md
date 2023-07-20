# webtechnologies

Github :: [meharehsaan](https://www.github.com/meharehsaan/webtechnologies)

---

## Contents

- **Java Documentation**
  - Source code to check builtin functions written by java
- **Java Practice**
  - Contains some additional programs I practiced.
- Lab01 **=>** cmdline arguments
- Lab02 **=>** Polymorphism
- Lab03 **=>** Array and Exception
- Lab04 **=>** File and Exception Handling
- Lab05 **=>** JDBC
- Lab06 **=>** HTML
- Lab07 **=>** JavaScript
- Lab08 **=>** Survlet and CRUD
- Lab09 **=>** Survlet and JDBC
- Lab10 **=>** Survlet State Managment 

<br>

### Environment Setup
---

On my Ubuntu 23.04 (Lunar Lobster) having kernal 6.2 I have following configurations of java environment.

```
export PATH="$PATH:/home/mehar/.local/bin"

export CATALINA_HOME="/home/mehar/webtomcat/apache-tomcat-10.1.10"

export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"

export CLASSPATH="$CLASSPATH:/usr/share/java/mysql-connector-j-8.0.33.jar:/home/mehar/webtomcat/apache-tomcat-10.1.10/lib/servlet-api.jar:/home/mehar/webtomcat/apache-tomcat-10.1.10/lib/jsp-api.jar:."

```

<br>

### Java codes
---

This repo contains all Java codes of
- Java **GUI**
- Basic **OOP** concepts
- **Polymorphism**
- **Streams**
- **Serialization**
- **ArrayList**
- **Threads**
- **Sockets**
- **Exception** Handling
- **Database** Connectivity
- **HttpSurvlet**
- Survlet **CRUD** application
- [Signuplogin-website](https://github.com/meharehsaan/miniprojects/tree/master/Signuploginapp-java)
  - sessions
  - cookies
  - JSP

<br>

#-----------------------------------Lab01-------------------------@**cmd arugments**

Write a program that takes input using command line arguments and calculates the area of a **geometric** shape based
on the input. The program should display the calculated area using the **GUI** component.

<br>

#-----------------------------------Lab02-------------------------@**polymorphism**

Implement the **TwoDimensionalShape** hierarchy
Each TwoDimensionalShape should contain method **getArea** to calculate the area of the two-dimensional shape.
Write a **Driver** class that uses an array of TwoDimensionalShape references to objects of each concrete class in the
hierarchy. The program should print a text **description** of the object to which each array element refers. Also, in the loop that
processes all the shapes in the array, determine whether each shape is a Circle, Square or Triangle. Make a call to area,
polymarphically.

<br>

#-----------------------------------Lab03-------------------------@**Arraylist and Exception Handling**

You are required to write a program for banking applications to store customer records. The program should have the
following classes:
    Write a Customer class with the following attributes:
- **name** - a string representing the name of the customer.
- **id** - a string representing the ID of the customer.
- **age** - an integer value indicating the age of the customer.
- **balance** - a double value indicating the amount saved by the customer.
Provide a parameterized constructor function to initialize the instance variables.

<br>

#-----------------------------------Lab04-------------------------@**File and Exception Handling**

Create a small application to save the records of employees in an organization. Create a class Employee with attributes
int id, string name, static double salary, string rank and implement the following functions

- to read/load data from csv file. 
- create objects and add it to a collection.
- to add a new object into collection.
- to write all the objects from collection to a txt file.
- to remove an object from collection based on id.

<br>

#-----------------------------------Lab05-------------------------@**JDBC**

You need to build an address book that shall be capable of storing user name, address, city and phone number of
a person. The feature list includes

- Mysql connector 8.0.33 is used
- **Add** – to add a new person record
- **Delete** – to delete an existing person record by name
- **Search** – to search a person record by name
- **Exit** – to exit from application

<br>

#-----------------------------------Lab06-------------------------@**HTML**

Create the following sample signup and login forms in **HTML**.

<br>

#-----------------------------------Lab07-------------------------@**JavaScript**

Apply **JavaScript** to validate the user input in the following way.
- All the fields are necessary and must be filled.
- **Email** shall be in the proper format (e.g., X @ Y . Z).
- Phone, Fax, and Zip code shall be **numeric** only.

<br>

#-----------------------------------Lab08-------------------------@**Survlet and CRUD**

Create a Servlet application that allows a user to perform **CRUD** (Create, Read, Update and Delete) operations on a collection of
books. The application should use the **GET** method for reading, and the POST method for creating, updating and deleting books.
    
- Mysql connector 8.0.33 is used
- Tomcat Server 10.1.10 is used
- I have also added database in this lab

<br>
        
#-----------------------------------Lab09-------------------------@**Survlet and JDBC**

Remove **Arraylist** in **personInfo class** to make code work properly according to input output because of ArrayList same record show **multiple** entries.
Add your MySQL connector jar file in lib folder and compile the code.
Remove **cj** from **cm.mysql.cj.jdbc.driver** because it is used in **linux** if you are not using linux.
Add your **MySQL** server password in the connection function

<br>

You can make a Pull Request if you remove **ArrayList** from code and code is working properly with perfect **output**.

#-----------------------------------Lab10-------------------------@**Survlet State managment**

Design a small **web** application that support the login of two different type of users i.e., teacher and student.

- Courses and their registration must be saved **manually** in course and courseAssignment tables.
- You are allowed to make any necessary **amendments** in the columns of table (e.g., adding any auto-incremental key as primary key) however, the name of the table must be the same.
- You need to implement the relationship of **primary key** and **foreign key** in database.
- Any type of users cannot proceed without **logging**-**in** and each user is only capable to view his/her own dashboard. (Hint: use session handling). Save the email and **user_type** in session after successful logged-in, and perform the check on their respective **dashboards**.
- HTML forms should be validated using JavaScript/place-holders.
- All users should be able to **logout** and after that they should not be able to view their **homepage**.

- Go to lab10 [Source Code](https://github.com/meharehsaan/miniprojects/tree/master/Signuploginapp-java)
