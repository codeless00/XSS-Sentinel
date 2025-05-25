package burp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import org.apache.commons.collections4.map.HashedMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.awt.event.MouseEvent;
import javax.swing.table.AbstractTableModel;

// import org.w3c.dom.events.MouseEvent;

import java.awt.*;
// import java.util.HashMap;
import java.util.*;



public class Settings {

    JPanel parentFrame;

    JButton LoggerClearButton;
    JButton LoggerCancelButton;
    JButton LoggerSaveButton;
    JButton LoggerAutoScroll;
    JButton SettingsDefaultButton;
    JButton SettingsScopeButton;
    JButton SettingsSaveButton;
    JButton ManualAddButton;
    JButton SentinelResetButton;
    JButton SentinelImportButton;
    JButton SentinelExportButton;
    JButton SentinelSaveButton;
    JButton SentinelStopButton;
    JButton SentinelStartButton;
    JButton VerifyCloseButton;
    JButton VerfiyVerifyButton;
    JButton ScopeAddButton;
    JButton ScopeDeleteButtton;
    JButton ScopeEditButton;
    JButton ScopeDoneButton;

    // public static HashMap<String,Object> DefaultSettings;
    public static HashMap<String,String> CurrentSettings;

    public static HashMap<String, SettingsListener> callbacks = new HashMap<>();

    public static ArrayList<String> CurrentScope = new ArrayList<>();

    public static LinkedHashMap<Integer,LinkedHashMap<String,String>> issueData = new LinkedHashMap<>();

    public static String DefaultLogs;
    public static String CurrentLogs;

    public JTextComponent LoggerTextArea;
    public JScrollPane scrollPane;
    public JScrollPane issue_table;

    JCheckBox SettingsBoxActiveScan;
    JCheckBox SettingsBoxHiddenParam;
    JCheckBox SettingsBoxAutomaticVerify;
    JCheckBox SettingsBoxDebug;
    JCheckBox SettingsBoxVerifyParam;
    JCheckBox SettingsBoxMagicPayload;

    JComboBox<String> SettingsBoxAttackMethod;
    JComboBox<String> SettingsBoxAttackType;

    JTextField SettingsBoxThreads;
    JTextField SettingsBoxConcurrentTime;
    JTextField SettingsBoxPayloadFile;
    JTextField SettingsBoxURLFile;
    JTextField SettingsBoxConcurrentRequest;
    JTextField SettingsBoxCrawlDepth;

    JTable issueTable;
    JTable manualTable;
    JTable verifyTable;
    JTable settingsBoxScopeTable;

    DefaultTableModel issueTableModel;
    DefaultTableModel manualTableModel;
    DefaultTableModel verifyTableModel;
    DefaultTableModel settingsBoxScopeTableModel;

    String[] issueColoumnNames = {"Time", "Severity", "Host","Issue Type"};
    String[] manualColoumnNames = {"MANUAL-SCAN"};
    String[] verifyColoumnNames = {"Name","Status"};

    Object[][] issueTableData;
    Object[][] manualTableData;
    Object[][] verifyTableData;

    JTextArea VerifyBoxLeftTextArea;
    JTextArea VerifyBoxRightTextArea;



    public String CurrentLoggerText;

    public boolean isScrollPaneBottom = true;

    Color color_blue = new Color(82,130,255);

    public Highlighter.HighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(color_blue);
    public int searchIndex = 0;

    public int currentSelectedIssueDetailsTab = 1;
    public int searchIndexIssue = 0;








    private JTextArea lineNumberArea;

    public Component getSettings() {

        verifyTableData = new Object[][]{
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"},
            {"Param Verify", "Verified"},
            {"Xss Payload verify", "Pending..."},
            {"Function 3 verify", "Verified"}
        };

        manualTableData = new Object[][]{
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
            {"shopify-admin-manual"},
            {"google-admin-manual"},
            {"paypal-admin-manual"},
        };

        issueTableData = new Object[][]{
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
            {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"},
            {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"},
            {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"},
        };
        parentFrame = new JPanel();
        // parentFrame.setTitle("Swing App");
        // parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // parentFrame.setSize(1500,1200);
        parentFrame.setLayout(new GridLayout(2,1));


        // Create panels
        // JPanel parent_panel = new JPanel(new GridBagLayout());

        JPanel panel_top = new JPanel(new GridLayout(1,2));
        JPanel panel_bottom = new JPanel(new GridLayout(1,2));

        JPanel panel_top_first = new JPanel(new BorderLayout()); 
        JPanel panel_top_second = new JPanel(new BorderLayout());
        JPanel panel_bottom_first = new JPanel(new BorderLayout());

        JPanel panel_bottom_second = new JPanel(new GridLayout(1,2));

        JPanel panel_bottom_second_first = new JPanel(new BorderLayout());
        JPanel panel_bottom_second_second = new JPanel(new BorderLayout());

        panel_bottom_second.add(panel_bottom_second_first);
        panel_bottom_second.add(panel_bottom_second_second);

        panel_top.add(panel_top_first);
        panel_top.add(panel_top_second);

        panel_bottom.add(panel_bottom_first);
        panel_bottom.add(panel_bottom_second);

        // panel_top_first.setBackground(Color.RED);
        // panel_top_second.setBackground(Color.ORANGE);
        // panel_bottom_first.setBackground(Color.LIGHT_GRAY);
        // panel_bottom_second_first.setBackground(Color.LIGHT_GRAY);
        // panel_bottom_second_second.setBackground(Color.LIGHT_GRAY);


        Font font_title = new Font("Monospaced", Font.BOLD, 18);

        JLabel logger_title = new JLabel("LOGGER",SwingConstants.CENTER);
        logger_title.setFont(font_title);
        JLabel settings_title = new JLabel("SETTINGS",SwingConstants.CENTER);
        settings_title.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        settings_title.setFont(font_title);
        JLabel issue_title = new JLabel("ISSUES",SwingConstants.CENTER);
        issue_title.setFont(font_title);
        JLabel verify_title = new JLabel("VERIFICATION",SwingConstants.CENTER);
        verify_title.setFont(font_title);

        JLabel manual_title = new JLabel("ADD-REQUEST",SwingConstants.CENTER);
        manual_title.setFont(font_title);
        manual_title.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 2));




        LoggerTextArea = new JEditorPane();
        // LoggerTextArea.setText();
        // LoggerTextArea.getDocument().putProperty("lineWrap", false);
        // LoggerTextArea.getScrollableTracksViewportWidth()
        LoggerTextArea.setEditable(false);

        LoggerTextArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        LoggerTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
        });

        lineNumberArea = new JTextArea("1");
        // lineNumberArea.setBackground(Color.LIGHT_GRAY);
        lineNumberArea.setEditable(false);
        lineNumberArea.setFocusable(false);
        lineNumberArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

        scrollPane = new JScrollPane(LoggerTextArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setRowHeaderView(lineNumberArea);
        


        // AdjustmentListener scrollBarListener = new AdjustmentListener() {

        //     @Override
        //     public void adjustmentValueChanged(AdjustmentEvent e) {

        //         // TODO Auto-generated method stub
        //         JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        //         int currentValue = verticalScrollBar.getValue();
        //         int visibleValue = verticalScrollBar.getVisibleAmount();
        //         int maximumValue = verticalScrollBar.getMaximum();
        //         // boolean isScrollBarAtBottom = currentValue + visibleValue == maximumValue;
        //         int difference = (maximumValue - (currentValue + visibleValue));
        //         // boolean isScrollBarAtTop =  difference > 10;

        //         System.out.println("Entering Listner");jte
        //         System.out.println("isScrollPaneBottom: " + isScrollPaneBottom);

        //         if (difference == 0) {
        //             if (isScrollPaneBottom) {
        //                 isScrollPaneBottom = false;
        //                 // LoggerTextArea.setCaretPosition(LoggerTextArea.getDocument().getLength());
        //             }
        //             else if (!isScrollPaneBottom) {
        //                 isScrollPaneBottom = true;
        //             }
                    
        //         }

                
        //         System.out.println("isScrollPaneBottom: " + isScrollPaneBottom);
        //         System.out.println("Existing Listner");

                    
                

        //     }
            
        // };
        // scrollPane.getVerticalScrollBar().addAdjustmentListener(scrollBarListener);






        LoggerClearButton = new JButton("CLEAR");

        LoggerClearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentText = LoggerTextArea.getText();
                CurrentLoggerText = currentText;
                LoggerTextArea.setText("");
                LoggerCancelButton.setEnabled(true);
                LoggerSaveButton.setEnabled(true);
                LoggerClearButton.setEnabled(false);
            }
            
        });
        LoggerCancelButton = new JButton("CANCEL");

        LoggerCancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                LoggerTextArea.setText(CurrentLoggerText + LoggerTextArea.getText());
                LoggerClearButton.setEnabled(true);
                LoggerCancelButton.setEnabled(false);
                LoggerSaveButton.setEnabled(false);
            }
            
        });


        LoggerSaveButton = new JButton("SAVE");

        LoggerSaveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                CurrentLoggerText = "";
                LoggerClearButton.setEnabled(true);
                LoggerCancelButton.setEnabled(false);
                LoggerSaveButton.setEnabled(false);
            }
            
        });

        LoggerAutoScroll = new JButton("Auto Scrolling is : ON");

        LoggerAutoScroll.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // System.out.println("Button Clicked Current value of Scroll Pane: " + isScrollPaneBottom);
                
                isScrollPaneBottom = !isScrollPaneBottom;
                LoggerAutoScroll.setText(isScrollPaneBottom ? "Auto Scrolling is : ON" : "Auto Scrolling is : OFF");

                // Utilities.sendToLogger("AutoScrolling: " + isScrollPaneBottom);

                // System.out.println("Button Clicked Current value of Scroll Pane: " + isScrollPaneBottom);


                // System.out.println("Done Processing Scroll Pane: " + isScrollPaneBottom + "\n");

                
            }
            
        });

        LoggerClearButton.setEnabled(true);
        LoggerCancelButton.setEnabled(false);
        LoggerSaveButton.setEnabled(false);

        JButton IssueAutoScroll = new JButton("AutoScroll");
        SentinelResetButton = new JButton("RESET");
        SentinelImportButton = new JButton("IMPORT");
        SentinelExportButton = new JButton("EXPORT");
        SentinelSaveButton = new JButton("SAVE");
        SentinelStopButton = new JButton("STOP");
        SentinelStartButton = new JButton("START");

        SentinelStartButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                new Start();
            }
            
        });

        ManualAddButton = new JButton("ADD REQUEST");




        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel2.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        JPanel buttonPanel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel3.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        
        JPanel buttonPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel4.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

        JTextField textField = new JTextField(30);
        JButton searchButton = new JButton("Regex-Search");


        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action here
                searchButton.doClick();
            }
        });


        JButton rightArrow = new JButton();
        ImageIcon icon = new ImageIcon("/home/raj/Desktop/BURP/burp-extension/XSS-Sentinel/src/Resource/right-arrow.png");
        rightArrow.setIcon(icon);

        rightArrow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                searchIndex++;
                highlightNext(textField);            
            }
            
        });

        JButton leftArrow = new JButton();
        ImageIcon icon2 = new ImageIcon("/home/raj/Desktop/BURP/burp-extension/XSS-Sentinel/src/Resource/left-arrow.png");
        leftArrow.setIcon(icon2);

        leftArrow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                searchIndex--;
                highlightPrevious(textField);            }
            
        });

        // JButton tmp = new JButton("            ");


        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                String searchText = textField.getText();
                if (!searchText.isEmpty()) {
                    searchIndex = 0;
                    highlightText(searchText);
                }            }
            
        });
        // searchButton.setPreferredSize(new Dimension(Integer.MAX_VALUE, searchButton.getPreferredSize().height));
        // Insets insets = textField.getMargin();
        // textField.setMargin(new Insets(insets.top, insets.left, insets.bottom, 20)); 
        // textField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));


        buttonPanel.add(leftArrow);
        buttonPanel.add(rightArrow);

        buttonPanel.add(textField);
        buttonPanel.add(searchButton);

        // buttonPanel.add(new JLabel("      "));


        buttonPanel.add(LoggerAutoScroll);
        buttonPanel.add(LoggerClearButton);
        buttonPanel.add(LoggerCancelButton);
        buttonPanel.add(LoggerSaveButton);

        buttonPanel2.add(SentinelResetButton);
        buttonPanel2.add(SentinelImportButton);
        buttonPanel2.add(SentinelExportButton);

        buttonPanel3.add(SentinelSaveButton);
        buttonPanel3.add(SentinelStopButton);
        buttonPanel3.add(SentinelStartButton);

        buttonPanel4.add(ManualAddButton);


        // add(scrollPane, BorderLayout.CENTER);


        // Create a table model
        // new DefaultTableMod
        issueTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells uneditable
            }
        };
        
        issueTableModel.addColumn("Time");
        issueTableModel.addColumn("Severity");
        issueTableModel.addColumn("Host");
        issueTableModel.addColumn("Title");

        // System.out.println("Row count before adding row: " + issueTableModel.getRowCount());

        // String[] row_first = {"14:19:16 14 Apr 2024", "INFORMATIVE","www.google.com","xss-exploit"};
        // String[] row_second = {"15:20:26 14 Apr 2024", "LOW","www.shopify.com","cache-purge"};
        // String[] row_third = {"14:19:16 14 Apr 2024", "HIGH","www.amazon.com","request-spitting"};

        // issueTableModel.addRow(row_first);
        // issueTableModel.addRow(row_second);
        // issueTableModel.addRow(row_third);

        // System.out.println("Row count before adding row: " + issueTableModel.getRowCount());





        issueTable = new JTable(issueTableModel);
        issueTable.setDragEnabled(false);
        issueTable.getTableHeader().setReorderingAllowed(false);
        issueTable.setDropMode(DropMode.USE_SELECTION);
        issue_table = new JScrollPane(issueTable);
        issue_table.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        issueTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2 && issueTable.getRowCount() > 0) {
                    int selectedRow = issueTable.getSelectedRow();
                    if (selectedRow != -1) {
                        show_issue_data(Utilities.getBurpFrame(), selectedRow);
                        // Perform action when a row is double-clicked
                        
                    }
                }
            }
        });
        issueTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println("Key Pressed" + e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    int selectedRow = issueTable.getSelectedRow();
                    if (selectedRow != -1) {
                        show_issue_data(Utilities.getBurpFrame(), selectedRow);
                    }
                }
                
            }
        });


        manualTableModel = new DefaultTableModel(manualTableData, manualColoumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells uneditable
            }
        };
        manualTable = new JTable(manualTableModel);
        manualTable.setDragEnabled(false);
        manualTable.getTableHeader().setReorderingAllowed(false);
        manualTable.setDropMode(DropMode.USE_SELECTION);
        JScrollPane manual_table = new JScrollPane(manualTable);
        manual_table.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));


        DefaultTableModel verifyTableModel = new DefaultTableModel(verifyTableData, verifyColoumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells uneditable
            }
        };
        JTable verifyTable = new JTable(verifyTableModel);
        
        verifyTable.setDragEnabled(false);
        verifyTable.getTableHeader().setReorderingAllowed(false);
        // table_three.setDropMode(DropMode.USE_SELECTION);
        JScrollPane verify_table = new JScrollPane(verifyTable);
        verify_table.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 0));

        verifyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2 && verifyTable.getRowCount() > 0) {
                    int selectedRow = verifyTable.getSelectedRow();
                    if (selectedRow != -1) {
                        verify_row(Utilities.getBurpFrame(), selectedRow);
                        // Perform action when a row is double-clicked
                        
                    }
                }
            }
        });
        verifyTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println("Key Pressed" + e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume();
                    int selectedRow = verifyTable.getSelectedRow();
                    if (selectedRow != -1) {
                        verify_row(Utilities.getBurpFrame(), selectedRow);
                    }
                }
                
            }
        });
















        /// It's code for the entire panel_top_second

        
        // Font font_title = new Font("Monospaced", Font.BOLD, 18);
        Font font_normal = new Font("Monospaced", Font.PLAIN, 16);


        // JLabel label = new JLabel("SETTINGS",SwingConstants.CENTER);
        // label.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        // label.setFont(font_title);

        JLabel label_two = new JLabel("  Active Scan:");
        label_two.setFont(font_normal);

        JLabel label_three = new JLabel("  Hidden Param:");
        label_three.setFont(font_normal);

        JLabel label_four = new JLabel("  Automatic Verify:");
        label_four.setFont(font_normal);

        JLabel label_five = new JLabel("  Attack Method:");
        label_five.setFont(font_normal);

        JLabel label_six = new JLabel("  Threads:");
        label_six.setFont(font_normal);

        JLabel label_seven = new JLabel("  Concurrent Time");
        label_seven.setFont(font_normal);

        JLabel label_eight = new JLabel("  Payload File:");
        label_eight.setFont(font_normal);

        JLabel label_nine = new JLabel("  URL File:");
        label_nine.setFont(font_normal);

        JLabel label_ten = new JLabel("  Debug:");
        label_ten.setFont(font_normal);

        JLabel label_eleven = new JLabel("  Verify-Param:");
        label_eleven.setFont(font_normal);

        JLabel label_tewelve = new JLabel("  Magic-Payload:");
        label_tewelve.setFont(font_normal);

        JLabel label_thirteen = new JLabel("  Attack-Type:");
        label_thirteen.setFont(font_normal);

        JLabel label_fourteen = new JLabel("  Concurrent-Request:");
        label_fourteen.setFont(font_normal);

        JLabel label_fifteen = new JLabel("  Crawl-Depth:");
        label_fifteen.setFont(font_normal);


        JPanel northPanel = new JPanel(new GridLayout(0,4));
        northPanel.setBackground(Color.ORANGE);




        SettingsBoxActiveScan = new JCheckBox();

        SettingsBoxActiveScan.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                Utilities.callSettingListener(Utilities.ActiveScan, String.valueOf(SettingsBoxActiveScan.isSelected()), false);
            }
        });

        SettingsBoxHiddenParam = new JCheckBox();

        SettingsBoxHiddenParam.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                Utilities.callSettingListener(Utilities.HiddenParam, String.valueOf(SettingsBoxHiddenParam.isSelected()), false);
            }
            
        });

        SettingsBoxAutomaticVerify = new JCheckBox();

        SettingsBoxAutomaticVerify.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                Utilities.callSettingListener(Utilities.AutomaticVerify, String.valueOf(SettingsBoxAutomaticVerify.isSelected()), false);

            }
            
        });

        SettingsBoxDebug = new JCheckBox();

        SettingsBoxDebug.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                Utilities.callSettingListener(Utilities.Debug, String.valueOf(SettingsBoxDebug.isSelected()), false);
            }
            
        });

        SettingsBoxVerifyParam = new JCheckBox();

        SettingsBoxVerifyParam.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                Utilities.callSettingListener(Utilities.VerifyParam, String.valueOf(SettingsBoxVerifyParam.isSelected()), false);
            }
            
        });

        SettingsBoxMagicPayload = new JCheckBox();

        SettingsBoxMagicPayload.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                Utilities.callSettingListener(Utilities.MagicPayloads, String.valueOf(SettingsBoxMagicPayload.isSelected()), false);
            }
            
        });

        JCheckBox checkBox_seven = new JCheckBox();
        JCheckBox checkBox_eight = new JCheckBox();

        String[] items = {"GET", "POST", "BOTH"};
        String[] items_two = {"MANUAL", "AUTOMATIC", "BOTH"};

        SettingsBoxAttackMethod = new JComboBox<>(items);

    

        SettingsBoxAttackMethod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected item
                String selectedValue = (String) SettingsBoxAttackMethod.getSelectedItem();
                Utilities.callSettingListener(Utilities.AttackMethod,selectedValue,false);
            }
        });

        SettingsBoxAttackType = new JComboBox<>(items_two);

        SettingsBoxAttackType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected item
                String selectedValue = (String) SettingsBoxAttackType.getSelectedItem();
                Utilities.callSettingListener(Utilities.AttackType,selectedValue,false);
            }
        });

        SettingsBoxThreads = new JTextField();
        SettingsBoxThreads.addFocusListener(new FocusListener() {

            String oldText;

            @Override
            public void focusGained(FocusEvent arg0) {
                oldText = SettingsBoxThreads.getText();
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                String updatedValue = SettingsBoxThreads.getText();
                if (!updatedValue.equals(oldText)) {
                    Utilities.callSettingListener(Utilities.Threads, updatedValue,false);

                    
                }
            }
            
        });

        SettingsBoxConcurrentTime = new JTextField();

        SettingsBoxConcurrentTime.addFocusListener(new FocusListener() {

            String oldText;

            @Override
            public void focusGained(FocusEvent arg0) {
                oldText = SettingsBoxConcurrentTime.getText();
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                String updatedValue = SettingsBoxConcurrentTime.getText();
                if (!updatedValue.equals(oldText)) {
                    Utilities.callSettingListener(Utilities.ConcurrentTime, updatedValue,false);

                    
                }
            }
            
        });


        SettingsBoxPayloadFile = new JTextField();

        SettingsBoxPayloadFile.addFocusListener(new FocusListener() {

            String oldText;

            @Override
            public void focusGained(FocusEvent arg0) {
                oldText = SettingsBoxPayloadFile.getText();
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                String updatedValue = SettingsBoxPayloadFile.getText();
                if (!updatedValue.equals(oldText)) {
                    Utilities.callSettingListener(Utilities.PayloadFile, updatedValue,false);

                    
                }
            }
            
        });

        SettingsBoxURLFile = new JTextField();

        SettingsBoxURLFile.addFocusListener(new FocusListener() {

            String oldText;

            @Override
            public void focusGained(FocusEvent arg0) {
                oldText = SettingsBoxURLFile.getText();
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                String updatedValue = SettingsBoxURLFile.getText();
                if (!updatedValue.equals(oldText)) {
                    Utilities.callSettingListener(Utilities.URLFile, updatedValue,false);

                    
                }
            }
            
        });

        SettingsBoxConcurrentRequest = new JTextField();

        SettingsBoxConcurrentRequest.addFocusListener(new FocusListener() {

            String oldText;

            @Override
            public void focusGained(FocusEvent arg0) {
                oldText = SettingsBoxConcurrentRequest.getText();
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                String updatedValue = SettingsBoxConcurrentRequest.getText();
                if (!updatedValue.equals(oldText)) {
                    Utilities.callSettingListener(Utilities.ConcurrentRequest, updatedValue,false);

                    
                }
            }
            
        });

        SettingsBoxCrawlDepth = new JTextField();

        SettingsBoxCrawlDepth.addFocusListener(new FocusListener() {

            String oldText;

            @Override
            public void focusGained(FocusEvent arg0) {
                oldText = SettingsBoxCrawlDepth.getText();
            }

            @Override
            public void focusLost(FocusEvent arg0) {
                
                String updatedValue = SettingsBoxCrawlDepth.getText();
                

                if (!updatedValue.equals(oldText)) {
                    Utilities.callSettingListener(Utilities.CrawlDepth, updatedValue,false);

                    
                }
            }
            
        });

        JTextField area_seven = new JTextField();
        JTextField area_eight = new JTextField();

        GridLayout layout_two = new GridLayout(8,0);
        layout_two.setVgap(20);
        JPanel label_panel = new JPanel(layout_two);
        GridLayout layout = new GridLayout(8,0);
        layout.setVgap(20);
        // layout.setHgap(10);
        JPanel checkBox_panel = new JPanel(layout);



        GridLayout layout_three = new GridLayout(8,0);
        layout_three.setVgap(20);
        JPanel label_panel_two = new JPanel(layout_three);

        GridLayout layout_four = new GridLayout(8,0);
        layout_four.setVgap(20);
        // layout.setHgap(10);
        JPanel checkBox_panel_two = new JPanel(layout_four);
        


        label_panel.add(label_two);
        label_panel.add(label_three);
        label_panel.add(label_four);
        label_panel.add(label_five);
        label_panel.add(label_six);
        label_panel.add(label_seven);
        label_panel.add(label_eight);
        label_panel.add(label_nine);

        northPanel.add(label_panel);



        checkBox_panel.add(SettingsBoxActiveScan);
        checkBox_panel.add(SettingsBoxHiddenParam);
        checkBox_panel.add(SettingsBoxAutomaticVerify);
        checkBox_panel.add(SettingsBoxAttackMethod);
        checkBox_panel.add(SettingsBoxThreads);
        checkBox_panel.add(SettingsBoxConcurrentTime);
        checkBox_panel.add(SettingsBoxPayloadFile);
        checkBox_panel.add(SettingsBoxURLFile);

        northPanel.add(checkBox_panel);


        label_panel_two.add(label_ten);
        label_panel_two.add(label_eleven);
        label_panel_two.add(label_tewelve);
        label_panel_two.add(label_thirteen);
        label_panel_two.add(label_fourteen);
        label_panel_two.add(label_fifteen);
        label_panel_two.add(new JLabel());
        label_panel_two.add(new JLabel());

        checkBox_panel_two.add(SettingsBoxDebug);
        checkBox_panel_two.add(SettingsBoxVerifyParam);
        checkBox_panel_two.add(SettingsBoxMagicPayload);
        checkBox_panel_two.add(SettingsBoxAttackType);
        checkBox_panel_two.add(SettingsBoxConcurrentRequest);
        checkBox_panel_two.add(SettingsBoxCrawlDepth);
        checkBox_panel_two.add(new JLabel());
        checkBox_panel_two.add(new JLabel());





        // northPanel.add(label_panel_two);
        // northPanel.add(checkBox_panel_two);


        // northPanel.add(comboBox_two);
        // northPanel.add(area_five);
        // northPanel.add(area_six);
        // northPanel.add(area_seven);
        // northPanel.add(area_eight);
        // // northPanel.add(area_one);

        // northPanel.add(new JLabel());
        // northPanel.add(new JLabel());
        // northPanel.add(new JLabel());
        // northPanel.add(new JLabel());

        northPanel.add(label_panel_two);
        northPanel.add(checkBox_panel_two);





     



        SettingsSaveButton = new JButton("SAVE");

        SettingsSaveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Boolean active_scan = SettingsBoxActiveScan.isSelected();
                Boolean hidden_param = SettingsBoxHiddenParam.isSelected();
                Boolean automatic_verify = SettingsBoxAutomaticVerify.isSelected();
                Boolean debug = SettingsBoxDebug.isSelected();
                Boolean verify_param = SettingsBoxVerifyParam.isSelected();
                Boolean magic_payload = SettingsBoxMagicPayload.isSelected();
                String attack_method = (String) SettingsBoxAttackMethod.getSelectedItem();
                String attack_type = (String) SettingsBoxAttackType.getSelectedItem();
                String thread = SettingsBoxThreads.getText();
                String concurrent_request = SettingsBoxConcurrentRequest.getText();
                String concurrent_time = SettingsBoxConcurrentTime.getText();
                String payload_file = SettingsBoxPayloadFile.getText();
                String url_file = SettingsBoxURLFile.getText();
                String crawl_depth = SettingsBoxCrawlDepth.getText();

                if (CurrentSettings == null) {
                    CurrentSettings = new HashMap<>();
                    CurrentSettings.put(Utilities.ActiveScan, String.valueOf(active_scan));
                    CurrentSettings.put(Utilities.HiddenParam, String.valueOf(hidden_param));
                    CurrentSettings.put(Utilities.AutomaticVerify, String.valueOf(automatic_verify));
                    CurrentSettings.put(Utilities.Debug, String.valueOf(debug));
                    CurrentSettings.put(Utilities.VerifyParam, String.valueOf(verify_param));
                    CurrentSettings.put(Utilities.MagicPayloads, String.valueOf(magic_payload));
                    CurrentSettings.put(Utilities.AttackMethod, attack_method);
                    CurrentSettings.put(Utilities.AttackType, attack_type);
                    CurrentSettings.put(Utilities.Threads, thread);
                    CurrentSettings.put(Utilities.ConcurrentRequest, concurrent_request);
                    CurrentSettings.put(Utilities.ConcurrentTime, concurrent_time);
                    CurrentSettings.put(Utilities.PayloadFile, payload_file);
                    CurrentSettings.put(Utilities.URLFile, url_file);
                    CurrentSettings.put(Utilities.CrawlDepth, crawl_depth);

                    SettingsSaveButton.setEnabled(false);
                }

                else{

                    if (!CurrentSettings.get(Utilities.ActiveScan).equals(String.valueOf(active_scan))) {
                        CurrentSettings.put(Utilities.ActiveScan, String.valueOf(active_scan));
                        Utilities.callSettingListener(Utilities.ActiveScan, String.valueOf(active_scan), true);
                    }

                    if (!CurrentSettings.get(Utilities.HiddenParam).equals(String.valueOf(hidden_param))) {
                        CurrentSettings.put(Utilities.HiddenParam, String.valueOf(hidden_param));
                        Utilities.callSettingListener(Utilities.HiddenParam, String.valueOf(hidden_param), true);
                    }

                    if (!CurrentSettings.get(Utilities.AutomaticVerify).equals(String.valueOf(automatic_verify))) {
                        CurrentSettings.put(Utilities.AutomaticVerify, String.valueOf(automatic_verify));
                        Utilities.callSettingListener(Utilities.AutomaticVerify, String.valueOf(automatic_verify), true);
                    }

                    if (!CurrentSettings.get(Utilities.Debug).equals(String.valueOf(debug))) {
                        CurrentSettings.put(Utilities.Debug, String.valueOf(debug));
                        Utilities.callSettingListener(Utilities.Debug, String.valueOf(debug), true);
                    }

                    if (!CurrentSettings.get(Utilities.VerifyParam).equals(String.valueOf(verify_param))) {
                        CurrentSettings.put(Utilities.VerifyParam, String.valueOf(verify_param));
                        Utilities.callSettingListener(Utilities.VerifyParam, String.valueOf(verify_param), true);
                    }

                    if (!CurrentSettings.get(Utilities.MagicPayloads).equals(String.valueOf(magic_payload))) {
                        CurrentSettings.put(Utilities.MagicPayloads, String.valueOf(magic_payload));
                        Utilities.callSettingListener(Utilities.MagicPayloads, String.valueOf(magic_payload), true);
                    }

                    if (!CurrentSettings.get(Utilities.AttackMethod).equals(attack_method)) {
                        CurrentSettings.put(Utilities.AttackMethod, attack_method);
                        Utilities.callSettingListener(Utilities.AttackMethod, attack_method, true);
                    }

                    if (!CurrentSettings.get(Utilities.AttackType).equals(attack_type)) {
                        CurrentSettings.put(Utilities.AttackType, attack_type);
                        Utilities.callSettingListener(Utilities.AttackType, attack_type, true);
                    }

                    if (!CurrentSettings.get(Utilities.Threads).equals(thread)) {
                        CurrentSettings.put(Utilities.Threads, thread);
                        Utilities.callSettingListener(Utilities.Threads, thread, true);
                    }
                    if (!CurrentSettings.get(Utilities.ConcurrentRequest).equals(concurrent_request)) {
                        CurrentSettings.put(Utilities.ConcurrentRequest, concurrent_request);
                        Utilities.callSettingListener(Utilities.ConcurrentRequest, concurrent_request, true);
                    }

                    if (!CurrentSettings.get(Utilities.ConcurrentTime).equals(concurrent_time)) {
                        CurrentSettings.put(Utilities.ConcurrentTime, concurrent_time);
                        Utilities.callSettingListener(Utilities.ConcurrentTime, concurrent_time, true);
                    }

                    if (!CurrentSettings.get(Utilities.PayloadFile).equals(payload_file)) {
                        CurrentSettings.put(Utilities.PayloadFile, payload_file);
                        Utilities.callSettingListener(Utilities.PayloadFile, payload_file, true);
                    }

                    if (!CurrentSettings.get(Utilities.URLFile).equals(url_file)) {
                        CurrentSettings.put(Utilities.URLFile, url_file);
                        Utilities.callSettingListener(Utilities.URLFile, url_file, true);
                    }

                    if (!CurrentSettings.get(Utilities.CrawlDepth).equals(crawl_depth)) {
                        CurrentSettings.put(Utilities.CrawlDepth, crawl_depth);
                        Utilities.callSettingListener(Utilities.CrawlDepth, crawl_depth, true);
                    }


                    int rowCount = settingsBoxScopeTableModel.getRowCount();
                    ArrayList<String> columnValues = new ArrayList<>();
            
                    // Assuming the column index is 0
                    int columnIndex = 0;
            
                    for (int i = 0; i < rowCount; i++) {
                        // Get the value at the specified row and column
                        Object value = settingsBoxScopeTableModel.getValueAt(i, columnIndex);
            
                        // Convert the value to a string and add it to the list
                        String strValue = (value == null) ? "" : value.toString();
                        columnValues.add(strValue);
                    }
                    if (Utilities.isScopeChanged(columnValues)) {
                        CurrentScope = columnValues;
                        PreWorker.ScopeListner(columnValues, true);
                    }

                    





                    SettingsSaveButton.setEnabled(false);



                }
            }
            
        });
        SettingsScopeButton = new JButton("SCOPE");

        SettingsScopeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                showChildPanel(Utilities.getBurpFrame());
            }
            
        });

        SettingsDefaultButton = new JButton("DEFAULT");

        SettingsDefaultButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Utilities.setDefaultSettings();
            }
            
        });


        JPanel buttonPanel_two = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel_two.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

  
        buttonPanel_two.add(SettingsDefaultButton);
        buttonPanel_two.add(SettingsScopeButton);
        buttonPanel_two.add(SettingsSaveButton);
















        

        panel_top_first.add(scrollPane,BorderLayout.CENTER);
        panel_top_first.add(logger_title,BorderLayout.NORTH);
        panel_top_first.add(buttonPanel,BorderLayout.SOUTH);

        panel_top_second.add(northPanel,BorderLayout.CENTER);
        panel_top_second.add(settings_title,BorderLayout.NORTH);
        panel_top_second.add(buttonPanel_two,BorderLayout.SOUTH);


        panel_bottom_first.add(issue_table,BorderLayout.CENTER);
        panel_bottom_first.add(issue_title,BorderLayout.NORTH);
        panel_bottom_first.add(buttonPanel2,BorderLayout.SOUTH);

        // panel_bottom_second.add(buttonPanel3,BorderLayout.SOUTH);


        panel_bottom_second_first.add(manual_table,BorderLayout.CENTER);
        panel_bottom_second_first.add(manual_title,BorderLayout.NORTH);
        panel_bottom_second_first.add(buttonPanel4,BorderLayout.SOUTH);


        panel_bottom_second_second.add(verify_table,BorderLayout.CENTER);
        panel_bottom_second_second.add(verify_title,BorderLayout.NORTH);
        panel_bottom_second_second.add(buttonPanel3,BorderLayout.SOUTH);



        // Set layout for the frame

        parentFrame.add(panel_top);
        parentFrame.add(panel_bottom);

        // pack(); // Sizes the frame to fit its content
        // parentFrame.setLocationRelativeTo(null); // Center the frame on the screen
        // parentFrame.setVisible(true);

        return parentFrame;
    }

    private void updateLineNumbers() {
        String text = LoggerTextArea.getText();
        int lineCount = text.split("\n", -1).length;
        StringBuilder numbers = new StringBuilder();
        for (int i = 1; i <= lineCount; i++) {
            numbers.append(i).append("\n");
        }
        lineNumberArea.setText(numbers.toString());
    }


    public void showChildPanel(JFrame parentFrame) {

        // settingsBoxScopeTableModel;
        // HashMap<String, ArrayList<String>> settingData;



        // settingsBoxScopeTableModel = new DefaultTableModel() {
        //     @Override
        //     public boolean isCellEditable(int row, int column) {
        //         // Make all cells uneditable
        //         return true;
        //     }
        // };
        // settingsBoxScopeTableModel.addColumn("");

        // settingData = new HashMap<>();
        // Font font = new Font("Arial", Font.BOLD, 20);
        Font font_normal = new Font("Arial", Font.PLAIN, 15);
        // setTitle("Rules");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(600, 200);
        // setLocationRelativeTo(null);
        // setResizable(false);
        JDialog childDialog = new JDialog(parentFrame, "SCOPE", true);

        JPanel panel = new JPanel(new BorderLayout());
        childDialog.setSize(600,200);
        // childDialog.setMaximumSize(new Dimension(600,200));
        childDialog.setResizable(false);
        

        // model = new DefaultTableModel();
    

        settingsBoxScopeTable = new JTable(settingsBoxScopeTableModel);
        settingsBoxScopeTable.setFont(font_normal);


        JScrollPane scrollPane = new JScrollPane(settingsBoxScopeTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        ScopeAddButton = new JButton("Add");
        ScopeAddButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                settingsBoxScopeTableModel.addRow(new Object[]{""});
                int selectedRow = settingsBoxScopeTable.getRowCount() -1;
                if (selectedRow != -1) {
                    // Put the selected cell into edit mode
                    settingsBoxScopeTable.editCellAt(selectedRow, 0);
                    // Select the entire row
                    settingsBoxScopeTable.setRowSelectionInterval(selectedRow, selectedRow);
                    // Show the blinking cursor
                    settingsBoxScopeTable.requestFocusInWindow();
                }
            }
            
        });
        
        
        

        ScopeEditButton = new JButton("Edit");
        ScopeEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = settingsBoxScopeTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Put the selected cell into edit mode
                    settingsBoxScopeTable.editCellAt(selectedRow, 0);
                    // Select the entire row
                    settingsBoxScopeTable.setRowSelectionInterval(selectedRow, selectedRow);
                    // Show the blinking cursor
                    settingsBoxScopeTable.requestFocusInWindow();
                } else {
                    JOptionPane.showMessageDialog(parentFrame,
                            "Please select a row to edit.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        


        ScopeDeleteButtton = new JButton("Delete");
        ScopeDeleteButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = settingsBoxScopeTable.getSelectedRow();
                if (selectedRow != -1) {
                    settingsBoxScopeTableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(parentFrame, "Please select a row to delete.");
                }
            }
        });

        ScopeDoneButton = new JButton("Done");
        ScopeDoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            
                KeyEvent ke = new KeyEvent(ScopeDoneButton, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_ENTER, KeyEvent.CHAR_UNDEFINED);
                KeyboardFocusManager.getCurrentKeyboardFocusManager().redispatchEvent(settingsBoxScopeTable, ke);

                int rowCount = settingsBoxScopeTableModel.getRowCount();
                ArrayList<String> columnValues = new ArrayList<>();
        
                // Assuming the column index is 0
                int columnIndex = 0;
        
                for (int i = 0; i < rowCount; i++) {
                    // Get the value at the specified row and column
                    Object value = settingsBoxScopeTableModel.getValueAt(i, columnIndex);
        
                    // Convert the value to a string and add it to the list
                    String strValue = (value == null) ? "" : value.toString();
                    columnValues.add(strValue);
                }

                PreWorker.ScopeListner(columnValues, false);

                childDialog.dispose();
            }
        });


        buttonPanel.add(ScopeAddButton);
        buttonPanel.add(ScopeEditButton);
        buttonPanel.add(ScopeDeleteButtton);
        buttonPanel.add(ScopeDoneButton);


        panel.add(buttonPanel, BorderLayout.EAST);

        childDialog.add(panel);
        // childDialog.pack();
        childDialog.setLocationRelativeTo(parentFrame);
        childDialog.setVisible(true);
    }













    public void verify_row(JFrame parentFrame, int selectedRow) {


        Font font = new Font("Arial", Font.PLAIN, 16);
        // Font font_normal = new Font("Arial", Font.PLAIN, 15);

        JPanel textPanel = new JPanel(new GridLayout(1, 2));

        VerifyBoxLeftTextArea = new JTextArea("INPUT");
        VerifyBoxLeftTextArea.setFont(font);
        VerifyBoxLeftTextArea.setLineWrap(true);
        VerifyBoxLeftTextArea.setWrapStyleWord(true);
        VerifyBoxLeftTextArea.setEditable(false);
        JScrollPane leftScrollPane = new JScrollPane(VerifyBoxLeftTextArea);
        textPanel.add(leftScrollPane);
        
                    // Right text box
        VerifyBoxRightTextArea = new JTextArea("OUTPUT");
        VerifyBoxRightTextArea.setFont(font);
        VerifyBoxRightTextArea.setLineWrap(true);
        VerifyBoxRightTextArea.setWrapStyleWord(true);
        JScrollPane rightScrollPane = new JScrollPane(VerifyBoxRightTextArea);
        textPanel.add(rightScrollPane);


        // setTitle("Rules");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(600, 200);
        // setLocationRelativeTo(null);
        // setResizable(false);
        JDialog childDialog = new JDialog(parentFrame, "VERIFICATION", true);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(textPanel, BorderLayout.CENTER);
        childDialog.setSize(800,500);
        // childDialog.setMaximumSize(new Dimension(600,200));
        // childDialog.setResizable(false);
        

        // model = new DefaultTableModel();
    
        // model.addColumn("");

        // table = new JTable(model);
        // table.setFont(font_normal);
        // JScrollPane scrollPane = new JScrollPane(table);
        // panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    
        VerfiyVerifyButton = new JButton("Verify");
        VerfiyVerifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                childDialog.dispose();
            }
        });

        VerifyCloseButton = new JButton("Close");
        VerifyCloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                childDialog.dispose();
            }
        });

        buttonPanel.add(VerifyCloseButton);
        buttonPanel.add(VerfiyVerifyButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        childDialog.add(panel);
        // childDialog.pack();
        childDialog.setLocationRelativeTo(parentFrame);
        childDialog.setVisible(true);
    }


    public void show_issue_data(JFrame parentFrame, int selectedRow) {


        Font font = new Font("Arial", Font.PLAIN, 16);
        // Font font_normal = new Font("Arial", Font.PLAIN, 15);

        JPanel textPanel = new JPanel(new BorderLayout());

        JTabbedPane pane = new JTabbedPane();

        pane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
                int selectedIndex = sourceTabbedPane.getSelectedIndex();
                currentSelectedIssueDetailsTab = selectedIndex;
                String selectedTabName = sourceTabbedPane.getTitleAt(selectedIndex);
                Utilities.sendToLogger("Tab \"" + selectedTabName + "\" selected");
            }
        });



        // issueTableModel.getValueAt(selectedRow, selectedRow);
        LinkedHashMap<String,String> tabs_to_show = new LinkedHashMap<>();
        // System.out.println("selected row: " + selectedRow);
        tabs_to_show = Settings.issueData.get(selectedRow);

        for (String tab_name : tabs_to_show.keySet()) {
            String tab_value = tabs_to_show.get(tab_name);
            JTextArea textArea = new JTextArea(tab_value);
            textArea.setFont(font);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setEditable(false);
            JScrollPane sc = new JScrollPane(textArea);
            textPanel.add(sc);

            pane.addTab(tab_name, sc);

        }

        textPanel.add(pane);

        // pane.getTabComponentAt(1);


        JDialog childDialog = new JDialog(parentFrame, "ISSUE DETAILS", true);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(textPanel, BorderLayout.CENTER);
        childDialog.setSize(800,500);
        // childDialog.setMaximumSize(new Dimension(600,200));
        // childDialog.setResizable(false);
        

        // model = new DefaultTableModel();
    
        // model.addColumn("");

        // table = new JTable(model);
        // table.setFont(font_normal);
        // JScrollPane scrollPane = new JScrollPane(table);
        // panel.add(scrollPane, BorderLayout.CENTER);

        JPanel tmpPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel_one = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttonPanel_two = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    
        // VerfiyVerifyButton = new JButton("Verify");
        // VerfiyVerifyButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         childDialog.dispose();
        //     }
        // });
        JTextField textField = new JTextField(30);

        JButton searchButton = new JButton("Regex-Search");

        
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action here
                searchButton.doClick();
            }
        });



        JButton rightArrow = new JButton();
        ImageIcon icon = new ImageIcon("/home/raj/Desktop/BURP/burp-extension/XSS-Sentinel/src/Resource/right-arrow.png");
        rightArrow.setIcon(icon);

        rightArrow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                searchIndexIssue++;
                String searchText = textField.getText();
                if (!searchText.isEmpty()) {
                    JScrollPane scrollPane = (JScrollPane) pane.getComponentAt(currentSelectedIssueDetailsTab);
                    JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();    
                    String text = textArea.getText();
                    int index = text.toLowerCase().indexOf(searchText.toLowerCase(), searchIndexIssue + searchText.length());
                    if (index != -1) {
                        searchIndexIssue = index;
                        highlightTextIssue(searchText,textArea);
                    } else {
                        // If not found, reset the search index to the beginning
                        searchIndexIssue = 0;
                        highlightTextIssue(searchText,textArea);
                    }
                }           
            }
            
        });

        JButton leftArrow = new JButton();
        ImageIcon icon2 = new ImageIcon("/home/raj/Desktop/BURP/burp-extension/XSS-Sentinel/src/Resource/left-arrow.png");
        leftArrow.setIcon(icon2);

        leftArrow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                searchIndexIssue--;
                String searchText = textField.getText();
                if (!searchText.isEmpty()) {
                    searchIndex -= 2 * searchText.length();
                    JScrollPane scrollPane = (JScrollPane) pane.getComponentAt(currentSelectedIssueDetailsTab);
                    JTextArea textArea = (JTextArea) scrollPane.getViewport().getView(); 
                    highlightTextIssue(searchText,textArea);
                }           }
            
        });

        // JButton tmp = new JButton("            ");


        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                searchIndexIssue = 0;
                String searchText = textField.getText();
                JScrollPane scrollPane = (JScrollPane) pane.getComponentAt(currentSelectedIssueDetailsTab);
                JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();

                highlightTextIssue(searchText, textArea);
            }
            
        });

        VerifyCloseButton = new JButton("Close");
        VerifyCloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                childDialog.dispose();
            }
        });

        buttonPanel_one.add(leftArrow);
        buttonPanel_one.add(rightArrow);
        buttonPanel_one.add(textField);
        buttonPanel_one.add(searchButton);



        buttonPanel_two.add(VerifyCloseButton);
        // buttonPanel.add(VerfiyVerifyButton);

        tmpPanel.add(buttonPanel_one,BorderLayout.WEST);
        tmpPanel.add(buttonPanel_two,BorderLayout.EAST);

        panel.add(tmpPanel, BorderLayout.SOUTH);

        childDialog.add(panel);
        // childDialog.pack();
        childDialog.setLocationRelativeTo(parentFrame);
        childDialog.setVisible(true);
    }



































     // Highlight the searched text
    private void highlightText(String searchText) {
        LoggerTextArea.getHighlighter().removeAllHighlights();
        String text = LoggerTextArea.getText();
        int index = text.toLowerCase().indexOf(searchText.toLowerCase(), searchIndex);
        if (index != -1) {
            try {
                LoggerTextArea.getHighlighter().addHighlight(index, index + searchText.length(), highlightPainter);
                LoggerTextArea.setCaretPosition(index + searchText.length());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // Highlight the next occurrence of the searched text
// Highlight the next occurrence of the searched text
    private void highlightNext(JTextField searchField) {
        String searchText = searchField.getText();
        if (!searchText.isEmpty()) {
            String text = LoggerTextArea.getText();
            int index = text.toLowerCase().indexOf(searchText.toLowerCase(), searchIndex + searchText.length());
            if (index != -1) {
                searchIndex = index;
                highlightText(searchText);
            } else {
                // If not found, reset the search index to the beginning
                searchIndex = 0;
                highlightText(searchText);
            }
        }
    }


    // Highlight the previous occurrence of the searched text
    private void highlightPrevious(JTextField searchField) {
        String searchText = searchField.getText();
        if (!searchText.isEmpty()) {
            searchIndex -= 2 * searchText.length();
            highlightText(searchText);
        }
    }



    private void highlightTextIssue(String searchText, JTextArea textArea){
        // searchText = textFiel
        if (!searchText.isEmpty()) {
            // searchIndexIssue = 0;
            // highlightText(searchText);
            // String searchText = textField.getText();
            // JScrollPane scrollPane = (JScrollPane) pane.getComponentAt(currentSelectedIssueDetailsTab);
            // textArea = (JTextArea) scrollPane.getViewport().getView();                
            textArea.getHighlighter().removeAllHighlights();
            String text = textArea.getText();
            int index = text.toLowerCase().indexOf(searchText.toLowerCase(), searchIndexIssue);
            if (index != -1) {
                try {
                    textArea.getHighlighter().addHighlight(index, index + searchText.length(), highlightPainter);
                    textArea.setCaretPosition(index + searchText.length());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
}


