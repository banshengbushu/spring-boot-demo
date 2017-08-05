package example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("man");
        System.out.println("init list" + list);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("stringlist"));
        objectOutputStream.writeObject(list);
        objectOutputStream.close();

        File file = new File("stringlist");

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        List<String> newlist = (List<String>)objectInputStream.readObject();
        objectInputStream.close();

        if(file.exists()){
            file.delete();
        }
        System.out.println("new list" + newlist);
    }

}
