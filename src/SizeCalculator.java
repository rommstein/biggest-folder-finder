import java.util.HashMap;

public class SizeCalculator {

    public static char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizeMultipliers.length; i++) {
            double value = size / Math.pow(1024, i);
            if (value < 1024){
                return Math.round(value) + "" + sizeMultipliers[i] + (i > 0 ? "b" : "");
            }
        }
        return "Very Big!";
    }

    public static long getSizeFromHumanReadable(String size) {
        HashMap<Character, Integer> char2Multiplier = getMultipliers();
        char sizeFactor = size.replaceAll("[0-9\\s+]+", "").charAt(0);
        int multiplier = char2Multiplier.get(sizeFactor);
        long length = multiplier * Long.valueOf(size.replaceAll("[^0-9]",""));
        return length;
    }

    public static HashMap<Character, Integer> getMultipliers() {
        char[] multipliers = {'B', 'K', 'M', 'G', 'T'};
        HashMap<Character, Integer> char2multiplier = new HashMap<>();
        for (int i = 0; i < sizeMultipliers.length; i++) {
            char2multiplier.put(sizeMultipliers[i], (int) Math.pow(1024, i));
        }
        return char2multiplier;
    }

//    private static long getFolderSize(File folder) {
//        if (folder.isFile()) {
//            return folder.length();
//        }
//        long sum = 0;
//        File[] files = folder.listFiles();
//        for (File file : files) {
//            sum += getFolderSize(file);
//        }
//        return sum;
//    }

}
