package com.myjob.ext;

import java.text.DecimalFormat;

public class NumberFormat {
	//금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
