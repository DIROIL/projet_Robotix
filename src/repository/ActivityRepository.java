package repository;

import enumeration.Status;
import model.Account;
import model.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static service.Navigation.getNumber;
import static service.Navigation.nextStep;

public class ActivityRepository {
    public static List<Activity> ACTIVITIES = new ArrayList<>(
        Arrays.asList(
            new Activity(1L, "Diffuser des sons", Status.PENDING, new ArrayList<>()),
            new Activity(2L, "Parler", Status.PENDING, new ArrayList<>()),
            new Activity(3L, "Écouter", Status.PENDING, new ArrayList<>()),
            new Activity(4L, "Afficher du texte", Status.STARTED, new ArrayList<>()),
            new Activity(5L, "Afficher des graphiques", Status.FINISHED, new ArrayList<>())
        )
    );

    public static void showAllActivity(){
        System.out.println("+---------------------+");
        System.out.println("| Liste des activités |");
        System.out.println("+---------------------+");
        int n = 0;
        for (Activity activity : ActivityRepository.ACTIVITIES){
            System.out.println(String.format("%3d", ++n) + ") " + activity.getName());
        }
        nextStep();
    }

    public static void showAllMyActivities(Account account){
        System.out.println("+----------------------------+");
        System.out.println("|   Liste de mes activités   |");
        System.out.println("+----------------------------+");
        int n = 0;
        for (Activity activity : account.getActivities()){
            System.out.println(String.format("%3d", ++n) + ") " + activity.getName() + " [id = " + activity.getId() + "]");
        }
        nextStep();
    }

    public static void subscribe(Account account){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro d'identifiant de l'activité : ");
        int id = getNumber(scanner);
        Activity activity = ActivityRepository.ACTIVITIES.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if(activity == null){
            System.out.println("Activité introuvable");
        } else {
            activity.getSubscriberIds().add(account.getId());
            System.out.println("Opération terminée avec succès");
        }
        nextStep();
    }
}
