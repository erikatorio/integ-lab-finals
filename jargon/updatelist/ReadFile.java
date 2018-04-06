
import java.io.*;
import java.util.*;
public class ReadFile {
    public static void main(String[] args)throws Exception {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Input 1 to Add \nInput 2 to Delete \nInput 3 to View \nInput 4 to Exit\n");
        System.out.print("Please Input your Number: ");
        int input;
        input = kbd.nextInt();
        String text = kbd.nextLine();
        String delete = kbd.nextLine();
        ArrayList <String> list = new ArrayList<String>();
       
        switch(input){
        case 1:
     try{
      

        File file = new File("file.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println("update members:");
        System.out.print("Type \"exit\" to Exit\n");
     
        while((text = kbd.nextLine()) != null){
        bw.write(text);
        bw.newLine();
        bw.flush();
        if(text.equals("exit")){
            break;
        }
        }

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

    
        br.close();
        bw.close();

    }catch(IOException e){
    e.printStackTrace();
    }

        break;





        case 2:
        File file = new File("file.txt");
        File tempFile = new File("Temp.txt");
        FileWriter fw = new FileWriter(file, true);
        BufferedReader bw = new BufferedReader(fw);
        BufferedWriter wr = new BufferedWriter(new FileWriter(tempFile));

        
        String currentLine;

        while((currentLine = kbd.readLine()) != null){

            String trimmedLine = currentLine.trim();
              if(trimmedLine.equals(delete)) continue;
             wr.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close(); 
        reader.close(); 
        boolean successful = tempFile.renameTo(inputFile);
        break;
    

        case 3:
         File file = new File("file.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while((st=br.readLine()) != null){
            System.out.println(st);
       
        }
        break;
    

        case 4:

        break;
    }

    }
}