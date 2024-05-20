import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class carRent {
    private JLabel rentCarLabel;
    private JComboBox carRentComboBox1;
    private JLabel carBrandLabel;
    private JSpinner timeSpinner1;
    private JLabel timeLabel;
    private JLabel insurTypeLabel;
    private JComboBox insuranceTypeComboBox1;
    private JButton rentButton;
    private JPanel rootPanel;
    private JComboBox comboBox1;

    private void createUIComponents() {

        Car BmwCar = new Car("BMW E60", 40, 'A', "Gas");
        Car ChevroletCar = new Car("Chevrolet Captiva",  35, 'A', "Petrol");
        Car NissanCar = new Car("Nissan Leaf", 70,'A', "Disel");
        Car SubaruCar = new Car("Subaru Forester", 55,'A', "Petrol");
        Car MercedesCar = new Car("Mercedes E220", 75, 'M', "Petrol");
        Car LexusCar = new Car("Lexus RX 450h", 65, 'A', "Petrol");
        Car BMW2Car = new Car("BMW M3 Competition", 300, 'A', "Petrol");



        String[] models = {BmwCar.getModelAndPrice(),
                ChevroletCar.getModelAndPrice(),
                NissanCar.getModelAndPrice(),
                SubaruCar.getModelAndPrice(),
                MercedesCar.getModelAndPrice(),
                BMW2Car.getModelAndPrice(),
                LexusCar.getModelAndPrice()
        };
        carRentComboBox1 = new JComboBox(models);

        comboBox1 = new JComboBox(models);


        String[] insuranceTypes = {"Nav 0EUR", "Puss apdrošināšana 400EUR","Pilna apdrošināšana 700EUR"};
        insuranceTypeComboBox1 = new JComboBox(insuranceTypes);

        SpinnerModel value = new SpinnerNumberModel(1, 1, 1000, 1);
        timeSpinner1 = new JSpinner(value);


        rentButton = new JButton();
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int carType = carRentComboBox1.getSelectedIndex();
                String rent = "";
                double amount = 0;
                switch (carType) {
                    case 0:
                        rent += BmwCar.toString();
                        amount = (BmwCar.getPricePerDay()*(int)timeSpinner1.getValue());
                        break;
                    case 1:
                        rent += ChevroletCar.toString();
                        amount = (ChevroletCar.getPricePerDay()*(int)timeSpinner1.getValue());
                        break;
                    case 2:
                        rent += NissanCar.toString();
                        amount = (NissanCar.getPricePerDay()*(int)timeSpinner1.getValue());
                        break;
                    case 3:
                        rent += SubaruCar.toString();
                        amount = (SubaruCar.getPricePerDay()*(int)timeSpinner1.getValue());
                        break;
                    case 4:
                        rent += MercedesCar.toString();
                        amount = (MercedesCar.getPricePerDay()*(int)timeSpinner1.getValue());
                        break;
                    case 5:
                        rent += BMW2Car.toString();
                        amount = (BMW2Car.getPricePerDay()*(int)timeSpinner1.getValue());
                        break;
                    case 6:
                        rent += LexusCar.toString();
                        amount = (LexusCar.getPricePerDay()*(int)timeSpinner1.getValue());
                        break;
                    default:
                        break;
                }

                int insuranceType = insuranceTypeComboBox1.getSelectedIndex();
                switch (insuranceType) {
                    case 1:
                        amount += 400;
                        break;
                    case 2:
                        amount += 700;
                        break;
                }
                rent += "Uz " +timeSpinner1.getValue() + " dienām?\n\n";
                rent += "Apdrošināšanas veids: " +insuranceTypeComboBox1.getItemAt(insuranceTypeComboBox1.getSelectedIndex()) + "\n\n";
                String summa = String.format("%.2f", amount);
                rent += "Summa: " + summa + " EUR\n";
                JFrame confirmation = new JFrame();
                int a = JOptionPane.showConfirmDialog(confirmation, "Viss pareizi?\n" + rent);
                if (a == JOptionPane.YES_OPTION) {
                    JFrame numberFrame = new JFrame();
                    JFrame nameFrame = new JFrame();
                    String name = JOptionPane.showInputDialog(nameFrame, "Ievadiet Jūsu vārdu un uzvārdu");
                    while (name.isEmpty()) {
                        JOptionPane.showMessageDialog(nameFrame, "Vards ir tukšs", "Irēšana", JOptionPane.WARNING_MESSAGE);
                        name = JOptionPane.showInputDialog(nameFrame, "Ievadiet Jūsu vārdu");
                    }
                    String number = JOptionPane.showInputDialog(nameFrame, "Ievadiet Jūsu telefona numuru");
                    while (number.isEmpty()) {
                        JOptionPane.showMessageDialog(numberFrame, "Telefona numurs ir tukšs", "Irēšana", JOptionPane.WARNING_MESSAGE);
                        number = JOptionPane.showInputDialog(numberFrame, "Ievadiet Jūsu telefona numuru");
                    }
                    try {
                        FileWriter fw = new FileWriter("iresana.txt", true);
                        String file1 = "Name: " + name + " \nTelefona numurs: " + number + "\n" + rent+ "\n";
                        fw.write(file1 + "----------------\n");
                        fw.close();
                        JFrame conf = new JFrame();
                        JOptionPane.showMessageDialog(conf, "Jūs esat veiksmīgi iznomājis automašīnu!");
                        System.exit(0);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Irēšana");
        frame.setContentPane(new carRent().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


    }
}

