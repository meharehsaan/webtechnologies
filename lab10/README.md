# Survlet State managment

Design a small **web** application that support the login of two different type of users i.e., teacher and student.

- Courses and their registration must be saved **manually** in course and courseAssignment tables.
- You are allowed to make any necessary **amendments** in the columns of table (e.g., adding any auto-incremental key as primary key) however, the name of the table must be the same.
- You need to implement the relationship of **primary** **key** and **foreign** **key** in database.
- Any type of users cannot proceed without **logging**-**in** and each user is only capable to view his/her own dashboard. (Hint: use session handling). Save the email and **user_type** in session after successful logged-in, and perform the check on their respective **dashboards**.
- HTML forms should be validated using JavaScript/place-holders.
- All users should be able to **logout** and after that they should not be able to view their **homepage**.

- Go to lab10 [Source Code](https://github.com/meharehsaan/miniprojects/tree/master/Signuploginapp-java)