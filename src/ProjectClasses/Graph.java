/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectClasses;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author lenovo
 */
public class Graph {
    
    private Connection connection;

    public Graph() {
        this.connection = DatabaseConnection.getConnection();
    }
    // Repair Graph
    public ChartPanel createPieChart() {
        DefaultPieDataset dataset = fetchDataFromDatabasePieChart();
        JFreeChart chart = ChartFactory.createPieChart(
                "Repair Status", // Chart title
                dataset, // Dataset
                true, true, false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        customizePiePlot(plot);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(650, 300));

        return chartPanel;
    }

    private DefaultPieDataset fetchDataFromDatabasePieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT status, COUNT(*) FROM repair GROUP BY status");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String status = rs.getString("status");
                int count = rs.getInt("COUNT(*)");
                dataset.setValue(status, count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private void customizePiePlot(PiePlot plot) {
        plot.setSectionPaint("Pending", java.awt.Color.RED);
        plot.setSectionPaint("Started", java.awt.Color.BLUE);
        plot.setSectionPaint("Completed", java.awt.Color.GREEN);
    }
    // payment graphs
    public ChartPanel createPaymentPieChart() {
        DefaultPieDataset paymentDataset = fetchDataFromDatabasePaymnetPieChart();
        JFreeChart chart = ChartFactory.createPieChart(
                "Payment Status", // Chart title
                paymentDataset, // Dataset
                true, true, false
        );

        PiePlot paymentPlot = (PiePlot) chart.getPlot();
        customizePaymentPiePlot(paymentPlot);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(650, 300));

        return chartPanel;
    }
    private DefaultPieDataset fetchDataFromDatabasePaymnetPieChart() {
        DefaultPieDataset paymentDataset = new DefaultPieDataset();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT\n" +
                                                            "    c.type AS customerType,\n" +
                                                            "    COALESCE(SUM(p.totalAmount), 0) AS totalAmount\n" +
                                                            "FROM\n" +
                                                            "    customer c\n" +
                                                            "LEFT JOIN\n" +
                                                            "    `order` o ON c.customerID = o.customerID\n" +
                                                            "LEFT JOIN\n" +
                                                            "    payment p ON o.orderID = p.orderID\n" +
                                                            "WHERE\n" +
                                                            "    c.type IN ('Normal', 'Wholesale')\n" +
                                                            "GROUP BY\n" +
                                                            "    c.type");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String getCustomerType = rs.getString("customerType");
                int getTotalAmount = rs.getInt("totalAmount");
                paymentDataset.setValue(getCustomerType, getTotalAmount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentDataset;
    }
    private void customizePaymentPiePlot(PiePlot paymentPlot) {
        paymentPlot.setSectionPaint("Wholesale", java.awt.Color.GREEN);
        paymentPlot.setSectionPaint("Normal", java.awt.Color.YELLOW);
    }
    // wholesale graph
    public ChartPanel createWholesalePaymentPieChart() {
        DefaultPieDataset wholesalePaymentDataset = fetchDataFromDatabaseWholesalePaymnetPieChart();
        JFreeChart chart = ChartFactory.createPieChart(
                "Wholesale Customer Payment Status", // Chart title
                wholesalePaymentDataset, // Dataset
                true, true, false
        );

        PiePlot wholesalePaymentPlot = (PiePlot) chart.getPlot();
        customizeWholesalePaymentPiePlot(wholesalePaymentPlot);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(650, 300));

        return chartPanel;
    }
    private DefaultPieDataset fetchDataFromDatabaseWholesalePaymnetPieChart() {
        DefaultPieDataset wholeSaleaPymentDataset = new DefaultPieDataset();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                                    "SELECT\n" +
                                    "    CONCAT(c.customerID, ' - ', c.customerName) AS customerIdentifier,\n" +
                                    "    COALESCE(SUM(p.totalAmount), 0) AS totalAmount\n" +
                                    "FROM\n" +
                                    "    customer c\n" +
                                    "LEFT JOIN\n" +
                                    "    `order` o ON c.customerID = o.customerID\n" +
                                    "LEFT JOIN\n" +
                                    "    payment p ON o.orderID = p.orderID\n" +
                                    "WHERE\n" +
                                    "    c.type = 'Wholesale'\n" +
                                    "GROUP BY\n" +
                                    "    c.customerID, c.customerName;");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String getCustomerIdentifier = rs.getString("customerIdentifier");
                int getTotalAmount = rs.getInt("totalAmount");
                wholeSaleaPymentDataset.setValue(getCustomerIdentifier, getTotalAmount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wholeSaleaPymentDataset;
    }
    private void customizeWholesalePaymentPiePlot(PiePlot paymentPlot) {
        Map<String, Color> colorMap = generateRandomColors(paymentPlot.getDataset().getItemCount());
        for (Map.Entry<String, Color> entry : colorMap.entrySet()) {
            paymentPlot.setSectionPaint(entry.getKey(), entry.getValue());
        }
    }

    private Map<String, Color> generateRandomColors(int count) {
        Map<String, Color> colorMap = new HashMap<>();
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            colorMap.put("Color" + i, randomColor);
        }

        return colorMap;
    }
}
