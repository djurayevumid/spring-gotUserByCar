package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        UserService userService = context.getBean(UserService.class);
//        User user = context.getBean("userBean", User.class);

//        user.setUserCar().;
//
        userService.addUser(new User("Mike", "Chukcha", "mike@mail.ru", new Car("BMW", 7)));
        userService.addUser(new User("Jane", "Jonnah", "jane@mail.ru", new Car("Mini cooper", 8)));
        userService.addUser(new User("Nick", "Flames", "nick@mail.ru", new Car("Volvo", 10)));
        userService.addUser(new User("Nick", "Nickolson", "nickolson@mail.ru", new Car("Hunday", 5)));
        userService.addUser(new User("Harold", "Dickerson", "har@mail.ru", new Car("Volvo", 4)));
//



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
                + userService.getUserByCarsModelAndSeries("Volvo", 10));
//      System.out.println(user1.getUserCar());
        System.out.println();

        //        System.out.println(car1.getModel());
        System.out.println();
        context.close();
    }
}
