package net.mytour.ext;

import java.text.DecimalFormat;

public class Number_Format {
	//�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
