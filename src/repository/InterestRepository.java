package repository;

import model.Account;
import model.Activity;
import model.Interest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static service.Navigation.nextStep;

public class InterestRepository {
    public static List<Interest> INTERESTS = new ArrayList<>(
        Arrays.asList(
            new Interest(1L, "Interest 1"),
            new Interest(2L, "Interest 2"),
            new Interest(3L, "Interest 3"),
            new Interest(4L, "Interest 4"),
            new Interest(5L, "Interest 5"),
            new Interest(6L, "Interest 6"),
            new Interest(7L, "Interest 7"),
            new Interest(8L, "Interest 8"),
            new Interest(9L, "Interest 9"),
            new Interest(10L, "Interest 10")
        )
    );

    public static void showAllMyInterests(Account account){
        System.out.println("+-----------------------+");
        System.out.println("| Liste de mes intérêts |");
        System.out.println("+-----------------------+");
        int n = 0;
        for (Activity activity : account.getActivities()){
            for(Interest interest: activity.getInterests()){
                System.out.println(String.format("%3d", ++n) + ") " + interest.getName());
            }
        }
        nextStep();
    }
}
