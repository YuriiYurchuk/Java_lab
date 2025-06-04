import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;

public class UnitConverterSwing extends JFrame {

    private JComboBox<String> unitComboBox;
    private JTextField inputField;
    private JLabel resultLabel;

    public UnitConverterSwing() {
        setTitle("Unit Converter to Meters");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 220);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Enter value:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputField = new JTextField(15);
        panel.add(inputField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Units:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        unitComboBox = new JComboBox<>(new String[]{"Inches", "Feet", "Miles"});
        panel.add(unitComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JButton convertButton = new JButton("Convert");
        panel.add(convertButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Result in meters:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        resultLabel = new JLabel();
        resultLabel.setFont(resultLabel.getFont().deriveFont(Font.BOLD));
        panel.add(resultLabel, gbc);

        convertButton.addActionListener(this::convertAction);

        setContentPane(panel);

        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    private void convertAction(ActionEvent e) {
        Locale locale = Locale.getDefault();
        NumberFormat nf = NumberFormat.getInstance(locale);

        try {
            Number number = nf.parse(inputField.getText());
            double value = number.doubleValue();

            String unit = (String) unitComboBox.getSelectedItem();
            double meters = 0;

            switch (Objects.requireNonNull(unit)) {
                case "Inches" -> meters = value * 0.0254;
                case "Feet" -> meters = value * 0.3048;
                case "Miles" -> meters = value * 1609.344;
            }

            String formattedResult = nf.format(meters);
            resultLabel.setText(formattedResult);

        } catch (ParseException ex) {
            resultLabel.setText("Error: please enter a valid number");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UnitConverterSwing app = new UnitConverterSwing();
            app.setVisible(true);
        });
    }
}
