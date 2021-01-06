package ua.otchenash.springcourse.dao;

import org.springframework.stereotype.Component;
import ua.otchenash.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PIOPLE_COUNT;
    private List <Person> people;


    {
        people = new ArrayList<>();

        people.add( new Person( ++PIOPLE_COUNT,"Papa", 66, "papa@gmail.com" ));
        people.add( new Person( ++PIOPLE_COUNT,"Mama", 62, "mama@gmail.com" ));
        people.add( new Person( ++PIOPLE_COUNT,"Me", 42, "me@gmail.com" ));
        people.add( new Person( ++PIOPLE_COUNT,"Brother", 36, "brother@gmail.com" ));
    }

    public List<Person> index(){
        return people;
    }

    public Person show (int id){
        return people.stream().filter(person -> person.getId() == id  ).findAny().orElse(null);
    }

    public void save (Person person){
        person.setId(++PIOPLE_COUNT);
        people.add(person);
    }

    public void update (int id, Person updatedPerson){
        Person personToBeUpdated = show( id );

        personToBeUpdated.setName( updatedPerson.getName() );
        personToBeUpdated.setAge( updatedPerson.getAge() );
        personToBeUpdated.setEmail( updatedPerson.getEmail() );
    }

    public void delete (int id){
        people.removeIf( p -> p.getId() == id );
    }
}
