package com.xtd.ybls.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author 冯瑞宁
 */
public class ExportTxt {
    /**
     * @param path 文件保存路径 示例："C:\\Users\\frn\\Desktop\\导入记录.txt"
     * @param text 写入文件的内容
     */
    public void exportTxt(String path, String text) {
        //将写入转化为流的形式
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            //一次写一行
            bw.write(text);
            bw.newLine();  //换行
            //关闭流
            bw.close();
            System.out.println("写入成功" + text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
