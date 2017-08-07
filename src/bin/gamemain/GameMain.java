package bin.gamemain;

import java.io.File;

/**
 * GameMain
 */
public interface GameMain {

    /**
     * GameInit
     */
    void GameInit();

    /**
     * @param ePut
     */
    void GameRun(String ePut);

    /**
     * GameEnd
     */
    void GameEnd();

    /**
     * @param ePut
     * @return
     */
    boolean checkInput(String ePut);

    /**
     * @param file
     */
    void listFile(File file);

    /**
     * @param dir
     */
    public void HeroOnMove(String dir);
}
