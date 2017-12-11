import java.util.*;
import java.io.*;

public class JReviewDriver {
	
public static void main(String[] args) {

String filepath = "questions.txt";
String filepath2 = "answers.txt";

try{
Testing test = new Testing(filepath,filepath2);

Scanner keyboard = new Scanner(System.in); 
String input;
@SuppressWarnings("unused")
int i = 0;

//introduction
System.out.println("Welcome to the Computer Science Review Program.\n");

	for (int x = 0; x < 1; i++){
	
	//main menu
	System.out.println("What would you like to do?\n"
	 + "1) Diagnostic Test (Comprehensive) \n"
	 + "2) Exit\n" );
		
	input = keyboard.nextLine();
	
	//switch
	switch(input){
		case "1":
		//load the questions and answers
		test.loadQuestionsAndAnswers(6);
		do
		{
		//display the question
		test.displayQuestion();

		//ask for user input 
		input = keyboard.nextLine();
		
		//check for the correct answer
		test.checkAnswer(input);		
		
		//go to the next question and check for end of test
		test.nextQuestion();
		}while(!(test.checkForEnd()));
				break;
		case "2":
		System.out.println("Thanks for using the Computer Science Review Program! [click enter to close out the program.]");
		keyboard.nextLine();
		keyboard.close();
		System.exit(0);		
				break;
		}
	}
}
catch (FileNotFoundException e)
{
	System.out.println("File(s) not found.");
	
	//place a while loop here for validation
}
}
}
