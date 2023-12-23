/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
/**
 *
 * @author lenovo
 */
public class WholeSaleCustomer extends Customer {
    
    private Connection connection;
    
    public WholeSaleCustomer(){}
    
    public boolean isPersonIDValid(String pID){
        String pattern = "^(CUS/W/\\d{5})$";
        return pID.matches(pattern);
    }        
    public void generateQRCode(String customerID, String filePath) {
        int width = 300;
        int height = 300;

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(customerID, BarcodeFormat.QR_CODE, width, height);

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (bitMatrix.get(x, y)) {
                        graphics.fillRect(x, y, 1, 1);
                    }
                }
            }

            // Ensure the file path has a .png extension
            if (!filePath.toLowerCase().endsWith(".png")) {
                filePath += ".png";
            }

            ImageIO.write(image, "png", new File(filePath));
            System.out.println("QR code generated and saved successfully!");
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
