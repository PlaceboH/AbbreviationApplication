package org.abbreviationlibrary;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbbreviationLibrary {

    private HashMap<String, String> abbMap;

    public AbbreviationLibrary(){
        abbMap = new HashMap<>();
        abbMap.put("www", "World Wide Web");
    }

    public void setAbbMap(HashMap<String, String> abbMap) {
        this.abbMap = abbMap;
    }

    private String name = "My library";
    public String getName(){
        return this.name;
    }

    private String insertString( String originalString, String stringToBeInserted, int index, int lastIndex ) {
        String newString = new String();
        int offset = 0;
        for (int i = 0; i < originalString.length(); i++) {
            newString += originalString.charAt(i);
            if (i == index) {
                newString += stringToBeInserted;
                 offset = stringToBeInserted.length();
            }
        }
        newString = newString.substring(0, index + offset + 1) + newString.substring(index + offset + lastIndex + 1, newString.length());
        System.out.println("HERE: " + newString);
        return newString;
    }


    public String keyWordSearch(String txt){
        for (String val : abbMap.keySet()){
            while(txt.contains(abbMap.get(val))){
                txt = insertString(txt, val, txt.indexOf(abbMap.get(val)) - 1 , abbMap.get(val).length());
            }
        }
        return txt;
    }

    public String abbreviationSearch(String txt){
        String[] text = txt.split("\\W+");
        for ( int i = 0; i < text.length; i++){
            int finalI = i;
            abbMap.forEach( (key, value) -> {
              if(key.equals(text[finalI]) ) {
                  text[finalI] = value;
              }
            });
        }

        return Stream.of(text)
                .collect(Collectors.joining(" "));
    }



}
