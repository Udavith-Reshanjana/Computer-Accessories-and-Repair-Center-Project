/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

/**
 *
 * @author lenovo
 */
public abstract class Person {

    private String personID;
    private String fName;
    private String mName;
    private String lName;
    private String NIC;
    private String address;
    private String phoneNumbers;
    private String type;
    private String username;
    private String password;

    public Person(){}
    public Person(String pID, String fullName, String personNIC, String add, String type) {
        personID = pID;
        fName = fullName;
        NIC = personNIC;
        address = add;
        this.type = type;
    }
    public Person(String pID, String fullName, String personNIC, String add, String type, String username, String password) {
        personID = pID;
        fName = fullName;
        NIC = personNIC;
        address = add;
        this.type = type;
        this.username = username;
        this.password = password;
    }
    public Person(String pID, String fName, String lName, String personNIC, String add, String pNum, String role, String username, String password) {
        personID = pID;
        this.fName = fName;
        this.lName = lName;
        NIC = personNIC;
        address = add;
        phoneNumbers = pNum;
        this.type = role;
        this.username = username;
        this.password = password;
    }
    public Person(String pID, String fName, String mName, String lName, String personNIC, String add, String pNum, String role, String username, String password) {
        personID = pID;
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.NIC = personNIC;
        this.address = add;
        this.phoneNumbers = pNum;
        this.type = role;
        this.username = username;
        this.password = password;
    }
    public Person(String pID, String pNum) {
        personID = pID;
        phoneNumbers = pNum;
    }

    public String getPersonID() {
        return personID;
    }
    public String getFirstName() {
        return fName;
    }
    public String getMiddleName() {
        return mName;
    }
    public String getLastName() {
        return lName;
    } 
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumbers;
    }
    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return username;
    }
    public String getNIC() {
        return NIC;
    }
    public String getType() {
        return type;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }
    public void setFirstName(String fName) {
        this.fName = fName;
    }
    public void setMiddleName(String mName) {
        this.mName = mName;
    }
    public void setLastName(String lName) {
        this.lName = lName;
    }
    public void setAddress(String add) {
            address = add;
    }
    public void setPhoneNumber(String phoNum) {
        this.phoneNumbers = phoNum;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
    
    public abstract boolean checkLogin(String role, String username, String password);
    public abstract boolean isPersonExist(String pID);
    public boolean isNICValid(String NICnum){
        switch (NICnum.length()) {
            case 12 -> {
                if (NICnum.matches("\\d{12}") == true) {
                    return true;
                }
                else {
                    return false;
                }
            }
            case 9 -> {
                if (NICnum.charAt(8) == 'v'|| NICnum.charAt(8) == 'V') {
                    if (NICnum.substring(0, 8).matches("\\d{8}") == true) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            default -> {
                return false;
            }
        }
    }
    public abstract boolean isPersonPhoneNumberExist(String pID, String phoneNumbers);
    public boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.length() == 12 && phoneNumber.startsWith("+94")) {
            return phoneNumber.substring(3).matches("(11|70|71|72|75|76|77|78)\\d{7}");
        } else if (phoneNumber.length() == 10 && phoneNumber.startsWith("0")) {            
            return phoneNumber.substring(1).matches("(11|70|71|72|75|76|77|78)\\d{7}");
        } else if (phoneNumber.length() == 9) {            
            return phoneNumber.substring(0, 2).matches("(11|70|71|72|75|76|77|78)") && phoneNumber.substring(2).matches("\\d{7}");
        }
        return false;
    }
    public abstract boolean isPhoneNumberDuplicated(String phoneNumbers);
    public abstract boolean isPersonIDValid(String pID);
    public abstract void addPerson(String pID, String fName, String mName, String lName, String personNIC, String add, String role, String username, String password);
    public abstract void deletePerson(String pID);
    public abstract void updatePerson(String pID, String fName, String mName, String lName, String personNIC, String add, String role, String username, String password);
    public abstract void addPhoneNumber(String pID, String phoneNumbers);
    public abstract void updatePhoneNumber(String pID, String oldpPhoneNumbers, String newPhoneNumbers);
    public abstract void deletePhoneNumber(String pID, String oldpPhoneNumbers);
    public abstract void showPrsonDetails(javax.swing.JTable table);
    public abstract void showPrsonContactDetails(javax.swing.JTable table);
}

