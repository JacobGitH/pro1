package org.example;
import com.google.gson.Gson;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class JsonHandle {
    public String path;
    public JsonHandle(String path) {
        this.path = path;
    }

    public <T> List<T> getJson(Class<T[]> clazz) {
        Gson gson = new Gson();
        try {
            path = Files.readString(Paths.get(path));
        }catch (IOException e){
            e.printStackTrace();
        }
        T[] t = gson.fromJson(path, clazz);
        List<T> list = new ArrayList<>(Arrays.asList(t));
        return list;
    }

    public <T> void putToJson(List<T> obj, String path){
        Gson gson = new Gson();
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(gson.toJson(obj));
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

//    //JSON---------------------------------------
//    String content;
//    JsonHandle jh = new JsonHandle("src/main/java/org/example/person.json");
//    List<Person> people = jh.getJson(Person[].class);
//    Person p = new Person("alice", 88);
//    people.add(p);
//    jh.putToJson(people, "src/main/java/org/example/output.json");
//    //JSON---------------------------------------


}
