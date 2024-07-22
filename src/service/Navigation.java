package service;

import enumeration.Profil;
import repository.*;

import java.util.Scanner;

import static repository.AccountRepository.ACCOUNT_CONNECTED;

public class Navigation {
    public static void showMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------- MENU PRINCIPAL ---------");
        System.out.println("1- Liste des utilisateurs");
        System.out.println("2- Rechercher un utilisateur");
        System.out.println("3- Voir le profil d'un utilisateur");
        System.out.println("4- Liste des activités");
        System.out.println("5- Liste des fournisseurs");
        System.out.println("6- Rechercher un fournisseur");
        System.out.println("7- Rechercher une composante");
        System.out.println("8- Se connecter");
        if(ACCOUNT_CONNECTED != null){
            System.out.println("9- Modifier mon profil");
            if(Profil.USER.equals(ACCOUNT_CONNECTED.getProfil())){
                System.out.println("10- Liste de mes robots");
                System.out.println("11- Liste de mes suiveurs");
                System.out.println("12- Liste de mes activités");
                System.out.println("13- Liste de mes intérêts");
                System.out.println("14- Suivre un utilisateur");
                System.out.println("15- S'inscrire à une activité");
                System.out.println("16- Voir l'état d'un robot");
                System.out.println("17- Voir ses notifications");
                System.out.println("18- Enregistrer un robot");
            } else {
                System.out.println("19- Liste de mes composantes");
                System.out.println("20- Enregistrer une composante");
            }
        }

        System.out.print("Entrez le numéro de l'action : ");
        int choice = getNumber(scanner);
        switch (choice){
            case 1:
                AccountRepository.showAllUser();
                break;
            case 2:
                AccountRepository.findUser();
                break;
            case 3:
                AccountRepository.showAccountDetails();
                break;
            case 4:
                ActivityRepository.showAllActivity();
                break;
            case 5:
                AccountRepository.showAllProvider();
                break;
            case 6:
                AccountRepository.findProvider();
                break;
            case 7:
                ComponentRepository.findComponent();
                break;
            case 8:
                AccountRepository.login();
                break;
            case 9:
                AccountRepository.updateProfil();
                break;
            case 10:
                AccountRepository.showAllMyRobots(ACCOUNT_CONNECTED);
                break;
            case 11:
                AccountRepository.showAllMyFollowers(ACCOUNT_CONNECTED);
                break;
            case 12:
                ActivityRepository.showAllMyActivities(ACCOUNT_CONNECTED);
                break;
            case 13:
                InterestRepository.showAllMyInterests(ACCOUNT_CONNECTED);
                break;
            case 14:
                AccountRepository.follow();
                break;
            case 15:
                ActivityRepository.subscribe(ACCOUNT_CONNECTED);
                break;
            case 16:
                RobotRepository.showRobotDetails();
                break;
            case 17:
                AccountRepository.showAllMyNotifications(ACCOUNT_CONNECTED);
                break;
            case 18:
                RobotRepository.createRobot(ACCOUNT_CONNECTED);
                break;
            case 19:
                ComponentRepository.showAllComponent(ACCOUNT_CONNECTED);
                break;
            case 20:
                ComponentRepository.createComponent(ACCOUNT_CONNECTED);
                break;
        }
    }

    public static void nextStep(){
        System.out.print("Voulez-vous continuer [O] Oui | [N] Non ? ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.toUpperCase().contains("O")){
            showMainMenu();
        } else {
            System.exit(0);
        }
    }

    public static int getNumber(Scanner scanner){
        String value = scanner.nextLine();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            System.out.print("Nombre invalide. Veuillez réessayer : ");
            return getNumber(scanner);
        }
    }

}


