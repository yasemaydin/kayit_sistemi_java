
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

class Ogrenci {
    private int ogrenciNo;
    private String ogrenciAd;
    private String ogrenciSoyad;
    private String ogrenciBolum;
    private String ogrenciDersler;
    private String ogrenciDersKodu;

    public Ogrenci(int ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum, String ogrenciDersler, String ogrenciDersKodu) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAd = ogrenciAd;
        this.ogrenciSoyad = ogrenciSoyad;
        this.ogrenciBolum = ogrenciBolum;
        this.ogrenciDersler = ogrenciDersler;
        this.ogrenciDersKodu = ogrenciDersKodu;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }

    public String getOgrenciBolum() {
        return ogrenciBolum;
    }

    public String getOgrenciDersler() {
        return ogrenciDersler;
    }

    public String getOgrenciDersKodu() {
        return ogrenciDersKodu;
    }
}

public class OgrenciFormu extends JFrame {
    private JTextField ogrenciNoField;
    private JTextField ogrenciAdField;
    private JTextField ogrenciSoyadField;
    private JTextField ogrenciBolumField;
    private JComboBox<String> ogrenciDerslerField; // Changed to JComboBox
    private JButton kaydetButton;
    private JTable ogrenciTable;
    private JTextField filterTextField;

    private DefaultTableModel tableModel;

    public OgrenciFormu() {
        setTitle("Öğrenci Formu");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel solPanel = new JPanel();
        solPanel.setLayout(new GridLayout(7, 2));
        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setResizable(false);

        ogrenciNoField = new JTextField();
        ogrenciAdField = new JTextField();
        ogrenciSoyadField = new JTextField();
        ogrenciBolumField = new JTextField();
        kaydetButton = new JButton("Kaydet");

        tableModel = new DefaultTableModel();
        ogrenciTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(ogrenciTable);

        filterTextField = new JTextField();
        filterTextField.setColumns(20);
        filterTextField.setBorder(new EmptyBorder(5, 10, 5, 10));
        filterTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterOgrenciTable();
            }
        });

        // Populate the JComboBox for "Öğrenci Dersleri"
        List<String> dersler = readDersler();
        DefaultComboBoxModel<String> derslerComboBoxModel = new DefaultComboBoxModel<>(dersler.toArray(new String[0]));
        ogrenciDerslerField = new JComboBox<>(derslerComboBoxModel);

        solPanel.add(createLabel("Öğrenci No:"));
        solPanel.add(ogrenciNoField);
        solPanel.add(createLabel("Öğrenci Adı:"));
        solPanel.add(ogrenciAdField);
        solPanel.add(createLabel("Öğrenci Soyadı:"));
        solPanel.add(ogrenciSoyadField);
        solPanel.add(createLabel("Öğrenci Bölümü:"));
        solPanel.add(ogrenciBolumField);
        solPanel.add(createLabel("Öğrenci Dersleri:"));
        solPanel.add(ogrenciDerslerField);
        solPanel.add(new JLabel());
        solPanel.add(kaydetButton);

        solPanel.add(new JPanel()); // Boş panel, düzeni korumak için eklendi

        add(solPanel, BorderLayout.WEST);
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        filterPanel.add(createLabel("Filtrele:"));
        filterPanel.add(filterTextField);

        add(filterPanel, BorderLayout.NORTH);

        String[] columnNames = {"Öğrenci No", "Öğrenci Adı", "Öğrenci Soyadı", "Öğrenci Bölümü", "Öğrenci Dersleri", "Öğrenci Ders Kodu"};
        tableModel.setColumnIdentifiers(columnNames);

        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validasyonKontrol()) {
                    kaydetOgrenci();
                    refreshOgrenciTable();
                    JOptionPane.showMessageDialog(null, "Öğrenci başarıyla kaydedildi!");
                }
            }
        });

        refreshOgrenciTable();
    }

    private List<String> readDersler() {
        List<String> derslerList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (BufferedReader reader = new BufferedReader(new FileReader("dersler.json"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject dersJson = (JSONObject) jsonParser.parse(line);
                String dersKodu = String.valueOf(dersJson.get("DersKodu"));
                String dersAd = (String) dersJson.get("DersAd");
                String combinedDers = dersKodu + " - " + dersAd;
                derslerList.add(combinedDers);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return derslerList;
    }

    private boolean validasyonKontrol() {
        try {
            int ogrenciNo = Integer.parseInt(ogrenciNoField.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Öğrenci No alanına sadece sayı girişi yapılabilir!");
            return false;
        }
    }

    private void kaydetOgrenci() {
        String selectedDers = (String) ogrenciDerslerField.getSelectedItem();
        String[] parts = selectedDers.split(" - ");
        String dersKodu = parts[0];
        String dersAd = parts[1];

        Ogrenci ogrenci = new Ogrenci(
                Integer.parseInt(ogrenciNoField.getText()),
                ogrenciAdField.getText(),
                ogrenciSoyadField.getText(),
                ogrenciBolumField.getText(),
                dersAd,
                dersKodu
        );

        JSONObject ogrenciJson = new JSONObject();
        ogrenciJson.put("ogrenciNo", ogrenci.getOgrenciNo());
        ogrenciJson.put("ogrenciAd", ogrenci.getOgrenciAd());
        ogrenciJson.put("ogrenciSoyad", ogrenci.getOgrenciSoyad());
        ogrenciJson.put("ogrenciBolum", ogrenci.getOgrenciBolum());
        ogrenciJson.put("ogrenciDersler", ogrenci.getOgrenciDersler());
        ogrenciJson.put("ogrenciDersKodu", ogrenci.getOgrenciDersKodu());

        yazdirOgrenci(ogrenciJson);
    }

    private void refreshOgrenciTable() {
        tableModel.setRowCount(0);
        List<Ogrenci> ogrenciler = okuOgrenciler("ogrenciler.json");
        for (Ogrenci ogrenci : ogrenciler) {
            Object[] row = {
                    ogrenci.getOgrenciNo(),
                    ogrenci.getOgrenciAd(),
                    ogrenci.getOgrenciSoyad(),
                    ogrenci.getOgrenciBolum(),
                    ogrenci.getOgrenciDersler(),
                    ogrenci.getOgrenciDersKodu()
            };
            tableModel.addRow(row);
        }
    }

    private List<Ogrenci> okuOgrenciler(String dosyaAdi) {
        List<Ogrenci> ogrenciler = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = reader.readLine()) != null) {
                JSONObject ogrenciJson = (JSONObject) jsonParser.parse(line);
                Ogrenci ogrenci = new Ogrenci(
                        Integer.parseInt(ogrenciJson.get("ogrenciNo").toString()),
                        (String) ogrenciJson.get("ogrenciAd"),
                        (String) ogrenciJson.get("ogrenciSoyad"),
                        (String) ogrenciJson.get("ogrenciBolum"),
                        (String) ogrenciJson.get("ogrenciDersler"),
                        (String) ogrenciJson.get("ogrenciDersKodu")
                );
                ogrenciler.add(ogrenci);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return ogrenciler;
    }

    private void yazdirOgrenci(JSONObject ogrenciJson) {
        try (FileWriter file = new FileWriter("ogrenciler.json", true)) {
            file.write(ogrenciJson.toJSONString() + "\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void filterOgrenciTable() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        ogrenciTable.setRowSorter(sorter);

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
                OgrenciFormu ogrenciFormu = new OgrenciFormu();
                ogrenciFormu.setLocationRelativeTo(null);
                ogrenciFormu.setVisible(true);
            }
        });
    }
}
