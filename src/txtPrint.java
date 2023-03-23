  
  
import java.io.File;  
import java.io.PrintWriter;  
public class txtPrint {  
    public static void main(String[] args) throws Exception {  
             //Data to write on Console using PrintWriter  
      PrintWriter writer = new PrintWriter(System.out);    
      writer.write("David program provides insertion sort report.");        
 writer.flush();  
      writer.close();  
//Data to write in File using PrintWriter       
      PrintWriter writer1 =null;      
         writer1 = new PrintWriter(new File("D:\\insertionsort.txt"));  
         String content = "I love my country";  
		writer1.write(content);                                                   
                         writer1.flush();  
         writer1.close();  
    }  
}  
