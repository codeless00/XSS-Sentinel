package burp;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MessageEditorTabFactory implements IMessageEditorTabFactory {

    IBurpExtenderCallbacks callbacks;
    BurpExtender extender;

    public MessageEditorTabFactory(IBurpExtenderCallbacks callbacks, BurpExtender extender) {
        this.callbacks = callbacks;
        this.extender = extender;
    }

    @Override
    public IMessageEditorTab createNewInstance(IMessageEditorController controller, boolean editable) {
        // TODO Auto-generated method stub
        IMessageEditorTab messageEditorTab = new IMessageEditorTab() {

            private JTextArea textArea;
            private byte[] message;
            private boolean isRequest;

            @Override
            public String getTabCaption() {
                // TODO Auto-generated method stub
                return "Custom Editor";
            }

            @Override
            public Component getUiComponent() {

                this.textArea = new JTextArea();
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                // TODO Auto-generated method stub
                return this.textArea;
            }

            @Override
            public boolean isEnabled(byte[] content, boolean isRequest) {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public void setMessage(byte[] content, boolean isRequest) {
                // TODO Auto-generated method stub
                this.message = content;
                this.isRequest = isRequest;
                if (content == null) {
                    textArea.setText(""); // Clear the text area if content is null
                } else {
                    textArea.setText(new String(content)); // Display the message in the text area
                }
            }

            @Override
            public byte[] getMessage() {
                // TODO Auto-generated method stub
                return this.message;
            }

            @Override
            public boolean isModified() {
                // TODO Auto-generated method stub
                boolean ismodified = !textArea.getText().equals(new String(message));
                return ismodified;
            }

            @Override
            public byte[] getSelectedData() {
                // TODO Auto-generated method stub
                return null;
            }
            ;
        };

        return messageEditorTab;
    }
    
}
