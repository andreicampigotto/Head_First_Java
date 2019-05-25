package usecabeca24;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import javax.swing.JCheckBox;

public class MySendListener implements ActionListener{
    
    public void actionPerformed(ActionEvent a){
        boolean checkBoxState[] = new boolean[256];
        
        for (int i = 0; i < 256; i++) {
            JCheckBox check = (JCheckBox) checkBoxList.get(i);
            if (check.isSelected()) {
                checkBoxState[i] = true;
            }
        }
        
        try {
            FileOutputStream fileStream = new FileOutputStream(new File("Checkbox.ser"));
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(checkBoxState);
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}

public class MyReadInListener implements ActionListener{
    public void actionPerformed(ActionEvent a){
        boolean checkBoxState[] = null;
        try {
            FileInputStream fileIn = new FileInputStream(new File("Checkbox.ser"));
            ObjectOutputStream is = new ObjectOutputStream(fileIn);
            checkBoxState = (boolean[]) is.readObject();
        } catch (Exception ex) { ex.printStackTrace(); }
        for (int i = 0; i < 256; i++) {
            JCheckBox check = (JCheckBox) checkBoxList.get(i);
            if (checkBoxState[i]) {
                check.setSelected(true);
            }else
                check.setSelected(false);
        }
        sequencer.stop();
        buildTrackAndStart();
    }
}
