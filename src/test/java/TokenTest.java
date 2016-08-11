import com.scrum.agile.security.Token;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by apolo & agustibm on 11/08/2016.
 */
public class TokenTest {

    @Test
    public void get_token(){
        Token token = new Token("password");
        token.setExpires(60L);
        token.addInfo("Test");

        String tokenForSend = token.sign();

        String expectedToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9";
        String infoFromToken = tokenForSend.split("\\.")[0];
        assertEquals(expectedToken, infoFromToken);

    }
}
