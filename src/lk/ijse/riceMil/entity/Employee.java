package lk.ijse.riceMil.entity;

public class Employee {
    private String nic;
    private String name;
    private String address;
    private String mobileNo;
    private String userName;
    private String password;

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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee(String nic, String name, String address, String mobileNo, String userName, String password) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.mobileNo = mobileNo;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Employee(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
