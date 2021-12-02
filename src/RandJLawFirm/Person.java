package RandJLawFirm;

public class Person {

    private String FirstName;
    private String LastName;
    private String Phone;

    public Person() {
    }

    public Person(String FirstName, String LastName, String Phone) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
