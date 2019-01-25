package main.leetcode;


import java.io.*;

public class ThreeTwoDay {



    private final static int[] averageYear = {31,28,31,30,31,30,31,31,30,31,30,31};
    private final static int[] leapYear = {31,29,31,30,31,30,31,31,30,31,30,31};

    private final static int startYear = 2010;
    private final static int startMonth = 1;
    private final static int startDay = 1;

    /**
     * @param readPath  读取文件路径
     * @param writePath    写入文件路径
     * @throws IOException
     */

    private static void readLocal(String readPath,String writePath) throws IOException {
        BufferedReader br = new BufferedReader((new FileReader(new File(readPath))));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(writePath)));

        String date;

        while ((date = br.readLine()) != null) {
            bw.write(getType(date));
            bw.newLine();
        }

        bw.flush();
        //关闭流
        br.close();
        bw.close();
    }

    /**
     * 通过结束时间获取 打鱼 OR 晒网
     * @param endDate
     * @return
     */

    private static String getType(String endDate){

        if(!isCurrent(endDate)){
            return "非法日期";
        }

        String[] ar = endDate.split("-");

        int endYear = Integer.parseInt(ar[0]);
        int endMonth = Integer.parseInt(ar[1]);
        int endDay = Integer.parseInt(ar[2]);

        boolean isLeap = isLeapYear(endYear);

        int sumDay = 0;

        for(int x=endYear;x>startYear;x--){
            sumDay +=isLeapYear(x)?366:365;
        }

        for(int x=endMonth;x>startMonth;x--){
            sumDay+=isLeap?leapYear[x]:averageYear[x];
        }

        sumDay += endDay-startDay;

        System.out.println("sumDay = "+sumDay);

        if(sumDay% 5>0 && sumDay <4){
            return "打鱼";
        }else{
            return "晒网";
        }
    }

    /**
     * 判断是否为正确日期
     * 格式:yyyy-MM-dd
     * @param date
     * @return
     */

    private static boolean isCurrent(String date){

        String[] ar = date.split("-");

        if(ar.length!=3){
            return false;
        }

        int year,month,day;
        try{
            year = Integer.parseInt(ar[0]);
            month = Integer.parseInt(ar[1]);
            day = Integer.parseInt(ar[2]);
        }catch (Throwable throwable){
            return false;
        }


        boolean isLeap = isLeapYear(year);
        int[] temp = isLeap?leapYear:averageYear;

        return month >= 0 && month <= 12 && day >= 1 && day <= temp[month] && year >= startYear;
    }

    /**
     * 判断是否为闰年
     * @param year
     * @return
     */

    private static boolean isLeapYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }



}
