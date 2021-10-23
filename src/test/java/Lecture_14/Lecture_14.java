package Lecture_14;

import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.PageFactoryPattern;
import patterns.User;
import patterns.UserBuilder;


public class Lecture_14 extends BaseTest {
    PageFactoryPattern pattern;
    UserBuilder userBuilder;
    User user ;

    @BeforeTest
    public void precondition() {
        pattern = new PageFactoryPattern(driver);
        user = new User ("пользователь",22,"someemail");
        building();
    }

    public void building() {
        userBuilder = new UserBuilder.Builder()
                .withAge(22)
                .withUsername("Helen")
                .withEmail("eleenoree")
                .build();
    }
    @Test(description = "Trying ValueObject pattern")
    public void valueTest () {
        pattern.printValue(user);
    }

    @Test(description = "Trying Builder pattern")
    public void tesBuilder() {
        pattern.print(userBuilder);
    }

    @Test(description = "Trying Page Factory pattern")
    public void authorize() {
        pattern.login();
    }
}
