package util;

public class PaintHelper {
    public static <T extends Enum<?>> T searchEnum(Class<T> enumeration, String search) {
        if (!search.isEmpty()) {
            for (T elem : enumeration.getEnumConstants()) {
                int result = elem.name().compareToIgnoreCase(search);

                if (result == 0) {
                    return elem;
                }
            }
        }

        return null;
    }
}
