package experimental;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;

public class ByteArrayBuilder {

    public static Map.Entry<Integer, byte[]> toByteArray(Object obj) {
        StringBuilder recordBuilder = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        Integer size = 0;

        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields
            Object value = null;

            try {
                value = field.get(obj);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            Class<?> fieldType = field.getType();

            if (fieldType == String.class) {
                // Fixed size for strings (e.g., 20 bytes)
                size += 20;
                String strValue = value != null ? (String) value : "";
                recordBuilder.append(String.format("%-20s", strValue));

            } else if (fieldType == int.class) {
                // Fixed size for integers (e.g., 4 bytes)
                size += 4;
                int intValue = (int) value;
                recordBuilder.append(String.format("%-4d", intValue));

            } else if (fieldType == LinkedList.class) {
                // Handle the LinkedList case (e.g., friends)
                LinkedList<?> list = (LinkedList<?>) value;
                int maxListSize = 5; // Define max number of list entries

                for (int i = 0; i < maxListSize; i++) {
                    size += 20;
                    if (i < list.size()) {
                        // Assume list elements are strings
                        String listElement = (String) list.get(i);
                        recordBuilder.append(String.format("%-20s", listElement));
                    } else {
                        // Pad with empty space if fewer than max size
                        recordBuilder.append(String.format("%-20s", "0xFFF"));
                    }
                }

            } else {
                // Handle other types if necessary (e.g., long, float)
            }
        }

        // Convert the string to a byte array
        String paddedRecord = recordBuilder.toString();
        return new AbstractMap.SimpleEntry<>(size, paddedRecord.getBytes(StandardCharsets.UTF_8));

    }

    public static <T> T fromByteArray(byte[] data, Class<T> clazz) throws Exception {
        // Convert the byte array back to a string
        String recordStr = new String(data, StandardCharsets.UTF_8).trim();
        Field[] fields = clazz.getDeclaredFields();
        T obj = clazz.getDeclaredConstructor().newInstance(); // Create a new instance of the class

        int currentIndex = 0;

        // Iterate over all fields in the class
        for (Field field : fields) {
            field.setAccessible(true); // Allow access to private fields
            Class<?> fieldType = field.getType();

            if (fieldType == String.class) {
                // Handle strings, assume fixed size (e.g., 20 bytes)
                String value = recordStr.substring(currentIndex, currentIndex + 20).trim();
                field.set(obj, value);
                currentIndex += 20;

            } else if (fieldType == int.class) {
                // Handle integers, assume fixed size (e.g., 4 bytes)
                String value = recordStr.substring(currentIndex, currentIndex + 4).trim();
                field.set(obj, Integer.parseInt(value));
                currentIndex += 4;

            } else if (fieldType == LinkedList.class) {
                // Handle LinkedList (assuming max size of 5 strings, each 20 bytes long)
                LinkedList<String> list = new LinkedList<>();

                // TODO Replace n with a calculated record offset for the list
                // int n = 24;
                int maxListSize = recordStr.substring(currentIndex).length() / (20) + 1;

                System.out.println("Size " + maxListSize);

                for (int i = 0; i < maxListSize; i++) {
                    if (i == maxListSize - 1) {
                        System.out.println(currentIndex + " " + recordStr.length());
                        String listElement = recordStr.substring(currentIndex)
                                .trim();
                        if (listElement == " ") {
                            break;
                        }
                        if (!listElement.isEmpty()) {
                            list.add(listElement);
                        }
                        break;

                    }
                    String listElement = recordStr.substring(currentIndex, currentIndex + 20).trim();
                    if (!listElement.isEmpty()) {
                        list.add(listElement);
                    }
                    currentIndex += 20;
                }
                field.set(obj, list);

            } else {
                // Handle other types (e.g., long, float) if needed
                throw new IllegalArgumentException("Unsupported field type: " + fieldType);
            }
        }

        return obj;
    }

}
