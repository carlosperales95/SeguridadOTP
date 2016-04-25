package seguridad.server.DAO;
import java.util.List;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import seguridad.server.data.Member;

import javax.jdo.Query;

public class ServerDAO implements IServerDAO {
		//Add here whatever you need	
		//This piece of code will be executed once when the object instance is created.
		//If you need to do any initialization, do it here.
		
		
		// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// Persistence Manager
		PersistenceManager pm = null;
		//Transaction to group DB operations
		Transaction tx = null;		
				
		
		/**
		 * 
		 * @param username
		 */
		@SuppressWarnings({ "finally", "unchecked" })
		public Member getMember(String username) {
			Member remember = null;
			try{
				System.out.println("INFO: Getting the member from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				System.out.println("begin");
				
				Query q = pm.newQuery(Member.class);
				q.setFilter("username == user_name");
				q.declareParameters("String user_name");
				List<Member> result = (List<Member>)q.execute(username);	
				System.out.println(result.get(0).getUsername());	
				
				if(!result.isEmpty())remember = result.get(0);
					
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("WARN: Exception when retrieving from database");
			}finally{
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				
				if (pm != null && !pm.isClosed()) {
					pm.close();
				}
				System.out.println("getMember() Returning " + remember);
				return remember;
			}
		}

		/**
		 * 
		 * @param username
		 * @param name
		 * @param email
		 */
		@SuppressWarnings({ "finally", "unchecked" })
		public List<Member> getallMembers() {
			List<Member> remember = null;
//			int i = 0;
			try{
				System.out.println("INFO: Getting all the members from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				
				
				Query q = pm.newQuery(Member.class);
			//	q.setFilter("username == user_name");
				q.declareParameters("String user_name");
				remember = (List<Member>)q.execute("");	
				
				
			/**for(Member m: extent){
					remember[i] = m;
					i++;
					}**/	
					
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("WARN: Exception when retrieving from database");
			}finally{
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				
				if (pm != null && !pm.isClosed()) {
					pm.close();
				}

				return remember;
			}
			
		}
		public void registerMember(Member member){
			
			try {
				System.out.println("- Store objects in the DB");

				//Get the Persistence Manager
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				
				pm.makePersistent(member);
				

				//End the transaction
				tx.commit();	
			} catch (Exception ex) {
				System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
				ex.printStackTrace();
			} finally {

				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				
				if (pm != null && !pm.isClosed()) {
					pm.close();
				}
			}
		}

	
}
