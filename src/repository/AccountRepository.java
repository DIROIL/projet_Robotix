package repository;

import enumeration.Profil;
import lib.Db;
import model.Account;
import model.Notification;
import model.Robot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static service.Navigation.*;

public class AccountRepository {
    public static Account ACCOUNT_CONNECTED;

    public static List<Account> ACCOUNTS = new ArrayList<>(
        Arrays.asList(
            new Account(1L, Profil.USER, "DOE", "John", "alpha", "doe@gmail.com", "Alph@012", "695-463-868", "GOOGLE"),
            new Account(2L, Profil.USER,"REDINGTON", "Raymond", "beta", "raymond@yahoo.fr", "bEt@123", "654-762-824", "IBM"),
            new Account(3L, Profil.USER,"JET", "Li", "gamma", "jet@toyota.com", "288#N21", "655-218-746", "TOYOTA"),
            new Account(4L, Profil.USER,"JACKY", "Chan", "omega", "jacky@gmail.com", "0meG@2024", "677-078-633", "MERCEDES"),
            new Account(5L, Profil.USER,"SYLVESTER", "Stallone", "epsilon", "stallone@apple.com", "epsilon!2345", "677-432-413", "APPLE"),
            new Account(6L, Profil.USER,"ARNOLD", "Schwarzenegger", "sigma", "arnold@amazon.com", "freud!$", "657-035-157", "AMAZON"),
            new Account(7L, Profil.USER,"MICHEAL", "Jordan", "delta", "michael.jordan@suzuki.com", "jackson&123", "699-282-125", "SUZUKI"),
            new Account(8L, Profil.USER,"JACK", "Sparrow", "zeta", "jack.sparrow@airbus.com", "Zorro$123", "690-242-432", "AIRBUS"),
            new Account(9L, Profil.USER,"BRAD", "Pitt", "theta", "brad.pitt@boeing.com", "Titanic$1930", "691-747-119", "BOEING"),
            new Account(10L, Profil.USER,"HARVEY", "Specter", "lambda", "harvey.specter@microsoft.com", "Survivor$234", "695-427-691", "MICROSOFT"),

            new Account(11L, Profil.PROVIDER,"JACQUES Chirac", "chirac@gmail.com", "288#N21", "655-218-746", "France", "PEUGEOT", 1500),
            new Account(12L, Profil.PROVIDER,"DONNIE Yen", "donnie@yahoo.fr", "freud!$", "677-078-633", "Japan", "TOYOTA", 2000),
            new Account(13L, Profil.PROVIDER,"TONY Cross", "tony@yahoo.com", "Zorro$123", "695-463-868", "Germany", "MERCEDES", 2500),
            new Account(14L, Profil.PROVIDER,"ZINEDINE Zidane", "zidane@gmail.com", "Titanic$1930", "654-762-824", "Korea", "SUZUKI", 3000),
            new Account(15L, Profil.PROVIDER,"KEVIN Owen", "kevin@gmail.com", "Survivor$234", "677-432-413", "USA", "BOEING", 3500)
        )
    );


    public static void insert(String tableName, String[] columns, Object[] values) {
        Db db = new Db();
        Connection connection = db.connect();
        try {
            StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
            for (int i = 0; i < columns.length; i++) {
                sql.append(columns[i]);
                if (i < columns.length - 1) {
                    sql.append(", ");
                }
            }
            sql.append(") VALUES (");
            for (int i = 0; i < values.length; i++) {
                sql.append("?");
                if (i < values.length - 1) {
                    sql.append(", ");
                }
            }
            sql.append(")");

            PreparedStatement stmt = connection.prepareStatement(sql.toString());
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }
            stmt.executeUpdate();
            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to insert data.");
            e.printStackTrace();
        }
    }

//    public static void createAccount() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter name: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Enter surname: ");
//        String surname = scanner.nextLine();
//
//        System.out.print("Enter username: ");
//        String username = scanner.nextLine();
//
//        System.out.print("Enter email: ");
//        String email = scanner.nextLine();
//
//        System.out.print("Enter password: ");
//        String password = scanner.nextLine();
//
//        System.out.print("Enter phone number: ");
//        String phoneNumber = scanner.nextLine();
//
//        System.out.print("Enter company name: ");
//        String companyName = scanner.nextLine();
//
//        try {
//            // Establish a connection to the database
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");
//
//            // Prepare the SQL insert statement
//            String sql = "INSERT INTO accounts (profil, name, surname, username, email, password, phone_number, company_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//
//            // Set the values for the prepared statement
//            statement.setString(1, Profil.USER.toString());
//            statement.setString(2, name);
//            statement.setString(3, surname);
//            statement.setString(4, username);
//            statement.setString(5, email);
//            statement.setString(6, password);
//            statement.setString(7, phoneNumber);
//            statement.setString(8, companyName);
//
//            // Execute the insert statement
//            statement.executeUpdate();
//
//            // Add the new account to the ACCOUNTS list
//            Account newAccount = new Account(
//                    (long) ACCOUNTS.size() + 1,
//                    Profil.USER,
//                    surname,
//                    name,
//                    username,
//                    email,
//                    password,
//                    phoneNumber,
//                    companyName
//            );
//            ACCOUNTS.add(newAccount);
//
//            System.out.println("Account created successfully!");
//        } catch (SQLException e) {
//            System.out.println("Error creating account: " + e.getMessage());
//        }
//    }


    public static void showAllUser(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des utilisateurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Account account : AccountRepository.ACCOUNTS.stream().filter(account -> Profil.USER.equals(account.getProfil())).collect(Collectors.toList())){
            System.out.println(String.format("%3d", ++n) + ") " + account.getName() + " " + account.getSurname() + " [id = " + account.getId() + "]");
        }
        nextStep();
    }

    public static void findUser(){
        System.out.print("Entrez le pseudo ou le nom d'un suiveur : ");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine().toLowerCase();
        List<Account> accounts = AccountRepository.ACCOUNTS.stream().filter(account -> {
            boolean match = Profil.USER.equals(account.getProfil());
            match = match && (account.getPseudo().toLowerCase().contains(keyword) || account.getFollowers().stream().anyMatch(follower -> follower.getFullName().toLowerCase().contains(keyword)));
            return match;
        }).collect(Collectors.toList());
        if(accounts.isEmpty()){
            System.out.println("Aucun résultat");
        } else {
            System.out.println("+------------------------+");
            System.out.println("|   Liste des résultats  |");
            System.out.println("+------------------------+");
            int n = 0;
            for (Account account : accounts){
                System.out.println(String.format("%2d", ++n) + ") " + account.getFullName() + " [id = " + account.getId() + "]");
            }
        }
        nextStep();
    }

    public static void showAllProvider(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des fournisseurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Account account : AccountRepository.ACCOUNTS.stream().filter(account -> Profil.PROVIDER.equals(account.getProfil())).collect(Collectors.toList())){
            System.out.println(String.format("%3d", ++n) + ") " + account.getName() + " [id = " + account.getId() + "]");
        }
        nextStep();
    }

    public static void showAccountDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro d'identifiant : ");
        int id = getNumber(scanner);
        Account account = AccountRepository.ACCOUNTS.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if(account == null){
            System.out.println("Compte introuvable");
        } else {
            System.out.println("- id : " + account.getId());
            System.out.println("- Nom : " + account.getName());
            if(account.getProfil().equals(Profil.USER)){
                System.out.println("- Prénom : " + account.getSurname());
                System.out.println("- Pseudo : " + account.getSurname());
            } else {
                System.out.println("- Adresse : " + account.getAddress());
            }
            System.out.println("- Email : " + account.getEmail());
            System.out.println("- Téléphone : " + account.getPhone());
        }
        nextStep();
    }

    public static void login() {
        String email, password;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre adresse e-mail : ");
        email = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        password = scanner.nextLine();
        ACCOUNT_CONNECTED = AccountRepository.ACCOUNTS.stream().filter(account -> account.getEmail().equals(email) && account.getPassword().equals(password)).findFirst().orElse(null);
        if(ACCOUNT_CONNECTED == null){
            System.out.println("Adresse e-mail ou mot de passe incorrect");
            nextStep();
        } else {
            System.out.println("Bienvenu sur Robotix, " + ACCOUNT_CONNECTED.getFullName());
            showMainMenu();
        }
    }

    public static void updateProfil(){
        String response;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre nom : ");
        response = scanner.nextLine();
        if(ACCOUNT_CONNECTED.getProfil().equals(Profil.USER)){
            ACCOUNT_CONNECTED.setName(response);
            System.out.println("Entrez votre prénom : ");
            response = scanner.nextLine();
            ACCOUNT_CONNECTED.setSurname(response);
            System.out.println("Entrez votre pseudo : ");
            response = scanner.nextLine();
            ACCOUNT_CONNECTED.setPseudo(response);
        } else {
            System.out.println("Entrez votre adresse : ");
            response = scanner.nextLine();
            ACCOUNT_CONNECTED.setAddress(response);
        }
        ACCOUNT_CONNECTED.setPassword(response);
        System.out.println("Entrez votre adresse e-mail : ");
        response = scanner.nextLine();
        ACCOUNT_CONNECTED.setEmail(response);
        System.out.println("Entrez votre numéro de téléphone : ");
        response = scanner.nextLine();
        ACCOUNT_CONNECTED.setPhone(response);
        System.out.println("Entrez le nom de votre entreprise (optionnel) : ");
        response = scanner.nextLine();
        if(!response.isBlank()) ACCOUNT_CONNECTED.setCompany(response);
        System.out.println("Opération terminée avec succès");
        nextStep();
    }

    public static void findProvider(){
        System.out.print("Entrez le nom, une adresse ou le type de composante : ");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine().toLowerCase();
        List<Account> accounts = AccountRepository.ACCOUNTS.stream().filter(account -> {
            boolean match = Profil.PROVIDER.equals(account.getProfil());
            match = match && (account.getName().toLowerCase().contains(keyword) || account.getAddress().toLowerCase().contains(keyword) || account.getComponents().stream().anyMatch(component -> component.getType().toLowerCase().contains(keyword)));
            return match;
        }).collect(Collectors.toList());
        if(accounts.isEmpty()){
            System.out.println("Aucun résultat");
        } else {
            System.out.println("+------------------------+");
            System.out.println("|   Liste des résultats  |");
            System.out.println("+------------------------+");
            int n = 0;
            for (Account account : accounts){
                System.out.println(String.format("%2d", ++n) + ") " + account.getName() + " " + account.getSurname() + " [id = " + account.getId() + "]");
            }
        }
        nextStep();
    }

    public static void showAllMyFollowers(Account account){
        System.out.println("+---------------------------+");
        System.out.println("|   Liste de mes suiveurs   |");
        System.out.println("+---------------------------+");
        int n = 0;
        for (Account follower : account.getFollowers()){
            System.out.println(String.format("%3d", ++n) + ") " + follower.getFullName() + " [id = " + account.getId() + "]");
        }
        nextStep();
    }

    public static void showAllMyRobots(Account account){
        System.out.println("+---------------------------+");
        System.out.println("|    Liste de mes robots    |");
        System.out.println("+---------------------------+");
        int n = 0;
        for (Robot robot : account.getRobots()){
            System.out.println(String.format("%3d", ++n) + ") " + robot.getName() + " [id = " + robot.getId() + "]");
        }
        nextStep();
    }

    public static void showAllMyNotifications(Account account) {
        System.out.println("+--------------------------------+");
        System.out.println("|   Liste de mes notifications   |");
        System.out.println("+--------------------------------+");
        int n = 0;
        for (Notification notification : account.getNotifications()){
            System.out.println(String.format("%3d", ++n) + ") " + notification.getMessage() + " [Date = " + new SimpleDateFormat("dd-MM-yyyy").format(notification.getDate()) + "]");
        }
        nextStep();
    }

    public static void follow() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro d'identifiant de l'utilisateur : ");
        int id = getNumber(scanner);
        Account account = AccountRepository.ACCOUNTS.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if(account == null){
            System.out.println("Compte introuvable");
        } else {
            Notification notification = new Notification("L'utilisateur " + ACCOUNT_CONNECTED.getFullName() + " vous suit désormais.");
            notification.setAccount(account.getId());
            NotificationRepository.NOTIFICATIONS.add(notification);
            account.getFollowerIds().add(ACCOUNT_CONNECTED.getId());
            System.out.println("Opération terminée avec succès");
        }
        nextStep();
    }
}
