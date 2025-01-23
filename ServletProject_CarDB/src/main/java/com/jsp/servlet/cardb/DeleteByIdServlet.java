package com.jsp.servlet.cardb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-car-by-id")
public class DeleteByIdServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int carId=Integer.parseInt(req.getParameter("carId"));
		
		Connection conn=null;


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=root");

			PreparedStatement ps=conn.prepareStatement("delete from car where carid=?");
			ps.setInt(1, carId);
			
			
			ps.executeUpdate();
			
			resp.sendRedirect("display-all");
			
//			req.setAttribute("carObject", rs);
//			RequestDispatcher rd=req.getRequestDispatcher("UpdateCar.jsp");
//
//			rd.forward(req, resp);

			System.out.println(" return to current servlet");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
