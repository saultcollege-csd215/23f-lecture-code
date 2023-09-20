package _02_data_calculations_actions.couponDog;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> couponList = List.of("10% off", "20% off", "30% off", "40% off", "50% off");

        var best = couponList.stream().filter(coupon -> coupon.contains("50%")).toList();
        for ( String coupon : best ) {
            System.out.println(coupon);
        }
    }
}
