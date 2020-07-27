package com.focuse.demo.printer;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author ：
 * @date ：Created in 2020/7/18 下午9:37
 * @description：
 * @modified By：
 */

@Component
public class DemoPrinterAware implements ImportAware {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String print() {
        return text;
    }

    public void setImportMetadata(AnnotationMetadata importMetadata) {

    }
}
