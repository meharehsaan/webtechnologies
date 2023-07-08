import java.io.*;
import java.sql.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/* 
 * Remove ArrayList from code If you want it to work fine.
 */

class person {
    String name;
    String password;
    String username;

    person(String name, String password, String username) {
        this.name = name;
        this.password = password;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return username;
    }

    public void setName(String t) {
        name = t;
    }

    public void setPassword(String a) {
        password = a;
    }

    public void setUserName(String i) {
        username = i;
    }
}

public class personInfo extends HttpServlet {
    ArrayList<person> AL;
    Connection con = null;
    Statement st = null;

    public void init(ServletConfig scfg) {

        // making and Arraylist to store records in mem
        AL = new ArrayList<person>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // for linux cj is used
            String url = "jdbc:mysql://127.0.0.1:3306/survletdata"; // database name and port
            con = DriverManager.getConnection(url, "root", "root"); // change database user and password according
            st = con.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Occurs Exception in constructor" + e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println(action);
        if (action != null) {
            switch (action) {
                case "create":
                    try {
                        createUser(request, response);
                        doGet(response);
                    } catch (SQLException e) {
                        System.out.println("Create person error : " + e);
                    }
                    break;
                case "update":
                    try {
                        updateUser(request);
                        doGet(response);
                    } catch (SQLException e) {
                        System.out.println("Update person error : " + e);
                    }
                    break;
                case "delete":
                    try {
                        deleteUser(request);
                        doGet(response);
                    } catch (SQLException e) {
                        System.out.println("Create person error : " + e);
                    }
                    break;
            }
        }
    }

    public void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        // PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        // out.println("<html>");
        // out.println("<body>");
        // out.println("<h1> hello i am on</h1>");

        // person newperson = new person(name, password, username);
        // AL.add(newperson);

        // for (person person : AL) {
        //     out.println("<tr>");
        //     out.println("<td>" + person.getName() + "</td>");
        //     out.println("<td>" + person.getUserName() + "</td>");
        //     out.println("<td>" + person.getPassword() + "</td>");
        //     out.println("</tr>");
        // }

        String query = "INSERT INTO persondetail(password,name,username) values('" + password + "', '" + name + "', '"+ username + "')";
        int rs = st.executeUpdate(query);

        // if (rs > 0) {
        //     out.println("<h1>Record inserted successfully.</h1>");
        // } else {
        //     out.println("<h1>Record could not inserted.</h1>");
        // }

        // out.println("Hello aget");
        // out.println("</body>");
        // out.println("</html>");

    }

    public void updateUser(HttpServletRequest request) throws SQLException {
        String username = request.getParameter("username");

        for (person person : AL) {
            if (person.getUserName().equals(username)) {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                person.setName(name);
                person.setPassword(password);

                String query1 = "UPDATE persondetail SET password = '" + password + "', name = '" + name
                        + "' WHERE username = '" + username + "'";
                int rs1 = st.executeUpdate(query1);
                /*
                 * if (rs1 > 0) {
                 * System.out.println("Deleted Record Sucessfully");
                 * } else {
                 * System.out.println("Error deleting record");
                 * }
                 */
                break;
            }
        }
    }

    public void deleteUser(HttpServletRequest request) throws SQLException {
        String username = request.getParameter("username");

        Iterator<person> iterator = AL.iterator();
        while (iterator.hasNext()) {
            person person = iterator.next();
            if (person.getUserName().equals(username)) {
                iterator.remove();
                String query2 = "DELETE FROM persondetail where username = '" + username + "'";
                int rs2 = st.executeUpdate(query2);
                /*
                 * if (rs2 > 0) {
                 * System.out.println("Deleted Record Sucessfully");
                 * } else {
                 * System.out.println("Error deleting record");
                 * }
                 */
                break;
            }
        }
    }

    public void doGet(HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String myquery = "Select * from persondetail";
        ResultSet rs = st.executeQuery(myquery);

        while (rs.next()) {
            String password1 = rs.getString("password");
            String name1 = rs.getString("name");
            String username1 = rs.getString("username");

            person newperson = new person(name1, password1, username1);
            AL.add(newperson);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>person Collection</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Person</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Address</th><th>Name</th><th>Phone</th></tr>");

        for (person person : AL)  {
            out.println("<tr>");
            out.println("<td>" + person.getName() + "</td>");
            out.println("<td>" + person.getUserName() + "</td>");
            out.println("<td>" + person.getPassword() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
