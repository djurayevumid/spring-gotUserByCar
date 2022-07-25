package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car car1 = new Car("BMW", 7);
        Car car2 = new Car("Aston Martin", 8);
        Car car3 = new Car("Mercedes Benz", 9);
        Car car4 = new Car("Mercedes Benz", 7);

        User user1 = new User("Tim", "Burton", "user1@mail.ru", car1);
        User user2 = new User("Adam", "Sandler", "user2@mail.ru", car2);
        User user3 = new User("Nate", "Higger", "user3@mail.ru", car3);
        User user4 = new User("Nill", "Kigger", "user4@mail.ru", car4);
        user1.setUserCar(car1);
        user2.setUserCar(car2);
        user3.setUserCar(car3);
        user4.setUserCar(car4);


        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);


        List<User> users = userService.getUsersList();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getUserCar());
            System.out.println();
        }


        System.out.println("The car with given parameters belongs to "
                + userService.getUserByCarsModelAndSeries("Aston Martin", 8));
//      System.out.println(user1.getUserCar());
        System.out.println();
        System.out.println(car1.getModel());
        System.out.println();
        context.close();
    }
}
