package src.main.java.com.hsbc;

public class ImmutableCollectionDemo {
    public static void main(String[] args){
        List<Item> list = new ArrayList<>();
        list.addAll(getItemsFromSomewhere());
        list.addAll(getItemsFromElsewhere());
        list.addAll(getItemsFromYetAnotherPlace());
    }
}
