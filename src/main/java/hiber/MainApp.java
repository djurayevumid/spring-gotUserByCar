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

        User user1 = new User(car1);

        user1.setFirstName("Mike");
        user1.setLastName("Chukcha");

        userService.addUser(user1);

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
                + userService.getUserByCarsModelAndSeries("BMW", 7));
//      System.out.println(user1.getUserCar());
        System.out.println();
        System.out.println(car1.getModel());
        System.out.println();
        context.close();
    }
}
