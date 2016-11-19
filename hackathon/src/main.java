
import java.util.Scanner;
public class main {
    private static Scanner input;

	
    public static void main(String[] args) {
       input = new Scanner(System.in);
       
       DBcon connect = new DBcon();
       //connect.getData();
       
       int in;
       String anything;
       
       System.out.println("Insert = 1"+"\nUpdate = 2"+"\nGenerate Random # = 3"+"\nDelete ID = 4");
       System.out.print("Input choice [1-5]: ");
       in = input.nextInt();
       
       if(in == 1){

           System.out.print("Enter string: ");
           anything = input.next();
           
           connect.insertData(anything);
       }
       else if(in == 2){
           int id;
           System.out.print("Enter id: ");
           id = input.nextInt();
           
           System.out.print("Enter stringUpdate: ");
           anything = input.next();
           
           connect.updateData(anything, id);           
       }
       else if(in == 3){
           System.out.println(connect.randomWithRange(1000000, 9999999));
       }
       else if(in == 4){
    	   int id;
    	   System.out.print("Enter id: ");
    	   id = input.nextInt();
    	   
    	   connect.delete(id);  
    	   System.out.print("Succesfully Deleted!");
       }
       else if(in == 5){
    	   
       }
    }
    
    
}
   
