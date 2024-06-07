package amose;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class homepage extends HttpServlet {
	public void service(ServletRequest req,ServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
req.getRequestDispatcher("home.html").forward(req, res);
}}
