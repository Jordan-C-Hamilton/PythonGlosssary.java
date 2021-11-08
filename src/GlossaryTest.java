//package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GlossaryTest {
    static Scanner myAns = new Scanner(System.in);
    public static void main(String[] args) {
        String file = "/Users/jordanhamilton/Downloads/pythonGlossary.csv";
        String line;
        int iteration = 0;
        BufferedReader br;
        ArrayList<Glossary> pythonInfo = new ArrayList<>();
        System.out.println("Welcome to the Glossary Test program.");
        System.out.println("Please enter your name.");
        String name = myAns.nextLine();
        //commenceTest();

        {
            try {
                br = new BufferedReader(new FileReader(file));

                while ((line = br.readLine()) != null){
                    if (iteration == 0){
                        iteration++;
                        continue;
                    }
                    Glossary info = new Glossary(line);
                    pythonInfo.add(info);

                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(pythonInfo);
        commenceTest(pythonInfo);
    }
    public static boolean questionGiver(ArrayList<Glossary> pythonList){
        Random rand = new Random();
        int randomElem = rand.nextInt(pythonList.size());
        Glossary randomQuestion = pythonList.get(randomElem);
        System.out.println("What is the term for " + randomQuestion.getDefinition() + "?");
        String answer = myAns.nextLine();
        if(answer.equalsIgnoreCase(randomQuestion.getTerm())){
            System.out.println("Correct!");
            return true;
        }else {
            System.out.println("False. The answer is: " + randomQuestion.getTerm());
            return false;
        }
    }
    public static int score(boolean questionScore){
        int number = 0;
        if (questionScore == true){
            number+= 1;
        }
        return number;
    }
    public static String commenceTest(ArrayList<Glossary> pythonInfo){
        int result = 0;
        System.out.println("Would you like to take a test?");
        System.out.println("Please enter (Y)es to take the test.");
        System.out.println("Please enter (N)o to exit program.");
        String reply = myAns.nextLine();
        if(reply.equalsIgnoreCase("y")){
            System.out.println("Commencing test:");
            int numOfQuestions = 0;
            while(numOfQuestions < 4) {
                //questionGiver(pythonInfo);
                result = score(questionGiver(pythonInfo));
                numOfQuestions = numOfQuestions + 1;
                System.out.println("num. of questions: " + numOfQuestions + "\nScore: " + result);
            }
            System.out.println(result);
        }else if(reply.equalsIgnoreCase("n")){
            String neglect = "Return when you feel that you are ready.";
            return neglect;
        }else{
            System.out.println("That is not a valid answer.");
        }
        String thankYou = "Thank you for taking the test.Goodbye!";
        return thankYou;
    }
    public static ArrayList<Glossary> quizGenerator(int Chapter){
        ArrayList<Glossary> chapterQuiz = new ArrayList<>();
        return quizGenerator(Chapter);

    }

}

