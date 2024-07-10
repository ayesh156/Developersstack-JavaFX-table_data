import javafx.scene.control.Button; // don't use AWT Button

public class CustomerTM {
    String nic;
    String name;
    String address;
    double salary;

    public CustomerTM() {
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public CustomerTM(String nic, String name, String address, double salary, Button btn) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.btn = btn;
    }

    Button btn;
}
