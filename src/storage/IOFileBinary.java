package storage;

import java.io.*;
import java.util.ArrayList;

public class IOFileBinary<E> {

    public void writerFileData(ArrayList<E> arrayData , String pathName){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(pathName)));
            objectOutputStream.writeObject(arrayData);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<E> readFileData(String pathName) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
