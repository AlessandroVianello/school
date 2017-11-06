/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitejdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class SQLiteJDBC
{

	/**
	 * @param args the command line arguments
	 */
	public static void createNewDatabase(String fileName) throws IOException
	{

		File files = new File("C:\\sqlite2\\database");
		if (!files.exists())
		{
			if (files.mkdirs())
			{
				System.out.println("Multiple directories are created!");
			} else
			{
				System.out.println("Failed to create multiple directories!");
			}
		}

		String url = "jdbc:sqlite:C:\\sqlite2\\database\\" + fileName;

		try (Connection conn = DriverManager.getConnection(url))
		{
			if (conn != null)
			{
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static void createNewTable(String fileName)
	{

		Connection conn = null;
		Statement stmt = null;

		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite2\\database\\" + fileName);
			System.out.println("Opened database successfully");

			stmt = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS dati(\n "
					+ "id INTEGER  PRIMARY KEY,\n"
					+ "username      TEXT        NOT NULL,\n"
					+ "password      TEXT        NOT NULL\n"
					+ ");";
			stmt.executeUpdate(sql);

		} catch (ClassNotFoundException ex)
		{
			Logger.getLogger(SQLiteJDBC.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex)
		{
			Logger.getLogger(SQLiteJDBC.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Table created successufully");
	}

	/**
	 *      * @param args the command line arguments     
	 */
	public static void main(String[] args) throws IOException
	{

		SQLiteJDBC.createNewDatabase(fileName);
		SQLiteJDBC.createNewTable(fileName);
		SQLiteJDBC.addNewUser("Paolo", "cad323");
		SQLiteJDBC.addNewUser("dad", "dewd444");
		SQLiteJDBC.showData();
	}

	static String fileName = "test.db";

	public static void addNewUser(String username, String password)
	{
		String credentials = "INSERT INTO dati VALUES(?,?,?);";

		try (Connection conn = SQLiteJDBC.connect();
				PreparedStatement pstmt = conn.prepareStatement(credentials))
		{
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
		} catch (SQLException ex)
		{
		}

	}

	private static Connection connect()
	{
		//SQLite connection string 
		String url = "jdbc:sqlite:C:\\sqlite2\\database\\" + fileName;
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url);
		} catch (SQLException ex)
		{
		}
		return conn;
	}

	static void showData()
	{

		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite2\\database\\" + fileName);
			conn.setAutoCommit(false);

			stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery("SELECT username,password FROM dati ;");

			while (res.next())
			{
				System.out.println(
						res.getString("username")
						+ ", " + res.getString("password"));

			}
			res.close();
		} catch (ClassNotFoundException ex)
		{
			Logger.getLogger(SQLiteJDBC.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex)
		{
			Logger.getLogger(SQLiteJDBC.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
