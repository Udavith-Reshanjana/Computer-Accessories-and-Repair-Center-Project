/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lenovo
 */
public class SecondHandHardware extends ElectronicDevice {
    
    public SecondHandHardware(){}
    
    public boolean isHardwareIDValid(String hardwareID) {

        String pattern = "HW/SEC/\\d{5}";

        Pattern regexPattern1 = Pattern.compile(pattern);

        Matcher matcher = regexPattern1.matcher(hardwareID);

        return matcher.matches();
    }
}
