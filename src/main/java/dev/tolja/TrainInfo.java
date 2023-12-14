package dev.tolja;

/**
 *
 * @param trainCode 车号
 * @param startStation 出发站
 * @param endStation 到达站
 * @param fromStation 起始站
 * @param toStation 终点站
 * @param startTime 起始时间
 * @param arriveTime 到达时间
 * @param liShi 历时
 * @param canWebBuy 是否可以在线购买
 * @param st 商务座特等座
 * @param yd 一等座
 * @param ed 二等座二等包座
 * @param gr 高级软卧
 * @param ry 软卧一等卧
 * @param dw 动卧
 * @param ye 硬卧二等卧
 * @param rw 软座
 * @param yz 硬座
 * @param wz 无座
 */
public record TrainInfo(String trainCode, String startStation, String endStation, String fromStation, String toStation, String startTime, String arriveTime, String liShi, String canWebBuy, String st, String yd, String ed, String gr, String ry, String dw, String ye, String rw, String yz, String wz){
    public static TrainInfo parseSeatNumbers(String s) {
        String[] split = s.split("\\|");
        return new TrainInfo(
                prettyString(split[3]),
                prettyString(split[4]),
                prettyString(split[5]),
                prettyString(split[6]),
                prettyString(split[7]),
                prettyString(split[8]),
                prettyString(split[9]),
                prettyString(split[10]),
                prettyString(split[11]),
                prettyString(split[25]),
                prettyString(split[31]),
                prettyString(split[30]),
                prettyString(split[21]),
                prettyString(split[23]),
                prettyString(split[33]),
                prettyString(split[28]),
                prettyString(split[24]),
                prettyString(split[29]),
                prettyString(split[26])
        );
    }

    private static String prettyString(String s){
        if (s.isBlank()) {
            return "--";
        }
        return s;
    }
}