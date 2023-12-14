package dev.tolja;

import dev.tolja.data.Station;

public class StationNameConverter {
    /**
     *
     * @param s 字符
     * @param type 1代表车站 2代表缩写
     * @return
     */
    public static String stationNameConverter(String s, int type){
        for (Station station : Station.stations) {
            if (type == 1 && s.trim().contains(station.name())) {
                return station.code();
            }
            if (type == 2 && s.trim().contains(station.code())) {
                return station.name();
            }
        }
        throw new RuntimeException("Unknown Station");
    }
}
