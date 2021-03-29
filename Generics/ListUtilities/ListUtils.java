package ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMax(List<T> elements){
      if (elements.isEmpty()){
          throw new IllegalStateException();
      }
        return Collections.max(elements);
    }
    public static <T extends Comparable<T>> T getMin(List<T> elements){
        if (elements.isEmpty()){
            throw new IllegalStateException();
        }
        return Collections.min(elements);
    }

}
