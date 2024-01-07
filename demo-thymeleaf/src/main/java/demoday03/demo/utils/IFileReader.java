package demoday03.demo.utils;

import demoday03.demo.model.Person;

import java.util.List;

public interface IFileReader {
    List<Person> readFile(String filePath);
}
