package wrapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLtest {
	
	private static 	Connection connection;
	private static boolean hasData = false;
	
	
	public ResultSet displayWebSites() throws ClassNotFoundException, SQLException {
		 if (connection == null)  getConnection();
		 
		 Statement state = connection.createStatement();
		 ResultSet result = state.executeQuery("SELECT url, status from website");
		 return result;
	}

	
	private void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:SQLTest.db");
		initialise();
	}


	private void initialise() throws SQLException {
		 if(!hasData) {
			 hasData = true;
			 
			 Statement state = connection.createStatement();
			 ResultSet result = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='website'");
			 
			 if(!result.next()) {
				 System.out.println("Building the tables");
				 
				 Statement state2 = connection.createStatement();
				 state2.execute("CREATE TABLE website(id integer NOT NULL PRIMARY KEY, "+" url varchar(30) NOT NULL, "+" date integer, "+" status integer);");
				 
				 
			 }
		 }
		 
		
		}
	 public void addWebSite(String id, String url, Date date, int status) throws ClassNotFoundException, SQLException {
			if(connection == null) getConnection();
			
			PreparedStatement prepared = connection.prepareStatement("INSERT INTO website(id, url, date, status) values(?,?,?,?);");
			prepared.setString(1, id);
			prepared.setString(2, url);
			prepared.setDate(3,date);
			prepared.setInt(4, status);
		   prepared.execute();
		}
	 
	 public void updateURLs(Date date) throws SQLException, ClassNotFoundException, IOException {
		 if (connection == null)  getConnection();
	
		Statement state = connection.createStatement();
		
		ResultSet rs = state.executeQuery("SELECT id, url, status, date  FROM website");
		//PreparedStatement pst = connection.prepareStatement("update website set date = ?, status = ? WHERE date = ?");
		
		int status; 
		URL url;
		Date _date;
		int id;
		int i = 0;
		
		while(rs.next()) {
			url = new URL(rs.getString("url"));
			_date = rs.getDate("date");
			System.out.println(_date);
			id = rs.getInt("id");
			System.out.println(url);
			HttpURLConnection _URLconnection = (HttpURLConnection)url.openConnection();
			_URLconnection.setRequestMethod("GET");
			_URLconnection.connect();
			status = _URLconnection.getResponseCode();
			System.out.println(status);
			PreparedStatement pst1 = connection.prepareStatement("update website set date = ?, status = ? WHERE date = ?");
			pst1.setDate(1, _date);
			pst1.setInt(2, status);
			pst1.setDate(3, date);
			i++;
			//�� ��, ��� ��� ����� ����� ��������� �������; � ������� ����. ���� ���-�� ��������� ��������� ����� ������ (������� ��������� ������) � ������ �������. ������ ����� ���� �����-�� ������ ����������� ���� � sqlite
			//������, �������� ����� �� 9 ����� ���������: �� ������� ������������ � ������, �� ����� ����������� ��������� �������.	(��������, �������� ���� "���" �� ����� �������).
			
			//��� ���������� �� ���������� ���� ���� �����: ����������� ������ � ������� ��������, � ����� ������, ������� ������������� �� ��������� ���� ������ ���.
			//�� � ����� ��� ������ (�����) �����-�� ����� Alexa, ��������� �� �������� ����� ���������� ������ ������-�� ��� ����.
			//������� � ������������ ������ � �� (������ ���� � ���� "21.yahoo.com") � ������������ url � ��������� (��� ����� ���� ����� ��������� [id �� ����� varchar(30)], ��� ������ UUID
			//������������ ������, ������� � ��� ���� �������� � ������ 
			//�� � ������ �� �������: ���� �������� � ������� �������� �� �����
		}
			
			
		//String query2 = "update website set date = ?, status = ? WHERE date = ?";
		 
	
		//PreparedStatement pst2 = connection.prepareStatement(query2);
		 //pst2.setDate(1, currentDate);
		 // pst2.setArray(2, status);
		 // System.out.println("aaa");
		
		  //pst2.execute();
		 // pst2.close();
		
	 }
	 
	
		 
	}
	


