//import models.Gender;

import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();


        Metadata metadata = new MetadataSources(serviceRegistry)
                // class for tabels in db
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Card.class)
                .getMetadataBuilder()

                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        User vasya = new User("Vasya", Gender.MALE, Arrays.asList("java", "html"), new Passport("zxcvbn"));
        User kolya = new User("Kolya", Gender.MALE, Arrays.asList("Java", "js", "mysql"), new Passport("poiuyt"));
        User olya = new User("Olya", Gender.FEMALE, Arrays.asList("python", "mongoDB"), new Passport("asdfgh"));

        //save obj
        session.save(vasya);
        session.save(kolya);
        session.save(olya);

        //select by id query
//        User user = session.find(User.class, 1);
//        System.out.println("I found - " + user);
        //select non unique
//        List<User> resultList = session.createQuery("select u from User u", User.class)
//                .getResultList();
//        System.out.println(resultList);
//        delete
//        for (User t : resultList) {
//            if (t.getId() == 1) session.delete(t);
//        }
//        Car bmw = new Car("bmw", 2005, ModelClass.ECONOMY);
//        Car audi = new Car("audi", 2021, ModelClass.BUSINESS);
//        Car gm = new Car("gm", 2005, ModelClass.ECONOMY);
//
//        session.save(bmw);
//        session.save(audi);
//        session.save(gm);
//
//        Car car = session.find(Car.class, 1);
//        System.out.println(car);
//        List<Car> resultListCars = session.createQuery("select c from Car c where c.modelClass='ECONOMY'", Car.class).getResultList();
//        System.out.println("size cars list = " + resultListCars.size());
//        for (Car resultListCar : resultListCars) {
//            System.out.println(resultListCar);
//        }
//        Passport passport1 = session.find(Passport.class, 2);
//        User user = passport1.getUser();
//        System.out.println(passport1.getUser() + " + " + passport1.getSeries() + " + " + passport1.getId());

        session.save(new Card("1234 1234 1234 1234",vasya));

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }
}