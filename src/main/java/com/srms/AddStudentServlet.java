package com.srms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String marks=request.getParameter("marks");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					
					"jdbc:oracle:thin:@localhost:1521/XEPDB1",
					"HR",
					"hr"
					);
		
		String s="INSERT INTO STUDENT(id,name,city,marks) VALUES (?,?,?,?)";
		
		PreparedStatement ps=conn.prepareStatement(s);
		
		ps.setInt(1, Integer.parseInt(id));
		ps.setString(2, name);
		ps.setString(3, city);
		ps.setInt(4,Integer.parseInt(marks));
		ps.executeUpdate();
		conn.close();
		response.getWriter().println("Inserted!");
	}catch(Exception e) {
		e.printStackTrace(response.getWriter());
	}

	


}

}

