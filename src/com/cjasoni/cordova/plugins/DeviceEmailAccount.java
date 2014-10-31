package com.cjasoni.cordova.plugins;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.accounts.Account;
import android.accounts.AccountManager;

public class DeviceEmailAccount extends CordovaPlugin {


   
    private  JSONObject getAccounts(AccountManager am) {
        String str = "";
        JSONObject json = new JSONObject();
        
        
        if (am != null) {
            Account[] accounts = am.getAccounts();

            for (int i = 0; i < accounts.length; i++) {
                
                
                try {
                    //if(checkValue(accounts[i].type) == "com.google"){
                        json.put(String.valueOf(i),accounts[i].name);
                    //}
                        
                } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        //e.printStackTrace();
                }
                
                
            }
        }

        return json;
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        try {
            if (action.equals("get")) {
                AccountManager am = AccountManager.get(this.cordova.getActivity());

                JSONObject result = getAccounts(am);
                if (result != null) {
                	callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, result));
                    //callbackContext.success(am);
                    return true;
                }
            }
            callbackContext.error("Invalid action");
            return false;
        } catch (Exception e) {
            String s = "Exception: " + e.getMessage();

            System.err.println(s);
            callbackContext.error(s);

            return false;
        }
    }
}
