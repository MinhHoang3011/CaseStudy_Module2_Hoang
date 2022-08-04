package crawlsData;

import model.Analgesic;
import model.Antibiotics;
import model.Tonic;
import model.Vitamin;
import storage.IOFileBinary;

import java.io.Serializable;
import java.util.ArrayList;

public class ListDataMedicin implements Serializable {
    private static final long serialVersionUID = -4333316296251054416L;
    private final IOFileBinary<Analgesic> analgesicIOFileBinary;
    private final IOFileBinary<Antibiotics> antibioticsIOFileBinary;
    private final IOFileBinary<Tonic> tonicIOFileBinary;
    private final IOFileBinary<Vitamin> vitaminIOFileBinary;

    private ListDataCrawl listDataCrawl;
    public ListDataMedicin() {
        analgesicIOFileBinary = new IOFileBinary<>();
        antibioticsIOFileBinary = new IOFileBinary<>();
        tonicIOFileBinary = new IOFileBinary<>();
        vitaminIOFileBinary = new IOFileBinary<>();
        listDataCrawl = new ListDataCrawl();
    }
    public ArrayList<Analgesic> setListAnagesic () {
        ArrayList<Analgesic> analgesicArrayList = listDataCrawl.newListAnalgesic();
        analgesicIOFileBinary.writerFileData(analgesicArrayList, "FileDataAnalgesic");
        return analgesicArrayList;
    }
    public ArrayList<Antibiotics> setListAntibiotics() {
        ArrayList<Antibiotics> antibioticsArrayList = listDataCrawl.newListAntibiotics();
        antibioticsIOFileBinary.writerFileData(antibioticsArrayList,"FileDataAntibiotics");
        return antibioticsArrayList;
    }
    public ArrayList<Tonic> setListTonic() {
        ArrayList<Tonic> tonicArrayList = listDataCrawl.newListTonic();
        tonicIOFileBinary.writerFileData(tonicArrayList, "FileDataTonic");
        return tonicArrayList;
    }
    public ArrayList<Vitamin> setListVitamin(){
        ArrayList<Vitamin> vitaminArrayList = listDataCrawl.newListVitamin();
        vitaminIOFileBinary.writerFileData(vitaminArrayList,"FileDataVitamin");
        return vitaminArrayList;
    }
    public ArrayList<Analgesic> getListAnagesic() {
        ArrayList<Analgesic> analgesicArrayList = listDataCrawl.newListAnalgesic();
        return analgesicIOFileBinary.readFileData("FileDataAnalgesic");
    }
    public ArrayList<Antibiotics> getListAntibiotic() {
        ArrayList<Antibiotics> antibioticsArrayList = listDataCrawl.newListAntibiotics();
        return antibioticsIOFileBinary.readFileData("FileDataAntibiotics");
    }
    public ArrayList<Tonic> getListTonic() {
        ArrayList<Tonic> tonicArrayList = listDataCrawl.newListTonic();
        return tonicIOFileBinary.readFileData("FileDataTonic");
    }
    public ArrayList<Vitamin> getListVitamin() {
        ArrayList<Vitamin> vitaminArrayList = listDataCrawl.newListVitamin();
        return vitaminIOFileBinary.readFileData("FileDataVitamin");
    }

    public static void main(String[] args) {
        ListDataMedicin listDataMedicin = new ListDataMedicin();
        listDataMedicin.setListAnagesic();
        listDataMedicin.getListAnagesic();
        listDataMedicin.setListAntibiotics();
        listDataMedicin.getListAntibiotic();
        listDataMedicin.setListTonic();
        listDataMedicin.getListTonic();
        listDataMedicin.setListVitamin();
        listDataMedicin.getListVitamin();
    }
}
