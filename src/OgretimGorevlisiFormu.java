
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
        solPanel.setLayout(new GridBagLayout());
        solPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setResizable(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        ogretmenNoField = new JTextField(10);
        adField = new JTextField(10);
        soyadField = new JTextField(10);
        bolumField = new JTextField(10);
        kaydetButton = createStyledButton("Kaydet");

        tableModel = new DefaultTableModel();
        ogretimGorevlisiTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(ogretimGorevlisiTable);

        filterTextField = new JTextField();
        filterTextField.setColumns(20);
        filterTextField.setBorder(new EmptyBorder(5, 10, 5, 10));
        filterTextField.addActionListener(e -> filterOgretimGorevlisiTable());



        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        solPanel.add(createLabel("No:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        solPanel.add(ogretmenNoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        solPanel.add(createLabel("Adı:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        solPanel.add(adField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        solPanel.add(createLabel("Soyadı:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        solPanel.add(soyadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        solPanel.add(createLabel("Bölümü:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        solPanel.add(bolumField, gbc);

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
                if (validasyonKontrol())
                {
                kaydetOgretimGorevlisi();
                refreshOgretimGorevlisiTable();
                JOptionPane.showMessageDialog(null, "Öğretim Görevlisi başarıyla kaydedildi!");
            }}
        });

        refreshOgretimGorevlisiTable();
    }
    private boolean validasyonKontrol() {
        try {
            int ogretmenNo = Integer.parseInt(ogretmenNoField.getText());

            if (ogretmenNo <= 0) {
                throw new NumberFormatException();
            }

            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Geçerli öğretmen numarası girin!", "Hata", JOptionPane.ERROR_MESSAGE);
            ogretmenNoField.requestFocus();
            return false;
        }
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
    private void kaydetOgretimGorevlisi() {
        JSONObject ogretimGorevlisiJson = new JSONObject();
        ogretimGorevlisiJson.put("OgretmenNo", Integer.parseInt(ogretmenNoField.getText()));
        ogretimGorevlisiJson.put("Ad", adField.getText());
        ogretimGorevlisiJson.put("Soyad", soyadField.getText());
        ogretimGorevlisiJson.put("Bolum", bolumField.getText());
        // Read existing data from the file
        List<JSONObject> existingData = okuOgretimGorevlileri("ogretimGorevlileri.json");

        // Add the new record to the existing data
        existingData.add(ogretimGorevlisiJson);

        // Save the updated data back to the file
        try (FileWriter file = new FileWriter("ogretimGorevlileri.json")) {
            JSONArray ogretimGorevlileriArray = new JSONArray();
            for (JSONObject existingRecord : existingData) {
                ogretimGorevlileriArray.add(existingRecord);
            }
            file.write(ogretimGorevlileriArray.toJSONString());
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
