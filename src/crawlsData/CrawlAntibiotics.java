package crawlsData;

import model.Antibiotics;
import model.Medicine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//public class CrawlAntibiotics implements ICrawlsData{
public class CrawlAntibiotics {

//    private static CrawlAntibiotics instance;

    private final String url = "https://www.nhathuocankhang.com/khang-sinh-khang-nam#c=10024&protype=2&o=3&pi=0";


//    private ArrayList<Medicine> dataAntibiotics = new ArrayList<>();
    private ArrayList<String> nameAntibiotics = new ArrayList<>();
    private ArrayList<String> priceAntibiotics = new ArrayList<>();
    private ArrayList<Integer> idAntibiotics = new ArrayList<>();
    private ArrayList<String> unitAntibiotics = new ArrayList<>();
    public CrawlAntibiotics() {
    }
    public ArrayList<String> getNameAntibiotics() {
        return nameAntibiotics;
    }
    public ArrayList<String> getPriceAntibiotics() {
        return priceAntibiotics;
    }
    public ArrayList<Integer> getIdAntibiotics() {
        return idAntibiotics;
    }
    public ArrayList<String> getUnitAntibiotics() {
        return unitAntibiotics;
    }
    public void crawlAll() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elementsName = doc.getElementsByClass("text-prod");
            ArrayList<Element> elementsPrice = doc.getElementsByClass("P_disprice");
            ArrayList<Element> elementsUnit = doc.getElementsByClass("qcdg");

            int id = 0;
            for (int i = 1; i <= 5; i++) {
                String name = elementsName.get(i).getElementsByTag("h3").text();
                String price = elementsPrice.get(i).getElementsByTag("b").text();
                String unit = elementsUnit.get(i).getElementsByTag("label").text();
                id ++;
                idAntibiotics.add(id);
                nameAntibiotics.add(name);
                priceAntibiotics.add(price);
                unitAntibiotics.add(unit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//    private CrawlAntibiotics() {
//
//    }

//    public static CrawlAntibiotics getInstance() {
//        if (instance == null) {
//            return instance = new CrawlAntibiotics();
//        }else return instance;
//    }
//    public List<Medicine> getDataAntibiotics(){
//        crawlAll();
//        return dataAntibiotics;
//    }
//
//    public void crawlAll(){
//        try {
//            Document doc = Jsoup.connect(url).get();
//            ArrayList<Element> elementsName = doc.getElementsByClass("text-prod");
//            ArrayList<Element> elementsPrice = doc.getElementsByClass("P_disprice");
//            ArrayList<Element> elementsUnit = doc.getElementsByClass("qcdg");
//
//            int id = 0;
//            for (int i = 1; i <5 ; i++) {
//                Antibiotics a1 = new Antibiotics();
//                String name = elementsName.get(i).getElementsByTag("h3").text();
//                a1.setName(name);
//                String price = elementsPrice.get(i).getElementsByTag("b").text();
//                price = price.replaceAll(","," ");
//                price = price.replaceAll("₫,"," ").trim();
//                a1.setPrice(Double.parseDouble(price));
//                String unit = elementsUnit.get(i).getElementsByTag("label").text();
//                a1.setUnit(unit);
//                id ++;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
