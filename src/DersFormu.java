
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.border.EmptyBorder;

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

        JPanel solPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setResizable(false);

        dersKoduField = new JTextField();
        dersAdField = new JTextField();
        dersDonemField = new JTextField();
        ogretimGorevlisiComboBox = new JComboBox<>();
        kaydetButton = createStyledButton("Kaydet");

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

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        solPanel.add(createLabel("Ders Kodu:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        solPanel.add(dersKoduField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        solPanel.add(createLabel("Ders Adı:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        solPanel.add(dersAdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        solPanel.add(createLabel("Dönem:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        solPanel.add(dersDonemField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        solPanel.add(createLabel("Öğretim Görevlisi:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        solPanel.add(ogretimGorevlisiComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        solPanel.add(new JPanel(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        solPanel.add(kaydetButton, gbc);

        solPanel.add(new JPanel());

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
    private JButton createStyledButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setBackground(new Color(70, 130, 180)); // Steel Blue renk
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }

    private boolean validasyonKontrol() {
        try {
            int dersKodu = Integer.parseInt(dersKoduField.getText());
            int dersDonem = Integer.parseInt(dersDonemField.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Geçersiz Ders Kodu veya Dönem numarası", "Hata", JOptionPane.ERROR_MESSAGE);
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
                dersFormu.setLocationRelativeTo(null);
                dersFormu.setVisible(true);
            }
        });
    }
}
