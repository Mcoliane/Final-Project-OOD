//our main and swing class. 
//this sets up the ui elemenets that will be used to build the computer.
//Author: Thien, Mark, Michael

package ui;

import Adapter.CSVPartsAdapter;
import Adapter.CSVReader;
import Adapter.PartsSource;
import Builder.Computer;
import Builder.ComputerBuilder;
import Builder.ComputerComponent;
import Builder.ConcreteComputerBuilder;
import Decorator.KeyboardDecorator;
import Decorator.MonitorDecorator;
import Decorator.MouseDecorator;
import observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ComputerBuilderApp extends JFrame implements Observer {
    //class variables that uses jcombobox, jcheckbox, jtextarea, jbutton, and jpanel
    private JComboBox<String> cpuCombo;
    private JComboBox<String> memoryCombo;
    private JComboBox<String> storageCombo;
    private JComboBox<String> gpuCombo;
    private JComboBox<String> motherboardCombo;
    private JComboBox<String> psuCombo;
    private JComboBox<String> otherCombo;

    private JCheckBox keyboardCheck;
    private JCheckBox mouseCheck;
    private JCheckBox monitorCheck;

    private JTextArea resultArea;

    private PartsSource partsSource;
    private ComputerBuilder builder;

    private Computer baseComputer;
    private ComputerComponent decoratedComputer;

    // Buttons for incremental adding
    private JButton addCPUButton;
    private JButton addMemoryButton;
    private JButton addStorageButton;
    private JButton addGPUButton;
    private JButton addMotherboardButton;
    private JButton addPSUButton;
    private JButton addOtherButton;

    private JButton buildButton;
    private JButton resetButton;

    // Original lists for resetting
    private List<String> originalCPUs;
    private List<String> originalMemories;
    private List<String> originalStorages;
    private List<String> originalGPUs;
    private List<String> originalMotherboards;
    private List<String> originalPSUs;
    private List<String> originalOthers;
    
    public ComputerBuilderApp() {
        super("Computer Builder (Observer + Single Use + Reset + Disable Buttons)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLayout(new BorderLayout());

        // Load parts using adapter
        try {
            CSVReader csvReader = new CSVReader("src/parts.csv");
            csvReader.load();
            partsSource = new CSVPartsAdapter(csvReader);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading parts: " + e.getMessage());
            System.exit(1);
        }

        // Store original lists for resetting purposes
        originalCPUs = partsSource.getCPUs();
        originalMemories = partsSource.getMemories();
        originalStorages = partsSource.getStorages();
        originalGPUs = partsSource.getGraphicsCards();
        originalMotherboards = partsSource.getMotherboards();
        originalPSUs = partsSource.getPSUs();
        originalOthers = partsSource.getOtherParts();

        builder = new ConcreteComputerBuilder();

        JPanel selectionPanel = new JPanel(new GridLayout(19, 2, 5, 5));
        selectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize combo boxes from original parts
        cpuCombo = createCombo(originalCPUs);
        memoryCombo = createCombo(originalMemories);
        storageCombo = createCombo(originalStorages);
        gpuCombo = createCombo(originalGPUs);
        motherboardCombo = createCombo(originalMotherboards);
        psuCombo = createCombo(originalPSUs);
        otherCombo = createCombo(originalOthers);

        selectionPanel.add(new JLabel("CPU:"));
        selectionPanel.add(cpuCombo);

        selectionPanel.add(new JLabel("Memory:"));
        selectionPanel.add(memoryCombo);

        selectionPanel.add(new JLabel("Storage:"));
        selectionPanel.add(storageCombo);

        selectionPanel.add(new JLabel("GPU:"));
        selectionPanel.add(gpuCombo);

        selectionPanel.add(new JLabel("Motherboard:"));
        selectionPanel.add(motherboardCombo);

        selectionPanel.add(new JLabel("PSU:"));
        selectionPanel.add(psuCombo);

        selectionPanel.add(new JLabel("Other:"));
        selectionPanel.add(otherCombo);

        keyboardCheck = new JCheckBox("Add Keyboard");
        mouseCheck = new JCheckBox("Add Mouse");
        monitorCheck = new JCheckBox("Add Monitor");

        selectionPanel.add(keyboardCheck);
        selectionPanel.add(new JLabel());

        selectionPanel.add(mouseCheck);
        selectionPanel.add(new JLabel());

        selectionPanel.add(monitorCheck);
        selectionPanel.add(new JLabel());

        // Buttons to add parts incrementally
        addCPUButton = new JButton("Add Selected CPU");
        addCPUButton.addActionListener(e -> addPart(cpuCombo, selected -> builder.addCPU(selected), addCPUButton));

        addMemoryButton = new JButton("Add Selected Memory");
        addMemoryButton.addActionListener(e -> addPart(memoryCombo, selected -> builder.addMemory(selected), addMemoryButton));

        addStorageButton = new JButton("Add Selected Storage");
        addStorageButton.addActionListener(e -> addPart(storageCombo, selected -> builder.addStorage(selected), addStorageButton));

        addGPUButton = new JButton("Add Selected GPU");
        addGPUButton.addActionListener(e -> addPart(gpuCombo, selected -> builder.addGraphicsCard(selected), addGPUButton));

        addMotherboardButton = new JButton("Add Selected Motherboard");
        addMotherboardButton.addActionListener(e -> addPart(motherboardCombo, selected -> builder.addMotherboard(selected), addMotherboardButton));

        addPSUButton = new JButton("Add Selected PSU");
        addPSUButton.addActionListener(e -> addPart(psuCombo, selected -> builder.addPSU(selected), addPSUButton));

        addOtherButton = new JButton("Add Selected Other Part");
        addOtherButton.addActionListener(e -> addPart(otherCombo, selected -> builder.addOtherPart("Other: " + selected), addOtherButton));

        selectionPanel.add(new JLabel("Add Parts Incrementally:"));
        selectionPanel.add(new JLabel());

        selectionPanel.add(new JLabel("CPU:"));
        selectionPanel.add(addCPUButton);

        selectionPanel.add(new JLabel("Memory:"));
        selectionPanel.add(addMemoryButton);

        selectionPanel.add(new JLabel("Storage:"));
        selectionPanel.add(addStorageButton);

        selectionPanel.add(new JLabel("GPU:"));
        selectionPanel.add(addGPUButton);

        selectionPanel.add(new JLabel("Motherboard:"));
        selectionPanel.add(addMotherboardButton);

        selectionPanel.add(new JLabel("PSU:"));
        selectionPanel.add(addPSUButton);

        selectionPanel.add(new JLabel("Other:"));
        selectionPanel.add(addOtherButton);

        buildButton = new JButton("Finalize & Apply Decorators");
        buildButton.addActionListener(e -> {
            applyDecorators();
            buildButton.setEnabled(false); // Disable after one use
        });

        resetButton = new JButton("Reset Computer");
        resetButton.addActionListener(e -> resetComputer());

        selectionPanel.add(buildButton);
        selectionPanel.add(resetButton);

        add(selectionPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // Initialize a fresh computer at start
        resetComputer();
    }

    private void ensureBaseComputer() {
        if (baseComputer == null) {
            builder.reset();
            baseComputer = builder.getResult();
            baseComputer.attach(this);
            decoratedComputer = baseComputer;
        }
    }

    /**
     * Adds a part from the given combo box using the provided PartAdder lambda,
     * then removes the selected item and disables the button.
     */
    private void addPart(JComboBox<String> comboBox, PartAdder adder, JButton buttonToDisable) {
        ensureBaseComputer();

        String selected = (String) comboBox.getSelectedItem();
        if (selected != null && !selected.isEmpty()) {
            adder.add(selected);
            comboBox.removeItem(selected); // remove chosen part so it can't be chosen again
            buttonToDisable.setEnabled(false); // disable this button after one successful addition
        }
    }

    private void applyDecorators() {
        if (baseComputer == null) {
            JOptionPane.showMessageDialog(this, "No computer parts added yet!");
            return;
        }

        decoratedComputer = baseComputer;
        if (keyboardCheck.isSelected()) decoratedComputer = new KeyboardDecorator(decoratedComputer);
        if (mouseCheck.isSelected()) decoratedComputer = new MouseDecorator(decoratedComputer);
        if (monitorCheck.isSelected()) decoratedComputer = new MonitorDecorator(decoratedComputer);

        update();
    }

    /**
     * Reset the computer:
     * - Reset the builder and create a new baseComputer
     * - Reattach the UI as an observer
     * - Repopulate combo boxes
     * - Re-enable all "Add Part" buttons and the "Finalize & Apply Decorators" button
     * - Clear the UI
     */
    private void resetComputer() {
        builder.reset();
        baseComputer = builder.getResult();
        baseComputer.attach(this);
        decoratedComputer = baseComputer;

        repopulateCombo(cpuCombo, originalCPUs);
        repopulateCombo(memoryCombo, originalMemories);
        repopulateCombo(storageCombo, originalStorages);
        repopulateCombo(gpuCombo, originalGPUs);
        repopulateCombo(motherboardCombo, originalMotherboards);
        repopulateCombo(psuCombo, originalPSUs);
        repopulateCombo(otherCombo, originalOthers);

        // Re-enable all add buttons
        addCPUButton.setEnabled(true);
        addMemoryButton.setEnabled(true);
        addStorageButton.setEnabled(true);
        addGPUButton.setEnabled(true);
        addMotherboardButton.setEnabled(true);
        addPSUButton.setEnabled(true);
        addOtherButton.setEnabled(true);

        // Re-enable build (decorators) button
        buildButton.setEnabled(true);

        resultArea.setText("Computer Reset. Add parts (one each) and apply decorators once.\n");
    }

    private void repopulateCombo(JComboBox<String> combo, List<String> items) {
        combo.removeAllItems();
        for (String item : items) {
            combo.addItem(item);
        }
    }

    @Override
    public void update() {
        resultArea.setText(">> Observer Notified! The computer parts have changed:\n"
                + decoratedComputer.toString());
    }

    private JComboBox<String> createCombo(List<String> items) {
        JComboBox<String> combo = new JComboBox<>();
        for (String item : items) {
            combo.addItem(item);
        }
        return combo;
    }

    @FunctionalInterface
    interface PartAdder {
        void add(String part);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ComputerBuilderApp().setVisible(true));
    }
}