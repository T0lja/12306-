package dev.tolja;

import com.google.gson.Gson;
import dev.tolja.data.TicketData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import static dev.tolja.HttpRequest.httpRequest;
import static dev.tolja.PrintInfo.printInfo;
import static dev.tolja.TrainInfo.parseSeatNumbers;
import static dev.tolja.StationNameConverter.stationNameConverter;

public class Main {
    public static void main(String[] args){
        System.out.println("请依次输入日期xxxx-xx-xx,出发站,到达站.");
        String[] split = new Scanner(System.in).nextLine().split(",");

        String uri = "https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=" + split[0] + "&leftTicketDTO.from_station=" + stationNameConverter(split[1], 1) + "&leftTicketDTO.to_station="+ stationNameConverter(split[2], 1) + "&purpose_codes=ADULT";

        try {
            Gson gson = new Gson();
            String content = httpRequest(uri);
            TicketData json = gson.fromJson(content,TicketData.class);
            String[] result = json.data().result();
            for(String str : result) {
                TrainInfo trainInfo = parseSeatNumbers(str);
                printInfo(trainInfo);
            }
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
