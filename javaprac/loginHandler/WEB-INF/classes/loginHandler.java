import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class loginHandler extends HttpServlet {

	Connection con = null;
	Statement st = null;

	public void init(ServletConfig scfg) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // for linux cj is used
			String url = "jdbc:mysql://127.0.0.1:3306/survletdata"; // database name and port
			con = DriverManager.getConnection(url, "root", "root"); // change database user and password according
			st = con.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Occurs Exception in constructor" + e);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {

		try {
			PrintWriter out = res.getWriter();

			String username = (String) req.getParameter("username");
			String password = req.getParameter("password");

			String value = "Login Successful";
			String nouser = "Something went wrong! User does not exist";
			req.setAttribute("key", value);
			req.setAttribute("nokey", nouser);

			String query = "select * from login where username = '" + username + "'";
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String user = rs.getString("username");
				String pass = rs.getString("password");

				if (user != "") {
					out.println("<html>");
					out.println("<head><title>Login Success</title></head>");
					out.println("<body>");
					out.println("<h1>" + username + " => " + req.getAttribute("key") + " => " + user + " => " + pass + " </h1>");
					out.println("</body>");
					out.println("</html>");
				} else if (user == "") {
					out.println("<html>");
					out.println("<head><title>Login Failed</title></head>");
					out.println("<body>");
					out.println("<h1>" + req.getAttribute("nokey") + "</h1>");
					out.println("</body>");
					out.println("</html>");
				} else {
					
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println("Error" + e);
		}
	}

}
