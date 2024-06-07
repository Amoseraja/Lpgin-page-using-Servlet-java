package amose;
import java.io.IOException;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class calculator extends HttpServlet{
	public void service(ServletRequest req,ServletResponse res) throws IOException {
		res.setContentType("text/html");
		Connection conn ;
        PreparedStatement pst ;
        ResultSet result ;
//	int x=Integer.parseInt	(req.getParameter("num1"));
//	int y=Integer.parseInt(req.getParameter("num2"));
//	int c=x+y;
//	res.getWriter().print("add"+c);
	
//	String x=	req.getParameter("usename");
//	String y=req.getParameter("password");
//	

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/amose";
            String username = "root";
            String password = "Amose@123";
            conn = DriverManager.getConnection(url, username, password);

            String userParam = req.getParameter("username");
            String passParam = req.getParameter("password");

            if (userParam != null && passParam != null) {
                pst = conn.prepareStatement("select * from emplogin where name = ? and password = ?");
                pst.setString(1, userParam);
                pst.setString(2, passParam);
                result = pst.executeQuery();

                if (result.next()) {
                    //res.getWriter().print("Login successful!");
                	req.getRequestDispatcher("home.html").forward(req, res);
                } else {
                    res.getWriter().print("Invalid username or password.");
                }
            }
	

}

	catch (Exception e) {
        e.printStackTrace();
    }
}
}