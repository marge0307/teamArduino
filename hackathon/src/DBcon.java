import java.sql.*;

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
        
        public void insertData(String any){
             try{
                
                String query = " insert into test (anything)"
                                + " values (?)";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, any);
                preparedStmt.execute();
                System.out.println("Data inserted!");
                        
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        public void updateData(String anyupdate, int id){
             try{
                 
                String sql = "UPDATE test SET anything=? WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, anyupdate);
                statement.setInt(2, id);
                
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
        
        int randomWithRange(int min, int max)
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
        public int withdraw(int anyupdate, int subtract){
            try{
               
               anyupdate = anyupdate - subtract;
               
               String sql = "UPDATE test SET anything=? WHERE id=?";
               PreparedStatement statement = con.prepareStatement(sql);
               statement.setString(1, anyupdate);
               statement.setInt(2, id);
               
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
}
