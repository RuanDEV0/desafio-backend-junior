import java.util.ArrayList;
import java.util.List;

public class ActiveService {
    private static final List<Active> activeList = new ArrayList<>();

    public static void save(Active active){
        activeList.add(active);
    }

    public static List<Active> getActiveList(){
        return activeList;
    }

    public static void reportSale(String code, int quantity){

    }

    public static List<Object> summary(){
        return new ArrayList<>();
    }
}
