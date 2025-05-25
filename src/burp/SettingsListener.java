package burp;

public interface SettingsListener {
    public void onchange(String newValue, Boolean save);
}
