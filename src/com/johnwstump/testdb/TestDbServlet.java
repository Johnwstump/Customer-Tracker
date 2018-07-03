package com.johnwstump.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.util.Optional;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Value("${db.usernameVariable:customerTrackerDBUsername}")
	private String DBUSERVAR;
	@Value("${db.passwordVariable:customerTrackerDBPassword}")
	private String DBPASSWORDVAR;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Setup Connection Variables
		String user = null;
		String pass = null;
		try {
			user = Optional.ofNullable(System.getenv(DBUSERVAR)).orElseThrow(() -> new Exception(DBUSERVAR + " is not set in the environment"));
			pass = Optional.ofNullable(System.getenv(DBPASSWORDVAR)).orElseThrow(() -> new Exception(DBPASSWORDVAR + " is not set in the environment"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		// Get Connection to database
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Connection succesful!");
			myConn.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException();
		}
	}

}
