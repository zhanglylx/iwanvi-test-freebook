package Monkey;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import javax.swing.JOptionPane;

import AppiumMethod.Tooltip;
import AppiumMethod.config;
import AppiumMethod.installAPPPackage;

public class RunMonkey {
    private static Config cf;
    private static int[] pid = new int[0];
    private static int p = 1;
    private static boolean stop = false;

    private RunMonkey() {
        cf = new Config();
        startMonkey();
        setPid();
    }

    /**
     * 启动Monkey
     */
    private void startMonkey() {
        Thread s = new Thread(new Runnable() {
            public void run() {
                System.out.println("开始执行monkey");
                adb(" shell monkey  -p " + cf.getPackageName()
                        + " --ignore-crashes --ignore-timeouts --ignore-native-crashes" + " -v -v -v " + "--throttle "
                        + cf.getEventsTime() + " " + cf.getRunCount() + " >/sdcard/monkeyLog.txt");
                analyze();
            }
        });
        s.start();
    }
    /*
     *分析monkeyLog
     */
    private void analyze() {
        if (!RunMonkey.stop) {
            RunMonkey.stop = true;
            //拉取手机文件到电脑
            pullMonkeyLog();
            logAnalysis.FilterErrorLog(new File(System.getProperty("user.dir") + File.separator + "monkeyLog.txt"));

        }
    }

    /**
     * 拉取log到电脑
     */
    private void pullMonkeyLog() {
        System.out.println("开始拉取手机文件");
        try {
            Process pro = Runtime.getRuntime()
                    .exec("cmd /c adb pull /sdcard/monkeyLog.txt " + System.getProperty("user.dir"));
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String msg ;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
                if (msg.contains("100%")) {
                    return;
                }
            }
            Tooltip.errHint("拉取monkeyLog失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭monkey
     */
    private void killMoneky() {
        while (true) {
            if ( p == 1) {
                p = JOptionPane.showConfirmDialog(null, "关闭Monkey请点击\"确定\"按钮", "温馨提示", JOptionPane.YES_NO_OPTION);
            }
            if (pidMonkey().length != 0) {
                setPid();
            }
            if (p == 0) {
                for (int i : RunMonkey.pid) {
                    adb("shell  kill " + i);
                }
                break;
            }
        }
        analyze();
    }

    /**
     * 设置pid
     */
    private void setPid() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    RunMonkey.pid = pidMonkey();
                    if (RunMonkey.pid.length != 0) {
                        break;
                    }
                }
                killMoneky();
            }
        });
        t.start();

    }

    private static int[] pidMonkey() {
        int[] pi = new int[0];
        for (String s : adb("shell ps ")) {
            if (s.toLowerCase().contains("monkey")) {
                String[] str = s.split(" ");
                f: for (String st : str) {
                    if (st.matches("\\d+")) {
                        pi = Arrays.copyOf(pi, pi.length + 1);
                        pi[pi.length - 1] = Integer.parseInt(st);
                        break f;
                    }
                }
            }
        }
        return pi;
    }

    /**
     * 执行adb命令
     *
     * @param code code
     * @return String[]
     */
    public static String[] adb(String code) {
        String[] str = new String[0];
        try {
            installAPPPackage.isPuth(config.ADB_PUTH);
            Process pro = Runtime.getRuntime().exec(config.ADB_PUTH + " " + code);
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String msg ;
            while ((msg = br.readLine()) != null) {
                if (!"".equals(msg)) {
                    str = Arrays.copyOf(str, str.length + 1);
                    str[str.length - 1] = msg;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "请亲把耳机子插上，否则手机会发出叫声");
        new RunMonkey();
    }
}
