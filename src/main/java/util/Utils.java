package util;

import com.encore.entities.SelectOptions;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {


    public static Map<Integer, String> getSelectOptionByType(HttpServletRequest request, int selectType) {
        List<SelectOptions> selectList = (List<SelectOptions>) request.getSession().getAttribute("selectList");
        return selectList.stream().filter(x -> x.getSelectType() == selectType).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
    }
}
