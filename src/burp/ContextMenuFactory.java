package burp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContextMenuFactory implements IContextMenuFactory {

    IBurpExtenderCallbacks callbacks;
    BurpExtender extender;
    ExtensionHelpers helpers;

    public ContextMenuFactory(IBurpExtenderCallbacks callbacks, BurpExtender extender, ExtensionHelpers helpers) {
        this.callbacks = callbacks;
        this.extender = extender;
        this.helpers = helpers;
    }

    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {

        callbacks.printOutput("Tool Caused: " + String.valueOf(invocation.getToolFlag()));

        IHttpRequestResponse[] resreq = invocation.getSelectedMessages();

        for(IHttpRequestResponse message: resreq){
            byte[] request = message.getRequest();
            if (request == null) {
                byte[] response = message.getResponse();

                helpers.analyse_response(response);
            }
            else{
                helpers.analyse_request(request);
            }
        }

        List<JMenuItem> menuItems = new ArrayList<>();

        // Create a JMenutItem
        JMenuItem menuItem1 = new JMenuItem("Menu Item 1");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                callbacks.printOutput("Menu Item 1 is Clicked");
            }
            
        });

        menuItems.add(menuItem1);

        // Create Another JMenuItemsite
        JMenuItem menuItem2 = new JMenuItem("Menu Item 2");
        menuItem2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                callbacks.printOutput("Menu Item 2 is Clicked");
            }
            
        });

        menuItems.add(menuItem2);

        // Create a Sub Menu
        JMenu subJMenu = new JMenu("submenu");
        JMenuItem subMenu1 = new JMenuItem("submenu1");
        JMenuItem subMenu2 = new JMenuItem("submenu2");
        subJMenu.add(subMenu1);
        subJMenu.add(subMenu2);

        menuItems.add(subJMenu);



        return menuItems;
    }
    
}
