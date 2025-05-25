package burp;

import java.util.ArrayList;

public class PreWorker {

    static Settings currentSettings;

    public PreWorker(Settings curSettings){
        this.currentSettings = curSettings;

        Utilities.registerSettingListener(Utilities.ActiveScan, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.ActiveScan).equals(String.valueOf(currentSettings.SettingsBoxActiveScan.isSelected()))) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.HiddenParam, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.HiddenParam).equals(String.valueOf(currentSettings.SettingsBoxHiddenParam.isSelected()))) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.AutomaticVerify, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.AutomaticVerify).equals(String.valueOf(currentSettings.SettingsBoxAutomaticVerify.isSelected()))) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }


            
        });

        Utilities.registerSettingListener(Utilities.AttackMethod, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                Utilities.sendToLogger("Attack Method value changed: " + newValue);

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.AttackMethod).equals(currentSettings.SettingsBoxAttackMethod.getSelectedItem())) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.Threads, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.Threads).equals(currentSettings.SettingsBoxThreads.getText())) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.ConcurrentTime, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.ConcurrentTime).equals(currentSettings.SettingsBoxConcurrentTime.getText())) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.PayloadFile, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.PayloadFile).equals(currentSettings.SettingsBoxPayloadFile.getText())) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.URLFile, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.URLFile).equals(currentSettings.SettingsBoxURLFile.getText())) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.Debug, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.Debug).equals(String.valueOf(currentSettings.SettingsBoxDebug.isSelected()))) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.VerifyParam, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.VerifyParam).equals(String.valueOf(currentSettings.SettingsBoxVerifyParam.isSelected()))) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.MagicPayloads, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.MagicPayloads).equals(String.valueOf(currentSettings.SettingsBoxMagicPayload.isSelected()))) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }            }
            
        });

        Utilities.registerSettingListener(Utilities.AttackType, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {

                Utilities.sendToLogger("Attacktype value change: " + newValue);
                
                if (save) {
                    // equals(String.valueOf(active_scan)
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.AttackType).equals(currentSettings.SettingsBoxAttackType.getSelectedItem())) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }
            }
            
        });

        Utilities.registerSettingListener(Utilities.ConcurrentRequest, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {
               
                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.ConcurrentRequest).equals(currentSettings.SettingsBoxConcurrentRequest.getText())) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }
            }
            
        });

        Utilities.registerSettingListener(Utilities.CrawlDepth, new SettingsListener() {

            @Override
            public void onchange(String newValue, Boolean save) {
                Utilities.sendToLogger("Crawl-Depth Value Changed: " + newValue);

                if (save) {
                    
                }
                else  {
                    // currentSettings.CurrentLoggerText
                    if (!Settings.CurrentSettings.get(Utilities.CrawlDepth).equals(currentSettings.SettingsBoxCrawlDepth.getText())) {
                        currentSettings.SettingsSaveButton.setEnabled(true);
                    }
                    else{
                        if(!Utilities.isSettingModified()){
                            currentSettings.SettingsSaveButton.setEnabled(false);
                        }
                        
                    }
                }
            }
            
        });

    }



    public static void ScopeListner(ArrayList<String> newValue, boolean save){

        if (save) {

            Utilities.sendToLogger("Scope is Changed New Scope is " + newValue);
                    
        }
        else  {
            // currentSettings.CurrentLoggerText
            if (Utilities.isScopeChanged(newValue)) {
                currentSettings.SettingsSaveButton.setEnabled(true);
            }
            else{
                currentSettings.SettingsSaveButton.setEnabled(false);
                
            }
        }

    }
    
}
