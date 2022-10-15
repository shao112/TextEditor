package Main;

import FactoryAndTemplate.EnvironmentFactory;
import Memento.Caretaker;
import Memento.Originator;
import Observer.*;
import Product.*;
import Strategy.Context;
import Strategy.Left;
import Strategy.Middle;
import Strategy.Right;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * GUI is the Abstraction part in "Bridge Pattern".
 ---------------------------------------------------------
 If we change the reference to the implementor(OperatingSystem type) in the abstraction,
 we are able to change the abstraction’s implementor at run-time.
 ***/

public class GUI {
    private OperatingSystem os;
    private EnvironmentFactory factory;

    private Caretaker caretaker = new Caretaker();
    private Originator originator = new Originator();
    private Subject subject = new Subject();

    private String fileName = null, fileAddress = null;

    //整個文件編輯器的儲存狀態
    private String saveState = "Unsaved";

    //Widgets
    private JFrame frame;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    private MenuBar menuBar;
    private Menu menuFile, menuEdit, menuFormat, menuColor, menuAlign; //MenuBar裡的主選單
    private Menu menuFont, menuFontSize; //menuFormat子Menu
    private MenuItem iNew, iOpen, iSave, iSaveAs, iExit; //menuFile子選單
    private MenuItem iSaveText, iUndo, iRedo; //menuEdit子選單
    private MenuItem iWrap, iFontArial, iFontCSMS, iFontTNR; //menuFont子選單
    private MenuItem iFontSize16, iFontSize20, iFontSize24, iFontSize28; //menuFontSize子選單
    private MenuItem iColor1, iColor2, iColor3; //menuColor子選單
    private MenuItem left, middle, right; //menuAlign子選單
    //private StatusPanel statusPanel;

    //Getter
    //region Description desc="Getters"
    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public Menu getMenuFile() {
        return menuFile;
    }

    public Menu getMenuEdit() {
        return menuEdit;
    }

    public Menu getMenuFormat() {
        return menuFormat;
    }

    public Menu getMenuColor() {
        return menuColor;
    }

    public Menu getMenuAlign() {
        return menuAlign;
    }

    public Menu getMenuFont() {
        return menuFont;
    }

    public Menu getMenuFontSize() {
        return menuFontSize;
    }

    public MenuItem getiNew() {
        return iNew;
    }

    public MenuItem getiOpen() {
        return iOpen;
    }

    public MenuItem getiSave() {
        return iSave;
    }

    public MenuItem getiSaveAs() {
        return iSaveAs;
    }

    public MenuItem getiExit() {
        return iExit;
    }

    public MenuItem getiSaveText() {
        return iSaveText;
    }

    public MenuItem getiUndo() {
        return iUndo;
    }

    public MenuItem getiRedo() {
        return iRedo;
    }

    public MenuItem getiWrap() {
        return iWrap;
    }

    public MenuItem getiFontArial() {
        return iFontArial;
    }

    public MenuItem getiFontCSMS() {
        return iFontCSMS;
    }

    public MenuItem getiFontTNR() {
        return iFontTNR;
    }

    public MenuItem getiFontSize16() {
        return iFontSize16;
    }

    public MenuItem getiFontSize20() {
        return iFontSize20;
    }

    public MenuItem getiFontSize24() {
        return iFontSize24;
    }

    public MenuItem getiFontSize28() {
        return iFontSize28;
    }

    public MenuItem getiColor1() {
        return iColor1;
    }

    public MenuItem getiColor2() {
        return iColor2;
    }

    public MenuItem getiColor3() {
        return iColor3;
    }

    public MenuItem getLeft() {
        return left;
    }

    public MenuItem getMiddle() {
        return middle;
    }

    public MenuItem getRight() {
        return right;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public String getSaveState() {
        return saveState;
    }

    //endregion
    //Setter
    //region Description desc="Setters"
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setMenuFile(Menu menuFile) {
        this.menuFile = menuFile;
    }

    public void setMenuEdit(Menu menuEdit) {
        this.menuEdit = menuEdit;
    }

    public void setMenuFormat(Menu menuFormat) {
        this.menuFormat = menuFormat;
    }

    public void setMenuColor(Menu menuColor) {
        this.menuColor = menuColor;
    }

    public void setMenuAlign(Menu menuAlign) {
        this.menuAlign = menuAlign;
    }

    public void setMenuFont(Menu menuFont) {
        this.menuFont = menuFont;
    }

    public void setMenuFontSize(Menu menuFontSize) {
        this.menuFontSize = menuFontSize;
    }

    public void setiNew(MenuItem iNew) {
        this.iNew = iNew;
    }

    public void setiOpen(MenuItem iOpen) {
        this.iOpen = iOpen;
    }

    public void setiSave(MenuItem iSave) {
        this.iSave = iSave;
    }

    public void setiSaveAs(MenuItem iSaveAs) {
        this.iSaveAs = iSaveAs;
    }

    public void setiExit(MenuItem iExit) {
        this.iExit = iExit;
    }

    public void setiSaveText(MenuItem iSaveText) {
        this.iSaveText = iSaveText;
    }

    public void setiUndo(MenuItem iUndo) {
        this.iUndo = iUndo;
    }

    public void setiRedo(MenuItem iRedo) {
        this.iRedo = iRedo;
    }

    public void setOs(OperatingSystem os) {
        this.os = os;
    }

    public void setiWrap(MenuItem iWrap) {
        this.iWrap = iWrap;
    }

    public void setiFontArial(MenuItem iFontArial) {
        this.iFontArial = iFontArial;
    }

    public void setiFontCSMS(MenuItem iFontCSMS) {
        this.iFontCSMS = iFontCSMS;
    }

    public void setiFontTNR(MenuItem iFontTNR) {
        this.iFontTNR = iFontTNR;
    }

    public void setiFontSize16(MenuItem iFontSize16) {
        this.iFontSize16 = iFontSize16;
    }

    public void setiFontSize20(MenuItem iFontSize20) {
        this.iFontSize20 = iFontSize20;
    }

    public void setiFontSize24(MenuItem iFontSize24) {
        this.iFontSize24 = iFontSize24;
    }

    public void setiFontSize28(MenuItem iFontSize28) {
        this.iFontSize28 = iFontSize28;
    }

    public void setiColor1(MenuItem iColor1) {
        this.iColor1 = iColor1;
    }

    public void setiColor2(MenuItem iColor2) {
        this.iColor2 = iColor2;
    }

    public void setiColor3(MenuItem iColor3) {
        this.iColor3 = iColor3;
    }

    public void setLeft(MenuItem left) {
        this.left = left;
    }

    public void setMiddle(MenuItem middle) {
        this.middle = middle;
    }

    public void setRight(MenuItem right) {
        this.right = right;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public void setSaveState(String saveState) {
        this.saveState = saveState;
    }
    //endregion

    public GUI(OperatingSystem os) throws CloneNotSupportedException {

        //region Description desc="Constructor"
        this.os = os;
        createFrame();
        //依照不同os呼叫不同getFactory()，factory可能是WindowsFactory或是MacFactory
        factory = os.getFactory(this);
        factory.buildEnvironment();
        frame.setJMenuBar(menuBar);

        addMenuToMenuBar();
        addSubMenuToMenuBar();
        addMenuItemToMenu();
        attachObserver();
        alignStrategy();

        frame.setVisible(true); //setVisible(true) 一定要放在最後一句
        //endregion

    }
    public void createFrame() {
        //Define JFrame
        frame = os.createOS();
//        frame.setIconImage(new ImageIcon(getClass().getResource("icon/mac.png")).getImage());//底下才是正確的
//        frame.setIconImage(new ImageIcon(getClass().getResource("/icon/mac.png")).getImage());
        frame.setTitle("Document Editor");
        //setBounds(x,y,w,h) = setLocation() + setSize()
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addMenuToMenuBar(){
        menuFile.setText("File");
        menuBar.add(menuFile);

        menuEdit.setText("Edit");
        menuBar.add(menuEdit);

        menuColor.setText("Color");
        menuBar.add(menuColor);

        menuAlign.setText("Align");
        menuBar.add(menuAlign);

        menuFormat.setText("Format");
        menuBar.add(menuFormat);
    }

    public void addSubMenuToMenuBar(){
        menuFont.setText("Font");
        menuFormat.add(menuFont);
        menuFontSize.setText("Font Size");
        menuFormat.add(menuFontSize);
    }

    public void addMenuItemToMenu(){
        iNew.setText("New");
        menuFile.add(iNew);

        iOpen.setText("Open");
        menuFile.add(iOpen);

        iSave.setText("Save");
        menuFile.add(iSave);

        iSaveAs.setText("SaveAs");
        menuFile.add(iSaveAs);

        iExit.setText("Exit");
        menuFile.add(iExit);

        iSaveText.setText("SaveText");
        menuEdit.add(iSaveText);

        iUndo.setText("Undo");
        menuEdit.add(iUndo);

        iRedo.setText("Redo");
        menuEdit.add(iRedo);

        iWrap.setText("Word Wrap: Off");
        menuFont.add(iWrap);

        iFontArial.setText("Arial");
        menuFont.add(iFontArial);

        iFontCSMS.setText("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR.setText("Times New Roman");
        menuFont.add(iFontTNR);

        iFontSize16.setText("16");
        menuFontSize.add(iFontSize16);
        iFontSize20.setText("20");
        menuFontSize.add(iFontSize20);
        iFontSize24.setText("24");
        menuFontSize.add(iFontSize24);
        iFontSize28.setText("28");
        menuFontSize.add(iFontSize28);

        iColor1.setText("Default");
        menuColor.add(iColor1);
        iColor2.setText("Black");
        menuColor.add(iColor2);
        iColor3.setText("Light Brown");
        menuColor.add(iColor3);

        left.setText("Left");
        menuAlign.add(left);
        middle.setText("Center");
        menuAlign.add(middle);
        right.setText("Right");
        menuAlign.add(right);
    }
    public void attachObserver(){
        subject.attach(new Function_NewFile(this,subject), iNew, "New");
        subject.attach(new Function_OpenFile(this,subject), iOpen, "Open");
        subject.attach(new Function_SaveFile(this,subject), iSave, "Save");
        subject.attach(new Function_SaveAsFile(this,subject), iSaveAs, "SaveAs");
        subject.attach(new Function_Exit(this,subject), iExit, "Exit");
        subject.attach(new Function_SaveText(this,subject,caretaker,originator), iSaveText, "SaveText");
        subject.attach(new Function_Undo(this,subject,caretaker,originator), iUndo, "Undo");
        subject.attach(new Function_Redo(this,subject,caretaker,originator), iRedo, "Redo");
        subject.attach(new Function_FontWrap(this,subject), iWrap, "wrap");
        subject.attach(new Function_FontFormat(this,subject), iFontArial, "Arial");
        subject.attach(new Function_FontFormat(this,subject), iFontCSMS, "Comic Sans MS");
        subject.attach(new Function_FontFormat(this,subject), iFontTNR, "Times New Roman");
        subject.attach(new Function_FontFormat(this,subject), iFontSize16, "16");
        subject.attach(new Function_FontFormat(this,subject), iFontSize20, "20");
        subject.attach(new Function_FontFormat(this,subject), iFontSize24, "24");
        subject.attach(new Function_FontFormat(this,subject), iFontSize28, "28");
        subject.attach(new Function_Color(this,subject), iColor1, "Color1");
        subject.attach(new Function_Color(this,subject), iColor2, "Color2");
        subject.attach(new Function_Color(this,subject), iColor3, "Color3");
    }
    public void alignStrategy(){
        left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Strategy Pattern的Context
                Context context = new Context(new Left());
                context.execute(textArea);
            }
        });
        middle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Strategy Pattern的Context
                Context context = new Context(new Middle());
                context.execute(textArea);
            }
        });
        right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Strategy Pattern的Context
                Context context = new Context(new Right());
                context.execute(textArea);
            }
        });
    }
}
