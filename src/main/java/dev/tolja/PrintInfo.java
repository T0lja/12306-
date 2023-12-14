package dev.tolja;

import static dev.tolja.StationNameConverter.stationNameConverter;

public class PrintInfo {
    public static void printInfo(TrainInfo trainInfo){

        System.out.println("车号 " + trainInfo.trainCode());
        System.out.println("出发站 " + stationNameConverter(trainInfo.startStation(), 2));
        System.out.println("到达站 " + stationNameConverter(trainInfo.endStation(), 2));
        System.out.println("起始站 " + stationNameConverter(trainInfo.fromStation(), 2));
        System.out.println("终点站 " + stationNameConverter(trainInfo.toStation(), 2));
        System.out.println("起始时间 " + trainInfo.startTime());
        System.out.println("到达时间 " + trainInfo.arriveTime());
        System.out.println("历时 " + trainInfo.liShi());
        System.out.println("是否可以在线购买 " + trainInfo.canWebBuy());
        printUsefulInfo("商务座特等座 " , trainInfo.st());
        printUsefulInfo("一等座 " , trainInfo.yd());
        printUsefulInfo("二等座二等包座 " , trainInfo.ed());
        printUsefulInfo("高级软卧 " , trainInfo.gr());
        printUsefulInfo("软卧一等卧 " , trainInfo.ry());
        printUsefulInfo("动卧 " , trainInfo.dw());
        printUsefulInfo("硬卧二等卧 ", trainInfo.ye());
        printUsefulInfo("软座 " , trainInfo.rw());
        printUsefulInfo("硬座 " , trainInfo.yz());
        printUsefulInfo("无座 " , trainInfo.wz());
        System.out.println("-----------------------------");
    }

    private static void printUsefulInfo(String info, String value){
        if (!value.contains("--")) {
            System.out.println(info + value);
        }
    }
}
