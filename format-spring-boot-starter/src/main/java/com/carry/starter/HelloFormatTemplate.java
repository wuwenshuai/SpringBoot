package com.carry.starter;

import com.carry.starter.format.FormatProcessor;

public class HelloFormatTemplate {

    private FormatProcessor formatProcessor;

    public HelloFormatTemplate(FormatProcessor formatProcessor) {
        this.formatProcessor = formatProcessor;
    }

    public <T> String doFormat(T obj){

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("begin:Execute format").append("<br/>");
        stringBuilder.append("Obj format result:").append(formatProcessor.format(obj)).append("<br/>");
        return stringBuilder.toString();

    }
}
