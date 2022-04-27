import javax.swing.*;
import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.awt.FileDialog;
import java.io.FileWriter;


public class Function_File{
    GUI gui;
    String fileName;
    String fileAddress;

    public Function_File(GUI gui){
        this.gui=gui;
    }

    public File newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        //update
        fileName = null;
        if(fileName==null) {
            saveAs();
        }
        return null;
    }

    //update
    public void open (JFrame window) {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        String check = fd.getFile().split("\\.")[1];
        //System.out.println(check);
        if(check.equals("txt")){
            if(fd.getFile()!=null) {
                fileName = fd.getFile();
                fileAddress = fd.getDirectory();
                gui.window.setTitle(fileName);
            }
            System.out.println("File address and file name" + fileAddress + fileName);

            try {
                BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
                gui.textArea.setText("");
                String line = null;

                while ((line = br.readLine()) !=null) {
                    gui.textArea.append(line + "\n");
                }
                br.close();

            }
            catch (Exception e) {
                System.out.println("FILE NOT OPENED!");
            }
        }
        else{
            JOptionPane.showMessageDialog(window,
                    "      This file is not text file.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void save() {
        if(fileName==null) {
            saveAs();
        }
        else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName + ".txt"); //update
                fw.write(gui.textArea.getText());
                fw.close();
            }
            catch (Exception e) {
                System.out.println("SOMETHING WRONG!");
            }
        }
    }

    public void saveAs () {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile()!=null) {
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAddress + fileName +".txt"); //update
            fw.write(gui.textArea.getText ());
            fw.close();
        }
        catch(Exception e) {
            System.out.println("SOMETHING WRONG!");
        }
    }

    public void exit(){
        System.exit(0);
    }
}