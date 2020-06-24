package com.carry.mybatis.Test;

import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;

import java.io.InputStream;

public class TestXpath {
    public static void main(String[] args) {
        // 如果XML文件直接放在源目录(Source Directory)下，则可以直接解析
        // 如果放在源目录下的子目录中，则必须加上相对工程路径
        // InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("org/apache/ibatis/parsing/test/mybatis-config.xml");
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis.xml");
        XPathParser xPathParser = new XPathParser(inputStream, false, null, null);
        XNode xNode = xPathParser.evalNode("/configuration");
        XNode xNode1 = xNode.evalNode("settings");
        System.out.println(xNode1.getName());
        System.out.println(xPathParser);
    }
}
