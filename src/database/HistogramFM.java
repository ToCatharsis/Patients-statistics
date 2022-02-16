package database;

import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;

/**
 * This class is used to compare histograms for men and women.
 * @author Ivan Ryzhankow, Alina Yermakova
 * @version 1.0.0
 */
public class HistogramFM extends JPanel 
{
    /**
     * Dataset used to create histograms.
     */
    private HistogramDataset dataset = new HistogramDataset();
    
    /**
     * A renderer which draws XY bars.
     */
    private XYBarRenderer renderer;


    /**
     * A function which creates a panel with a histogram.
     * @param nadpis Text allowing to choose which histogram we want to draw.
     * @param minWg The lowest weight of the patients.
     * @param maxWg The highest weight of the patients.
     * @param minWz The lowest height of the patients.
     * @param maxWz The highest height of the patients.
     * @param minWk The lowest age of the patients.
     * @param maxWk The highest age of the patients.
     * @return Panel with histogtram.
     * @throws Exception 
     */
    private ChartPanel createChartPanel(String nadpis, double minWg, 
             double maxWg, double minWz, double maxWz, int minWk, int maxWk) throws Exception {
        
        Database databaseF = new Database();
        databaseF.readFileSex(databaseF.patients, "Female", minWg, maxWg, minWz, maxWz, minWk, maxWk);
        double[] hF = new double[databaseF.patients.size()];
        Database databaseM = new Database();
        databaseM.readFileSex(databaseM.patients, "Male", minWg, maxWg, minWz, maxWz, minWk, maxWk);
        double[] hM = new double[databaseM.patients.size()];
        
        switch (nadpis) {
            case ("Wiek"):
                for (int i=0; i<databaseF.patients.size(); i++)
                {
                    hF[i] = databaseF.patients.get(i).getAge();
                }
                for (int i=0; i<databaseM.patients.size(); i++)
                {
                    hM[i] = databaseM.patients.get(i).getAge();
                }
                break;
            case ("Waga"):
                for (int i=0; i<databaseF.patients.size(); i++)
                {
                    hF[i] = databaseF.patients.get(i).getWeight();
                }
                for (int i=0; i<databaseM.patients.size(); i++)
                {
                    hM[i] = databaseM.patients.get(i).getWeight();
                }
                break;
            case ("Wzrost"):
                for (int i=0; i<databaseF.patients.size(); i++)
                {
                    hF[i] = databaseF.patients.get(i).getHeight();
                }
                for (int i=0; i<databaseM.patients.size(); i++)
                {
                    hM[i] = databaseM.patients.get(i).getHeight();
                }
                break;
            default:
                for (int i=0; i<databaseF.patients.size(); i++)
                {
                    hF[i] = 0;
                }
                for (int i=0; i<databaseM.patients.size(); i++)
                {
                    hM[i] = 0;
                }
                break;
        }
        int size;
        if (databaseF.patients.size()>databaseM.patients.size()) {
            size = databaseF.patients.size();}
        else {
            size = databaseM.patients.size();}
        dataset.addSeries("Female", hF, size);
        dataset.addSeries("Male", hM, size);
       
        JFreeChart chart = ChartFactory.createHistogram("Histogram", nadpis,
            "Iość pacjentów", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardXYBarPainter());
        Paint[] paintArray = {
            new Color(0xffff0000, true),
            new Color(0xff0053fa, true),
        };
        plot.setDrawingSupplier(new DefaultDrawingSupplier(
            paintArray,
            DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
            DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE));
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        return panel;
    }
    

    /**
     * A function which displays drew chart.
     * @param nadpis
     * @param minWg The lowest weight of the patients.
     * @param maxWg The highest weight of the patients.
     * @param minWz The lowest height of the patients.
     * @param maxWz The highest height of the patients.
     * @param minWk The lowest age of the patients.
     * @param maxWk The highest age of the patients.
     * @throws Exception 
     */
     public void display(String nadpis, double minWg, 
             double maxWg, double minWz, double maxWz, int minWk, int maxWk) throws Exception {
        JFrame f = new JFrame("Raport (histogram, " + nadpis + ")");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createChartPanel(nadpis, minWg, maxWg, minWz, maxWz, minWk, maxWk));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    } 
}




