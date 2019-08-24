public class Item {
    private String id;
    private static int idPublic=1;
    private String name;
    private String description;
    private float price;

    public Item(String Name, String Description, float Price){
        this.name=Name;
        this.description=Description;
        this.price=Price;

        this.id=""+idPublic;
        this.idPublic++;
    }
}