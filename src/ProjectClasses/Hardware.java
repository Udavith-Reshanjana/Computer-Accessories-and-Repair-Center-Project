/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

/**
 *
 * @author lenovo
 */
public interface Hardware {
    
    public void closeConnection();
    public boolean isHardwareExist(String hardwareID);
    public boolean isHardwareIDValid(String hardwareID);
    public boolean isHardwareQtyValid(String qty);
    public boolean isHardwareUsageTimeValid(String usagetime);
    public boolean isHardwareUnitPriceValid(String unitprice);
    public void addHardware(String hardwareID, String hardwareName, String brandName, String hardwareType, double unitprice, int qty, String importedCountry, int usageTime);
    public void deleteHardware(String hardwareID);
    public void updateHardware(String hardwareID, String hardwareName, String brandName, String hardwareType, double unitprice, int qty, String importedCountry, int usageTime);
    public void showHardwareDetails(javax.swing.JTable table);
    public int parseIntegerValue(Object value);
    public double parseDoubleValue(Object value);
}
