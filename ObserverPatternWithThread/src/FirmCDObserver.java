import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class FirmCDObserver extends Observer {


    public FirmCDObserver(Firm[] subjects){

        try {
            CreateOutputFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Firm firm: subjects) {
            firm.Attach(this);
        }
    }

    @Override
    public void Update(Firm firm) {
        WriteOutputFile(firm.getClass().getName()+": "+firm.getShare()+"\n");
    }

    @Override
    public void CreateOutputFile() throws IOException {
        File f = new File("Output.txt");
        if(f.createNewFile()){
            System.out.println("Output.txt has been created");
        }
        else{
            System.out.println("Output.txt already exist");
        }
    }

    @Override
    public void WriteOutputFile(String data) {
        try {
            Files.write(Paths.get("Output.txt"),data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
