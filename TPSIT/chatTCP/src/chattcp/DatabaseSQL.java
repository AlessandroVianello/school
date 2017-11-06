package chattcp;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseSQL
{
	public static void newDatabase(String nameFile)
	{
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

		String url = "jdbc:sqlite:C:\\Users\\alessandro.vianello.LAP\\Desktop\\Personal\\TPSIT\\chatTCP\\" + nameFile;//cambiare per ogni computer

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

	public static void createTable(String nameFile)
	{

		Connection conn = null;
		Statement stmt = null;

		try
		{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\alessandro.vianello.LAP\\Desktop\\Personal\\TPSIT\\chatTCP\\" + nameFile);//cambiare per ogni computer
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
}
