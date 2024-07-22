package repository;

import model.Account;
import model.Component;

import java.util.*;
import java.util.stream.Collectors;

import static service.Navigation.getNumber;
import static service.Navigation.nextStep;

public class ComponentRepository {
    public static List<Component> COMPONENTS = new ArrayList<>(
        Arrays.asList(
           new Component(1L, "GForce", "CPU", "3Ghz", 1500.0, 11L),
           new Component(2L, "MICHELIN", "Roues", "50 cm de diamètre", 100.0, 11L),
           new Component(3L, "Bras", "Bras", "1.5mètre de long", 50.0, 12L),
           new Component(4L, "Hélice", "Hélice", "5 palles", 40.0, 12L),
           new Component(5L, "Caméra", "Caméra", "200 Méga pixels", 60.0, 13L),
           new Component(6L, "JBL", "Haut-parleur", "Bass + Equaliseur", 35.0, 14L),
           new Component(7L, "Philips", "Micro", "Amplification", 10.0, 15L),
           new Component(8L, "OLED", "Écran", "17 pouces", 15.0, 15L)
        )
    );

    public static void findComponent(){
        System.out.print("Entrez le nom, le type ou le nom du fournisseur : ");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine().toLowerCase();
        List<Component> components = ComponentRepository.COMPONENTS.stream().filter(component -> {
            boolean match = component.getName().toLowerCase().contains(keyword);
            match = match || component.getType().toLowerCase().contains(keyword);
            match = match || AccountRepository.ACCOUNTS.stream().filter(account -> Objects.equals(account.getId(), component.getProviderId())).findFirst().map(Account::getFullName).orElse("").toLowerCase().contains(keyword);
            return match;
        }).collect(Collectors.toList());
        if(components.isEmpty()){
            System.out.println("Aucun résultat");
        } else {
            System.out.println("+------------------------+");
            System.out.println("|   Liste des résultats  |");
            System.out.println("+------------------------+");
            int n = 0;
            for (Component component : components){
                System.out.println(String.format("%3d", ++n) + ") " + component.getName());
            }
        }
        nextStep();
    }

    public static void showAllComponent(Account account){
        System.out.println("+--------------------------+");
        System.out.println("| Liste de mes composantes |");
        System.out.println("+--------------------------+");
        int n = 0;
        for (Component component : ComponentRepository.COMPONENTS.stream().filter(component -> Objects.equals(account.getId(), component.getProviderId())).collect(Collectors.toList())){
            System.out.println(String.format("%3d", ++n) + ") " + component.getName());
        }
        nextStep();
    }

    public static void createComponent(Account account){
        String response;
        Component component = new Component();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom : ");
        response = scanner.nextLine();
        component.setName(response);
        System.out.println("Entrez le type : ");
        response = scanner.nextLine();
        component.setType(response);
        System.out.println("Entrez la description : ");
        component.setDescription(response);
        System.out.println("Entrez le prix : ");
        int price = getNumber(scanner);
        component.setPrice(price);
        component.setProviderId(account.getId());
        component.setId((long) (ComponentRepository.COMPONENTS.size() + 1));
        ComponentRepository.COMPONENTS.add(component);
        System.out.println("Opération terminée avec succès");
        nextStep();
    }
}
