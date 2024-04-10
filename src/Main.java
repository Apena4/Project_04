import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int task = prompt(input);
        while(true){
            switch (task){
                case 1:
                    Collections.sort(taskList);
                    newTask(input);
                    task = prompt(input);
                    break;
                case 2:
                    deleteTask(input);
                    task = prompt(input);
                    break;
                case 3:
                    Collections.sort(taskList);
                    changeTask(input);
                    task = prompt(input);
                    break;
                case 4:
                    list();
                    task = prompt(input);
                    break;
                case 5:
                    makePriority();
                    task = prompt(input);
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("enter another value");
                    prompt(input);
                    break;


            }



        }

    }
    public static int prompt(Scanner input){
        System.out.println("Please Select a Task. \n1.) Add a task \n2.) Remove a task \n3.) Update a task \n4.)List all tasks \n0.) Exit \nWhich task would you like to assign?");
        int task = input.nextInt();
        input.nextLine();
        return task;
    }
    //Here the newTask method asks what task they want to add then waits for the users feedback while also keeping it in a string
    public static Task newTask(Scanner input){
        while(true) {
            try {
                System.out.println("What is the name of the task");
                String name = input.nextLine();
                System.out.println("Give the task a description");
                String description = input.nextLine();
                System.out.println("What is the priority of the task 0-5");
                int priority = input.nextInt();
                input.nextLine();
                Task newTask = new Task(name, description, priority);
                taskList.add(newTask);
                return newTask;
            } catch (NumberFormatException e) {
                System.out.println("Error");
            }
        }
    }

    //prints the statement of which task the user wants to get removed then waits for the users input and then removes said task
    public static void deleteTask(Scanner input){
        System.out.println("What do you wish to remove?");
        int taskRemove = input.nextInt()-1;
        input.nextLine();
        taskList.remove(taskRemove);
        taskList.forEach(System.out::println);
        System.out.println(taskList);

    }

    public static ArrayList<Task> taskList = new ArrayList<>();

    //Here it lists the tasks that are listed and then you can decide which one to change based of the index value shown next to each task
    public static void changeTask(Scanner input){
        System.out.println(taskList);
        System.out.println("Which task do you want to update");
        int newList = input.nextInt()-1;
        Task newTask = taskList.get(newList);
        System.out.println("Add an appropriate description... ");
        String description = input.nextLine();
        newTask.setDescription(description);
        taskList.set(newList, newTask);




    }
    //ArrayList allows any value to get in so the list of task can be listed while also showing the index
    public static ArrayList<Task> list() {
        try {

            Scanner input = new Scanner(System.in);
            System.out.println("1: Print entire list");
            System.out.println("2: Print list by priority");
            System.out.println("Which would you like?");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    for (int i = 0; i < taskList.size(); i++) {
                        System.out.println("Index value: " + i + " | " + "Task Name: " + taskList.get(i).getName() +
                                " Description: " + taskList.get(i).getDescription() +
                                " Priority: " + taskList.get(i).getPriority() + "\n");
                    }
                    break;

                case 2:
                    System.out.println("Which priority would you like to view 0-5");
                    int wantedPriority = input.nextInt();
                    input.nextLine();
                    boolean isPriorInList = false;
                    for(Task task: taskList) {
                        if (task.getPriority() == wantedPriority) {
                            int i = taskList.indexOf(task);
                            System.out.println("Index value: " + i + " | " + "Task Name: " + taskList.get(i).getName() +
                                    " Description: " + taskList.get(i).getDescription() +
                                    " Priority: " + taskList.get(i).getPriority() + "\n");
                            isPriorInList = true;
                        }



                    }
                    break;


            }
        } catch (Exception e) {
            System.out.println("Error!");
        }

        return taskList;
    }
    public static void makePriority(){
        System.out.println(taskList);
        System.out.println("what task priority would you like to change... 0-"+taskList.size());
        int taskSelected = input.nextInt();
        input.nextLine();
        Task makePriority = taskList.get(taskSelected);
        System.out.println("set the priority between 0-5");
        int newPriority = input.nextInt();
        input.nextLine();
        makePriority.setPriority(newPriority);
    }}