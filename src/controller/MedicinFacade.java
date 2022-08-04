package controller;

import java.util.Scanner;

public class MedicinFacade {
    private MedicinProductManager medicinProductManager;
    private AnalgesicManager analgesicManager;
    private AntibioticsManager antibioticsManager;
    private TonicManager tonicManager;
    private VitaminManager vitaminManager;

    private static MedicinFacade instance;
    private final Scanner scanner = new Scanner(System.in);
}
