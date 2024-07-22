package repository;

import model.Account;
import model.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static service.Navigation.getNumber;
import static service.Navigation.nextStep;

public class RobotRepository {
    public static List<Robot> ROBOTS = new ArrayList<>();

    public static void createRobot(Account account){
        String response;
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom : ");
        response = scanner.nextLine();
        robot.setName(response);
        System.out.println("Entrez le numéro de série : ");
        response = scanner.nextLine();
        robot.setSerialNumber(response);
        System.out.println("Entrez le type : ");
        robot.setType(response);
        robot.setSupervisor(account.getId());
        robot.setId((long) (RobotRepository.ROBOTS.size() + 1));
        RobotRepository.ROBOTS.add(robot);
        System.out.println("Opération terminée avec succès");
        nextStep();
    }

    public static void showRobotDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro d'identifiant : ");
        int id = getNumber(scanner);
        Robot robot = RobotRepository.ROBOTS.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
        if(robot == null){
            System.out.println("Robot introuvable");
        } else {
            System.out.println("- id : " + robot.getId());
            System.out.println("- Nom : " + robot.getName());
            System.out.println("- Type : " + robot.getType());
            System.out.println("- Batterie : " + robot.getBattery() + " %");
            System.out.println("- Numéro de série : " + robot.getSerialNumber());
            System.out.println("- Vitesse : " + robot.getSpeed() + " m/s");
            System.out.println("- Position[x] : " + robot.getPosition().getX());
            System.out.println("- Position[y] : " + robot.getPosition().getY());
            System.out.println("- Position[z] : " + robot.getPosition().getZ());
            System.out.println("- Utilisation du CPU : " + robot.getProcessorUsage() + " %");
            System.out.println("- Utilisation de la mémoire : " + robot.getMemoryUsage() + " %");
        }
        nextStep();
    }
}
