
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class uygulama extends JFrame {
    private JButton dersFormuButton;
    private JButton ogrenciFormuButton;
    private JButton ogretimGorevlisiFormuButton;

    public uygulama() {
        setTitle("Uygulama");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20)); // 10 pixel yatay, 20 pixel dikey boşluk

        dersFormuButton = createStyledButton("Ders");
        ogrenciFormuButton = createStyledButton("Öğrenci");
        ogretimGorevlisiFormuButton = createStyledButton("Öğretim Görevlisi");

        // Butonlara action listener ekleme
        dersFormuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DersFormu dersFormu = new DersFormu();
                dersFormu.setLocationRelativeTo(null);
                dersFormu.setVisible(true);
            }
        });

        ogrenciFormuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgrenciFormu ogrenciFormu = new OgrenciFormu();
                ogrenciFormu.setLocationRelativeTo(null);
                ogrenciFormu.setVisible(true);
            }
        });

        ogretimGorevlisiFormuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgretimGorevlisiFormu ogretimGorevlisiFormu = new OgretimGorevlisiFormu();
                ogretimGorevlisiFormu.setLocationRelativeTo(null);
                ogretimGorevlisiFormu.setVisible(true);
            }
        });

        // Butonları panele ekleme
        add(dersFormuButton);
        add(ogrenciFormuButton);
        add(ogretimGorevlisiFormuButton);
    }

    // Buton stilini oluşturan yardımcı metot
    private JButton createStyledButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setBackground(new Color(70, 130, 180)); // Steel Blue renk
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(200, 40));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                uygulama uygulama = new uygulama();
                uygulama.setLocationRelativeTo(null);

                uygulama.setVisible(true);
            }
        });
    }
}
