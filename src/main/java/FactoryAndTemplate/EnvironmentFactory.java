package FactoryAndTemplate;

import Main.Application;
import Main.GUI;
import Product.*;
import Prototype.PrototypeMgr;
import state.stateContext;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class EnvironmentFactory {
    protected PrototypeMgr prototype = new PrototypeMgr();

    private GUI gui;

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

    public EnvironmentFactory(GUI gui) {
        this.gui = gui;
        frame = gui.getFrame();
        textArea = gui.getTextArea();
        scrollPane = gui.getScrollPane();
        menuBar = gui.getMenuBar();

        menuFile = gui.getMenuFile();
        menuEdit = gui.getMenuEdit();
        menuFormat = gui.getMenuFormat();
        menuColor = gui.getMenuColor();
        menuAlign = gui.getMenuAlign();
        menuFont = gui.getMenuFont();
        menuFontSize = gui.getMenuFontSize();

        iNew = gui.getiNew();
        iOpen = gui.getiOpen();
        iSave = gui.getiSave();
        iSaveAs = gui.getiSaveAs();
        iExit = gui.getiExit();

        iSaveText = gui.getiSaveText();
        iUndo = gui.getiUndo();
        iRedo = gui.getiRedo();

        iWrap = gui.getiWrap();
        iFontArial = gui.getiFontArial();
        iFontCSMS = gui.getiFontCSMS();
        iFontTNR = gui.getiFontTNR();

        iFontSize16 = gui.getiFontSize16();
        iFontSize20 = gui.getiFontSize20();
        iFontSize24 = gui.getiFontSize24();
        iFontSize28 = gui.getiFontSize28();

        iColor1 = gui.getiColor1();
        iColor2 = gui.getiColor2();
        iColor3 = gui.getiColor3();

        left = gui.getLeft();
        middle = gui.getMiddle();
        right = gui.getRight();

    }
    //Template Method：Execute all the methods.
    public final void buildEnvironment() throws CloneNotSupportedException {
        processTextArea(); //Concrete method
        processMenuBar(); //Concrete method
        processMenu(); //Concrete method
        processMenuItem(); //Concrete method

        if(Application.osName.startsWith("Mac OS")){ //改成檢視frame是否建置了 if(frame != null)
            changeIcon(); //hook method and primitive method
        }
        processResult(); //Concrete method
    }

    public abstract void changeIcon();

    private void processMenuBar() throws CloneNotSupportedException {
       menuBar = createMenuBar();
     }
     private void processMenu() throws CloneNotSupportedException {
       menuFile = createMenu();
        menuEdit = createMenu();
        menuFormat = createMenu();
        menuColor = createMenu();
        menuAlign = createMenu();
        menuFont = createMenu();
        menuFontSize = createMenu();
     }
     private void processMenuItem() throws CloneNotSupportedException {
       iNew = createMenuItem();
        iOpen = createMenuItem();
        iSave = createMenuItem();
        iSaveAs = createMenuItem();
        iExit = createMenuItem();
        iSaveText = createMenuItem();
        iUndo = createMenuItem();
        iRedo = createMenuItem();

        iWrap = createMenuItem();
        iFontArial = createMenuItem();
        iFontCSMS = createMenuItem();
        iFontTNR = createMenuItem();

        iFontSize16 = createMenuItem();
        iFontSize20 = createMenuItem();
        iFontSize24 = createMenuItem();
        iFontSize28 = createMenuItem();

        iColor1 = createMenuItem();
        iColor2 = createMenuItem();
        iColor3 = createMenuItem();

        left = createMenuItem();
        middle = createMenuItem();
        right = createMenuItem();
     }
    public abstract MenuBar createMenuBar() throws CloneNotSupportedException; //Abstract Method, Factory Method
    public abstract Menu createMenu() throws CloneNotSupportedException; //Abstract Method, Factory Method
    public abstract MenuItem createMenuItem() throws CloneNotSupportedException; //Abstract Method, Factory Method
    //public abstract void createIcon(); //hook method and primitive method
    //public abstract StatusPanel createStatusPanel(); //Factory Method

    public void processResult(){
        gui.setMenuBar(menuBar);
//        frame.setJMenuBar(menuBar);
        gui.setFrame(frame);
        gui.setTextArea(textArea);

        gui.setMenuFile(menuFile);
        gui.setMenuEdit(menuEdit);
        gui.setMenuAlign(menuAlign);
        gui.setMenuColor(menuColor);
        gui.setMenuFormat(menuFormat);
        gui.setMenuFont(menuFont);
        gui.setMenuFontSize(menuFontSize);

        gui.setiNew(iNew);
        gui.setiOpen(iOpen);
        gui.setiSave(iSave);
        gui.setiSaveAs(iSaveAs);
        gui.setiExit(iExit);

        gui.setiSaveText(iSaveText);
        gui.setiUndo(iUndo);
        gui.setiRedo(iRedo);

        gui.setiWrap(iWrap);
        gui.setiFontArial(iFontArial);
        gui.setiFontCSMS(iFontCSMS);
        gui.setiFontTNR(iFontTNR);

        gui.setiFontSize16(iFontSize16);
        gui.setiFontSize20(iFontSize20);
        gui.setiFontSize24(iFontSize24);
        gui.setiFontSize28(iFontSize28);

        gui.setiColor1(iColor1);
        gui.setiColor2(iColor2);
        gui.setiColor3(iColor3);

        gui.setLeft(left);
        gui.setMiddle(middle);
        gui.setRight(right);
    }

    private final void processTextArea(){ //concrete method
        textArea = new JTextArea();

        // 初始化 State pattern
        stateContext context = new stateContext(textArea);
        context.execute();
        // 監聽滑鼠點擊事件
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                context.execute();
            }
        });

        // 監聽鍵盤事件
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
                textArea.setEditable(true);
                int id = e.getID();
                if (id == KeyEvent.KEY_TYPED) {
                    context.execute();
//                    originator.setState(textPane.getText());
//                    careTaker.addMemento(originator.createMemento());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        //ScrollBar
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }
}
