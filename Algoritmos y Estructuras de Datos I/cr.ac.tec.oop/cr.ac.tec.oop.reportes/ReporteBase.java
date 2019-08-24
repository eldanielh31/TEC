import java.util.Date;
import java.util.List;

public class ReporteBase {
    private String name;
    private Date date;
    protected List items;

    public ReporteBase(List Items, String Name, Date Date){
        this.name=Name;
        this.date=Date;
        this.items=Items;
    }

    public void Generar(){



    }


}