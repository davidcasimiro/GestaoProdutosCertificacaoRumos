package repository;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DButils {
	private static DataSource dataSource;
	private static final String JNDI_LOOKUP_SERVICE = "jdbc/gprodutosDS";
	
	static {
			
		try {

			Context initialContext = new InitialContext();
			Context dbContext = (Context) initialContext.lookup("java:comp/env");			
            dataSource = (DataSource)dbContext.lookup(JNDI_LOOKUP_SERVICE);
            String s="";
			
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		
		
//		try {
///*			Hashtable env = new Hashtable(5);
//			env.put(Context.INITIAL_CONTEXT_FACTORY,
//					"weblogic.jndi.WLInitialContextFactory");
//			env.put(Context.PROVIDER_URL,
//					"t3://weblogicServer:7001");
//*/			
///*			Context ctx = new InitialContext();
//			Object lookup = ctx.lookup(JNDI_LOOKUP_SERVICE);
//			if(lookup != null) {
//				dataSource = (DataSource) lookup;
//			}else {
//				new RuntimeException("DataSource not found!!!");
//			} */
//			Context initContext = new InitialContext();
//			//initContext = (Context) initContext.lookup("java:comp/env");
//			Object lookup = initContext.lookup("gprodutos_db");
//			if(lookup != null) {
//				dataSource = (DataSource) lookup;
//			}else {
//				new RuntimeException("DataSource not found!!!");
//			}
//			
//		}catch(NamingException e) {
//			e.printStackTrace();
//		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	

}
