package demoday03.demo.service;

import demoday03.demo.DAO.PersonRepositoryInterface;
import demoday03.demo.DAO.PersonimplementsInterface;
import demoday03.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Autowired
    private PersonimplementsInterface personimplementsInterface;
//    public void printListPeople() {
//        personRepositoryInterface.printListPeople(PersonDB.personList);
//    }
    public List<Person> getAllPerson() {
        return personimplementsInterface.getAll();
    }


    public List<Person> sortPeopleByFullName() {
        return personimplementsInterface.sortPeopleByFullName();
    }


    public List<Person> sortPeopleByFullNameReversed() {
        return personimplementsInterface.sortPeopleByFullNameReversed();
    }

    public List<String> getSortedJobsAZ() {
        return personimplementsInterface.getSortedJobs();
    }

    public List<String> getSortedCities() {
        return personimplementsInterface.getSortedCities();
    }

    public List<String> femaleNames() {
        return personimplementsInterface.femaleNames();
    }

    public Person highestEarner() {
        return personimplementsInterface.highestEarner();
    }

    public List<Person> bornAfter1990() {
        return personimplementsInterface.bornAfter1990();
    }

    public double averageSalary() {
      return   personimplementsInterface.averageSalary();
    }

    public double averageAge() {
        return personimplementsInterface.averageAge();
    }

    public List<Person> nameContains(String keywword) {
        return personimplementsInterface.nameContains(keywword);
    }

    public List<Person> sortedByAgeForMale() {
        return personimplementsInterface.sortedByAgeForMale();
    }

    public Person getLongestName() {
        return personimplementsInterface.longestName();
    }

    public List<Person> aboveAverageSalary() {
        return personimplementsInterface.aboveAverageSalary();
    }

    public Map<String, List<Person>> groupPeopleByCity() {
        return personimplementsInterface.groupPeopleByCity();
    }

    public Map<String, Long> groupJobByCount() {
        return personimplementsInterface.groupJobByCount();
    }

    public List<Person> inSalaryRange(int start , int end) {
        return personimplementsInterface.inSalaryRange( start ,  end);

    }

    public List<Person> startsWith(String startWith) {
        return personimplementsInterface.startsWith(startWith);
    }

    public List<Person> sortByBirthYearDescending() {
        return personimplementsInterface.sortByBirthYearDescending();
    }

    public List<Person> top5HighestPaid() {
        return personimplementsInterface.top5HighestPaid();
    }

    public List<Person> inAgeRange(int start, int end) {
        return personimplementsInterface.inAgeRange(start, end);
    }
}
