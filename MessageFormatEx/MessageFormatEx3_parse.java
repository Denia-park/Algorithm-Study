package MessageFormatEx;

import java.text.MessageFormat;
import java.text.ParseException;

/*
이번에는 parse(String source)를 이용해서 출력된 데이터로부터 필요한 데이터만을 뽑아냄

해당 예제를 잘 이용하면 어려운 작업을 쉽게 처리가능

★잘 기억해둘 것★
 */

public class MessageFormatEx3_parse {
    public static void main(String[] args) throws ParseException {
        String[] data = {
                "INSERT INTO COST_INFO VALUES ('이자바','02-123-4567',30,'12-34');",
                "INSERT INTO COST_INFO VALUES ('강프로','02-456-4567',33,'33-21');"
        };

        String pattern = "INSERT INTO COST_INFO VALUES ({0},{1},{2},{3});";

        MessageFormat mf = new MessageFormat(pattern);

        for (String datum : data) {
            Object[] objs = mf.parse(datum);
            for (Object obj : objs) {
                System.out.print(obj + ",");
            }
            System.out.println();
        }
    }
}
