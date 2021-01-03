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

        people.add( new Person( ++PIOPLE_COUNT,"Papa" ));
        people.add( new Person( ++PIOPLE_COUNT,"Mama" ));
        people.add( new Person( ++PIOPLE_COUNT,"I" ));
        people.add( new Person( ++PIOPLE_COUNT,"Sombody" ));
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
    }

    public void delete (int id){
        people.removeIf( p -> p.getId() == id );
    }
}
