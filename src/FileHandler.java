import java.io.*;
import java.util.LinkedList;

public class FileHandler {

    public LinkedList<Member> readFile() {
        LinkedList<Member> m = new LinkedList<>();
        Member mbr;
        String line;
        String[] splitLine;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            line = reader.readLine();
            while (line != null) {
                if (line.isEmpty()){
                    m=new LinkedList<>();
                    return m;
                }
                splitLine = line.split(",");
                if (splitLine[0].equals("S")) {
                    mbr = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                } else {
                    mbr = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                }
                m.addLast(mbr);
                line = reader.readLine();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return m;
    }


        public void appendFile (String mem){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
                writer.write(mem + "\n");
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        public void overRightFile (LinkedList < Member > m) {
            String s;
            try {

                BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false));
                for (int i = 0; i < m.size(); i++) {
                    s = m.get(i).toString();
                    writer.write(s + "\n");
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            try {
                File oldFile = new File("members.csv");
                File tempFile = new File("members.temp");
                oldFile.delete();
                tempFile.renameTo(oldFile);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }

    }



