package com.focuse.componentscandemo.xmlcomps;

import com.focuse.componentscandemo.printer.Printer;
import org.springframework.stereotype.Component;

/**
 * @author ：
 * @date ：Created in 2020/7/18 下午9:37
 * @description：
 * @modified By：
 */
@Component
public class XmlPrinter implements Printer {
    private String text = "this is xmlPrinter";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String print() {
        return this.getClass().getSimpleName() + ":" + text;
    }
}
