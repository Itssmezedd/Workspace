package SE_Lab_Assignment_5.DA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import SE_Lab_Assignment_5.Domain.BlockSection;

public class BlockSectionDA {
    BlockSection blockSection;

    public BlockSection getBlockSection() {
        return blockSection;
    }

    public BlockSectionDA() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("SE_Lab_Assignment_5/csv/blockSectionInfo.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] specific = line.split(", ");
            blockSection = new BlockSection();

            blockSection.setBlockCode(specific[0]);
            blockSection.setDescription(specific[1]);
            blockSection.setAdviser(specific[2]);

            StudentDA studentDA = new StudentDA();
            blockSection.setStudentList(studentDA.getStudentList());
        }

        br.close();
    }
}
