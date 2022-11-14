package Train.Validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationServiceTest {
    UserValidationService validation = new UserValidationService();
    User userTrueCom = new User("A", "B", new Address("Андорра", "D", "E", 1), "iv@gmail.com", "Phone");
    User userTrueDE = new User("A", "B", new Address("Андорра", "D", "E", 1), "iv@gmail.de", "Phone");
    User userTrueUa = new User("A", "B", new Address("Андорра", "D", "E", 1), "iv@gmail.ua", "Phone");
    User userTrueRu = new User("A", "B", new Address("Андорра", "D", "E", 1), "iv@gmail.ru", "Phone");
    User userWithoutDog = new User("A", "B", new Address("Андорра", "D", "E", 1), "ivgmail.ru", "Phone");
    User userWithoutDot = new User("A", "B", new Address("Андорра", "D", "E", 1), "iv@gmailru", "Phone");
    User userWithTwoDot = new User("A", "B", new Address("Андорра", "D", "E", 1), "i..v@gmail.ru", "Phone");
    User userWithDotInStart = new User("A", "B", new Address("Андорра", "D", "E", 1), ".iv@gmail.ru", "Phone");
    User userWithoutEmailName = new User("A", "B", new Address("Андорра", "D", "E", 1), "@gmail.ru", "Phone");
    User userWithDotAfterDog = new User("A", "B", new Address("Андорра", "D", "E", 1), "iv.@gmail.ru", "Phone");
    User userWithTwoDog = new User("A", "B", new Address("Андорра", "D", "E", 1), "i@hv@gmail.ru", "Phone");
    User userEmpty1 = new User("", "B", new Address("Андорра", "D", "E", 1), "iv@gmail.ru", "Phone");
    User userEmpty2 = new User("A", "", new Address("Андорра", "D", "E", 1), "iv@gmail.ru", "Phone");
    User userEmpty3 = new User("A", "B", new Address("", "D", "E", 1), "iv@gmail.ru", "Phone");
    User userEmpty4 = new User("A", "B", new Address("Андорра", "D", "", 1), "iv@gmail.ru", "Phone");
    User userEmpty5 = new User("A", "B", new Address("Андорра", "D", "E", 1), "", "Phone");
    User userEmpty6 = new User("A", "B", new Address("Андорра", "D", "E", 1), "iv@gmail.ru", "");
    User userEmpty7 = new User("A", "B", new Address("Андорра", "", "E", 1), "iv@gmail.ru", "Phone");
    User userHouseNumberIsZero = new User("A", "B", new Address("Андорра", "D", "E", 0), "iv@gmail.com", "Phone");
    User userTestFromSiteFalse1 = new User("A", "B", new Address("Андорра", "D", "E", 1), "plaintextaddress", "Phone");
    User userTestFromSiteFalse2 = new User("A", "B", new Address("Андорра", "D", "E", 1), ".@#@@##@%^%#$@#$@#.com", "Phone");
    User userTestFromSiteFalse3 = new User("A", "B", new Address("Андорра", "D", "E", 1), "John Doe <example@email.com>", "Phone");
    User userTestFromSiteFalse4 = new User("A", "B", new Address("Андорра", "D", "E", 1), "おえあいう@example.com", "Phone");
    User userTestFromSiteFalse5 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example@email.com (John Doe)", "Phone");
    User userTestFromSiteFalse6 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example@email", "Phone");
    User userTestFromSiteFalse8 = new User("A", "B", new Address("Андорра", "D", "E", 1), "”(),:;<>['\']@email.com", "Phone");
    User userTestFromSiteFalse9 = new User("A", "B", new Address("Андорра", "D", "E", 1), "obviously”not”correct@email.com", "Phone");
    User userTestFromSiteFalse10 = new User("A", "B", new Address("Андорра", "D", "E", 1), ".example\\is”especially”not\\allowed@email.com", "Phone");
    User userTestFromSiteTrue1 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example@email.com", "Phone");
    User userTestFromSiteTrue2 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example.first.middle.lastname@email.com", "Phone");
    User userTestFromSiteTrue3 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example@subdomain.email.com", "Phone");
    User userTestFromSiteTrue4 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example+firstname+lastname@email.com", "Phone");
    User userTestFromSiteTrue6 = new User("A", "B", new Address("Андорра", "D", "E", 1), "0987654321@example.com", "Phone");
    User userTestFromSiteTrue7 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example@email-one.com", "Phone");
    User userTestFromSiteTrue8 = new User("A", "B", new Address("Андорра", "D", "E", 1), "_______@email.com", "Phone");
    User userTestFromSiteTrue9 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example.firstname-lastname@email.com", "Phone");
    User userWrongCountry = new User("A", "B", new Address("Андрра", "D", "E", 1), "", "Phone");
    User userLongTrue = new User("A", "B", new Address("Андорра", "D", "E", 1), "ivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivvvvviviviviviviviviviviviviviviviviviviv@gmail.com", "Phone");
    User userLongFalse = new User("A", "B", new Address("Андорра", "D", "E", 1), "ivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivvvvvivivivivivivivivivivivivivivivivivivv@gmail.com", "Phone");
    User userLongFalse2 = new User("A", "B", new Address("Андорра", "D", "E", 1), "ivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivivvvvvivivivivivivivivivivivivivivivivivivvv@gmail.com", "Phone");

    @Test
    void isCorrectUsers() {
        assertTrue(validation.isCorrectUsers(userTrueCom));
        assertTrue(validation.isCorrectUsers(userTrueDE));
        assertTrue(validation.isCorrectUsers(userTrueRu));
        assertTrue(validation.isCorrectUsers(userTrueUa));
        assertFalse(validation.isCorrectUsers(userWithoutDot));
        assertFalse(validation.isCorrectUsers(userWithoutDog));
        assertFalse(validation.isCorrectUsers(userWithTwoDog));
        assertFalse(validation.isCorrectUsers(userWithTwoDot));
        assertFalse(validation.isCorrectUsers(userWithDotInStart));
        assertFalse(validation.isCorrectUsers(userWithoutEmailName));
        assertFalse(validation.isCorrectUsers(userWithDotAfterDog));
        assertFalse(validation.isCorrectUsers(userEmpty1));
        assertFalse(validation.isCorrectUsers(userEmpty2));
        assertFalse(validation.isCorrectUsers(userEmpty3));
        assertFalse(validation.isCorrectUsers(userEmpty4));
        assertFalse(validation.isCorrectUsers(userEmpty5));
        assertFalse(validation.isCorrectUsers(userEmpty6));
        assertFalse(validation.isCorrectUsers(userEmpty7));
        assertFalse(validation.isCorrectUsers(userHouseNumberIsZero));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse1));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse2));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse3));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse4));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse5));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse6));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse8));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse9));
        assertFalse(validation.isCorrectUsers(userTestFromSiteFalse10));
        assertTrue(validation.isCorrectUsers(userTestFromSiteTrue1));
        assertTrue(validation.isCorrectUsers(userTestFromSiteTrue2));
        assertTrue(validation.isCorrectUsers(userTestFromSiteTrue3));
        assertTrue(validation.isCorrectUsers(userTestFromSiteTrue4));
        assertTrue(validation.isCorrectUsers(userTestFromSiteTrue6));
        assertTrue(validation.isCorrectUsers(userTestFromSiteTrue7));
        assertTrue(validation.isCorrectUsers(userTestFromSiteTrue8));
        assertTrue(validation.isCorrectUsers(userTestFromSiteTrue9));
        assertFalse(validation.isCorrectUsers(userWrongCountry));
        assertTrue(validation.isCorrectUsers(userLongTrue));
        assertFalse(validation.isCorrectUsers(userLongFalse));
        assertFalse(validation.isCorrectUsers(userLongFalse2));

    }

    @Test
    void getIncorrectUsers() {
        LinkedList<User> test= new LinkedList<>();
        User userTrueCom = new User("A", "B", new Address("Андорра", "D", "E", 1), "iv@gmail.com", "Phone");
        User userTestFromSiteTrue1 = new User("A", "B", new Address("Андорра", "D", "E", 1), "example@email.com", "Phone");
        User userTestFromSiteFalse1 = new User("A", "B", new Address("Андорра", "D", "E", 1), "plaintextaddress", "Phone");
        User userTestFromSiteFalse2 = new User("A", "B", new Address("Андорра", "D", "E", 1), ".@#@@##@%^%#$@#$@#.com", "Phone");
        User userTestFromSiteFalse3 = new User("A", "B", new Address("Андорра", "D", "E", 1), "John Doe <example@email.com>", "Phone");
        User userTestFromSiteFalse4 = new User("A", "B", new Address("Андорра", "D", "E", 1), "おえあいう@example.com", "Phone");

        test.add(userTrueCom);
        test.add(userTestFromSiteTrue1);
        test.add(userTestFromSiteFalse1);
        test.add(userTestFromSiteFalse2);
        test.add(userTestFromSiteFalse3);
        test.add(userTestFromSiteFalse4);

        List<User> ar = Arrays.asList(userTrueCom, userTestFromSiteFalse1);

        LinkedList<User> wrongList = new LinkedList<>();
        wrongList.add(userTestFromSiteFalse1);
        wrongList.add(userTestFromSiteFalse2);
        wrongList.add(userTestFromSiteFalse3);
        wrongList.add(userTestFromSiteFalse4);


        LinkedList<User> test2 = validation.getIncorrectUsers(test);
        assertEquals(4, test2.size());
        System.out.println();
        for (int i = 0; i < wrongList.size(); i++) {
            assertEquals(test2.get(i), wrongList.get(i));
        }
        assertEquals(test2, wrongList);

    }
}





















