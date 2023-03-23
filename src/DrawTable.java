import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
public class DrawTable {
	public static void main() {
        Runnable r = new Runnable() {

            public void run() {
                new DrawTable().createUI();
            }
        };

        EventQueue.invokeLater(r);
    }

    private void createUI() {

        try {
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            JTable table = new JTable();

            TableModel tableModel = new TableModel();
            BufferedReader file = new BufferedReader(new  FileReader("d:\\davidSort.txt"));
            String line;
            file.readLine();

            List<Line> iterativeList = new ArrayList<Line>();
            while((line = file.readLine()) != null) {
                String[] splits = line.split(",");
                //String digits = line.replaceAll("[^0-9.]", "");
                Line linee = new Line();
                linee.setSize( Integer.parseInt(splits[0]) );
                linee.setAvgCount1(Double.parseDouble(splits[1].trim()) );
                linee.setCoefCount1(Double.parseDouble(splits[2]) );
                linee.setAvgTime1( Double.parseDouble(splits[3]) );
                linee.setCoefTime1( Double.parseDouble(splits[4].trim()) );
                linee.setAvgCount2( Double.parseDouble(splits[5].trim()) );
                linee.setCoefCount2(Double.parseDouble(splits[6].trim()) );
                linee.setAvgTime2(Double.parseDouble(splits[7].trim()) );
                linee.setCoefTime2(Double.parseDouble(splits[8].trim()) );
                iterativeList.add( linee );
                
            }
    
            
            tableModel.setList(iterativeList);
            table.setModel(tableModel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(table));
            frame.setTitle("David Benchmark");
            frame.pack();
            frame.setVisible(true);

        } catch(IOException ex) {}
    }

    class Line {

        private int size;
        private double avgCount1;
        private double coefCount1;
        private double avgTime1;
        private double coefTime1;
        private double avgCount2;
        private double coefCount2;
        private double avgTime2;
        private double coefTime2;

        public int getSize() {
            return this.size;
        }
        public void setSize(int size) {
            this.size = size;
        }
        public double getAvgCount1() {
            return this.avgCount1;
        }
        public void setAvgCount1(double avgCount1) {
            this.avgCount1 = avgCount1;
        }
        public double getCoefCount1() {
            return this.coefCount1;
        }
        public void setCoefCount1(double coefCount1) {
            this.coefCount1 = coefCount1;
        }
        public double getAvgTime1() {
            return this.avgTime1;
        }
        public void setAvgTime1(double avgTime1) {
            this.avgTime1 = avgTime1;
        }
        public double getCoefTime1() {
            return this.coefTime1;
        }
        public void setCoefTime1(double coefTime1) {
            this.coefTime1 = coefTime1;
        }
        public void getCoefTime1(double coefTime1) {
            this.coefTime1 = coefTime1;
        }
        
        public double getAvgCount2() {
            return this.avgCount2;
        }
        public void setAvgCount2(double avgCount2) {
            this.avgCount2 = avgCount2;
        }
        public double getCoefCount2() {
            return this.coefCount2;
        }
        public void setCoefCount2(double coefCount2) {
            this.coefCount2 = coefCount2;
        }
        public double getAvgTime2() {
            return this.avgTime2;
        }
        public void setAvgTime2(double avgTime2) {
            this.avgTime2 = avgTime2;
        }
        public double getCoefTime2() {
            return this.coefTime2;
        }
        
        public void setCoefTime2(double coefTime2) {
            this.coefTime2 = coefTime2;
        }
        public void getCoefTime2(double coefTime2) {
            this.coefTime2 = coefTime2;
        }
    }

    class TableModel extends AbstractTableModel {

        private List<Line> list = new ArrayList<Line>();
        private String[] columnNames = { "Size", "Avg Count1", "Coef Count1", "Avg Time1", "Coef Time1","Avg Count2", "Coef Count2", "Avg Time2", "Coef Time2"};

        public void setList(List<Line> list) {
            this.list = list;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public int getRowCount() {
        	int nn = list.size();
            return list.size();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return list.get(rowIndex).getSize();
                case 1:
                    return list.get(rowIndex).getAvgCount1();
                case 2:
                    return list.get(rowIndex).getCoefCount1();
                case 3:
                    return list.get(rowIndex).getAvgTime1();
                case 4:
                    return list.get(rowIndex).getCoefTime1();
                case 5:
                    return list.get(rowIndex).getAvgCount2();
                case 6:
                    return list.get(rowIndex).getCoefCount2();
                case 7:
                    return list.get(rowIndex).getAvgTime2();
                case 8:
                    return list.get(rowIndex).getCoefTime2();
                default:
                    return null;
                  
            }
        }
    }

}
