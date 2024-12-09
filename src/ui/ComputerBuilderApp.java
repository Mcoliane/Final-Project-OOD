package ui;

import Adapter.CSVPartsAdapter;
import Adapter.CSVReader;
import Adapter.PartsSource;
import Builder.Computer;
import Builder.ComputerBuilder;
import Builder.ComputerComponent;
import Builder.ConcreteComputerBuilder;
import decorator.KeyboardDecorator;
import decorator.MouseDecorator;
import decorator.MonitorDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ComputerBuilderApp extends JFrame {

    private JComboBox<String> cpuCombo;
    private JComboBox<String> memoryCombo;
    private JComboBox<String> storageCombo;
    private JComboBox<String> gpuCombo;
    private JComboBox<String> otherCombo;

    private JCheckBox keyboardCheck;
    private JCheckBox mouseCheck;
    private JCheckBox monitorCheck;

    private JTextArea resultArea;

    private PartsSource partsSource;
    private ComputerBuilder builder;

    public ComputerBuilderApp() {
        super("Computer Builder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        // Load parts using adapter
        try {
            CSVReader csvReader = new CSVReader("/Users/super/IdeaProjects/Fall_2024/TestFinalProj/src/parts.csv");
            csvReader.load();
            partsSource = new CSVPartsAdapter(csvReader);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading parts: " + e.getMessage());
            System.exit(1);
        }

        builder = new ConcreteComputerBuilder();

        JPanel selectionPanel = new JPanel(new GridLayout(9, 2, 5, 5));
        selectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        cpuCombo = createCombo(partsSource.getCPUs());
        memoryCombo = createCombo(partsSource.getMemories());
        storageCombo = createCombo(partsSource.getStorages());
        gpuCombo = createCombo(partsSource.getGraphicsCards());
        otherCombo = createCombo(partsSource.getOtherParts());

        selectionPanel.add(new JLabel("CPU:"));
        selectionPanel.add(cpuCombo);

        selectionPanel.add(new JLabel("Memory:"));
        selectionPanel.add(memoryCombo);

        selectionPanel.add(new JLabel("Storage:"));
        selectionPanel.add(storageCombo);

        selectionPanel.add(new JLabel("GPU:"));
        selectionPanel.add(gpuCombo);

        selectionPanel.add(new JLabel("Other:"));
        selectionPanel.add(otherCombo);

        // Decorator-related UI components
        keyboardCheck = new JCheckBox("Add Keyboard");
        mouseCheck = new JCheckBox("Add Mouse");
        monitorCheck = new JCheckBox("Add Monitor");

        selectionPanel.add(keyboardCheck);
        selectionPanel.add(new JLabel(""));

        selectionPanel.add(mouseCheck);
        selectionPanel.add(new JLabel(""));

        selectionPanel.add(monitorCheck);
        selectionPanel.add(new JLabel(""));

        JButton buildButton = new JButton("Build Computer");
        selectionPanel.add(new JLabel(""));
        selectionPanel.add(buildButton);

        add(selectionPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        buildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buildComputer();
            }
        });
    }

    private JComboBox<String> createCombo(List<String> items) {
        JComboBox<String> combo = new JComboBox<>();
        for (String item : items) {
            combo.addItem(item);
        }
        return combo;
    }

    private void buildComputer() {
        builder.reset();

        // Using the Builder
        String selectedCPU = (String) cpuCombo.getSelectedItem();
        String selectedMemory = (String) memoryCombo.getSelectedItem();
        String selectedStorage = (String) storageCombo.getSelectedItem();
        String selectedGPU = (String) gpuCombo.getSelectedItem();
        String selectedOther = (String) otherCombo.getSelectedItem();

        if (selectedCPU != null && !selectedCPU.isEmpty()) {
            builder.addCPU(selectedCPU);
        }

        if (selectedMemory != null && !selectedMemory.isEmpty()) {
            builder.addMemory(selectedMemory);
        }

        if (selectedStorage != null && !selectedStorage.isEmpty()) {
            builder.addStorage(selectedStorage);
        }

        if (selectedGPU != null && !selectedGPU.isEmpty()) {
            builder.addGraphicsCard(selectedGPU);
        }

        if (selectedOther != null && !selectedOther.isEmpty()) {
            builder.addOtherPart("Other: " + selectedOther);
        }

        ComputerComponent computer = builder.getResult(); // Base Computer

        // Apply Decorators based on user selection
        if (keyboardCheck.isSelected()) {
            computer = new KeyboardDecorator(computer);
        }
        if (mouseCheck.isSelected()) {
            computer = new MouseDecorator(computer);
        }
        if (monitorCheck.isSelected()) {
            computer = new MonitorDecorator(computer);
        }

        resultArea.setText(computer.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ComputerBuilderApp().setVisible(true);
        });
    }
}