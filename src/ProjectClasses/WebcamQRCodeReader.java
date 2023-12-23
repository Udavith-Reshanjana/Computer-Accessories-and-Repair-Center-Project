package ProjectClasses;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import org.opencv.imgproc.Imgproc;

public class WebcamQRCodeReader {
    
    private JFrame frame;
    private JLabel lblImage;
    private boolean isCameraRunning;
    private String decodedText;
    private volatile boolean isCameraActive = true;
    private volatile boolean isRunning;
    private volatile boolean stopReading = false;

    static {
        // Load the OpenCV native library
        System.load("C:\\Users\\lenovo\\Downloads\\opencv\\build\\java\\x64\\opencv_java480.dll");
    }

    public void startReading1() {
        VideoCapture camera = new VideoCapture(0);
        if (!camera.isOpened()) {
            System.out.println("Error: Camera not opened.");
            return;
        }

        try {
            while (!stopReading && isCameraActive) {
                Mat frameMat = new Mat();
                camera.read(frameMat);

                String decodedText = readQRCode(frameMat);

                if (decodedText != null) {
                    System.out.println("Decoded QR Code: " + decodedText);
                    stopReading = true;  // Stop reading after the first QR code is detected
                }

                displayFrame(frameMat);

                // Release the frame
                frameMat.release();

                // Add a shorter delay to capture frames more frequently
                try {
                    Thread.sleep(100);  // Adjust the sleep duration as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            camera.release();
            System.out.println("Camera terminated successfully.");
            JOptionPane.showMessageDialog(null, "Camera terminated successfully.");
            closeWebcamUI();
        }
    }
    public String startReading() {
        VideoCapture camera = new VideoCapture(0);
        if (!camera.isOpened()) {
            System.out.println("Error: Camera not opened.");
            return null;
        }

        try {
            while (!stopReading && isCameraActive) {
                Mat frameMat = new Mat();
                camera.read(frameMat);

                String decodedText = readQRCode(frameMat);

                if (decodedText != null) {
                    System.out.println("Decoded QR Code: " + decodedText);

                    // Validate the person ID using the Wholesale class method
                    WholeSaleCustomer wholesale = new WholeSaleCustomer();
                    if (wholesale.isPersonIDValid(decodedText)) {
                        JOptionPane.showMessageDialog(null, "QR code is recognized successfully.");
                        stopReading = true;  // Stop reading after the first valid QR code is detected
                        return decodedText;  // Return the decoded text
                    } else {
                        System.out.println("Invalid Person ID: " + decodedText);
                        JOptionPane.showMessageDialog(null, "This is an invalid QR code.");
//                        camera.release();
                            return null;
                    }
                }

                displayFrame(frameMat);

                // Release the frame
                frameMat.release();

                // Add a delay to make it more visible (adjust the value as needed)
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            camera.release();
            System.out.println("Camera terminated successfully.");
            JOptionPane.showMessageDialog(null, "Camera terminated successfully.");
        }

        return null;  // Return null if no valid QR code is detected
    }


    private void closeWebcamUI() {
        SwingUtilities.invokeLater(() -> {
            frame.dispose();
            System.out.println("Webcam UI terminated successfully.");
        });
    }

    public void stopReading() {
        stopReading = true;
    }

    private String readQRCode(Mat frame) {
        try {
            BufferedImage image = matToBufferedImage(frame);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Result result = new MultiFormatReader().decode(binaryBitmap);

            return result.getText();
        } catch (NotFoundException e) {
            return null;
        }
    }

    private BufferedImage matToBufferedImage(Mat mat) {
        Mat resizedMat = new Mat();
        Imgproc.resize(mat, resizedMat, new Size(640, 480));  // Resize for display
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".png", resizedMat, matOfByte);
        byte[] byteArray = matOfByte.toArray();

        try {
            return ImageIO.read(new ByteArrayInputStream(byteArray));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void displayFrame(Mat frameMat) {
        BufferedImage image = matToBufferedImage(frameMat);
        ImageIcon icon = new ImageIcon(image);
        SwingUtilities.invokeLater(() -> lblImage.setIcon(icon));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WebcamQRCodeReader reader = new WebcamQRCodeReader();
            reader.initialize();
            Thread webcamThread = new Thread(reader::startReading);
            webcamThread.start();
        });
    }

    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblImage = new JLabel();
        frame.getContentPane().add(lblImage);
        frame.setVisible(true);
    }
    public void stopCamera() {
        isCameraActive = false;
    }
    public void closeCameraUI() {
    // Close the camera UI (replace 'frame' with the actual variable name of your JFrame)
        frame.dispose();
    }
    public boolean isStopReading() {
        return stopReading;
    }
    public void setStopReading(boolean stopReading) {
        this.stopReading = stopReading;
    }
}



