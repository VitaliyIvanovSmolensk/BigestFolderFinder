import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        String folderPath = "d:/Games/";
        File file = new File(folderPath);
        long start = System.currentTimeMillis();
        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(getHumanRedableSize(size));


//        System.out.println(getFolderSize(file));

        System.out.println(System.currentTimeMillis() - start);


    }

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
            return Math.round(size/1024L) + "Kb";
        }else if (size / (1024*1024) < 1024) {
            return Math.round(size/(1024L*1024)) + "Mb";
        }else if (size / (1024*1024*1024) < 1024) {
            return Math.round(size/(1024L*1024*1024)) + "Gb";
        }else {
            return Math.round(size/(1024L*1024*1024*1024)) + "Tb";
        }
    }
    public static Long getSizeFromeHumanReadble (String size){
        long volium = 0l;
        for (int i = 0; i < size.length();i++){
            char lit = size.charAt(i);
            if (lit == 'B') {
                volium = Long.parseLong(size.substring(0, i));
                return volium;
            } else if (lit == 'K') {
                volium = Long.parseLong(size.substring(0, i));
                return volium * 1024;
            } else if (lit == 'M') {
                volium = Long.parseLong(size.substring(0, i));
                return volium * 1024*1024;
            } else if (lit == 'G') {
                volium = Long.parseLong(size.substring(0, i));
                return volium * 1024*1024*1024;
            } else if (lit == 'T') {
                volium = Long.parseLong(size.substring(0, i));
                return volium * 1024*1024*1024*1024;
            }
        }
        return 0l;
    }
}
