package steven;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCreate {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Write something");
		String s=in.nextLine();
		try {
			FileWriter fw=new FileWriter("mytxt.txt");
			fw.write(s);
			fw.close();    
			System.out.println("Success! File \""+"mytxt.txt"+"\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
}
