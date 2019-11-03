package info.mywinecellar.model;

import info.mywinecellar.password.ValidPassword;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotNull
    @NotEmpty(message = "Don't you have a name?!?!")
    @Size(max = 30, message = "No name is that long!")
    private String firstName;

    @NotNull
    @NotEmpty(message = "What, no surname?")
    @Size(max = 30, message = "No name is is that long!")
    private String lastName;

    @NotNull
    @NotEmpty(message = "You can't login without a Username")
    @Size(min = 6, max = 30, message = "Let's make that Username 6 characters or more")
    private String userName;

    @ValidPassword
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;

    @Email(message = "This email does not fit our requirements")
    private String email;

    public String getFirstName() {
        return StringUtils.capitalize(firstName);
    }

    public String getLastName() {
        return StringUtils.capitalize(lastName);
    }
}
