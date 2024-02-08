import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        growup();
    }

    private static void growup() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int resultCount=0;
        for (int i = 0; i < count; i++) {
            String words = br.readLine();
            boolean result = true;
            for (int j = 0; j < words.length()-1; j++) {
                if (words.charAt(j)!=words.charAt(j+1)){
                    if (words.substring(j+1).contains(String.valueOf(words.charAt(j)))) {
                        result = false;
                        break;
                    }
                }
            }
            if (result){
                resultCount++;
            }
        }
        System.out.println(resultCount);
    }
}