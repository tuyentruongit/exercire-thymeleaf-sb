package demoday03.demo.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import demoday03.demo.database.PersonDB;
import demoday03.demo.model.Person;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CSVFileReader implements IFileReader {
    @Override
    public List<Person> readFile(String filePath) {
        List<Person> persons = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            // Đọc dòng tiêu đề (nếu có)
            String[] header = reader.readNext();

            // Duyệt qua từng dòng và chuyển đổi thành đối tượng Person
            String[] line;
            while ((line = reader.readNext()) != null) {
                Person person = new Person();
                person.setId(Integer.parseInt(line[0]));
                person.setFullName(line[1]);
                person.setJob(line[2]);
                person.setGender(line[3]);
                person.setCity(line[4]);
                person.setSalary(Integer.parseInt(line[5]));

                // Chuyển đổi chuỗi ngày thành LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate birthday = LocalDate.parse(line[6], formatter);
                person.setBirthday(birthday);

                persons.add(person);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return persons;
    }



}
