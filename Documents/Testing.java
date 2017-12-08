import java.io.*;
import java.util.*;

public class Testing
{
	//attributes
	private int index;
	private int correct;
	private int numQuestions;
	private int count;
	private String question;
	private String[] questions;
	private String[] answers;
	private String filepath;
	private String filepath2;
	private boolean end;	
	//constructor
	public Testing(String filepath,String filepath2) throws FileNotFoundException
	{
		index = 0;
		correct = 0;
		count = 0;
		numQuestions = 0;
		end = false;
		//this sets the filepath for the questions
		this.filepath = filepath;
		//this sets the filepath for the answers
		this.filepath2 = filepath2;
	}
	//methods
	public void loadQuestionsAndAnswers(int numQuestions) throws FileNotFoundException
	{
	//open the files
	File file = new File(filepath);
	File file2 = new File(filepath2);
	//read the text files filled with questions and answers
	Scanner inputFile = new Scanner(file);
	Scanner inputFile2 = new Scanner(file2);
	//create an array to store the questions and answers
	questions = new String[numQuestions];
	answers = new String[numQuestions];
	
	int x = 0;
	int nq = numQuestions;
	this.count = numQuestions;
	this.numQuestions = numQuestions;
	//load the questions and answers into their array
		while(nq != 0)
		{
			questions[x] = inputFile.nextLine();
			answers[x++] = inputFile2.nextLine();
			nq--;
		}
	}
	public void displayQuestion()
	{
		System.out.println(questions[index]);
	}
	public void nextQuestion()
	{
		count--;
		//check for the end of the array
		if(count != 0)
		{
		index++;
		}
		else
		{
			index = 0;
			System.out.println("\nThere are no more questions in your set.\n");
			System.out.println("We are now calculating your score.\n");
			double score = (double) (correct / numQuestions) * 100;
			if (score <= 0){ System.out.println("Your score is 0%\n");}
			else {System.out.println("Your score is " + score + "%\n");}
			end = true;			
		}
	}
	public void checkAnswer(String answer)
	{
		if (answer.equalsIgnoreCase(answers[index]))
		{
			correct++;
			System.out.println("\nThat is correct! Great Job!\n");
		}
		else
			System.out.println("\nSorry that was the wrong answer!\n");
	}
	public boolean checkForEnd()
	{
		return end;
	}
}