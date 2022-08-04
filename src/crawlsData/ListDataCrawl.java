package crawlsData;

import model.Medicine;

import java.util.ArrayList;
import java.util.List;

public class ListDataCrawl {
    private List<Medicine> listOfTonic = new ArrayList<>(CrawlTonic.getInstance().getDataTonic());
    private List<Medicine> listOfAnalgesic = new ArrayList<>(CrawlsAnalgesic.getInstance().getDataAnalgesic());
    private List<Medicine> listOfVitamin = new ArrayList<>(CrawlVitamin.getInstance().getDataVitamin());
    private List<Medicine> listOfAntibiotics = new ArrayList<>(CrawlAntibiotics.getInstance().getDataAntibiotics());
    private List<Medicine> listOfAll = new ArrayList<>();

    public List<Medicine> getListOfTonic() {
        return listOfTonic;
    }

    public List<Medicine> getListOfAnalgesic() {
        return listOfAnalgesic;
    }

    public List<Medicine> getListOfAntibiotics() {
        return listOfAntibiotics;
    }

    public List<Medicine> getListOfVitamin() {
        return listOfVitamin;
    }
    public List<Medicine> getListData(){
        for (Medicine m: listOfTonic
             ) {listOfAll.add(m);
        }
        for (Medicine m: listOfAnalgesic
             ) { listOfAll.add(m);
        }
        for (Medicine m: listOfAntibiotics
             ) { listOfAll.add(m);
        }
        for (Medicine m: listOfVitamin
             ) { listOfAll.add(m);
        }
        return listOfAll;
    }
}
