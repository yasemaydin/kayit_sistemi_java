//import org.json.simple.JSONObject;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JTextField ogretimGorevlisiField;
//    private JButton kaydetButton;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiField = new JTextField();
//        kaydetButton = new JButton("Kaydet");
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//                dispose();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        add(new JLabel("Ders Kodu:"));
//        add(dersKoduField);
//        add(new JLabel("Ders Adı:"));
//        add(dersAdField);
//        add(new JLabel("Dönem:"));
//        add(dersDonemField);
//        add(new JLabel("Öğretim Görevlisi:"));
//        add(ogretimGorevlisiField);
//        add(kaydetButton);
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiField.getText());
//
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//// (Devam ediyor...)
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox; // Değişiklik burada
//    private JButton kaydetButton;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>(); // Değişiklik burada
//        kaydetButton = new JButton("Kaydet");
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//                dispose();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        add(new JLabel("Ders Kodu:"));
//        add(dersKoduField);
//        add(new JLabel("Ders Adı:"));
//        add(dersAdField);
//        add(new JLabel("Dönem:"));
//        add(dersDonemField);
//        add(new JLabel("Öğretim Görevlisi:"));
//        add(ogretimGorevlisiComboBox);
//        add(kaydetButton);
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader(dosyaAdi)) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JList<String> dersListesi; // Yeni eklendi
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(600, 300); // Genişlik arttırıldı
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        // Ders bilgileri giriş alanları
//        JPanel dersBilgileriPanel = new JPanel();
//        dersBilgileriPanel.setLayout(new GridLayout(5, 2));
//        dersBilgileriPanel.add(new JLabel("Ders Kodu:"));
//        dersKoduField = new JTextField();
//        dersBilgileriPanel.add(dersKoduField);
//        dersBilgileriPanel.add(new JLabel("Ders Adı:"));
//        dersAdField = new JTextField();
//        dersBilgileriPanel.add(dersAdField);
//        dersBilgileriPanel.add(new JLabel("Dönem:"));
//        dersDonemField = new JTextField();
//        dersBilgileriPanel.add(dersDonemField);
//        dersBilgileriPanel.add(new JLabel("Öğretim Görevlisi:"));
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        dersBilgileriPanel.add(ogretimGorevlisiComboBox);
//        kaydetButton = new JButton("Kaydet");
//        dersBilgileriPanel.add(kaydetButton);
//
//        // Ders listesi
//        DefaultListModel<String> dersListModel = new DefaultListModel<>();
//        dersListesi = new JList<>(dersListModel);
//        JScrollPane dersListesiScrollPane = new JScrollPane(dersListesi);
//
//        // Ana pencere düzeni
//        setLayout(new GridLayout(1, 2));
//        add(dersBilgileriPanel);
//        add(dersListesiScrollPane);
//
//        // Kaydet butonu olay dinleyicisi
//        kaydetButton.addActionListener(e -> {
//            kaydetDers();
//            refreshDersListesi(); // Ders listesini güncelle
//        });
//
//        // Öğretim görevlisi verilerini oku ve comboBox'a ekle
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        // İlk açılışta ders listesini güncelle
//        refreshDersListesi();
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersListesi() {
//        DefaultListModel<String> dersListModel = (DefaultListModel<String>) dersListesi.getModel();
//        dersListModel.clear();
//
//        // Dersleri oku ve listeye ekle
//        List<String> dersler = okuDersler("dersler.json");
//        for (String ders : dersler) {
//            dersListModel.addElement(ders);
//        }
//    }
//
//    private List<String> okuDersler(String dosyaAdi) {
//        List<String> dersler = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader(dosyaAdi)) {
//            JSONArray derslerArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : derslerArray) {
//                JSONObject ders = (JSONObject) obj;
//                String dersBilgisi = "Ders Kodu: " + ders.get("DersKodu") +
//                        ", Ders Adı: " + ders.get("DersAd") +
//                        ", Dönem: " + ders.get("DersDonem") +
//                        ", Öğretim Görevlisi: " + ders.get("OgretimGorevlisi");
//                dersler.add(dersBilgisi);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return dersler;
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (FileReader reader = new FileReader(dosyaAdi)) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            DersFormu dersFormu = new DersFormu();
//            dersFormu.setVisible(true);
//        });
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JList<String> dersListesi;
//
//    private DefaultListModel<String> dersListModel;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(600, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new GridLayout(1, 2));
//
//        JPanel solPanel = new JPanel();
//        solPanel.setLayout(new BoxLayout(solPanel, BoxLayout.Y_AXIS));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        dersListModel = new DefaultListModel<>();
//        dersListesi = new JList<>(dersListModel);
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//
//                refreshDersListesi();
//                dispose();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        solPanel.add(new JLabel("Ders Kodu:"));
//        solPanel.add(dersKoduField);
//        solPanel.add(new JLabel("Ders Adı:"));
//        solPanel.add(dersAdField);
//        solPanel.add(new JLabel("Dönem:"));
//        solPanel.add(dersDonemField);
//        solPanel.add(new JLabel("Öğretim Görevlisi:"));
//        solPanel.add(ogretimGorevlisiComboBox);
//        solPanel.add(kaydetButton);
//
//        add(solPanel);
//        add(new JScrollPane(dersListesi));
//
//        refreshDersListesi(); // Uygulama başladığında mevcut dersleri listele
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        yazdirDers(dersJson);
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    private void yazdirDers(JSONObject dersJson) {
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersListesi() {
//        dersListModel.clear();
//        List<String> dersler = okuDersler("dersler.json");
//        for (String ders : dersler) {
//            dersListModel.addElement(ders);
//        }
//    }
//
//    private List<String> okuDersler(String dosyaAdi) {
//        List<String> dersler = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                JSONObject ders = (JSONObject) jsonParser.parse(line);
//                String dersBilgisi = "Ders Kodu: " + ders.get("DersKodu") +
//                        ", Ders Adı: " + ders.get("DersAd") +
//                        ", Dönem: " + ders.get("DersDonem") +
//                        ", Öğretim Görevlisi: " + ders.get("OgretimGorevlisi");
//                dersler.add(dersBilgisi);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return dersler;
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DersFormu().setVisible(true);
//            }
//        });
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JTable dersTablosu;
//
//    private DefaultTableModel tabloModel;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(800, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel solPanel = new JPanel();
//        solPanel.setLayout(new GridLayout(5, 2));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        tabloModel = new DefaultTableModel();
//        tabloModel.addColumn("Ders Kodu");
//        tabloModel.addColumn("Ders Adı");
//        tabloModel.addColumn("Dönem");
//        tabloModel.addColumn("Öğretim Görevlisi");
//
//        dersTablosu = new JTable(tabloModel);
//
//        solPanel.add(new JLabel("Ders Kodu:"));
//        solPanel.add(dersKoduField);
//        solPanel.add(new JLabel("Ders Adı:"));
//        solPanel.add(dersAdField);
//        solPanel.add(new JLabel("Dönem:"));
//        solPanel.add(dersDonemField);
//        solPanel.add(new JLabel("Öğretim Görevlisi:"));
//        solPanel.add(ogretimGorevlisiComboBox);
//        solPanel.add(kaydetButton);
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//                refreshDersListesi();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        add(solPanel, BorderLayout.WEST);
//        add(new JScrollPane(dersTablosu), BorderLayout.CENTER);
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        refreshDersListesi();
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        yazdirDers(dersJson);
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    private void yazdirDers(JSONObject dersJson) {
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersListesi() {
//        tabloModel.setRowCount(0); // Tabloyu temizle
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("dersler.json"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                JSONObject ders = (JSONObject) new JSONParser().parse(line);
//                Object[] row = {ders.get("DersKodu"), ders.get("DersAd"), ders.get("DersDonem"), ders.get("OgretimGorevlisi")};
//                tabloModel.addRow(row);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new DersFormu().setVisible(true));
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JTable dersTable;
//    private JTextField filterTextField;
//
//    private DefaultTableModel tableModel;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(600, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel solPanel = new JPanel();
//        solPanel.setLayout(new GridLayout(6, 2));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        tableModel = new DefaultTableModel();
//        dersTable = new JTable(tableModel);
//        JScrollPane tableScrollPane = new JScrollPane(dersTable);
//
//        filterTextField = new JTextField();
//        filterTextField.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                filterDersTable();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                filterDersTable();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                filterDersTable();
//            }
//        });
//
//        solPanel.add(new JLabel("Ders Kodu:"));
//        solPanel.add(dersKoduField);
//        solPanel.add(new JLabel("Ders Adı:"));
//        solPanel.add(dersAdField);
//        solPanel.add(new JLabel("Dönem:"));
//        solPanel.add(dersDonemField);
//        solPanel.add(new JLabel("Öğretim Görevlisi:"));
//        solPanel.add(ogretimGorevlisiComboBox);
//        solPanel.add(new JLabel("Filtrele:"));
//        solPanel.add(filterTextField);
//        solPanel.add(kaydetButton);
//
//        add(solPanel, BorderLayout.WEST);
//        add(tableScrollPane, BorderLayout.CENTER);
//
//        String[] columnNames = {"Ders Kodu", "Ders Adı", "Dönem", "Öğretim Görevlisi"};
//        tableModel.setColumnIdentifiers(columnNames);
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//                refreshDersTable();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        refreshDersTable(); // Uygulama başladığında mevcut dersleri listele
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        yazdirDers(dersJson);
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    private void yazdirDers(JSONObject dersJson) {
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersTable() {
//        tableModel.setRowCount(0);
//        List<String> dersler = okuDersler("dersler.json");
//
//        for (String ders : dersler) {
//            String[] dersBilgisi = ders.split(",");
//            tableModel.addRow(dersBilgisi);
//        }
//    }
//
//    private List<String> okuDersler(String dosyaAdi) {
//        List<String> dersler = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                JSONObject ders = (JSONObject) jsonParser.parse(line);
//                String dersBilgisi = ders.get("DersKodu") + ", " +
//                        ders.get("DersAd") + ", " +
//                        ders.get("DersDonem") + ", " +
//                        ders.get("OgretimGorevlisi");
//                dersler.add(dersBilgisi);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return dersler;
//    }
//
//    private void filterDersTable() {
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
//        dersTable.setRowSorter(sorter);
//
//        String text = filterTextField.getText().toLowerCase();
//        if (text.trim().length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DersFormu().setVisible(true);
//            }
//        });
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JTable dersTable;
//    private JTextField filterTextField;
//
//    private DefaultTableModel tableModel;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(800, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel solPanel = new JPanel();
//        solPanel.setLayout(new GridLayout(6, 2));
//        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        tableModel = new DefaultTableModel();
//        dersTable = new JTable(tableModel);
//        JScrollPane tableScrollPane = new JScrollPane(dersTable);
//
//        filterTextField = new JTextField();
//        filterTextField.setBorder(new EmptyBorder(5, 5, 5, 5));
//        filterTextField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                filterDersTable();
//            }
//        });
//
//        solPanel.add(new JLabel("Ders Kodu:"));
//        solPanel.add(dersKoduField);
//        solPanel.add(new JLabel("Ders Adı:"));
//        solPanel.add(dersAdField);
//        solPanel.add(new JLabel("Dönem:"));
//        solPanel.add(dersDonemField);
//        solPanel.add(new JLabel("Öğretim Görevlisi:"));
//        solPanel.add(ogretimGorevlisiComboBox);
//        solPanel.add(new JLabel("Filtrele:"));
//        solPanel.add(filterTextField);
//        solPanel.add(kaydetButton);
//
//        add(solPanel, BorderLayout.WEST);
//        add(tableScrollPane, BorderLayout.CENTER);
//
//        String[] columnNames = {"Ders Kodu", "Ders Adı", "Dönem", "Öğretim Görevlisi"};
//        tableModel.setColumnIdentifiers(columnNames);
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//                refreshDersTable();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        refreshDersTable(); // Uygulama başladığında mevcut dersleri listele
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        yazdirDers(dersJson);
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    private void yazdirDers(JSONObject dersJson) {
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersTable() {
//        tableModel.setRowCount(0);
//        List<String> dersler = okuDersler("dersler.json");
//
//        for (String ders : dersler) {
//            String[] dersBilgisi = ders.split(",");
//            tableModel.addRow(dersBilgisi);
//        }
//    }
//
//    private List<String> okuDersler(String dosyaAdi) {
//        List<String> dersler = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                JSONObject ders = (JSONObject) jsonParser.parse(line);
//                String dersBilgisi = ders.get("DersKodu") + ", " +
//                        ders.get("DersAd") + ", " +
//                        ders.get("DersDonem") + ", " +
//                        ders.get("OgretimGorevlisi");
//                dersler.add(dersBilgisi);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return dersler;
//    }
//
//    private void filterDersTable() {
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
//        dersTable.setRowSorter(sorter);
//
//        String text = filterTextField.getText().toLowerCase();
//        if (text.trim().length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DersFormu().setVisible(true);
//            }
//        });
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JTable dersTable;
//    private JTextField filterTextField;
//
//    private DefaultTableModel tableModel;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(800, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel solPanel = new JPanel();
//        solPanel.setLayout(new GridLayout(7, 2));
//        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        tableModel = new DefaultTableModel();
//        dersTable = new JTable(tableModel);
//        JScrollPane tableScrollPane = new JScrollPane(dersTable);
//
//        filterTextField = new JTextField();
//        filterTextField.setBorder(new EmptyBorder(5, 5, 5, 5));
//        filterTextField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                filterDersTable();
//            }
//        });
//
//        solPanel.add(new JLabel("Ders Kodu:"));
//        solPanel.add(dersKoduField);
//        solPanel.add(new JLabel("Ders Adı:"));
//        solPanel.add(dersAdField);
//        solPanel.add(new JLabel("Dönem:"));
//        solPanel.add(dersDonemField);
//        solPanel.add(new JLabel("Öğretim Görevlisi:"));
//        solPanel.add(ogretimGorevlisiComboBox);
//        solPanel.add(new JLabel()); // Filtreleme etiketinin altına boş bir alan eklendi
//        solPanel.add(kaydetButton);
//
//
//        // Butonun altında biraz boşluk bırak
//        solPanel.add(new JPanel());
//
//        add(solPanel, BorderLayout.WEST);
//        add(tableScrollPane, BorderLayout.CENTER);
//
//        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        filterPanel.add(new JLabel("Filtrele:"));
//        filterPanel.add(filterTextField);
//
//        add(filterPanel, BorderLayout.NORTH);
//
//        String[] columnNames = {"Ders Kodu", "Ders Adı", "Dönem", "Öğretim Görevlisi"};
//        tableModel.setColumnIdentifiers(columnNames);
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//                refreshDersTable();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        refreshDersTable(); // Uygulama başladığında mevcut dersleri listele
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        yazdirDers(dersJson);
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    private void yazdirDers(JSONObject dersJson) {
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersTable() {
//        tableModel.setRowCount(0);
//        List<JSONObject> dersler = okuDersler("dersler.json");
//        for (JSONObject ders : dersler) {
//            Object[] row = {
//                    ders.get("DersKodu"),
//                    ders.get("DersAd"),
//                    ders.get("DersDonem"),
//                    ders.get("OgretimGorevlisi")
//            };
//            tableModel.addRow(row);
//        }
//    }
//
//    private List<JSONObject> okuDersler(String dosyaAdi) {
//        List<JSONObject> dersler = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                JSONObject ders = (JSONObject) jsonParser.parse(line);
//                dersler.add(ders);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return dersler;
//    }
//
//    private void filterDersTable() {
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
//        dersTable.setRowSorter(sorter);
//
//        String text = filterTextField.getText().toLowerCase();
//        if (text.trim().length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DersFormu().setVisible(true);
//            }
//        });
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JTable dersTable;
//    private JTextField filterTextField;
//
//    private DefaultTableModel tableModel;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(800, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel solPanel = new JPanel();
//        solPanel.setLayout(new GridLayout(7, 2));
//        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        tableModel = new DefaultTableModel();
//        dersTable = new JTable(tableModel);
//        JScrollPane tableScrollPane = new JScrollPane(dersTable);
//
//        filterTextField = new JTextField();
//        filterTextField.setColumns(20);  // Daha geniş bir sütun sayısı ayarla
//        filterTextField.setBorder(BorderFactory.createCompoundBorder(
//                filterTextField.getBorder(),
//                BorderFactory.createEmptyBorder(5, 10, 5, 10))); // BorderFactory kullanılarak düzenleme yapıldı
//        filterTextField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                filterDersTable();
//            }
//        });
//
//        solPanel.add(new JLabel("Ders Kodu:"));
//        solPanel.add(dersKoduField);
//        solPanel.add(new JLabel("Ders Adı:"));
//        solPanel.add(dersAdField);
//        solPanel.add(new JLabel("Dönem:"));
//        solPanel.add(dersDonemField);
//        solPanel.add(new JLabel("Öğretim Görevlisi:"));
//        solPanel.add(ogretimGorevlisiComboBox);
//        solPanel.add(new JLabel()); // Filtreleme etiketinin altına boş bir alan eklendi
//        solPanel.add(kaydetButton);
//
//        // Butonun altında biraz boşluk bırak
//        solPanel.add(new JPanel());
//
//        add(solPanel, BorderLayout.WEST);
//        add(tableScrollPane, BorderLayout.CENTER);
//
//        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        filterPanel.add(new JLabel("Filtrele:"));
//        filterPanel.add(filterTextField);
//
//        add(filterPanel, BorderLayout.NORTH);
//
//        String[] columnNames = {"Ders Kodu", "Ders Adı", "Dönem", "Öğretim Görevlisi"};
//        tableModel.setColumnIdentifiers(columnNames);
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//                refreshDersTable();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        refreshDersTable(); // Uygulama başladığında mevcut dersleri listele
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", dersKoduField.getText());
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", dersDonemField.getText());
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        yazdirDers(dersJson);
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    private void yazdirDers(JSONObject dersJson) {
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersTable() {
//        tableModel.setRowCount(0);
//        List<JSONObject> dersler = okuDersler("dersler.json");
//        for (JSONObject ders : dersler) {
//            Object[] row = {
//                    ders.get("DersKodu"),
//                    ders.get("DersAd"),
//                    ders.get("DersDonem"),
//                    ders.get("OgretimGorevlisi")
//            };
//            tableModel.addRow(row);
//        }
//    }
//
//    private List<JSONObject> okuDersler(String dosyaAdi) {
//        List<JSONObject> dersler = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                JSONObject ders = (JSONObject) jsonParser.parse(line);
//                dersler.add(ders);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return dersler;
//    }
//
//    private void filterDersTable() {
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
//        dersTable.setRowSorter(sorter);
//
//        String text = filterTextField.getText().toLowerCase();
//        if (text.trim().length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DersFormu().setVisible(true);
//            }
//        });
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//class Ders {
//    private String dersKodu;
//    private String dersAd;
//    private String dersDonem;
//    private String ogretimGorevlisi;
//
//    public Ders(String dersKodu, String dersAd, String dersDonem, String ogretimGorevlisi) {
//        this.dersKodu = dersKodu;
//        this.dersAd = dersAd;
//        this.dersDonem = dersDonem;
//        this.ogretimGorevlisi = ogretimGorevlisi;
//    }
//
//    public String getDersKodu() {
//        return dersKodu;
//    }
//
//    public String getDersAd() {
//        return dersAd;
//    }
//
//    public String getDersDonem() {
//        return dersDonem;
//    }
//
//    public String getOgretimGorevlisi() {
//        return ogretimGorevlisi;
//    }
//}
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JTable dersTable;
//    private JTextField filterTextField;
//
//    private DefaultTableModel tableModel;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(800, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel solPanel = new JPanel();
//        solPanel.setLayout(new GridLayout(7, 2));
//        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        tableModel = new DefaultTableModel();
//        dersTable = new JTable(tableModel);
//        JScrollPane tableScrollPane = new JScrollPane(dersTable);
//
//        filterTextField = new JTextField();
//        filterTextField.setColumns(20);
//        filterTextField.setBorder(new EmptyBorder(5, 10, 5, 10));
//        filterTextField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                filterDersTable();
//            }
//        });
//
//        solPanel.add(new JLabel("Ders Kodu:"));
//        solPanel.add(dersKoduField);
//        solPanel.add(new JLabel("Ders Adı:"));
//        solPanel.add(dersAdField);
//        solPanel.add(new JLabel("Dönem:"));
//        solPanel.add(dersDonemField);
//        solPanel.add(new JLabel("Öğretim Görevlisi:"));
//        solPanel.add(ogretimGorevlisiComboBox);
//        solPanel.add(new JLabel());
//        solPanel.add(kaydetButton);
//
//        solPanel.add(new JPanel());
//
//        add(solPanel, BorderLayout.WEST);
//        add(tableScrollPane, BorderLayout.CENTER);
//
//        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        filterPanel.add(new JLabel("Filtrele:"));
//        filterPanel.add(filterTextField);
//
//        add(filterPanel, BorderLayout.NORTH);
//
//        String[] columnNames = {"Ders Kodu", "Ders Adı", "Dönem", "Öğretim Görevlisi"};
//        tableModel.setColumnIdentifiers(columnNames);
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kaydetDers();
//                refreshDersTable();
//                JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//            }
//        });
//
//        refreshDersTable();
//    }
//
//    private void kaydetDers() {
//        Ders yeniDers = new Ders(
//                dersKoduField.getText(),
//                dersAdField.getText(),
//                dersDonemField.getText(),
//                (String) ogretimGorevlisiComboBox.getSelectedItem()
//        );
//
//        yazdirDers(yeniDers);
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    private void yazdirDers(Ders ders) {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", ders.getDersKodu());
//        dersJson.put("DersAd", ders.getDersAd());
//        dersJson.put("DersDonem", ders.getDersDonem());
//        dersJson.put("OgretimGorevlisi", ders.getOgretimGorevlisi());
//
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersTable() {
//        tableModel.setRowCount(0);
//        List<Ders> dersler = okuDersler("dersler.json");
//        for (Ders ders : dersler) {
//            Object[] row = {
//                    ders.getDersKodu(),
//                    ders.getDersAd(),
//                    ders.getDersDonem(),
//                    ders.getOgretimGorevlisi()
//            };
//            tableModel.addRow(row);
//        }
//    }
//
//    private List<Ders> okuDersler(String dosyaAdi) {
//        List<Ders> dersler = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                JSONObject dersJson = (JSONObject) jsonParser.parse(line);
//                Ders ders = new Ders(
//                        (String) dersJson.get("DersKodu"),
//                        (String) dersJson.get("DersAd"),
//                        (String) dersJson.get("DersDonem"),
//                        (String) dersJson.get("OgretimGorevlisi")
//                );
//                dersler.add(ders);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return dersler;
//    }
//
//    private void filterDersTable() {
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
//        dersTable.setRowSorter(sorter);
//
//        String text = filterTextField.getText().toLowerCase();
//        if (text.trim().length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DersFormu().setVisible(true);
//            }
//        });
//    }
//}
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableRowSorter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//class Ders {
//    private int dersKodu;
//    private String dersAd;
//    private int dersDonem;
//    private String ogretimGorevlisi;
//
//    public Ders(int dersKodu, String dersAd, int dersDonem, String ogretimGorevlisi) {
//        this.dersKodu = dersKodu;
//        this.dersAd = dersAd;
//        this.dersDonem = dersDonem;
//        this.ogretimGorevlisi = ogretimGorevlisi;
//    }
//
//    public int getDersKodu() {
//        return dersKodu;
//    }
//
//    public String getDersAd() {
//        return dersAd;
//    }
//
//    public int getDersDonem() {
//        return dersDonem;
//    }
//
//    public String getOgretimGorevlisi() {
//        return ogretimGorevlisi;
//    }
//}
//
//public class DersFormu extends JFrame {
//    private JTextField dersKoduField;
//    private JTextField dersAdField;
//    private JTextField dersDonemField;
//    private JComboBox<String> ogretimGorevlisiComboBox;
//    private JButton kaydetButton;
//    private JTable dersTable;
//    private JTextField filterTextField;
//
//    private DefaultTableModel tableModel;
//
//    public DersFormu() {
//        setTitle("Ders Formu");
//        setSize(800, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        JPanel solPanel = new JPanel();
//        solPanel.setLayout(new GridLayout(7, 2));
//        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        dersKoduField = new JTextField();
//        dersAdField = new JTextField();
//        dersDonemField = new JTextField();
//        ogretimGorevlisiComboBox = new JComboBox<>();
//        kaydetButton = new JButton("Kaydet");
//
//        tableModel = new DefaultTableModel();
//        dersTable = new JTable(tableModel);
//        JScrollPane tableScrollPane = new JScrollPane(dersTable);
//
//        filterTextField = new JTextField();
//        filterTextField.setColumns(20);
//        filterTextField.setBorder(new EmptyBorder(5, 10, 5, 10));
//        filterTextField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                filterDersTable();
//            }
//        });
//
//        solPanel.add(new JLabel("Ders Kodu:"));
//        solPanel.add(dersKoduField);
//        solPanel.add(new JLabel("Ders Adı:"));
//        solPanel.add(dersAdField);
//        solPanel.add(new JLabel("Dönem:"));
//        solPanel.add(dersDonemField);
//        solPanel.add(new JLabel("Öğretim Görevlisi:"));
//        solPanel.add(ogretimGorevlisiComboBox);
//        solPanel.add(new JLabel());
//        solPanel.add(kaydetButton);
//
//        solPanel.add(new JPanel());
//
//        add(solPanel, BorderLayout.WEST);
//        add(tableScrollPane, BorderLayout.CENTER);
//
//        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//        filterPanel.add(new JLabel("Filtrele:"));
//        filterPanel.add(filterTextField);
//
//        add(filterPanel, BorderLayout.NORTH);
//
//        String[] columnNames = {"Ders Kodu", "Ders Adı", "Dönem", "Öğretim Görevlisi"};
//        tableModel.setColumnIdentifiers(columnNames);
//
//        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
//        for (String ogretimGorevlisi : ogretimGorevlileri) {
//            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
//        }
//
//        kaydetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (validasyonKontrol()) {
//                    kaydetDers();
//                    refreshDersTable();
//                    JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
//                }
//            }
//        });
//
//        refreshDersTable();
//    }
//
//    private boolean validasyonKontrol() {
//        try {
//            int dersKodu = Integer.parseInt(dersKoduField.getText());
//            int dersDonem = Integer.parseInt(dersDonemField.getText());
//            return true;
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Ders Kodu ve Dönem alanlarına sadece sayı girişi yapılabilir!");
//            return false;
//        }
//    }
//
//    private void kaydetDers() {
//        JSONObject dersJson = new JSONObject();
//        dersJson.put("DersKodu", Integer.parseInt(dersKoduField.getText()));
//        dersJson.put("DersAd", dersAdField.getText());
//        dersJson.put("DersDonem", Integer.parseInt(dersDonemField.getText()));
//        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());
//
//        yazdirDers(dersJson);
//    }
//
//    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
//        List<String> ogretimGorevlileri = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);
//
//            for (Object obj : ogretimGorevlileriArray) {
//                JSONObject ogretimGorevlisi = (JSONObject) obj;
//                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
//                ogretimGorevlileri.add(adSoyad);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return ogretimGorevlileri;
//    }
//
//    private void yazdirDers(JSONObject dersJson) {
//        try (FileWriter file = new FileWriter("dersler.json", true)) {
//            file.write(dersJson.toJSONString() + "\n");
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void refreshDersTable() {
//        tableModel.setRowCount(0);
//        List<Ders> dersler = okuDersler("dersler.json");
//        for (Ders ders : dersler) {
//            Object[] row = {
//                    ders.getDersKodu(),
//                    ders.getDersAd(),
//                    ders.getDersDonem(),
//                    ders.getOgretimGorevlisi()
//            };
//            tableModel.addRow(row);
//        }
//    }
//
//    private List<Ders> okuDersler(String dosyaAdi) {
//        List<Ders> dersler = new ArrayList<>();
//        JSONParser jsonParser = new JSONParser();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                JSONObject dersJson = (JSONObject) jsonParser.parse(line);
//                Ders ders = new Ders(
//                        Integer.parseInt(dersJson.get("DersKodu").toString()),
//                        (String) dersJson.get("DersAd"),
//                        Integer.parseInt(dersJson.get("DersDonem").toString()),
//                        (String) dersJson.get("OgretimGorevlisi")
//                );
//                dersler.add(ders);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return dersler;
//    }
//
//    private void filterDersTable() {
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
//        dersTable.setRowSorter(sorter);
//
//        String text = filterTextField.getText().toLowerCase();
//        if (text.trim().length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new DersFormu().setVisible(true);
//            }
//        });
//    }
//}
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
import java.util.List;

class Ders {
    private int dersKodu;
    private String dersAd;
    private int dersDonem;
    private String ogretimGorevlisi;

    public Ders(int dersKodu, String dersAd, int dersDonem, String ogretimGorevlisi) {
        this.dersKodu = dersKodu;
        this.dersAd = dersAd;
        this.dersDonem = dersDonem;
        this.ogretimGorevlisi = ogretimGorevlisi;
    }

    public int getDersKodu() {
        return dersKodu;
    }

    public String getDersAd() {
        return dersAd;
    }

    public int getDersDonem() {
        return dersDonem;
    }

    public String getOgretimGorevlisi() {
        return ogretimGorevlisi;
    }
}

public class DersFormu extends JFrame {
    private JTextField dersKoduField;
    private JTextField dersAdField;
    private JTextField dersDonemField;
    private JComboBox<String> ogretimGorevlisiComboBox;
    private JButton kaydetButton;
    private JTable dersTable;
    private JTextField filterTextField;

    private DefaultTableModel tableModel;

    public DersFormu() {
        setTitle("Ders Formu");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel solPanel = new JPanel();
        solPanel.setLayout(new GridLayout(7, 2));
        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setResizable(false);

        dersKoduField = new JTextField();
        dersAdField = new JTextField();
        dersDonemField = new JTextField();
        ogretimGorevlisiComboBox = new JComboBox<>();
        kaydetButton = new JButton("Kaydet");

        tableModel = new DefaultTableModel();
        dersTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(dersTable);

        filterTextField = new JTextField();
        filterTextField.setColumns(20);
        filterTextField.setBorder(new EmptyBorder(5, 10, 5, 10));
        filterTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterDersTable();
            }
        });

        solPanel.add(createLabel("Ders Kodu:"));
        solPanel.add(dersKoduField);
        solPanel.add(createLabel("Ders Adı:"));
        solPanel.add(dersAdField);
        solPanel.add(createLabel("Dönem:"));
        solPanel.add(dersDonemField);
        solPanel.add(createLabel("Öğretim Görevlisi:"));
        solPanel.add(ogretimGorevlisiComboBox);
        solPanel.add(new JLabel());
        solPanel.add(kaydetButton);

        solPanel.add(new JPanel()); // Boş panel, düzeni korumak için eklendi

        add(solPanel, BorderLayout.WEST);
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filterPanel.add(createLabel("Filtrele:"));
        filterPanel.add(filterTextField);

        add(filterPanel, BorderLayout.NORTH);

        String[] columnNames = {"Ders Kodu", "Ders Adı", "Dönem", "Öğretim Görevlisi"};
        tableModel.setColumnIdentifiers(columnNames);

        List<String> ogretimGorevlileri = okuOgretimGorevlileri("OgretimGorevlileri.json");
        for (String ogretimGorevlisi : ogretimGorevlileri) {
            ogretimGorevlisiComboBox.addItem(ogretimGorevlisi);
        }

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validasyonKontrol()) {
                    kaydetDers();
                    refreshDersTable();
                    JOptionPane.showMessageDialog(null, "Ders başarıyla kaydedildi!");
                }
            }
        });

        refreshDersTable();
    }

    private boolean validasyonKontrol() {
        try {
            int dersKodu = Integer.parseInt(dersKoduField.getText());
            int dersDonem = Integer.parseInt(dersDonemField.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ders Kodu ve Dönem alanlarına sadece sayı girişi yapılabilir!");
            return false;
        }
    }

    private void kaydetDers() {
        JSONObject dersJson = new JSONObject();
        dersJson.put("DersKodu", Integer.parseInt(dersKoduField.getText()));
        dersJson.put("DersAd", dersAdField.getText());
        dersJson.put("DersDonem", Integer.parseInt(dersDonemField.getText()));
        dersJson.put("OgretimGorevlisi", ogretimGorevlisiComboBox.getSelectedItem());

        yazdirDers(dersJson);
    }

    private List<String> okuOgretimGorevlileri(String dosyaAdi) {
        List<String> ogretimGorevlileri = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            JSONArray ogretimGorevlileriArray = (JSONArray) jsonParser.parse(reader);

            for (Object obj : ogretimGorevlileriArray) {
                JSONObject ogretimGorevlisi = (JSONObject) obj;
                String adSoyad = ogretimGorevlisi.get("Ad") + " " + ogretimGorevlisi.get("Soyad");
                ogretimGorevlileri.add(adSoyad);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return ogretimGorevlileri;
    }

    private void yazdirDers(JSONObject dersJson) {
        try (FileWriter file = new FileWriter("dersler.json", true)) {
            file.write(dersJson.toJSONString() + "\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void refreshDersTable() {
        tableModel.setRowCount(0);
        List<Ders> dersler = okuDersler("dersler.json");
        for (Ders ders : dersler) {
            Object[] row = {
                    ders.getDersKodu(),
                    ders.getDersAd(),
                    ders.getDersDonem(),
                    ders.getOgretimGorevlisi()
            };
            tableModel.addRow(row);
        }
    }

    private List<Ders> okuDersler(String dosyaAdi) {
        List<Ders> dersler = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject dersJson = (JSONObject) jsonParser.parse(line);
                Ders ders = new Ders(
                        Integer.parseInt(dersJson.get("DersKodu").toString()),
                        (String) dersJson.get("DersAd"),
                        Integer.parseInt(dersJson.get("DersDonem").toString()),
                        (String) dersJson.get("OgretimGorevlisi")
                );
                dersler.add(ders);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return dersler;
    }

    private void filterDersTable() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        dersTable.setRowSorter(sorter);

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
                DersFormu dersFormu = new DersFormu();
                dersFormu.setLocationRelativeTo(null); // Ekranın ortasına konumlandırma
                dersFormu.setVisible(true);
            }
        });
    }
}
