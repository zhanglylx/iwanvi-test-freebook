package Monkey;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import AppiumMethod.DevicesInfo;
import AppiumMethod.Tooltip;
import AppiumMethod.installAPPPackage;

public class Config {
    private static File file;
    private static StringBuffer s;
    private final String apkNameRand = Long.toString(System.currentTimeMillis());
    private String packageName = apkNameRand;
    private int runTime = 8;
    private String apkName = apkNameRand;
    private boolean apkReInstall = true;
    private String apkPath;
    private long runCount = 10000000;
    private int eventsTime = 300;
    static {
    }

    public Config() {
        System.out.println("获取配置信息");
        file = new File(System.getProperty("user.dir") + File.separator + "config.txt");
        createConfigFile();
        getConfig();
        if (apkReInstall) {
            findApk();
            checkAppPackage();
        }else{
            checkAppPackage();
        }
    }
    /**
     * 检查手机中是否安装了包
     *
     */
    private void checkAppPackage(){
        for (String s : DevicesInfo.adb(" shell pm  list package -3")) {
            if (s.contains(this.packageName)) {
                return;
            }
        }
        Tooltip.errHint("手机中没有安装app:"+packageName, DevicesInfo.adb(" shell pm  list package -3"));
    }
    /**
     * 获取config文件中的内容
     */
    private void getConfig() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                if (msg.contains("packageName")) {
                    this.packageName = substring(msg).equals("") ? packageName : substring(msg);
                    System.out.println("获取到的包名：" + packageName);
                } else if (msg.contains("runTime")) {
                    try {
                        this.runTime =  Integer.parseInt( substring(msg).equals("") ? Integer.toString(runTime) : substring(msg));;
                    } catch (NumberFormatException e) {
                        runTime = 8;
                    }
                    System.out.println("获取的运行时间:" + runTime + "小时");
                } else if (msg.startsWith("apkName")) {

                    this.apkName = substring(msg).equals("") ? apkName : substring(msg);
                    if (!apkName.equals(apkNameRand)) {
                        System.out.println("获取到的apkName:" + apkName);
                    } else {
                        System.out.println("没有配置apkName，将自动搜索");
                    }
                } else if (msg.contains("apkReInstall")) {
                    if ("false".equals(substring(msg).toLowerCase())) {
                        this.apkReInstall = false;
                    }
                    System.out.println("获取到的apkReInstall:" + apkReInstall);
                } else if(msg.contains("runCount")){
                    this.runCount = Long.parseLong( substring(msg).equals("") ? Long.toString(runCount) : substring(msg));
                    System.out.println("获取到的 runCount："+runCount);
                }else if (msg.contains("eventsTime")){
                    this.eventsTime =  Integer.parseInt( substring(msg).equals("") ? Integer.toString(eventsTime) : substring(msg));
                    System.out.println("获取到的 eventsTime："+eventsTime);
                }
            }
            if (packageName.contains(apkNameRand)) {
                Tooltip.errHint("没有在config文件中获取到packageName");
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * 截取config中的文件
     * @param msg
     * @return
     */
    private String substring(String msg) {
        if(msg.startsWith("apkName") &&
                !"".equals(msg.substring(msg.indexOf("=") + 1, msg.length()).trim())){
            if(!msg.endsWith(".apk")){
                msg = msg+".apk";
            }
        }
        return msg.substring(msg.indexOf("=") + 1, msg.length()).trim();
    }

    /*
     *
     * 创建config文件
     */
    private void createConfigFile() {
        if (!file.exists()) {
            System.out.println("没有找到config文件，创建一个新的config文件到当前目录:" + System.getProperty("user.dir"));
            configValues();
            try {
                if (file.createNewFile()) {
                    createConfigData();
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec("cmd /c explorer /select, " + System.getProperty("user.dir") + File.separator
                            + "config.txt");
                } else {
                    System.out.println("config文件创建失败，请手动创建到："+System.getProperty("user.dir"));
                    System.out.println("格式：");
                    System.out.println(s.toString());
                    Tooltip.errHint("请按照打印的格式进行创建");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Tooltip.errHint("创建config文件发生异常");
            }
        }
    }
    private void configValues(){
        s = new StringBuffer();
        s=sbAppEnd(s,"请在每一个=后填写，手机请关闭锁屏和密码解锁");
        s=sbAppEnd(s,"//包名，不填写包名程序不执行");
        s=sbAppEnd(s,"packageName = " );
        s=sbAppEnd(s,"//运行时间,单位：小时，不填写默认8小时，暂时没有用到，不用填写" );
        s=sbAppEnd(s,"runTime = ");
        s=sbAppEnd(s,"//apk名称,不填写默认从当前运行文件搜索.apk文件" );
        s=sbAppEnd(s,"apkName = " );
        s=sbAppEnd(s,"//是否重新安装apk,true是安装，false是不安装,默认安装" );
        s=sbAppEnd(s,"apkReInstall = ");
        s=sbAppEnd(s,"//运行次数,默认为10000000" );
        s=sbAppEnd(s,"runCount = ");
        s=sbAppEnd(s,"//事件间隔时间:单位:毫秒，默认为:300" );
        s=sbAppEnd(s,"eventsTime = " );
        s=sbAppEnd(s,System.lineSeparator());
        s=sbAppEnd(s,"说明:如果apkReInstall为true并且apkName没有填写，程序会在当前目录下自动获取一个尾椎为.apk的文件进行安装" + System.lineSeparator());
    }
    /**
     * 给默认config文件添加格式
     * @param s StringBuffer
     * @param str 需要添加的文件
     * @return StringBuffer
     */
    public static StringBuffer sbAppEnd(StringBuffer s , String str){
        s.append(str);
        s.append(System.lineSeparator());
        s.append(System.lineSeparator());
        return s;
    }
    /**
     * 创建config文件默认格式
     */
    private void createConfigData() {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.write(s.toString());
            br.flush();
            br.close();
            Tooltip.finishHint("默认配置文件创建完毕");
        } catch (IOException e) {
            e.printStackTrace();
            Tooltip.errHint("写入config默认文件发生未知错误");
        }
    }
    /**
     * 查找当前目录下的apk文件,并进行卸载与安装
     */
    private void findApk() {
        String fileName = this.apkName.equals(this.apkNameRand) ? "*.apk" : this.apkName;
        try {
            String regStr = "^.:\\\\.*(" + (this.apkName.equals(this.apkNameRand) ? ".*.apk" : fileName)
                    + ")$";
            Pattern pattern = Pattern.compile(regStr);
            String msg = null;
            System.out.println("正在寻找\'" + fileName + "\"配置路径,当前查找路径:" + System.getProperty("user.dir"));
            Process pro = Runtime.getRuntime()
                    .exec("cmd /c dir/s/a/b " + System.getProperty("user.dir") + File.separator + fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            while ((msg = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(msg);
                if (matcher.find()) {
                    System.out.println("获取到的" + fileName + "文件路径:" + msg);
                    this.apkPath = msg;
                    //检查设备是否连接
                    checkDevicesExist();
                    // 卸载包
                    installAPPPackage.uninstallPackge(this.packageName);
                    // 安装包
                    installAPPPackage.installPackage(this.apkPath,this.packageName);
                    return;
                }
            }
            System.out.println("没有找到\"" + fileName + "\"文件路径");
            Tooltip.errHint("没有找到\"" + fileName + "\"文件路径");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 检查设备是否连接
     */
    private void checkDevicesExist() {
        System.out.println("开始获取设备名称....");
        int j = 0;
        String[] adb = DevicesInfo.adb("devices");
        DevicesInfo.err(adb, "devices");
        for (String s : adb) {
            s = s.toLowerCase();
            if (s.endsWith("device")) {
                j++;
            }
        }
        if (j == 0) {
            Tooltip.errHint("没有找到设备");
        } else if (j > 1) {
            Tooltip.errHint("请只连接一台设备");
        } else {
            if (j != 1) {
                Tooltip.errHint("检查设备时，发生未知错误", adb);
            }
        }
    }
    public String getPackageName() {
        return packageName;
    }

    public int getRunTime() {
        return runTime;
    }

    public String getApkName() {
        return apkName;
    }

    public long getRunCount() {
        return runCount;
    }

    public int getEventsTime() {
        return eventsTime;
    }




}
