import java.util.Scanner;


public class Compiler {

	public static void main(String args[]){
		TinyParser myParser = new TinyParser();
		ParserLL1 myParserLL1 = new ParserLL1();
		System.out.println("Please type (1) for recursive descent parser");
		System.out.println("or          (2) for Top down LL1 parser");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		if(choice == 1){
			boolean result = false;
			myParser.myScanner = new TinyScanner("test.txt");
			myParser.token = myParser.myScanner.getToken();
			while(myParser.token.getType() != myParser.EOFtok){
				result = myParser.program();
			}
			if(result == true){
				System.out.println("** Parsing complete **");
			}
			else{
				System.out.println("** Parsing error **");
			}
		}
		else if(choice == 2){
			myParserLL1.myScanner = new TinyScanner("test.txt");
			if(myParserLL1.parse()){
				System.out.println("***Parsing done***");
			}
			else{
				System.out.println("** Parsing error **");
			}
		}
		else{
			System.out.println("Please type 1 or 2 only");
		}
	}
}
