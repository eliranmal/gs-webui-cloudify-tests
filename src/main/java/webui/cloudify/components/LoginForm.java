package webui.cloudify.components;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webui.tests.components.abstracts.AbstractComponent;import java.lang.String;


/**
 * User: guym
 * Date: 4/9/13
 * Time: 11:42 AM
 */
public class LoginForm extends AbstractComponent<LoginForm> {

    @FindBy(css="form")
    LoginDetails details;

    @FindBy( css = "#login_button button, input[type='submit']" )
    WebElement submit;



    private boolean _if( String str ) {
        return !StringUtils.isEmpty( str );
    }

    public LoginForm username( String username ) {
        if ( _if( username ) )
        {
            details.username.sendKeys( username );
        }
        return this;
    }

    public LoginForm password( String password ){
        if ( _if( password )){
            details.password.sendKeys( password );
        }
        return this;
    }

    public LoginForm submit(){
        submit.click();
        return this;
    }


    public static class LoginDetails extends AbstractComponent<LoginDetails>{

        @FindBy( css = "#username-input, input[name='username']" )
        public WebElement username;

        @FindBy( css = "#password-input, input[name='password']" )
        public WebElement password;
    }
}
