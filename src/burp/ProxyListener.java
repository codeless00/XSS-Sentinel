package burp;

public class ProxyListener  implements IProxyListener{
    BurpExtender extender;
    IBurpExtenderCallbacks callbacks;

    public ProxyListener(IBurpExtenderCallbacks callbacks, BurpExtender extender) {
        this.callbacks = callbacks;
        this.extender = extender;
    }

    @Override
    public void processProxyMessage(boolean messageIsRequest, IInterceptedProxyMessage message) {
        if (messageIsRequest) {
            extender.intercepted_proxy_req_message(message);
            
        } else {
            extender.intercepted_proxy_res_message(message);
        }
    }
    
}
