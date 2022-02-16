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
 * This class is used to building histograms for different parametrs.
 * @author Ivan Ryzhankow, Alina Yermakova
 * @version 1.0.0
 */
public class Histogram extends JPanel
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
     * @param patients A list of patients.
     * @param sex Sex of patients for whom will be generated histogram.
     * @param nadpis Text allowing to choose which histogram we want to draw.
     * @return Panel with histogram.
     */
    private ChartPanel createChartPanel(ArrayList<Patient> patients, String sex, String nadpis) 
    {        
        double[] h = new double[patients.size()];
        
        switch (nadpis) {
            case ("Wiek"):
                for (int i=0; i<patients.size(); i++)
                {
                    h[i] = patients.get(i).getAge();
                }
                break;
            case ("Waga"):
                for (int i=0; i<patients.size(); i++)
                {
                    h[i] = patients.get(i).getWeight();
                }
                break;
            case ("Wzrost"):
                for (int i=0; i<patients.size(); i++)
                {
                    h[i] = patients.get(i).getHeight();
                }
                break;
            default:
                for (int i=0; i<patients.size(); i++)
                {
                    h[i] = 0;
                }
                break;
        }
        dataset.addSeries(sex, h, patients.size());
       
        JFreeChart chart = ChartFactory.createHistogram("Histogram", nadpis,
            "Iość pacjentów", dataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardXYBarPainter());
        Paint[] paintArray = {
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
     * A function which displays the panel with histogram.
     * @param patients A list of patients.
     * @param sex Sex of patients for whom will be generated histogram.
     * @param nadpis Text above the histogram.
     */
    public void display(ArrayList<Patient> patients, String sex, String nadpis) 
    {
        JFrame f = new JFrame("Raport (histogram, " + nadpis + ")");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(createChartPanel(patients, sex, nadpis));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}