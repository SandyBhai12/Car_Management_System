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
@WebServlet("/add-car")
public class AddCarServlet extends HttpServlet {

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

		//jdbc logic

		Connection conn=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/servlet_cardb?user=root&password=root");

			PreparedStatement ps=conn.prepareStatement("Insert into car values(?,?,?,?,?)");

			ps.setInt(1, carId);
			ps.setString(2, carModel);
			ps.setString(3, carBrand);
			ps.setString(4, carColor);
			ps.setInt(5, carPrice);

			ps.execute();

			resp.sendRedirect("index.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		}


	}

}
