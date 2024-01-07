package demoday03.demo.DAO;

import demoday03.demo.database.PersonDB;
import demoday03.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonimplementsInterface implements PersonRepositoryInterface {
//    @Override
//    public void printListPeople(List<Person> persons) {
//
//    }

    @Override
    public List<Person> getAll() {
        return PersonDB.personList;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.personList.stream()
                .sorted((p1,p2)->p1.getFullName().compareTo(p2.getFullName()))
               .toList();
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.personList.stream()
                .sorted((p1,p2)->p2.getFullName().compareTo(p1.getFullName()))
                .toList();
    }

    @Override
    public List<String> getSortedJobs() {

       return PersonDB.personList.stream()
               .map(p1 ->p1.getJob())
               .sorted()
               .distinct() //Loại bỏ phần tử không trùng lặp .
               .toList();
    }

    @Override
    public List<String> getSortedCities() {
        return  PersonDB.personList.stream()
                .map(p1 ->p1.getCity())
                .sorted()
                .distinct() //Loại bỏ phần tử không trùng lặp .
                .toList();
    }

    @Override
    public List<String> femaleNames() {
        return PersonDB.personList.stream()
                .filter(p1 ->p1.getGender().equals("Female"))
                .map(p1 ->p1.getFullName())
                .toList();
    }

    @Override
    public Person highestEarner() {

        return PersonDB.personList.stream()
                .reduce((p1, p2) -> p1.getSalary() > p2.getSalary() ? p1 : p2)
                .get();
    }

    @Override
    public List<Person> bornAfter1990() {

        return PersonDB.personList.stream()
                .filter(p1->p1.getBirthday().getYear()>1990)
                .toList();
    }

    @Override
    public double averageSalary() {

        double average = PersonDB.personList.stream().
                mapToDouble(p1-> p1.getSalary())
                .sum();

        return average/PersonDB.personList.size();
    }

    @Override
    public double averageAge() {
        double average = PersonDB.personList.stream().
                mapToInt(p1-> cacuAge(p1.getBirthday()))
                .sum();

        return average/PersonDB.personList.size();
    }
    public int cacuAge(LocalDate birth ){
         LocalDate now = LocalDate.now();
        Period age = Period.between(birth,now);
        return age.getYears();
    }

    @Override
    public List<Person> nameContains(String keyword) {

        return PersonDB.personList.stream()
                .filter(p1 -> p1.getFullName().contains(keyword))
                .toList();
    }

    @Override
    public List<Person> sortedByAgeForMale() {

        return PersonDB.personList.stream()
                .filter(person -> person.getGender().equals("Male"))
                .sorted((p1,p2)->cacuAge(p2.getBirthday())-cacuAge(p1.getBirthday()))
                .toList();
    }

    @Override
    public Person longestName() {

        return PersonDB.personList.stream()
                .max((person1, person2) -> Integer.compare(person1.getFullName().length(), person2.getFullName().length()))
                .get();
    }

    @Override
    public List<Person> aboveAverageSalary() {
        double ave = averageSalary();
        return PersonDB.personList.stream()
                .filter(person -> person.getSalary()>ave)
                .toList();
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return PersonDB.personList.stream()
                .collect(Collectors.groupingBy(Person::getCity));
    }

    @Override
    public Map<String, Long> groupJobByCount() {
        return  PersonDB.personList.stream().collect(Collectors.groupingBy(Person::getJob, Collectors.counting()));
    }

    @Override
    public List<Person> inSalaryRange(int start, int end) {
         return PersonDB.personList.stream()
                 .filter(person -> person.getSalary() >= start && person.getSalary() <= end)
                 .toList();
    }

    @Override
    public List<Person> startsWith(String prefix) {
        return PersonDB.personList.stream()
                .filter(person -> person.getFullName().startsWith(prefix))
                .toList();
    }

    @Override
    public List<Person> sortByBirthYearDescending() {
        return PersonDB.personList.stream()
                .sorted((p1,p2)->p2.getBirthday().getYear()-p1.getBirthday().getYear())
                .toList();

    }

    @Override
    public List<Person> top5HighestPaid() {
        return PersonDB.personList.stream()
                .sorted((p1,p2)->p2.getSalary()- p1.getSalary())
                .limit(5)
                .toList();
    }

    @Override
    public List<Person> inAgeRange(int start, int end) {
        return PersonDB.personList.stream().filter(person -> LocalDate.now().getYear() - person.getBirthday().getYear() >= start && LocalDate.now().getYear() - person.getBirthday().getYear() <= end).collect(Collectors.toList());
    }
}



