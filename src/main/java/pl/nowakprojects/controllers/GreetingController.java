package pl.nowakprojects.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.nowakprojects.controllers.paramscontainers.GreetingParams;
import pl.nowakprojects.model.Greeting;

/**
 * Created by Mateusz on 08.04.2017.
 */
@RestController
@RequestMapping("/api/v1")
public class GreetingController {


    @RequestMapping("/greeting")
    public Greeting getGreeting(){
        return new Greeting("Hello there!");
    }

    @RequestMapping("/greetingwithparams")
    public Greeting getGreetingWithParams(
            @RequestParam(name = "name", required = false, defaultValue = "Stranger") String someone
    ){
        return new Greeting("Hello " + someone + "!");
    }

    @RequestMapping("/greetingwithmodel")
    public Greeting getGreetingWithModel(@Validated GreetingParams model){
        return new Greeting("Hello " +" "+ model.getTitle() + " " + model.getName() + " " + model.getSurname() + " " + model.getAge());
    }

    @RequestMapping("/greetingwithpath/{title}/{name}/{surname}/{age}")
    public Greeting getGreetingWithPath(@PathVariable String title,
                                        @PathVariable String name,
                                        @PathVariable String surname,
                                        @PathVariable Integer age) {
        System.out.println("He's " + age + " years old");
        return new Greeting(title + " " + name + " " + " surname");
    }

    @RequestMapping(value = "/greetingwithpost", method = RequestMethod.POST)
    public Greeting getGreetingWithPost(@Validated @RequestBody GreetingParams body) {
        System.out.println("He's " + body.getAge() + " years old");
        return new Greeting(body.getTitle() + " " + body.getName() + " " + body.getSurname());
    }

    @RequestMapping(value = "/greetingwithcodes", method = RequestMethod.POST)
    public ResponseEntity<Greeting> getGreetingsWithCode(@Validated @RequestBody GreetingParams body){
        Greeting greeting = new Greeting(body.getTitle() + " " + body.getName() + " " + body.getSurname());
        HttpStatus httpStatus = HttpStatus.CREATED;
        if ("Nowak".equals(body.getSurname())) {
            httpStatus = HttpStatus.ALREADY_REPORTED;
        } else if ("Kowalski".equals(body.getSurname())) {
            httpStatus = HttpStatus.GONE;
        }

        return new ResponseEntity<>(greeting,httpStatus);
    }
}
