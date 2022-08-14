package git.Algorithm.baekjoon;

import java.io.*;

public class B22859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] div = br.readLine().replace("</div>", "").split("<div title=\"");
        for(int i = 1; i < div.length; i++){
            String[] p = div[i].split("<p>");
            sb.append("title : " + p[0].replace("\">", "").trim());
            for(int j = 1; j < p.length; j++){
                p[j] = p[j].replace("</", "<").replace(" >", ">").replaceAll("<[a-zA-Z]*>", "").replace("  ", " ").trim();
                sb.append("\n" + p[j]);
            }
            if(i != div.length -1){
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
