package burp;

public class ScopeChangeListener implements IScopeChangeListener {
    IBurpExtenderCallbacks callbacks;
    BurpExtender extender;

    public ScopeChangeListener(IBurpExtenderCallbacks callbacks,BurpExtender extender) {
        this.callbacks = callbacks;
        this.extender = extender;
    }

    @Override
    public void scopeChanged() {
        
        callbacks.printOutput("Scope Changed!!");
        
    }
    
}
