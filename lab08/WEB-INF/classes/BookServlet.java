import java.io.*;
import java.sql.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public void setISBN(String i) {
        isbn = i;
    }
}

public class BookServlet extends HttpServlet {
    ArrayList<Book> AL;
    Connection con = null;
    Statement st = null;

    public void init(ServletConfig scfg) {

        // making and Arraylist to store records in mem
        AL = new ArrayList<Book>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");                             //for linux cj is used 
            String url = "jdbc:mysql://127.0.0.1:3306/survletdata";        //database name and port
            con = DriverManager.getConnection(url, "root", "root");   //change database user and password according
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
                        createBook(request);
                        doGet(response);
                    } catch (SQLException e) {
                        System.out.println("Create book error : " + e);
                    }
                    break;
                case "update":
                    try {
                        updateBook(request);
                        doGet(response);
                    } catch (SQLException e) {
                        System.out.println("Update book error : " + e);
                    }
                    break;
                case "delete":
                    try {
                        deleteBook(request);
                        doGet(response);
                    } catch (SQLException e) {
                        System.out.println("Create book error : " + e);
                    }
                    break;
            }
        }
    }

    public void createBook(HttpServletRequest request) throws SQLException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        System.out.println("hello");
        Book newBook = new Book(title, author, isbn);
        AL.add(newBook);

        String query = "insert into bookdetail(author,title,isbn) values('" + author + "', '" + title + "', '" + isbn + "')";
        int rs = st.executeUpdate(query);

        /*
         * if (rs > 0) {
         * System.out.println("Record inserted successfully.");
         * } else {
         * System.out.println("Record could not inserted.");
         * }
         */

    }

    public void updateBook(HttpServletRequest request) throws SQLException {
        String isbn = request.getParameter("isbn");

        for (Book book : AL) {
            if (book.getISBN().equals(isbn)) {
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                book.setTitle(title);
                book.setAuthor(author);
                String query1 = "UPDATE bookdetail SET author = '" + author + "', title = '" + title + "' WHERE isbn = '" + isbn + "'";
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

    public void deleteBook(HttpServletRequest request) throws SQLException {
        String isbn = request.getParameter("isbn");

        Iterator<Book> iterator = AL.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getISBN().equals(isbn)) {
                iterator.remove();
                String query2 = "DELETE FROM bookdetail where isbn = '" + isbn + "'";
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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Book Collection</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Book Collection</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Title</th><th>Author</th><th>Pages</th></tr>");

        for (Book book : AL) {
            out.println("<tr>");
            out.println("<td>" + book.getTitle() + "</td>");
            out.println("<td>" + book.getAuthor() + "</td>");
            out.println("<td>" + book.getISBN() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
