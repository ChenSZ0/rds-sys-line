import me.jy.rds.canteentime.dto.CanteentimeDto;
import me.jy.rds.common.utils.EasyPoiUtil;

import java.util.List;

/**
 * @author Cshuzhuo
 * @date 2018/10/23 9:56
 */
public class test {
    public static void main(String[] args) {
        List<CanteentimeDto> canteentimeDtos = EasyPoiUtil.importExcel("C:\\Users\\GDGA\\Desktop\\饭堂就餐情况导入模版.xlsx", 1, 1, CanteentimeDto.class);
        for (int i = 0; i < canteentimeDtos.size(); i++) {
            System.out.println(canteentimeDtos);
        }
    }
}
