package crawlsData;

import model.Analgesic;
import model.Medicine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlTonic {
//    private static CrawlTonic instance;
    private final String url = "https://www.nhathuocankhang.com/tim-kiem?key=thu%E1%BB%91c+b%E1%BB%95";
//    private ArrayList<Medicine> dataTonic = new ArrayList<>();
    private ArrayList<String> nameTonic = new ArrayList<>();
    private ArrayList<String> priceTonic = new ArrayList<>();
    private ArrayList<Integer> idTonic = new ArrayList<>();
    private ArrayList<String> unitTonic = new ArrayList<>();

    public CrawlTonic() {

    }

    public ArrayList<String> getNameTonic() {
        return nameTonic;
    }

    public ArrayList<String> getPriceTonic() {
        return priceTonic;
    }

    public ArrayList<Integer> getIdTonic() {
        return idTonic;
    }

    public ArrayList<String> getUnitTonic() {
        return unitTonic;
    }
    public void crawlAll(){
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elementName = doc.getElementsByClass("text-prod");
            ArrayList<Element> elementPrice = doc.getElementsByClass("P_disprice");
            ArrayList<Element> elementUnit = doc.getElementsByClass("qcdg");

            int id = 11;
            for (int i = 0; i <= 5; i++) {
                String name = elementName.get(i).getElementsByTag("h3").text();
                String price = elementPrice.get(i).getElementsByTag("b").text();
                String unit = elementUnit.get(i).getElementsByTag("label").text();
                id++;
                idTonic.add(id);
                nameTonic.add(name);
                priceTonic.add(price);
                unitTonic.add(unit);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //    private CrawlTonic() {
//    }

//    public static CrawlTonic getInstance() {
//        if (instance == null) {
//            return instance = new CrawlTonic();
//        }
//        else return instance;
//    }
//    public List<Medicine> getDataTonic() {
//        crawlAll();
//        return dataTonic;
//    }
//    public void crawlAll() {
//        try {
//            Document doc = Jsoup.connect(url).get();
//            ArrayList<Element> elementName = doc.getElementsByClass("text-prod");
//            ArrayList<Element> elementPrice = doc.getElementsByClass("P_disprice");
//            ArrayList<Element> elementUnit = doc.getElementsByClass("qcdg");
//            int id = 0;
//            for (int i = 1; i < 5 ; i++) {
//                Analgesic a1 = new Analgesic();
//                String name = elementName.get(i).getElementsByTag("h3").text();
//                a1.setName(name);
//                String price = elementPrice.get(i).getElementsByTag("b").text();
//                price = price.replaceAll(",","");
//                price = price.replaceAll("₫","").trim();
//                a1.setPrice(Double.parseDouble(price));
//                String unit = elementUnit.get(i).getElementsByTag("label").text();
//                a1.setUnit(unit);
//                id ++;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
