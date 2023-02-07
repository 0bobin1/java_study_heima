package com.a08regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo10 {
    public static void main(String[] args) {
        /*有如下文本：
        * "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台"

        * 需求1：爬取版本号为8,11,17的Java文本，但只要Java,不显示版本号。
        * 需求2：爬取版本号为8,11,17的Java文本。正确爬取结果为：Java8,Java11,Java17,Java17
        * 需求3：爬取除了版本号为8,11,17的Java文本。
        * */


        /*
         * (?:正则) :获取所有
         * (?=正则) :获取前面部分
         * (?!正则) :获取不是指定内容的前面部分
         * */
        String s = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";

        //定义正则表达式
        //?理解为前面的数据Java
        //=表示Java后面要跟随的数据，但在获取时只获取前半部分
        //需求1
        String regex1 = "(?i)Java(?=8|11|17)";
        //需求2
        //?:表示要拼接的
        String regex2 = "(?i)Java(8|11|17)";
        String regex3 = "(?i)Java(?:8|11|17)";
        //需求3
        //?!表示除了后面的
        String regex4 = "(?i)Java(?!8|11|17)";

        Pattern p = Pattern.compile(regex4);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }


    }
}
