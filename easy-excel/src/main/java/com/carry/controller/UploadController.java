package com.carry.controller;


import com.alibaba.excel.EasyExcel;
import com.carry.dao.DemoDAO;
import com.carry.listen.ConverterDataListener;
import com.carry.listen.DemoDataListener;
import com.carry.pojo.ConverterData;
import com.carry.pojo.DemoData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController

public class UploadController {

    @PostMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), DemoData.class, new DemoDataListener(new DemoDAO())).sheet().doRead();
        return "success";
    }

    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
     * <p>3. 直接读即可
     */

    public static void main(String[] args) {
        // simpleRead();
        converterRead();
    }

    public static void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "C:\\Users\\carry.wu\\Desktop\\demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().autoTrim(false).doRead();
        System.out.println("over");
    }

    /**
     * 工具类
     */




    /**
     * 日期、数字或者自定义格式转换
     * <p>
     * 默认读的转换器
     * <p>1. 创建excel对应的实体对象
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器
     * <p>3. 直接读即可
     */

    public static void converterRead() {
        String fileName = "C:\\Users\\carry.wu\\Desktop\\demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, ConverterData.class, new ConverterDataListener())
                // 这里注意 我们也可以registerConverter来指定自定义转换器， 但是这个转换变成全局了， 所有java为string,excel为string的都会用这个转换器。
                // 如果就想单个字段使用请使用@ExcelProperty 指定converter
                // .registerConverter(new CustomStringStringConverter())
                // 读取sheet
                .sheet().autoTrim(true).doRead();
    }


}
