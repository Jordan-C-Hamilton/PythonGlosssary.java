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

    public static ArrayList<Glossary> quizGenerator(int ChapterGiven, ArrayList<Glossary> pythonInfo){
        ArrayList<Glossary> chapterQuiz = new ArrayList<>();
        for (int i = 0; i < pythonInfo.size(); i++) {
            Glossary info = pythonInfo.get(i);
            if(ChapterGiven == info.getChapter()){
                chapterQuiz.add(info);
            }
        }
        return chapterQuiz;
    }
    public static void commenceTest(ArrayList<Glossary> pythonInfo){
        int result = 0;
        System.out.println("Would you like to take a test?");
        System.out.println("Please enter (Y)es to take the test.");
        System.out.println("Please enter (N)o to exit program.");
        String reply = myAns.nextLine();
        if(reply.equalsIgnoreCase("y")){
            System.out.println("Commencing test:");
            System.out.println("What chapter would you like to be tested on?");
            int chapter = myAns.nextInt();
            myAns.nextLine();
            ArrayList<Glossary> quizMaterial = quizGenerator(chapter,pythonInfo);
            int numOfQuestions = 0;
            while(numOfQuestions < 4) {
                int number = 0;
                if(questionGiver(quizMaterial)){
                    number += 25;
                    result += number;
                }
                numOfQuestions = numOfQuestions + 1;
                //System.out.println("num. of questions: " + numOfQuestions + "\nScore: " + result);
            }
            System.out.println("num. of questions: " + numOfQuestions + "\nScore: " + result);
        }else if(reply.equalsIgnoreCase("n")){
            System.out.println("Feel free to come back when you are ready.");
        }else{
            System.out.println("That is not a valid answer.");
        }
        System.out.println("Thank you for participating. GoodBye!");
    }

}

