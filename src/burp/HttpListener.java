package burp;

import java.util.List;

public class HttpListener implements IHttpListener{

    IHttpRequestResponse messageInfo;
    boolean messageIsRequest;
    IBurpExtenderCallbacks callbacks;
    IExtensionHelpers extensionHelpers;

    HttpListener(IBurpExtenderCallbacks callbacks, ExtensionHelpers extensionHelpers){
        this.callbacks = callbacks;
        this.extensionHelpers = callbacks.getHelpers();
        callbacks.registerHttpListener(this);
    }

    @Override
    public void processHttpMessage(int toolFlag, boolean messageIsRequest, IHttpRequestResponse messageInfo) {
        this.messageInfo = messageInfo;
        this.messageIsRequest = messageIsRequest;

        // Call this to analyse every request and response
        if(messageIsRequest){
            List<IParameter> parameters = extensionHelpers.analyzeRequest(messageInfo).getParameters();
            for (IParameter parameter : parameters) {
                callbacks.printOutput("Type: " + Byte.toString(parameter.getType()));
                callbacks.printOutput("Name: " + parameter.getName());
                callbacks.printOutput("Value: " + (parameter.getValue()));
                
            }
            // extensionHelpers.analyse_request(messageInfo);
        }
        else{
            // extensionHelpers.analyse_response(messageInfo);
        }
    }


}
