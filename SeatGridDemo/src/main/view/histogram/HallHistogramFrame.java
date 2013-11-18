package main.view.histogram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import main.controller.HistogramFrameController;
import main.model.Event;
import main.model.Hall;
import main.util.Strings;

/**
 * Okno zawierające panel histogramu oraz podstawowe narzędzia pozwalające
 * kontrolować w jaki sposób ma być wyświetlany histogram. Pozwala także na
 * zawężenie wyświetlanych danych.
 *
 * @author bargosc
 */
public class HallHistogramFrame extends javax.swing.JFrame {

    private final HistogramFrameController controller;
    private JButton generateBtn;
    private JComboBox axisCombo;
    private JList eventList;
    private JPanel contentPanel;
    private HallHistogramPanel histogramPanel;
    private Hall hall;

    public HallHistogramFrame(HistogramFrameController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        JPanel sidebar = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        JLabel axisComboLabel = new JLabel();

        eventList = new JList();
        generateBtn = new JButton();
        axisCombo = new JComboBox();
        contentPanel = new JPanel(new BorderLayout());

        eventList.setModel(new DefaultListModel<Event>());
        scrollPane.setViewportView(eventList);

        generateBtn.setText(Strings.BUTTON_GENERATE_HISTOGRAM);
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                onGenerateHistogramClick(evt);
            }
        });

        axisComboLabel.setText(Strings.LABEL_HORIZONTAL_AXIS_SCALING);

        axisCombo.setModel(new DefaultComboBoxModel<>(
                new PeriodAxisLabelSet[]{
            PeriodAxisLabelSet.DETAILED_LABEL_SET,
            PeriodAxisLabelSet.NORMAL_LABEL_SET,
            PeriodAxisLabelSet.BIG_PERIODS_LABEL_SET
        }));
        axisCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                onAxisComboSelect(e);
            }
        });

        GroupLayout sidebarLayout = new GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.Alignment.TRAILING)
                .addGroup(sidebarLayout.createSequentialGroup()
                .addComponent(axisComboLabel)
                .addGap(0, 0, Short.MAX_VALUE))
                .addComponent(axisCombo, 0, GroupLayout.DEFAULT_SIZE,
                              Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING,
                          sidebarLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(generateBtn)
                .addGap(0, 0, 0)));
        sidebarLayout.setVerticalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(sidebarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(scrollPane)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generateBtn)
                .addGap(18, 18, 18)
                .addComponent(axisComboLabel)
                .addGap(0, 0, 0)
                .addComponent(axisCombo, GroupLayout.PREFERRED_SIZE,
                              GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidebar, GroupLayout.PREFERRED_SIZE,
                              GroupLayout.DEFAULT_SIZE,
                              GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                          layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
                .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sidebar, GroupLayout.DEFAULT_SIZE,
                              GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));

        pack();
    }

    public void setHistogramPanel(HallHistogramPanel histogramPanel) {
        contentPanel.removeAll();
        contentPanel.add(histogramPanel, BorderLayout.CENTER);
        this.histogramPanel = histogramPanel;
        pack();
    }

    private void onGenerateHistogramClick(ActionEvent evt) {
        List<Event> selectedEvents = eventList.getSelectedValuesList();
        controller.handleGenerateHistogramClick(this, selectedEvents);
    }

    private void onAxisComboSelect(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            PeriodAxisLabelSet selectedItem = (PeriodAxisLabelSet) e.getItem();
            controller.handleAxisComboSelection(this, selectedItem);
        }
    }

    // Getters & setters
    public JList getEventList() {
        return eventList;
    }

    public HallHistogramPanel getHistogramPanel() {
        return histogramPanel;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
