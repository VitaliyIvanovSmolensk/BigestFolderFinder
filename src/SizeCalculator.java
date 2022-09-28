import java.io.File;

public class SizeCalculator {

    public static long getFolderSize (File folder){
        if (folder.isFile()){
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files){
            sum += getFolderSize(file);
        }
        return  sum;
    }
    public static String getHumanRedableSize(long size){
        if (size / 1024 < 1 ){
            return size + "B";
        } else if (size / 1024 < 1024) {
            return Math.round((size/1024.)*100)/100. + " Kb";
        } else if (size / (1024*1024) < 1024) {
            return Math.round(size/(1024.*1024)*100)/100. + " Mb";
        } else if (size / (1024*1024*1024) < 1024) {
            return Math.round(size/(1024.*1024*1024)*100)/100. + " Gb";
        } else {
            return Math.round(size/(1024.*1024*1024*1024)*100)/100. + " Tb";
        }
    }
    public static Long getSizeFromeHumanReadble (String size){
        Long volium =0L;
        for (int i = 0; i < size.length();i++){
            char lit = size.charAt(i);
            switch (lit) {
                case 'B' -> volium = Long.parseLong(size.substring(0, i));
                case 'K' -> volium = Long.parseLong(size.substring(0, i)) * 1024;
                case 'M' -> volium = Long.parseLong(size.substring(0, i)) * 1024 * 1024;
                case 'G' -> volium = Long.parseLong(size.substring(0, i)) * 1024 * 1024 * 1024;
                case 'T' -> volium = Long.parseLong(size.substring(0, i)) * 1024 * 1024 * 1024 * 1024;
            }
        }
        return volium;
    }

}
