import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KonversiSuhu {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Aplikasi Konversi Suhu");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(33, 150, 243));
        JLabel titleLabel = new JLabel("Konversi Suhu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Komponen input suhu
        JLabel inputLabel = new JLabel("Suhu:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(inputLabel, gbc);

        JTextField inputField = new JTextField(10);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        centerPanel.add(inputField, gbc);

        // Komponen combobox
        String[] opsi = {
            "Celcius ke Fahrenheit",
            "Fahrenheit ke Celcius",
            "Celcius ke Kelvin",
            "Kelvin ke Celcius",
            "Fahrenheit ke Kelvin",
            "Kelvin ke Fahrenheit"
        };
        JComboBox<String> comboBox = new JComboBox<>(opsi);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        centerPanel.add(comboBox, gbc);

        // Tombol konversi
        JButton konversiButton = new JButton("Konversi");
        konversiButton.setFont(new Font("Arial", Font.BOLD, 16));
        konversiButton.setBackground(new Color(76, 175, 80));
        konversiButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        centerPanel.add(konversiButton, gbc);

        // Label hasil
        JLabel hasilLabel = new JLabel("Hasil: ", SwingConstants.CENTER);
        hasilLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        centerPanel.add(hasilLabel, gbc);

        konversiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double suhu = Double.parseDouble(inputField.getText());
                    String pilihan = (String) comboBox.getSelectedItem();
                    double hasil = 0.0;

                    switch (pilihan) {
                        case "Celcius ke Fahrenheit":
                            hasil = (suhu * 9 / 5) + 32;
                            hasilLabel.setText("Hasil: " + hasil + " °F");
                            break;
                        case "Fahrenheit ke Celcius":
                            hasil = (suhu - 32) * 5 / 9;
                            hasilLabel.setText("Hasil: " + hasil + " °C");
                            break;
                        case "Celcius ke Kelvin":
                            hasil = suhu + 273.15;
                            hasilLabel.setText("Hasil: " + hasil + " K");
                            break;
                        case "Kelvin ke Celcius":
                            hasil = suhu - 273.15;
                            hasilLabel.setText("Hasil: " + hasil + " °C");
                            break;
                        case "Fahrenheit ke Kelvin":
                            hasil = (suhu - 32) * 5 / 9 + 273.15;
                            hasilLabel.setText("Hasil: " + hasil + " K");
                            break;
                        case "Kelvin ke Fahrenheit":
                            hasil = (suhu - 273.15) * 9 / 5 + 32;
                            hasilLabel.setText("Hasil: " + hasil + " °F");
                            break;
                    }
                } catch (NumberFormatException ex) {
                    hasilLabel.setText("Masukkan angka yang valid!");
                }
            }
        });

        // Menambahkan panel ke frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Menampilkan frame
        frame.setVisible(true);
    }
}
