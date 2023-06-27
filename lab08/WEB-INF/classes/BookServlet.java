import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

class Book {
    String title;
    String author;
    String ISBN;

    Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setTitle(String t){
        title = t;
    }

    public void setAuthor(String a){
        author = a;
    }

    public void setISBN(String i){
        ISBN = i;
    }
}


public class BookServlet extends HttpServlet {
    ArrayList<Book> AL;

    public void init(ServletConfig scfg) {
        AL = new ArrayList<Book>();
        AL.add(new Book("Java how to program", "Deitel", "9780136053064"));
        AL.add(new Book("Head First C#", "Andrew Stellman", "9781491976708"));
        AL.add(new Book("C#", "Svetlin Nakov", "9789544007737"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {
                case "create":
                    createBook(request);
                    break;
                case "update":
                    updateBook(request);
                    break;
                case "delete":
                    deleteBook(request);
                    break;
            }
        }

        // response.sendRedirect(request.getContextPath() + "/create");
    }

    public void createBook(HttpServletRequest request) {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String ISBN = request.getParameter("isbn");

        Book newBook = new Book(title, author, ISBN);
        AL.add(newBook);
    }

    public void updateBook(HttpServletRequest request) {
        String ISBN = request.getParameter("isbn");

        for (Book book : AL) {
            if (book.getISBN().equals(ISBN)) {
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                book.setTitle(title);
                book.setAuthor(author);
                break;
            }
        }
    }

    public void deleteBook(HttpServletRequest request) {
        String isbn = request.getParameter("isbn");

        Iterator<Book> iterator = AL.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getISBN().equals(isbn)) {
                iterator.remove();
                break;
            }
        }
    }
}