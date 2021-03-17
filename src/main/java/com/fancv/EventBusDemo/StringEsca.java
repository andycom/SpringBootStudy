package com.fancv.EventBusDemo;

import com.google.common.html.HtmlEscapers;

/**
 * @author hamish-wu
 */
public class StringEsca {

    public static void main(String[] args) {
        String s = HtmlEscapers.htmlEscaper().escape("<h2><h2>");
        System.out.println(s);
    }
}
