package org.example;
import com.sun.source.tree.NewArrayTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class CsvHandle {
    public  List<Person> CreatePersonFromCsv(String path, boolean skipFirstLine){
        List<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                persons.add(new Person(data[0], Integer.parseInt(data[1]), data[2], data[3]));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void InsertIntoCsvSingle(Person person, String path){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.newLine();
            bw.write(person.name +","+ person.age +","+ person.email +","+ person.gender);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void InsertIntoCsvMultiple(List<Person> person, String path){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (Person p : person) {
                bw.newLine();
                bw.write(p.name + "," + p.age + "," + p.email + "," + p.gender);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
//    CsvHandle csvh = new CsvHandle();
//    List<Person> people = csvh.CreatePersonFromCsv("src/main/java/org/example/person.csv", true);
//    csvh.InsertIntoCsvMultiple(people, "src/main/java/org/example/person.csv");
//    Person person = new Person("Leopold", 22 , "email@seee", "male");
//    csvh.InsertIntoCsvSingle(person, "src/main/java/org/example/person.csv");
}
