import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerDataList = new ArrayList<>();
    static {
        customerDataList.add(new Customer("4567","Nimal","Colombo",25000));
        customerDataList.add(new Customer("4568","Banda","Jaffna",35000));
        customerDataList.add(new Customer("4569","Thisara","Matara",15000));
        customerDataList.add(new Customer("4570","Eshara","Galle",27000));
    }
}
