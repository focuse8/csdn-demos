package com.focuse.demo;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：
 * @date ：Created in 2020/7/18 下午9:37
 * @description：
 * @modified By：
 */

public class DemoPrinterAware  implements ImportAware {
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
