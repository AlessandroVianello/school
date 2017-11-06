package chattcp;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseSQL
{
	String nameFile;

	public void newDatabase(String nameFile)
	{
		this.nameFile = nameFile;
		File file = new File("C:\\Users\\alessandro.vianello.LAP\\Desktop\\Personal\\TPSIT\\chatTCP");//cambiare per ogni computer
		if (!file.exists())
		{
			if (file.mkdirs())
			{
				System.out.println("Multiple directories are created!");
			} else
			{
				System.out.println("Failed to create multiple directories!");
			}
		}

		String url = "jdbc:sqlite:C:\\Users\\alessandro.vianello.LAP\\Desktop\\Personal\\TPSIT\\chatTCP\\" + this.nameFile;//cambiare per ogni computer

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

	public void createTable(String nameFile)
	{
		this.nameFile = nameFile;
		Connection conn = null;
		Statement stmt = null;

		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\alessandro.vianello.LAP\\Desktop\\Personal\\TPSIT\\chatTCP\\" + this.nameFile);//cambiare per ogni computer
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
			Logger.getLogger(DatabaseSQL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex)
		{
			Logger.getLogger(DatabaseSQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Table created successufully");
	}

	public void addNewUser(String username, String password,String nameFile)
	{
		String credentials = "INSERT INTO dati VALUES(?,?,?);";
		this.nameFile=nameFile;

		try (Connection conn = DatabaseSQL.connect(this.nameFile);
				PreparedStatement pstmt = conn.prepareStatement(credentials))
		{
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
		} catch (SQLException ex)
		{
		}

	}

	private static  Connection connect(String nameFile)
	{
		//SQLite connection string 
		String url = "jdbc:sqlite:C:\\Users\\alessandro.vianello.LAP\\Desktop\\Personal\\TPSIT\\chatTCP\\" + nameFile;
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url);
		} catch (SQLException ex)
		{
		}
		return conn;
	}
}
