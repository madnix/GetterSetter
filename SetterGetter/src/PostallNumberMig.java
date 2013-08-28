import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class PostallNumberMig {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		PreparedStatement stmt=null;
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oraclejava","oraclejava");
		
		try {
			conn.setAutoCommit(true);
			stmt =conn.prepareStatement("insert into post(seq, zipcode, sido, gugun, "+
			"dong, ri, st_bunji, ed_bunji) values (?,?,?,?,?,?,?,?) ");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("post.txt"),"EUC-KR"));
			try {
				int tocnt=0;
				int cnt=0;
				String s;
				
				long start = System.nanoTime();
				while((s = reader.readLine())!= null){
					tocnt++;
					int charCnt =0;
					int seq = tocnt;
					
					String zipcode = s.substring(0,7);
					
					charCnt =zipcode.length() + 1;
					String sido = s.substring(charCnt, s.indexOf('|',charCnt));
					
					charCnt += sido.length() + 1;
					String gugun = s.substring(charCnt, s.indexOf('|', charCnt));
					
					charCnt += gugun.length() + 1;
					String dong = s.substring(charCnt, s.indexOf('|', charCnt));
					
					charCnt += dong.length() + 1;
					String ri = s.substring(charCnt, s.indexOf('|', charCnt));
					
					charCnt += ri.length() + 1;
					String st_bunji = s.substring(charCnt, s.indexOf('|', charCnt));
					
					charCnt += st_bunji.length() + 1;
					String ed_bunji = s.substring(charCnt, s.indexOf('|', charCnt));
					
					stmt.setInt(1, seq);
					stmt.setString(2, zipcode.trim());
					stmt.setString(3, sido.trim());
					stmt.setString(4, gugun.trim());
					stmt.setString(5, dong.trim());
					stmt.setString(6, ri.trim());
					stmt.setString(7, st_bunji.trim());
					stmt.setString(8, ed_bunji.trim());
					
					stmt.addBatch();
					cnt++;
					
					if(cnt == 50000){
						cnt=0;
						stmt.executeBatch();
					
						
					}
				}
				if(cnt > 0)
					stmt.executeBatch();
				
				long end = System.nanoTime();
				System.out.println((end - start)+"(ns)");
			}finally{
				reader.close();
			}
			conn.commit();
		}finally{
			if(stmt!=null)
				try {
					stmt.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			conn.close();
		}
		
	}

}
