package demoday03.demo.DAO;

import demoday03.demo.database.PersonDB;
import demoday03.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAO {
    public List<Person> findPerson(){
        return PersonDB.personList;
    }
    public Person findById(int id){
        for ( Person person: PersonDB.personList){
            if(person.getId()==id){
                return person;
            }
        }
        return null;
    }
}
