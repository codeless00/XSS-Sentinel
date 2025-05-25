package burp;

public class ExtensionStateListener implements IExtensionStateListener{
    IBurpExtenderCallbacks callbacks;

    public ExtensionStateListener(IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
    }

    @Override
    public void extensionUnloaded() {
        System.out.println("Unloaded extension");
        if (Utilities.executor != null) {
            Utilities.executor.shutdownNow();
        }
        
    }
    
}
