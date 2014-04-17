import java.io.File;
import java.util.Scanner;

/**
 * A simple class to read files
 * @author Abhijit
 *
 */
public class readTxt {
	File filename;
	/**
	 * This constructor initiates an object of this class with a filename
	 * @param f is the filename (with location)  such as C:\\hello.txt
	 */
	readTxt(String f){
		filename=new File(f);
	}
	/**
	 * This method reads the file and returns a string of it's contents
	 * @return String type with the contents of the file
	 */
	public String read(){
		String text=null;
		try{
		 text = new Scanner( filename ).useDelimiter("\\A").next();
		}
		catch (Exception FileNotFoundException){
			System.out.println("File Not Found");
		}
		return text;
	}
}
