
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageResource {

    private static final String WELCOME_MESSAGE = "BEM VINDO A AULA DE MICROSSERVICO USANDO SPRING BOOT !!!";
    private static final String MISSING_CREDENTIALS = "USUARIO E SENHA NAO INFORMADOS";
    private static final String INVALID_CREDENTIALS = "USUARIO E SENHA INVALIDOS";
    private static final String SUCCESS_LOGIN = "LOGIN EFETUADO COM SUCESSO !!!";

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return WELCOME_MESSAGE;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "user", required = false) String user,
            @RequestParam(value = "password", required = false) String password) {
        if (isBlank(user) || isBlank(password)) {
            return MISSING_CREDENTIALS;
        }

        if (user.length() > 15 || password.length() > 15) {
            return INVALID_CREDENTIALS;
        }

        return SUCCESS_LOGIN;
    }

    private boolean isBlank(String value) {
        return value == null || !StringUtils.hasText(value);
    }
}
