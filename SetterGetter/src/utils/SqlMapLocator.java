package utils;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapLocator {
	
	public static SqlMapClient getMapper(){
		
		SqlMapClient sqlMapper;
		try {
			Reader reader = 
					Resources.getResourceAsReader("SqlMapConfig.xml");
			
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (Exception e) {
			throw new RuntimeException("¿¡·¯" + e);
		}
		return sqlMapper;
		
		
	}
}
