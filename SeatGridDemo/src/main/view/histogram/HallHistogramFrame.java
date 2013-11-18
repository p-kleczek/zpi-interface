package main.view.histogram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
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

    private final Hall hall;
    private JButton generateBtn;
    private JComboBox axisCombo;
    private JList eventList;
    private JPanel contentPanel;

    public HallHistogramFrame(Hall hall) {
        this.hall = hall;
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

        eventList.setModel(new EventListModel(hall));
        scrollPane.setViewportView(eventList);

        generateBtn.setText(Strings.BUTTON_GENERATE_HISTOGRAM);
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                onGenerateHistogramClick(evt);
            }
        });

        axisComboLabel.setText(Strings.LABEL_HORIZONTAL_AXIS_SCALING);

        axisCombo.setModel(new DefaultComboBoxModel(new String[]{
            PeriodAxisLabelSet.DETAILED_LABEL_SET.getName(),
            PeriodAxisLabelSet.NORMAL_LABEL_SET.getName(),
            PeriodAxisLabelSet.BIG_PERIODS_LABEL_SET.getName()
        }));

        GroupLayout sidebarLayout = new GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.Alignment.TRAILING)
                .addGroup(sidebarLayout.createSequentialGroup()
                .addComponent(axisComboLabel)
                .addGap(0, 0, Short.MAX_VALUE))
                .addComponent(axisCombo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, sidebarLayout.createSequentialGroup()
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
                .addComponent(axisCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidebar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sidebar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));

        pack();
    }

    public void setHistogramPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        pack();
    }

    private void onGenerateHistogramClick(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
