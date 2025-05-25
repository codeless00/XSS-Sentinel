package burp;

public class Start {

    public Start(){
        Utilities.sendToLogger("Starting Engine...");

        Settings.CurrentScope

        for(String settings_key: Settings.CurrentSettings.keySet()){
            String settings_value = Settings.CurrentSettings.get(settings_key);
            Utilities.sendToLogger(settings_key+": " + settings_value);


        }
    }
    
}
