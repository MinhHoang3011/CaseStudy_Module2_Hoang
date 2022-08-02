package Controller;

import Model.Analgesic;
import Storage.IOFileBinary;

import java.util.ArrayList;

public class AnalgesicManager implements MedicinManager<Analgesic>{

    private ArrayList<Analgesic> listAnalgesic;
    private IOFileBinary<Analgesic> ioFileBinaryAnalgesic = new IOFileBinary<>();


}


