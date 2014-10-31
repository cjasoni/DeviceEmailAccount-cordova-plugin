package com.cjasoni.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;

import android.content.Context;
import android.accounts.Account;
import android.accounts.AccountManager;

public class DeviceEmailAccount extends CordovaPlugin {

 
    private String getAccount(AccountManager am) {
        String str = "";

        if (am != null) {
            Account[] accounts = am.getAccounts();

            for (int i = 0; i < accounts.length; i++) {
                if (str.length() > 0) {
                    str += ",";
                }

                str += "account" + i + "Name: " + accounts[i].nam) + ","
                        + "account" + i + "Type: " + accounts[i].type;
            }
        }

        return str;
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        try {
            if (action.equals("get")) {
                AccountManager am = AccountManager.get(this.cordova.getActivity());

                String result = getAccount(am);
                if (result != null) {
                    callbackContext.success(result);
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
