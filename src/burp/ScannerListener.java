package burp;

public class ScannerListener implements IScannerListener {
    IBurpExtenderCallbacks callbacks;
    BurpExtender extender;

    public ScannerListener(IBurpExtenderCallbacks callbacks, BurpExtender extender) {
        this.callbacks = callbacks;
        this.extender = extender;
    }

    @Override
    public void newScanIssue(IScanIssue issue) {
        extender.scanner_listener(issue);
    }
    
}
