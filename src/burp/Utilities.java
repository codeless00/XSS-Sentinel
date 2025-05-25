package burp;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.awt.*;

public class Utilities {

    public static boolean Manual = false;
    static Settings currentSettings;
    public static ThreadPoolExecutor executor;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static final String ActiveScan = "Active-Scan";
    public static final String HiddenParam = "Hidden-Param";
    public static final String AutomaticVerify = "Automatic-Verify";
    public static final String Debug = "Debug";
    public static final String VerifyParam = "Verify-Params";
    public static final String MagicPayloads = "Magic-Payloads";
    public static final String AttackMethod = "Attack-Method";
    public static final String AttackType = "Attack-Type";
    public static final String Threads = "Threads";
    public static final String ConcurrentRequest = "Concurrent-Request";
    public static final String ConcurrentTime = "Concurrent-Time";
    public static final String PayloadFile = "Payload-File";
    public static final String URLFile = "URL-File";
    public static final String CrawlDepth = "Crawl-Depth";
    public static final String CurrentScope = "scope";
    // public static ArrayList<String> CurrentScope = "scope";

    public static ArrayList<String> SettingArray = new ArrayList<>(Arrays.asList(ActiveScan, HiddenParam, AutomaticVerify, Debug,VerifyParam,MagicPayloads,AttackMethod,AttackType,Threads,ConcurrentRequest,ConcurrentTime,PayloadFile,URLFile,CrawlDepth));


   


    public static JFrame getBurpFrame()
    {
        for(Frame f : Frame.getFrames())
        {
            if(f.isVisible() && f.getTitle().startsWith(("Burp Suite")))
            {
                return (JFrame) f;
            }
        }
        return null;
    }


    public static void sendToLogger(String data){
        try {
            Document doc = currentSettings.LoggerTextArea.getDocument();
            doc.insertString(doc.getLength(), data + "\r\n", null);
            // DefaultCaret caret =(DefaultCaret)currentSettings.LoggerTextArea.getCaret();
            if(currentSettings.isScrollPaneBottom){
            
                // caret = 
                currentSettings.scrollPane.getVerticalScrollBar().setValue(currentSettings.scrollPane.getVerticalScrollBar().getMaximum());
                // System.out.println("Scrolled to the bottom");
        
            }
        }
        catch (BadLocationException e) {
            e.printStackTrace();
        }
        
    }

    public static void registerSettingListener(String key, SettingsListener listener) {
        Settings.callbacks.put(key, listener);
    }

    public static void callSettingListener(String key, String value, Boolean save) {
        SettingsListener listner = (SettingsListener)Settings.callbacks.getOrDefault(key, null);
        if (listner != null) {
            listner.onchange(value, save);
        }
    }


    public static void removeSettingListener(String key, SettingsListener listener) {
        Settings.callbacks.remove(key);
    }

    public static void initializeSetting(Settings currentSetting){
        currentSettings = currentSetting;
    }

    public static void setDefaultSettings(){
        Boolean save = false;
        if (Settings.CurrentSettings == null) {
            save = true;
        }
        currentSettings.SettingsBoxActiveScan.setSelected(true);
        currentSettings.SettingsBoxHiddenParam.setSelected(false);
        currentSettings.SettingsBoxAutomaticVerify.setSelected(true);
        currentSettings.SettingsBoxDebug.setSelected(false);
        currentSettings.SettingsBoxVerifyParam.setSelected(true);
        currentSettings.SettingsBoxMagicPayload.setSelected(false);
        currentSettings.SettingsBoxAttackMethod.setSelectedItem("POST");
        currentSettings.SettingsBoxAttackType.setSelectedItem("BOTH");
        currentSettings.SettingsBoxThreads.setText("10");
        currentSettings.SettingsBoxConcurrentRequest.setText("50");
        currentSettings.SettingsBoxConcurrentTime.setText("2000");
        currentSettings.SettingsBoxPayloadFile.setText("/usr/share/payload.txt");
        currentSettings.SettingsBoxURLFile.setText("/usr/share/url.txt");
        currentSettings.SettingsBoxCrawlDepth.setText("7");

        if (save) {
            currentSettings.SettingsSaveButton.doClick();
        }

    }

    public static void setCurrentAsCurrentSetting(){

    }


    public static void runTask(){

        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 10000; // in milliseconds
        ArrayList<String> severity = new ArrayList<>();
        severity.add("INFO");
        severity.add("Medium");
        severity.add("Critical");
        severity.add("High");


        
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);

        executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, workQueue);

        Runnable task = new Runnable() {

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("sending to logger");
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd MMM yyyy");
                    Date date = new Date();
                    String formattedDate = formatter.format(date);

                    Random rand = new Random();
                    int randomIndex = rand.nextInt(severity.size());
                    String randomSeverity = severity.get(randomIndex);

                    LinkedHashMap<String,String> tab_data = new LinkedHashMap<>();

                    tab_data.put("Request1", "Found vunerability in " + formattedDate);
                    tab_data.put("Response1", "Found vunerability in response1 " + formattedDate);
                    tab_data.put("Request2", "Found vunerability in path1 " + formattedDate);
                    tab_data.put("Response2", "Found vunerability in response2 " + formattedDate);





                    Utilities.createIssue(formattedDate, randomSeverity, "www."+generateRandomString(8)+".com", generateRandomString(8), tab_data);
                    sendToLogger("Generating Demo Issue..." + generateRandomString(5));
        
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // Restore interrupted status
                        Thread.currentThread().interrupt();
                        System.out.println("Task interrupted. Exiting.");
                        return;
                    }
                }
            }
            
        };
        executor.submit(task);
        executor.shutdown();


    
    }


    // Method to generate a random string of specified length
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            // Generate a random index within the range of the characters
            int randomIndex = random.nextInt(CHARACTERS.length());
            // Append the character at the random index to the StringBuilder
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }


    public static boolean isSettingModified() {

    

        Boolean active_scan = currentSettings.SettingsBoxActiveScan.isSelected();
        Boolean hidden_param = currentSettings.SettingsBoxHiddenParam.isSelected();
        Boolean automatic_verify = currentSettings.SettingsBoxAutomaticVerify.isSelected();
        Boolean debug = currentSettings.SettingsBoxDebug.isSelected();
        Boolean verify_param = currentSettings.SettingsBoxVerifyParam.isSelected();
        Boolean magic_payload = currentSettings.SettingsBoxMagicPayload.isSelected();
        String attack_method = (String) currentSettings.SettingsBoxAttackMethod.getSelectedItem();
        String attack_type = (String) currentSettings.SettingsBoxAttackType.getSelectedItem();
        String thread = currentSettings.SettingsBoxThreads.getText();
        String concurrent_request = currentSettings.SettingsBoxConcurrentRequest.getText();
        String concurrent_time = currentSettings.SettingsBoxConcurrentTime.getText();
        String payload_file = currentSettings.SettingsBoxPayloadFile.getText();
        String url_file = currentSettings.SettingsBoxURLFile.getText();
        String crawl_depth = currentSettings.SettingsBoxCrawlDepth.getText();

        if (!Settings.CurrentSettings.get(Utilities.ActiveScan).equals(String.valueOf(active_scan))) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.HiddenParam).equals(String.valueOf(hidden_param))) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.AutomaticVerify).equals(String.valueOf(automatic_verify))) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.Debug).equals(String.valueOf(debug))) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.VerifyParam).equals(String.valueOf(verify_param))) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.MagicPayloads).equals(String.valueOf(magic_payload))) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.AttackMethod).equals(attack_method)) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.AttackType).equals(attack_type)) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.Threads).equals(thread)) {
            return true;

        }
        else if (!Settings.CurrentSettings.get(Utilities.ConcurrentRequest).equals(concurrent_request)) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.ConcurrentTime).equals(concurrent_time)) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.PayloadFile).equals(payload_file)) {
            return true;

        }

        else if (!Settings.CurrentSettings.get(Utilities.URLFile).equals(url_file)) {
            return true;
        }

        else if (!Settings.CurrentSettings.get(Utilities.CrawlDepth).equals(crawl_depth)) {
            return true;

        }
        else{
            return false;
        }
    }

    public static void initializeSettingBoxScope(){

        // Utilities.CurrentScope = new ArrayList<>();
        currentSettings.settingsBoxScopeTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make all cells uneditable
                return true;
            }
        };
        currentSettings.settingsBoxScopeTableModel.addColumn("                 Regex-Pattern");
    }

    public static boolean isScopeChanged(ArrayList<String> newValue){


        Boolean result = compareArrayLists(newValue, Settings.CurrentScope);
        return !result;


    }


    public static boolean compareArrayLists(ArrayList<String> list1, ArrayList<String> list2) {
        // Make a copy of each ArrayList and sort them
        ArrayList<String> sortedList1 = new ArrayList<>(list1);
        ArrayList<String> sortedList2 = new ArrayList<>(list2);
        Collections.sort(sortedList1);
        Collections.sort(sortedList2);

        // Check if the sorted ArrayLists are equal
        return sortedList1.equals(sortedList2);
    }

    public static boolean createIssue(String time, String severity, String host, String issueType, LinkedHashMap<String,String> data){

        int current_rowcount = currentSettings.issueTableModel.getRowCount();

        String[] row_data = {time,severity,host,issueType};
        currentSettings.issueTableModel.addRow(row_data);

        if(currentSettings.isScrollPaneBottom){
            
            // caret = 
            currentSettings.issue_table.getVerticalScrollBar().setValue(currentSettings.scrollPane.getVerticalScrollBar().getMaximum());
            // System.out.println("Scrolled to the bottom");
    
        }
        Settings.issueData.put(current_rowcount,data);

        return true;
    }
    
}
