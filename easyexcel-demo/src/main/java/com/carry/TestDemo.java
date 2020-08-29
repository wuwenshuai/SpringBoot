package com.carry;

import com.carry.entity.Text;
import com.carry.service.TextService;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {



    public static void main(String[] args) {
        List<Text> texts = new ArrayList<Text>();
        Text text = new Text();
        text.setClientId("1111");
        text.setText("test");
        text.setTextKey("1223");
        texts.add(text);


        TextService textService = new TextService();


    }
}
