package main.java.filter;

import main.java.utils.Constants;

import java.util.HashMap;


public class QueryFilter implements IFilter, Constants {

    HashMap<String, String> filterRegexMap;

    public QueryFilter() {
        this.filterRegexMap = new HashMap<>();
    }

    public void addRegex(String regex, String replaceText) {
        filterRegexMap.put(regex, replaceText);
    }

    @Override
    public String filter(String text) {
        for(String key: filterRegexMap.keySet()) {
            text = text.replaceAll(key, filterRegexMap.get(key));
        }
        return text.trim();
    }

    @Override
    public void construct() {
        this.addRegex(POSSESSIVE_REGEX, "");
        this.addRegex(QUERY_SPECIAL_CHARACTER_REGEX, " ");
        this.addRegex(MULTISPACE_REGEX, " ");
    }
}
