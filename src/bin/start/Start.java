package bin.start;

import bin.common.JGameState;
import bin.gamemain.JGameMain;

import java.util.Scanner;

public class Start {
    static JGameState GameState;  // 用于游戏逻辑判断
    static boolean GameStart;  // 用于游戏结束
    static String iPut;   // 用于游戏处理输入
    static JGameMain game = new JGameMain();//游戏引擎
    static Scanner scI = new Scanner(System.in);//游戏输入

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
                        if (iPut.equals("开始") || iPut.equals("读取")) {
                            GameState = JGameState.GameStart;
                            break;
                        } else if (iPut.equals("结束")) {
                            GameState = JGameState.GameEnd;
                            break;
                        } else {
                            System.out.println("您的输入有误，请重新输入");
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
                    if (!iPut.equals("结束")) {
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
