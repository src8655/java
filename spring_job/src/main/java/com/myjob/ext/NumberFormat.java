package com.myjob.ext;

import java.text.DecimalFormat;

public class NumberFormat {
	//�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
