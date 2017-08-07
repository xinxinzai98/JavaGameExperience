package bin.start;

import bin.common.JGameState;
import bin.gamemain.JGameMain;

import java.util.Scanner;

public class Start {
    static JGameState GameState;  // ������Ϸ�߼��ж�
    static boolean GameStart;  // ������Ϸ����
    static String iPut;   // ������Ϸ��������
    static JGameMain game = new JGameMain();//��Ϸ����
    static Scanner scI = new Scanner(System.in);//��Ϸ����

    public static void main(String[] args) {
        GameStart = true;
        GameState = JGameState.GameInit;
        while (GameStart) {
            switch (GameState) {
                case GameInit:
                    GameInit();
                    while (true) {
                        System.out.print(">>");
                        iPut = scI.nextLine();
                        if (iPut.equals("��ʼ") || iPut.equals("��ȡ")) {
                            GameState = JGameState.GameStart;
                            break;
                        } else if (iPut.equals("����")) {
                            GameState = JGameState.GameEnd;
                            break;
                        } else {
                            System.out.println("����������������������");
                        }
                    }
                    break;

                case GameStart:
                    GameRun(iPut);
                    GameState = JGameState.GameRun;
                    break;

                case GameRun:
                    System.out.print(">>");
                    iPut = scI.next();
                    if (!iPut.equals("����")) {
                        GameRun(iPut);
                    } else {
                        GameState = JGameState.GameEnd;
                    }
                    break;

                case GameEnd:
                    GameEnd();
                    break;

                default:
                    break;
            }

        }
    }

    public static void GameInit() {
        game.GameInit();
    }

    public static void GameStart(String iPut) {
        game.GameRun(iPut);
    }

    public static void GameRun(String iPut) {
        game.GameRun(iPut);
    }

    public static void GameEnd() {
        game.GameEnd();
        GameStart = false;
    }
}
