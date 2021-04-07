package com.jyb.jdbc.i18n.factory;

import com.jyb.jdbc.i18n.factory.i18n.I18N;
import com.jyb.jdbc.i18n.factory.i18n.I18NFactory;

public class Software {
    public static void main(String[] args) {
        I18N i18N = I18NFactory.getI18nObject("china");
        System.out.println(i18N.getTitle());
    }
}
