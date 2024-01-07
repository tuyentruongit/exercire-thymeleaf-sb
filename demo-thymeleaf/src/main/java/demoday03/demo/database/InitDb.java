package demoday03.demo.database;

import com.opencsv.exceptions.CsvException;
import demoday03.demo.model.Person;
import demoday03.demo.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Configuration
public class InitDb implements CommandLineRunner {
    @Autowired
    private IFileReader iFileReader;


    @Override
    public void run(String... args) throws Exception {

        PersonDB.personList = iFileReader.readFile("persons.csv");


        System.out.println(PersonDB.personList.size());
    }
}
