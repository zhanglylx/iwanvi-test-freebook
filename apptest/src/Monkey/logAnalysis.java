package Monkey;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import AppiumMethod.Tooltip;

public class logAnalysis {
    /**
     * 读取txt文件的内容
     *
     * @param file
     *            想要读取的文件对象
     */
    public static void FilterErrorLog(File file) {
        StringBuilder result = new StringBuilder(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date()));
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
            String msg;
            int i = 0;
            boolean crash = false;
            boolean count = false;
            while ((msg = br.readLine()) != null) {// 使用readLine方法，一次读一行
                if (!"".equals(msg)) {
                    if (msg.toLowerCase().contains("CRASH".toLowerCase())
                            && msg.toLowerCase().contains(new Config().getPackageName())) {
                        crash = true;
                        i = 0;
                        System.out.println("发现崩溃");
                        result.append(System.lineSeparator());
                        result.append(StringUtils.repeat("=", 50));
                        count = true;
                    }
                    if (crash) {
                        if (i < 10 || msg.contains("at")) {
                            result.append(System.lineSeparator());
                            result.append(msg);
                            i++;
                        } else {
                            crash = false;
                        }
                    }
                }
            }
            br.close();
            BufferedWriter sc = new BufferedWriter(
                    new FileWriter(System.getProperty("user.dir") + File.separator + "errLong"+
                            new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-sss").format(new Date())+".txt"));
            sc.write(result.toString());
            sc.flush();
            sc.close();
            if (count) {
                Tooltip.finishHint("错误log打印完毕：" + System.getProperty("user.dir") + File.separator + "errLong"+
                        new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-sss").format(new Date())+".txt");
            }else{
                Tooltip.finishHint("没有发现崩溃信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
