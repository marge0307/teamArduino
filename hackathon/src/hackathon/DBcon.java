package hackathon;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

import javax.swing.JOptionPane;

public class DBcon {
    private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBcon(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackathon","root","");
                        st = con.createStatement();
                        
                }catch(Exception ex){
			System.out.print("Error: "+ex);
		}
	}
        
        public void getData(){
            try{
                
                String query = "select * from test";
                rs = st.executeQuery(query);
                System.out.println("Records from Database");
                
                while(rs.next()){
                    String id = rs.getString("id");
                    String any = rs.getString("anything");
                    System.out.println("ID: "+id+" - "+"String: "+any);
                }
                        
            }catch(Exception ex){
                System.out.println(ex);
            }
              
        }
        
        public void insertData(int tran, int amount, String accnum){
             try{
                
                String query = " insert into transactions (transaction, amount, accnum)"
                                + " values (?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt (1, tran);
                preparedStatement.setInt (2, amount);
                preparedStatement.setString (3, accnum);
                
                preparedStatement.execute();
                
                System.out.println("Data inserted!");
                        
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        public String selectforacc(String name){
        	try{
        		String cp = "";
           	 	String query = "select * from test where name = \""+name+"\"";
                rs = st.executeQuery(query);
                
                while(rs.next()){
                    cp = rs.getString("cp");
                }
                return cp;
                
        	}catch(Exception x){
        		System.out.print(x);
        		return "";
        	}
        	
        }
        
        public void updateData(String name, int amount){
             try{
            	 int oldamount = 0;
            	 String cp = "";
            	 String query = "select * from test where name = \""+name+"\"";
                 rs = st.executeQuery(query);
                 System.out.println("Records from Database");
                 
                 while(rs.next()){
                     oldamount = rs.getInt("amount");
                     cp = rs.getString("cp");
                 }
                amount = oldamount + amount;
                String msg = "Hey "+name+"! The current amount in your bank is: "+amount;
                sendPost(cp, msg);
                 
                String sql = "UPDATE test SET amount=? WHERE name=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, amount);
                statement.setString(2, name);
                
                int rowsUpdated = statement.executeUpdate();
                
                if (rowsUpdated > 0) {
                        System.out.println("An existing user was updated successfully!");
                }
                else{
                    System.out.println("No id found");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        public static int randomWithRange(int min, int max)
            {
                int range = (max - min) + 1;
                return (int)(Math.random() * range) + min;
            }
        
        public void delete(int id){
        	try{
        	String query = "delete from test where id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            	
        	}catch(Exception ex){
        		System.out.println(ex);
        	}
        }
        public boolean selectName(String name){
        	try{
        		 int size = 0;
        		 String query = "select * from test where name = \""+name+"\"";
                 rs = st.executeQuery(query);
                 
                 while(rs.next()){
                    size++;
                 }
	            if (size > 0) {
	            	return true;
	            }
	            else{
	            	return false;
	            }	
        	}catch(Exception ex){
        		System.out.println(ex);
        		return false;
        	}
        }
        public static void sendPost(String add, String msg) throws Exception {

			String url = "http://203.87.236.231:8080/1/smsmessaging/outbound/42257793/requests";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add request header
			con.setRequestMethod("POST");
			String urlParameters = "{\"address\":\""+add+"\",\"message\":\""+msg+"\"}";
			
					
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());

		}

//        public int withdraw(int anyupdate, int subtract){
//            try{
//               
//               anyupdate = anyupdate - subtract;
//               
//               String sql = "UPDATE test SET anything=? WHERE id=?";
//               PreparedStatement statement = con.prepareStatement(sql);
////               statement.setString(1, anyupdate);
////               statement.setInt(2, id);
//               
//               int rowsUpdated = statement.executeUpdate();
//               
//               if (rowsUpdated > 0) {
//                       System.out.println("An existing user was updated successfully!");
//               }
//               else{
//                   System.out.println("No id found");
//               }
//           }catch(Exception ex){
//               System.out.println(ex);
//           }
//       }
}
