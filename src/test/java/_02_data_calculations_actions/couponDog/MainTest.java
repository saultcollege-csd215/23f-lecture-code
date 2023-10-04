package _02_data_calculations_actions.couponDog;

import _02_data_calculations_actions.couponDog.data.CouponRank;
import _02_data_calculations_actions.couponDog.data.Coupon;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void toStringList() {

        var coupons = List.of( new Coupon("A", CouponRank.BEST),
                               new Coupon("B", CouponRank.BAD),
                               new Coupon("C", CouponRank.GOOD) );

        assertEquals(List.of("A", "B", "C"), Main.toStringList(coupons));
        assertEquals(List.of(), Main.toStringList(List.of()));
    }
}