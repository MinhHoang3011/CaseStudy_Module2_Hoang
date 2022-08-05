package storage;

import java.io.*;
import java.util.ArrayList;

public class IOFileBinary<E> implements Serializable {
    private static final long serialVersionUID = -4333316296251054416L;
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
            return (ArrayList<E>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
