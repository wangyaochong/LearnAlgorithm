package a面试常见.网易春招;

import java.util.Scanner;

/**
 * Created by【王耀冲】on 【2017/4/4】 at 【16:08】.
 */
public class 赶去公司 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String taxiCount = in.nextLine();
        String taxiX = in.nextLine();
        String taxiY = in.nextLine();
        String officeLoc = in.nextLine();
        int officeX=Integer.parseInt(officeLoc.split(" ")[0]);
        int officeY=Integer.parseInt(officeLoc.split(" ")[1]);
        String moveTime = in.nextLine();
        int walkTime=Integer.parseInt( moveTime.split(" ")[0]);
        int driveTime=Integer.parseInt( moveTime.split(" ")[1]);
        String[] splitTaxiX = taxiX.split(" ");
        String[] splitTaxiY = taxiY.split(" ");
        int minTime=(Math.abs(officeX)+Math.abs(officeY))*walkTime;//记录走路需要的时间
        int count=Integer.parseInt(taxiCount);
        for(int i=0;i<count;i++){
            int tX=Integer.parseInt(splitTaxiX[i]);
            int tY=Integer.parseInt(splitTaxiY[i]);
            //计算走路到计程车站和计程车开到公司的时间
            int time=(Math.abs(tX)+Math.abs(tY))*walkTime+(Math.abs(officeX-tX)+Math.abs(officeY-tY))*driveTime;
            if(time<minTime){
                minTime=time;
            }
        }
        System.out.println(minTime);

    }
}
