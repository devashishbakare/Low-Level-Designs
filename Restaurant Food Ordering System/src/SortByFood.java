import java.util.List;

public class SortByFood implements SortingStrategy{

    private String foodItem;
    public SortByFood(String foodItem){
        this.foodItem = foodItem;
    }
    @Override
    public List<String> sort() {
        return null;
    }
}
