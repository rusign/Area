package com.beans;
 
public class PasswordModelBean extends RegistrationModelBean {
    public MessageHolder validPassword(String password) {
        return validProperty(password, "Erreur: Le mot de passe est trop petit",
                            "OK");
    }
}
