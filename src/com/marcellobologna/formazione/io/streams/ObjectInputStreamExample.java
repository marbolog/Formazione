package com.marcellobologna.formazione.io.streams;

import java.io.*;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * The Java ObjectInputStream class (java.io.ObjectInputStream) enables you to read Java objects from an InputStream
 * instead of just raw bytes. You wrap an InputStream in a ObjectInputStream and then you can read objects from it. Of
 * course the bytes read must represent a valid, serialized Java object. Otherwise reading objects will fail.
 * <p>
 * Normally you will use the ObjectInputStream to read objects written (serialized) by a Java ObjectOutputStream . You
 * will see an example of that later.
 */
public class ObjectInputStreamExample {

    public static class Person implements Serializable {

        private String name = null;
        private int age = 0;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {

        try (ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream("/home/local/ARIADNE/bologna/Documenti/prove/person.bin"));
             ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream("/home/local/ARIADNE/bologna/Documenti/prove/person.bin"));
        ) {

            Person person = new Person();
            person.setName("Jakob Jenkov");
            person.setAge(40);

            objectOutputStream.writeObject(person);
            objectOutputStream.close();

            Person personRead = (Person) objectInputStream.readObject();

            objectInputStream.close();

            System.out.println(personRead.name);
            System.out.println(personRead.age);

        } catch (Exception e) {

        }
    }


}
