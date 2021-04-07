package com.jyb.jdbc.i18n.factory.i18n;

public class I18NFactory {
    public static I18N getI18nObject(String area){
        if(area.equals("china")){
            return new Chinese();
        }else if(area.equals("spain")){
            return new Spanish();
        }else if(area.equals("itail")){
            return new Italia();
        }else{
            return null;
        }
    }
}
