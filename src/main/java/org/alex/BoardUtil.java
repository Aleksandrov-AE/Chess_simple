package org.alex;

import java.util.ArrayList;
import java.util.List;

public class BoardUtil {
    public static List<Coordinates> getDiagonalBetween(Coordinates source, Coordinates target) {
        // клетки лежат на одной диагонали
        List<Coordinates> list = new ArrayList<>();
        int sourceHorizont = source.horizontal.ordinal();
        int sourceVertical = source.vertical;
        int targetHorizont = target.horizontal.ordinal();
        int targetVertical = target.vertical;
        int horizontalStep = sourceHorizont > targetHorizont ? -1 : 1;
        int verticalStep =  sourceVertical > targetVertical  ? -1 : 1;
        for (int i = sourceHorizont + horizontalStep, j = sourceVertical + verticalStep;
        i != targetHorizont && j != targetVertical;
        i += horizontalStep, j += verticalStep) {
                list.add(new Coordinates(Horizontal.values()[i], j));
        }
      return  list;
    }

    public  static List<Coordinates> getHorizontalCoordinates(Coordinates sourse, Coordinates target) {
        List<Coordinates> result = new ArrayList<>();
        int step = sourse.horizontal.ordinal() > target.horizontal.ordinal() ? -1 : 1;
        for (int i = sourse.horizontal.ordinal() + step; i != target.horizontal.ordinal(); i += step) {
            result.add(new Coordinates(Horizontal.values()[i], sourse.vertical));
        }
        return result;
    }

    public  static List<Coordinates> getVerticalCoordinates(Coordinates sourse, Coordinates target) {
        List<Coordinates> result = new ArrayList<>();
        int step = sourse.vertical > target.vertical ? -1 : 1;
        for (int i = sourse.vertical + step; i != target.vertical; i += step) {
            result.add(new Coordinates(sourse.horizontal, i));
        }
        return result;
    }
}
