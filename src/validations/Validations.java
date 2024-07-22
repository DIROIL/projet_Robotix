package validations;

import repository.AccountRepository;

public class Validations {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static String validatecreateAccount(String profil, String name, String surname, String pseudo, String email, String password, String phone) {
        String error = null;
        try {
            // Validation des champs obligatoires
            if (profil.isEmpty() || name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
                error = "Tous les champs sont obligatoires.";
                return error;
            }

            // Validation du format des données
            if (!isValidEmail(email)) {
                error = "L'email n'est pas au bon format.";
                return error;
            }

            // Traitement des valeurs nulles ou invalides
            if (phone.isEmpty()) {
                phone = "N/A"; // Définir une valeur par défaut
            }

        } catch (IllegalArgumentException e) {
            error = e.getMessage();
            return error;
        }
        return null; // Pas d'erreur, le compte a été créé avec succès
    }

    private static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }
}
