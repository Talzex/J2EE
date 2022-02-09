package bean;

import bean.validation.Login;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Person {

    @NotNull
    @Email(message = "email incorrect format")
    private String email;
    // firstName est un chaine de taille quelconque de lettres.
    @NotNull
    @Pattern(regexp="[a-zA-Z]*", message="firstName syntax error")
    private String firstName;
    // lastName est un chaine de  2 à 12 lettres.
    @NotNull
    @Pattern(regexp="[a-zA-Z]{2,12}",  message="lastName syntax error")
    private String lastName;
    @Login
    @NotNull
    private String login;
    private boolean isStudent;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
