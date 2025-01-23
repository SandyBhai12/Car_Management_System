package com.jsp.servlet.cardb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save-updated-car")
public class UpdateCarServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carId=Integer.parseInt(req.getParameter("carId"));
		String carModel=req.getParameter("carModel");
		String carBrand=req.getParameter("carBrand");
		String carColor=req.getParameter("carColor");
		int carPrice=Integer.parseInt(req.getParameter("carPrice"));
		
		Connection conn=null;


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=root");

			PreparedStatement ps=conn.prepareStatement("update car set carmodel=?,carbrand=?,carcolor=?,carprice=? where carid=?");
			ps.setString(1, carModel);
			ps.setString(2, carBrand);
			ps.setString(3, carColor);
			ps.setInt(4, carPrice);
			ps.setInt(5, carId);
			
			
			
			ps.execute();
			
			resp.sendRedirect("display-all");

			
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
