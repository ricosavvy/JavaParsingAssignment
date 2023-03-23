package com.paradigms.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner input;
    private static List<String> subjects = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<Grade> grades = new ArrayList<>();
    private static boolean running = true;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        while (running) {
            clearScreen();
            mainMenu();
        }
    }

    public static void mainMenu() {

        System.out.println("##### Welcome to the grade book #####");
        System.out.println("What would you want to do? ");
        System.out.println("1) Enter grade");
        System.out.println("2) View grades");
        System.out.println("3) Change grade");
        System.out.println("4) Quit");

        char command = input.nextLine().charAt(0);
        switch(command){
            case '1':
                enterGrade();
                break;
            case '2':
                printGrades();
                break;
            case '3':
                changeGrade();
                break;
            case '4':
                running = false;
                return;
            default:
                System.out.println("Wrong command");
                System.out.println("Press any key to continue");
                input.nextLine();
        }
    }
    public static void enterGrade()
    {


        System.out.println("#### Enter a students computer number ####");
        int compNum = input.nextInt();
        input.nextLine();
        // Fetch student
        Student student = null;
        for(Student s: students)
        {
            if(s.computerNumber == compNum)
            {
                student = s;
                break;
            }
        }

        if(student == null)
        {
            System.out.println("Student not found!!!!");
            student = createStudent(compNum);
            System.out.println("Student Created");
        }
        System.out.println(Arrays.toString(students.toArray()));
        input.nextLine();
        //entering the grades
        ArrayList<Double> quizzes, tests , assignments, projects;
        quizzes = fetchResults("Quizzes");
        tests = fetchResults("Tests");
        assignments = fetchResults("Assignments");
        projects = fetchResults("Projects");
        System.out.println("Enter final exam score");
        double fn = input.nextDouble();
        input.nextLine();
        Grade grade = new Grade(student, "CSC 3301", quizzes, tests, assignments, projects, fn);
        grades.add(grade);
        System.out.println("Done!!");
        // System.out.println(Arrays.toString(grades.toArray()));
        System.out.println(grade);
        input.nextLine();
    }

    public static ArrayList<Double> fetchResults(String prompt)
    {
        System.out.println("Enter the results for "+ prompt);
        String[] rString = input.nextLine().split(" ");
        ArrayList<Double> res = new ArrayList<>();
        for (String s : rString) {
            res.add(Double.parseDouble(s));
        }
        return res;
    }
    public static void printGrades()
    {

    }
    public static void printStudentGrade()
    {

    }
    public static void changeGrade()
    {
        
    }

    public static Student createStudent(int compNum)
    {   
        System.out.println("Enter the students name: ");
        String name = input.nextLine();
        Student s = new Student(name, compNum);
        students.add(s);
        return s;

    }
    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}