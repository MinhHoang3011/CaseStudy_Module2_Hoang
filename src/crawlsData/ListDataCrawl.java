package crawlsData;

import model.Analgesic;
import model.Antibiotics;
import model.Tonic;
import model.Vitamin;

import java.util.ArrayList;

public class ListDataCrawl {
    private CrawlsAnalgesic crawlsAnalgesic = new CrawlsAnalgesic();
    private CrawlAntibiotics crawlAntibiotics = new CrawlAntibiotics();
    private CrawlVitamin crawlVitamin = new CrawlVitamin();
    private CrawlTonic crawlTonic = new CrawlTonic();

    public ListDataCrawl() {
        crawlsAnalgesic.crawlAll();
        crawlAntibiotics.crawlAll();
        crawlVitamin.crawlAll();
        crawlTonic.crawlAll();
    }

    public ArrayList<Analgesic> newListAnalgesic(){
        ArrayList<Analgesic> analgesicArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlsAnalgesic.getNameAnalgesic();
        ArrayList<String> priceList = crawlsAnalgesic.getPriceAnalgesic();
        ArrayList<Integer> idList = crawlsAnalgesic.getIdAnalgesic();
        ArrayList<String> unitList = crawlsAnalgesic.getUnitAnalgesic();
        for (int i = 0; i < nameList.size(); i++) {
            double price = Double.parseDouble(priceList.get(i).replaceAll("₫","").trim());
            String name = nameList.get(i);
            int id = idList.get(i);
            String unit = unitList.get(i);
            Analgesic analgesic = new Analgesic(id, name, price, unit);
            analgesicArrayList.add(analgesic);
        }
        return analgesicArrayList;
    }
    public ArrayList<Antibiotics> newListAntibiotics(){
        ArrayList<Antibiotics> antibioticsArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlAntibiotics.getNameAntibiotics();
        ArrayList<String> priceList = crawlAntibiotics.getPriceAntibiotics();
        ArrayList<Integer> idList = crawlAntibiotics.getIdAntibiotics();
        ArrayList<String> unitList = crawlAntibiotics.getUnitAntibiotics();
        for (int i = 0; i < nameList.size(); i++) {
            double price = Double.parseDouble(priceList.get(i).replaceAll("₫","").trim());
            String name = nameList.get(i);
            int id = idList.get(i);
            String unit = unitList.get(i);
            Antibiotics antibiotics = new Antibiotics(id, name, price, unit);
            antibioticsArrayList.add(antibiotics);
        }
        return antibioticsArrayList;
    }
    public ArrayList<Tonic> newListTonic(){
        ArrayList<Tonic> tonicArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlTonic.getNameTonic();
        ArrayList<String> priceList = crawlTonic.getPriceTonic();
        ArrayList<Integer> idList = crawlTonic.getIdTonic();
        ArrayList<String> unitList = crawlTonic.getUnitTonic();
        for (int i = 0; i < nameList.size(); i++) {
            double price = Double.parseDouble(priceList.get(i).replaceAll("₫","").trim());
            String name = nameList.get(i);
            int id = idList.get(i);
            String unit = unitList.get(i);
            Tonic tonic = new Tonic(id, name, price, unit);
            tonicArrayList.add(tonic);
        }
        return tonicArrayList;
    }
    public ArrayList<Vitamin> newListVitamin() {
        ArrayList<Vitamin> vitaminArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlVitamin.getNameVitamin();
        ArrayList<String> priceList = crawlVitamin.getPriceVitamin();
        ArrayList<Integer> idList = crawlVitamin.getIdVitamin();
        ArrayList<String> unitList = crawlVitamin.getUnitVitamin();
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            double price = Double.parseDouble(priceList.get(i).replaceAll("₫","").trim());
            int id = idList.get(i);
            String unit = unitList.get(i);
            Vitamin vitamin = new Vitamin(id, name, price, unit);
            vitaminArrayList.add(vitamin);
        }
        return vitaminArrayList;
    }

//    private List<Medicine> listOfTonic = new ArrayList<>(CrawlTonic.getInstance().getDataTonic());
//    private List<Medicine> listOfAnalgesic = new ArrayList<>(CrawlsAnalgesic.getInstance().getDataAnalgesic());
//    private List<Medicine> listOfVitamin = new ArrayList<>(CrawlVitamin.getInstance().getDataVitamin());
//    private List<Medicine> listOfAntibiotics = new ArrayList<>(CrawlAntibiotics.getInstance().getDataAntibiotics());
//    private List<Medicine> listOfAll = new ArrayList<>();
//
//    public List<Medicine> getListOfTonic() {
//        return listOfTonic;
//    }
//
//    public List<Medicine> getListOfAnalgesic() {
//        return listOfAnalgesic;
//    }
//
//    public List<Medicine> getListOfAntibiotics() {
//        return listOfAntibiotics;
//    }
//
//    public List<Medicine> getListOfVitamin() {
//        return listOfVitamin;
//    }
//    public List<Medicine> getListData(){
//        for (Medicine m: listOfTonic
//             ) {listOfAll.add(m);
//        }
//        for (Medicine m: listOfAnalgesic
//             ) { listOfAll.add(m);
//        }
//        for (Medicine m: listOfAntibiotics
//             ) { listOfAll.add(m);
//        }
//        for (Medicine m: listOfVitamin
//             ) { listOfAll.add(m);
//        }
//        return listOfAll;
//    }
}
