package wrapper;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class QuasiCrawlerApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		SQLtest sql = new SQLtest();
		Date keyDate;
			
		keyDate = new Date((System.currentTimeMillis())-(1000L*60*30*24*30));
		System.out.println(keyDate);
			sql.updateURLs(keyDate);
			
			
		}
		
	}

