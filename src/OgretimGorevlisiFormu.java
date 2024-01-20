//import org.json.simple.JSONObject;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OgretimGorevlisiFormu extends JFrame {
//    private JTextField ogretmenNoField;
//    private JTextField adField;
//    private JTextField soyadField;
//    private JTextField bolumField;
//    private JComboBox<String> verdigiDerslerComboBox;
//    private JButton kaydetButton;
//    private JButton dersEkleButton;
//    private JButton dersSilButton;
//
//    public OgretimGorevlisiFormu() {
//        setTitle("Öğretim Görevlisi Formu");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//
//        ogretmenNoField = new JTextField();
//        adField = new JTextField();
//        soyadField = new JTextField();
//        bolumField = new JTextField();
//        verdigiDerslerComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        List<String> dersler = okuDersler("dersler.json");
//        for (String ders : dersler) {
//            verdigiDerslerComboBox.addItem(ders);
//        }
////        dersEkleButton = new JButton("Ders Ekle");
////        dersEkleButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                String yeniDers = JOptionPane.showInputDialog("Yeni Ders Adı:");
////                verdigiDerslerComboBox.addItem(yeniDers);
////            }
////        });
////        dersSilButton = new JButton("Ders Sil");
////        dersSilButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                int selectedIndex = verdigiDerslerComboBox.getSelectedIndex();
////                if (selectedIndex != -1) {
////                    verdigiDerslerComboBox.removeItemAt(selectedIndex);
////                }
////            }
////        });
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetOgretimGorevlisi();
//                dispose();
//                JOptionPane.showMessageDialog(null, "Öğretim Görevlisi başarıyla kaydedildi!");
//
//            }
//        });
//
//        add(new JLabel("Öğretmen No:"));
//        add(ogretmenNoField);
//        add(new JLabel("Adı:"));
//        add(adField);
//        add(new JLabel("Soyadı:"));
//        add(soyadField);
//        add(new JLabel("Bölümü:"));
//        add(bolumField);
////        add(new JLabel("Verdiği Dersler:"));
////        add(verdigiDerslerComboBox);
////        add(dersEkleButton);
////        add(dersSilButton);
//        add(kaydetButton);
//
//    }
//
//    private void kaydetOgretimGorevlisi() {
//        JSONObject ogretimGorevlisiJson = new JSONObject();
//        ogretimGorevlisiJson.put("OgretmenNo", Integer.parseInt(ogretmenNoField.getText()));
//        ogretimGorevlisiJson.put("Ad", adField.getText());
//        ogretimGorevlisiJson.put("Soyad", soyadField.getText());
//        ogretimGorevlisiJson.put("Bolum", bolumField.getText());
////        ogretimGorevlisiJson.put("VerdigiDersler", verdigiDerslerComboBox.getSelectedItem());
//
//        try (FileWriter file = new FileWriter("ogretimGorevlileri.json", true)) {
//            file.write(ogretimGorevlisiJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private List<String> okuDersler(String dosyaAdi) {
//        List<String> dersler = new ArrayList<>();
//        // Dersleri dosyadan okuma işlevselliği
//        return dersler;
//    }
//}
//
//// (Devam ediyor...)
//import org.json.simple.JSONObject;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OgretimGorevlisiFormu extends JFrame {
//    private JTextField ogretmenNoField;
//    private JTextField adField;
//    private JTextField soyadField;
//    private JTextField bolumField;
//    private JButton kaydetButton;
//
//    public OgretimGorevlisiFormu() {
//        setTitle("Öğretim Görevlisi Formu");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//
//        ogretmenNoField = new JTextField();
//        adField = new JTextField();
//        soyadField = new JTextField();
//        bolumField = new JTextField();
//        kaydetButton = new JButton("Kaydet");
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetOgretimGorevlisi();
//                dispose();
//                JOptionPane.showMessageDialog(null, "Öğretim Görevlisi başarıyla kaydedildi!");
//            }
//        });
//
//        add(new JLabel("Öğretmen No:"));
//        add(ogretmenNoField);
//        add(new JLabel("Adı:"));
//        add(adField);
//        add(new JLabel("Soyadı:"));
//        add(soyadField);
//        add(new JLabel("Bölümü:"));
//        add(bolumField);
//        add(kaydetButton);
//    }
//
//    private void kaydetOgretimGorevlisi() {
//        JSONObject ogretimGorevlisiJson = new JSONObject();
//        ogretimGorevlisiJson.put("OgretmenNo", Integer.parseInt(ogretmenNoField.getText()));
//        ogretimGorevlisiJson.put("Ad", adField.getText());
//        ogretimGorevlisiJson.put("Soyad", soyadField.getText());
//        ogretimGorevlisiJson.put("Bolum", bolumField.getText());
//
//        try (FileWriter file = new FileWriter("ogretimGorevlileri.json", true)) {
//            file.write(ogretimGorevlisiJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class OgretimGorevlisiFormu extends JFrame {
//    private JTextField ogretmenNoField;
//    private JTextField adField;
//    private JTextField soyadField;
//    private JTextField bolumField;
//    private JButton kaydetButton;
//
//    public OgretimGorevlisiFormu() {
//        setTitle("Öğretim Görevlisi Formu");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//
//        ogretmenNoField = new JTextField();
//        adField = new JTextField();
//        soyadField = new JTextField();
//        bolumField = new JTextField();
//        kaydetButton = new JButton("Kaydet");
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetOgretimGorevlisi();
//                dispose();
//                JOptionPane.showMessageDialog(null, "Öğretim Görevlisi başarıyla kaydedildi!");
//            }
//        });
//
//        add(new JLabel("Öğretmen No:"));
//        add(ogretmenNoField);
//        add(new JLabel("Adı:"));
//        add(adField);
//        add(new JLabel("Soyadı:"));
//        add(soyadField);
//        add(new JLabel("Bölümü:"));
//        add(bolumField);
//        add(kaydetButton);
//    }
//
//    private void kaydetOgretimGorevlisi() {
//        JSONObject ogretimGorevlisiJson = new JSONObject();
//        ogretimGorevlisiJson.put("OgretmenNo", Integer.parseInt(ogretmenNoField.getText()));
//        ogretimGorevlisiJson.put("Ad", adField.getText());
//        ogretimGorevlisiJson.put("Soyad", soyadField.getText());
//        ogretimGorevlisiJson.put("Bolum", bolumField.getText());
//
//        JSONArray ogretimGorevlileriArray = new JSONArray();
//
//        // Önce mevcut içeriği oku
//        List<JSONObject> existingData = okuOgretimGorevlileri("ogretimGorevlileri.json");
//
//        // Yeni öğretim görevlisini listeye ekle
//        existingData.add(ogretimGorevlisiJson);
//
//        // Tüm öğretim görevlilerini JSON array'e ekle
//        for (JSONObject ogretimGorevlisi : existingData) {
//            ogretimGorevlileriArray.add(ogretimGorevlisi);
//        }
//
//        try (FileWriter file = new FileWriter("ogretimGorevlileri.json")) {
//            // JSON array'i dosyaya yaz
//            file.write(ogretimGorevlileriArray.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private List<JSONObject> okuOgretimGorevlileri(String dosyaAdi) {
//        List<JSONObject> ogretimGorevlileri = new ArrayList<>();
//
//        JSONParser parser = new JSONParser();
//
//        try {
//            Object obj = parser.parse(new FileReader(dosyaAdi));
//
//            // JSON array okuma
//            JSONArray jsonArray = (JSONArray) obj;
//
//            // Iterator kullanarak array içinde dolaşma
//            Iterator<JSONObject> iterator = jsonArray.iterator();
//            while (iterator.hasNext()) {
//                ogretimGorevlileri.add(iterator.next());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return ogretimGorevlileri;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new OgretimGorevlisiFormu().setVisible(true);
//            }
//        });
//    }
//}
//
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OgretimGorevlisiFormu extends JFrame {
    private JTextField ogretmenNoField;
    private JTextField adField;
    private JTextField soyadField;
    private JTextField bolumField;
    private JButton kaydetButton;
    private JTable ogretimGorevlisiTable;
    private JTextField filterTextField;

    private DefaultTableModel tableModel;

    public OgretimGorevlisiFormu() {
        setTitle("Öğretim Görevlisi Formu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel solPanel = new JPanel();
        solPanel.setLayout(new GridLayout(6, 2));
        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setResizable(false);

        ogretmenNoField = new JTextField();
        adField = new JTextField();
        soyadField = new JTextField();
        bolumField = new JTextField();
        kaydetButton = new JButton("Kaydet");

        tableModel = new DefaultTableModel();
        ogretimGorevlisiTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(ogretimGorevlisiTable);

        filterTextField = new JTextField();
        filterTextField.setColumns(20);
        filterTextField.setBorder(new EmptyBorder(5, 10, 5, 10));
        filterTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterOgretimGorevlisiTable();
            }
        });

        solPanel.add(createLabel("Öğretmen No:"));
        solPanel.add(ogretmenNoField);
        solPanel.add(createLabel("Adı:"));
        solPanel.add(adField);
        solPanel.add(createLabel("Soyadı:"));
        solPanel.add(soyadField);
        solPanel.add(createLabel("Bölümü:"));
        solPanel.add(bolumField);
        solPanel.add(new JLabel());
        solPanel.add(kaydetButton);

        solPanel.add(new JPanel()); // Boş panel, düzeni korumak için eklendi

        add(solPanel, BorderLayout.WEST);
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filterPanel.add(createLabel("Filtrele:"));
        filterPanel.add(filterTextField);

        add(filterPanel, BorderLayout.NORTH);

        String[] columnNames = {"Öğretmen No", "Ad", "Soyad", "Bölüm"};
        tableModel.setColumnIdentifiers(columnNames);

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kaydetOgretimGorevlisi();
                refreshOgretimGorevlisiTable();
                JOptionPane.showMessageDialog(null, "Öğretim Görevlisi başarıyla kaydedildi!");
            }
        });

        refreshOgretimGorevlisiTable();
    }

    private void kaydetOgretimGorevlisi() {
        JSONObject ogretimGorevlisiJson = new JSONObject();
        ogretimGorevlisiJson.put("OgretmenNo", Integer.parseInt(ogretmenNoField.getText()));
        ogretimGorevlisiJson.put("Ad", adField.getText());
        ogretimGorevlisiJson.put("Soyad", soyadField.getText());
        ogretimGorevlisiJson.put("Bolum", bolumField.getText());

        try (FileWriter file = new FileWriter("ogretimGorevlileri.json", true)) {
            file.write(ogretimGorevlisiJson.toJSONString() + "\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void refreshOgretimGorevlisiTable() {
        tableModel.setRowCount(0);
        List<JSONObject> ogretimGorevlileri = okuOgretimGorevlileri("ogretimGorevlileri.json");
        for (JSONObject ogretimGorevlisi : ogretimGorevlileri) {
            Object[] row = {
                    ogretimGorevlisi.get("OgretmenNo"),
                    ogretimGorevlisi.get("Ad"),
                    ogretimGorevlisi.get("Soyad"),
                    ogretimGorevlisi.get("Bolum")
            };
            tableModel.addRow(row);
        }
    }

    private List<JSONObject> okuOgretimGorevlileri(String dosyaAdi) {
        List<JSONObject> ogretimGorevlileri = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(dosyaAdi)) {
            Object obj = parser.parse(reader);

            if (obj instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) obj;

                for (Object o : jsonArray) {
                    if (o instanceof JSONObject) {
                        ogretimGorevlileri.add((JSONObject) o);
                    }
                }
            } else {
                System.err.println("Invalid JSON format. Expected JSONArray.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return ogretimGorevlileri;
    }


    private void filterOgretimGorevlisiTable() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        ogretimGorevlisiTable.setRowSorter(sorter);

        String text = filterTextField.getText().toLowerCase();
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBorder(new EmptyBorder(5, 5, 5, 10));
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OgretimGorevlisiFormu().setVisible(true);
            }
        });
    }
}
