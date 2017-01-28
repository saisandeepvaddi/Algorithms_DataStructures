package LearnHashTables;

/**
 * About the code : A template Person class for using in HashTables
 */


public class Person {
    private String fullName = null;
    private String address = null;

    public Person(String fullName, String address){
        this.fullName = fullName;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }



}
