package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//same as csv
public class txthandle {
    public List<Person> createPersonFromTXT(String path, boolean skipFirstLine) {
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
}
