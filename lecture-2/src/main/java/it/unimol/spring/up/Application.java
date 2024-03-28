package it.unimol.spring.up;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx =
                SpringApplication.run(Application.class, args);

        Person p = ctx.getBean(Person.class);

        System.out.println(
                "My name is " + p.getName() + " and my parrot is " + p.getParrot().getName());

        Dog d = ctx.getBean(Dog.class);

        System.out.println("Dog's friend is " + d.getFriend().getName());

        ctx.getBeansOfType(Parrot.class)
                .values()
                .forEach(Parrot::speak);
    }
}
