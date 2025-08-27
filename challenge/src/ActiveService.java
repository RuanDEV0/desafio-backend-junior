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

        activeList.forEach(active->{
            if(active.getCode().equals(code)){
                active.setQuantity(active.getQuantity() - quantity);
            }
        });

        activeList.removeIf(active->active.getQuantity() == 0 && active.getCode().equals(code));
    }

    public static List<Object> summary(){
        return new ArrayList<>();
    }

    public static boolean existsActiveByCode(String code) {
        boolean found = false;
        for (Active active : activeList) {
            found = active.getCode().equals(code);
        }
        return found;
    }

    public static Active getActiveByCode(String code) {
        for (Active active : activeList) {
            if(active.getCode().equals(code)) return active;
        }
        return null;
    }

    public static String investmentSummary(){
        double valueTotal = 0;

        for (Active active : activeList){
            valueTotal += active.getPriceTotal();
        }

        StringBuilder result = new StringBuilder();

        for (Active active : activeList){
            result.append("\n -------- \n" + "Codigo: ").append(active.getCode()).append("\nValor alocado: ").append(active.getPriceTotal()).append(" \n --------");
        }

        return " Valor Carteira: " + valueTotal +
                "\n Ativos: " + result;
    }
}
