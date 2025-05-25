package burp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.net.InetAddress;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class BurpExtender implements IBurpExtender{

    IBurpExtenderCallbacks callbacks;
    ExtensionHelpers helpers;
    Settings settings;

    @Override
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;


        // It is used to set Extension Name
        callbacks.setExtensionName("XSS-Sentinel");
        // callbacks.printOutput("Line first");
        // callbacks.printOutput("Line Second");

        // It contain varioius helpers methods for analysing and manipulating request and response
        // IExtensionHelpers helpers = callbacks.getHelpers();
        this.helpers = new ExtensionHelpers(callbacks);
        callbacks.registerExtensionStateListener(new ExtensionStateListener(callbacks));
        // callbacks.registerProxyListener(new ProxyListener(callbacks,this));
        // callbacks.registerScannerListener(new ScannerListener(callbacks,this));
        // callbacks.registerHttpListener(new HttpListener(callbacks, helpers));
        // callbacks.registerScopeChangeListener(new ScopeChangeListener(callbacks,this));
        // callbacks.registerContextMenuFactory(new ContextMenuFactory(callbacks,this,helpers));
        // callbacks.registerMessageEditorTabFactory(new MessageEditorTabFactory(callbacks,this));
        // callbacks.registerScannerInsertionPointProvider(new ScannerInsertionPointProvider(callbacks,this));
        // callbacks.registerScannerCheck(new ScannerCheck(callbacks,this));
        // callbacks.registerIntruderPayloadGeneratorFactory(new IntruderPayloadGeneratorFactory(callbacks,this));
        ITab tab = new ITab() {

            @Override
            public String getTabCaption() {
                // TODO Auto-generated method ;stub
                return "XSS-Sentinel";
            }

            @Override
            public Component getUiComponent() {

                // JPanel parentFrame = new JPanel();
                // // parentFrame.setTitle("Swing App");
                // // parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // // parentFrame.setSize(1500,1200);
                // parentFrame.setLayout(new GridLayout(2,1));
        
        
                // // Create panels
                // // JPanel parent_panel = new JPanel(new GridBagLayout());
        
                // JPanel panel_top = new JPanel(new GridLayout(1,2));
                // JPanel panel_bottom = new JPanel(new GridLayout(1,2));
        
                // JPanel panel_top_first = new JPanel(new BorderLayout()); 
                // JPanel panel_top_second = new JPanel(new BorderLayout());
                // JPanel panel_bottom_first = new JPanel(new BorderLayout());
        
                // JPanel panel_bottom_second = new JPanel(new GridLayout(1,2));
        
                // JPanel panel_bottom_second_first = new JPanel(new BorderLayout());
                // JPanel panel_bottom_second_second = new JPanel(new BorderLayout());
        
                // panel_bottom_second.add(panel_bottom_second_first);
                // panel_bottom_second.add(panel_bottom_second_second);
        
                // panel_top.add(panel_top_first);
                // panel_top.add(panel_top_second);
        
                // panel_bottom.add(panel_bottom_first);
                // panel_bottom.add(panel_bottom_second);
        
                // // panel_top_first.setBackground(Color.RED);
                // // panel_top_second.setBackground(Color.ORANGE);
                // panel_bottom_first.setBackground(Color.LIGHT_GRAY);
                // panel_bottom_second_first.setBackground(Color.LIGHT_GRAY);
                // panel_bottom_second_second.setBackground(Color.LIGHT_GRAY);

                

                // parentFrame.add(panel_top);
                // parentFrame.add(panel_bottom);

                settings = new Settings();
                Component parentFrame = settings.getSettings();
                Utilities.initializeSetting(settings);

                return parentFrame;
            }
            
        };

        callbacks.addSuiteTab(tab);
        Utilities.setDefaultSettings();
        Utilities.initializeSettingBoxScope();
        new PreWorker(settings);


        // Utilities.runTask();







    }

    synchronized void intercepted_proxy_req_message(IInterceptedProxyMessage message){
        IHttpRequestResponse request = message.getMessageInfo();
        InetAddress ipAddress = message.getClientIpAddress();

        callbacks.printOutput("Intercepted Proxy Request: ");
        callbacks.printOutput("Unique Id: " + message.getMessageInfo().toString());
        callbacks.printOutput("IP Address: " + ipAddress.toString());
        callbacks.printOutput("Interception Rule: " + message.getInterceptAction());
        helpers.analyse_request(request);
        callbacks.printOutput("\n");

    }

    void intercepted_proxy_res_message(IInterceptedProxyMessage message){


    }

    void scanner_listener(IScanIssue issue){
        callbacks.printOutput("URL: " + issue.getUrl().toString());
        callbacks.printOutput("Issue Name: " + issue.getIssueName() + " Issue Detail: " + issue.getIssueDetail());
        IHttpRequestResponse[] requestResponses = issue.getHttpMessages();
        for (IHttpRequestResponse reqres: requestResponses){
            byte[] req = reqres.getRequest();
            if (req == null) {
                helpers.analyse_response(reqres);
            }
            else{
                helpers.analyse_request(reqres);
            }
        }
        callbacks.printOutput("\n");


    }
    
}



