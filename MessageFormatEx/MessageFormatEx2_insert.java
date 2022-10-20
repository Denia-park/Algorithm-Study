package MessageFormatEx;

import java.text.MessageFormat;

//반복문으로 하나 이상의 데이터 집합을 출력하는 예제
//다수의 데이터를 DB에 저장하기 위한 Insert문으로 변환하는 경우 등에 사용하면 좋다.

//홑따옴표(')는 MessageFormat의 양식에 escape문자로 사용되기 때문에
//문자열 msg내에서 홑따옴표를 사용하려면 홑따옴표를 연속으로 두 번 ('') 사용해야 한다.

public class MessageFormatEx2_insert {
    public static void main(String[] args) {
        String tableName = "COST_INFO";
        String msg = "INSERT INTO " + tableName + " VALUES (''{0}'',''{1}'',{2},''{3}'');";

        Object[][] arguments = {
                {"이자바", "02-123-4567", "30", "12-34"},
                {"강프로", "02-456-4567", "33", "33-21"}
        };

        for (int i = 0; i < arguments.length; i++) {
            String result = MessageFormat.format(msg, arguments[i]);
            System.out.println(result);
        }
    }
}
