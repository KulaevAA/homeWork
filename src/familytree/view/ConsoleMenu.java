package familytree.view;

import familytree.presenter.IFamilyTreePresenter;

import java.util.Scanner;

public class ConsoleMenu {
    private IFamilyTreePresenter presenter;
    private Scanner scanner;
    private boolean work;

    public ConsoleMenu(IFamilyTreePresenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
        work = true;
    }

    public void displayMenu() {
        while (work) {
            System.out.println("Select action:");
            System.out.println("1. Print a tree");
            System.out.println("2. Save the tree to a file");
            System.out.println("3. load a tree from a file");
            System.out.println("4. Sort by age");
            System.out.println("5. Sort by name");
            System.out.println("6. Add human");
            System.out.println("7. Exit");            

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    presenter.displayFamilyTree(); 
                    break;
                case "2":
                    presenter.saveFamilyTree();                    
                    break;
                case "3":
                    presenter.loadFamilyTree();                    
                    break;
                case "4":
                    presenter.sortByAge();
                    break;
                case "5":
                    presenter.sortByName();
                    break;
                case "6":
                    addHuman();
                    break;
                case "7":                   
                    finish();
                    break;
                default:
                    System.out.println("Incorrect selection. Please try again.");
            }           
        }
    }

    private void finish() {
        work = false;
        scanner.close();
        System.out.println("Exit");
    }

    private void addHuman() {
        System.out.print("Enter name ");
        String name = scanner.nextLine();

        System.out.print("Enter gender (Male/Female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter birthdate (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
       
        System.out.print("Enter deathdate (YYYY-MM-DD) or leave blank:");
        String deathDate = scanner.nextLine();
        
        presenter.addHumanToTree(name, gender, birthDate, deathDate);
    }

}