package io.not2excel;

import net.md_5.bungee.api.ChatColor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Carter on 5/27/2015.
 */
public class Messages {

    private static Map<String, String> messages = new HashMap<>();

    private CustomConfig config;

    public Messages(CustomConfig config){
        for(String key : config.getKeys(true)) {
            messages.put(key, ChatColor.translateAlternateColorCodes('&', config.getConfig().getString(key)));
        }
    }

    public String get(String key){
        if(!messages.containsKey(key)) {
            String s = "Default_for_" + key.replaceAll(Pattern.quote("."), "_");
            config.set(key, s, true);
            return s;
        }
        return messages.get(key);
    }

    public String get(String key, MsgVar... values) {
        if (!messages.containsKey(key)) {
            final StringBuilder s = new StringBuilder("Default_for_" + key.replaceAll(Pattern.quote("."), "_"));
            Arrays.stream(values).forEach(val -> s.append("_").append(val.identifier));
            config.set(key, s, true);
            return "Generated default for " + key;
        } else {
            String s = messages.get(key);
            Arrays.stream(values).forEach(val -> s.replace(val.identifier, String.valueOf(val.variable)));
            return s;
        }
    }

    public class MsgVar{
        public String identifier;
        public Object variable;
        public MsgVar(String identifier, Object variable){
            this.identifier = identifier;
            this.variable = variable;
        }
    }


}
