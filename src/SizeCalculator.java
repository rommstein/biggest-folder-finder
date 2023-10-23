import java.io.File;

public class SizeCalculator {
    private static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }
    private static String getHumanReadableSize(long size){
        if (size < 1024){
            return size + "b";
        }
        else if (size < 1024 * 1024){
            int kbSize = (int) (size / 1024);
            return kbSize + "kb";
        }
        else if (size < 1024 * 1024 * 1204){
            int mbSize = (int) (size / 1024 * 1024);
            return mbSize + "mb";
        }
        else{
            int gbSize = (int) (size / 1024 * 1024 * 1024);
            return gbSize + "gb";
        }
    }
    private static long getSizeFromHumanReadable(String size){
        long bytes = 0;
        size = size.toLowerCase();
        String value = size.replaceAll("[^0-9.]", "");
        double numericValue = Double.parseDouble(value);
        if (size.contains("gb") || size.contains("g")) {
            bytes = Math.round(numericValue * Math.pow(1024, 3));
        } else if (size.contains("mb") || size.contains("m")) {
            bytes = Math.round(numericValue * Math.pow(1024, 2));
        } else if (size.contains("kb") || size.contains("k")) {
            bytes = Math.round(numericValue * 1024);
        } else if (size.contains("b")) {
            bytes = Math.round(numericValue);
        } else {
            System.out.println("Некорректный формат размера!");
        }
        return bytes;
    }
}
