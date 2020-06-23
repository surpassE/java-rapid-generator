package main.java.com.rapid.framework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 格式化mysql dump出来的数据库表结构的sql
 * 去掉注释信息及初始AUTO_INCREMENT
 */
public class MysqlDumpFormat {


    static Pattern pattern = Pattern.compile("(AUTO_INCREMENT = \\d+)");

    public static void main(String[] args) throws Exception{
        doFilter();
    }

    private static void doTest() {
        String line = "ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;";

        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
    private static void doFilter() throws Exception{
        String srcPath = "D:\\test\\esu-config-center-cds.sql";
        File srcFile = new File(srcPath);
        File dstFile = new File(srcFile.getParent() + File.separator + srcFile.getName() + "_final");
        StringBuilder sb = new StringBuilder();
        Files.lines(Paths.get(srcFile.getAbsolutePath())).filter(a -> a.startsWith("SET "));
        try(
                BufferedReader br = Files.newBufferedReader(Paths.get(srcFile.getAbsolutePath()));

                BufferedWriter bw = Files.newBufferedWriter(Paths.get(dstFile.getAbsolutePath()),  Charset.forName("UTF-8"))
        ){
            String line;
            boolean ignore = false;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("/*")) {
                    ignore = true;
                }
                if (line.startsWith("*/")) {
                    ignore = false;
                    continue;
                }
                if (ignore) {
                    continue;
                }
                if (line.startsWith("SET ")) {
                    continue;
                }
                if (line.startsWith("DROP TABLE")) {
                    continue;
                }
                if (line.startsWith("-- ")) {
                    continue;
                }
                if (line.contains("AUTO_INCREMENT")) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String tmp = matcher.group();
                        line = line.replaceAll(matcher.group(), "AUTO_INCREMENT = 1");
                    }
                }
                if (line.contains("CHARACTER SET utf8 COLLATE utf8_bin ")) {
                    line = line.replaceAll("CHARACTER SET utf8 COLLATE utf8_bin ", "");
                }
                if(line.contains("CHARACTER SET utf8 COLLATE utf8_general_ci ")){
                    line = line.replaceAll("CHARACTER SET utf8 COLLATE utf8_general_ci ", "");
                }
                sb.append(line).append("\n");
            }
            System.out.println(sb.toString());
            bw.write(sb.toString());
        }
    }
}
