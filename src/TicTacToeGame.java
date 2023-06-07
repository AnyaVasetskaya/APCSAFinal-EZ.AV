import java.util.ArrayList;

public class TicTacToeGame {
    private Tile t1;
    private Tile t2;
    private Tile t3;
    private Tile t4;
    private Tile t5;
    private Tile t6;
    private Tile t7;
    private Tile t8;
    private Tile t9;
    private Player player;
    private Player ai;

    private TicTacToeFrame gameWindow;

    public TicTacToeGame() {
        t1 = new Tile ("corner", 1);
        t2 = new Tile ("edge", 2);
        t3 = new Tile ("corner", 3);
        t4 = new Tile ("edge", 4);
        t5 = new Tile ("center", 5);
        t6 = new Tile ("edge", 6);
        t7 = new Tile ("corner", 7);
        t8 = new Tile ("edge", 8);
        t9 = new Tile ("corner", 9);
        gameWindow = new TicTacToeFrame(this);
    }

    public void play() {
        gameWindow.replaceScreen("game"); //gameWindow is the frame
    }


    public void aiMove() {
        //next move
        Tile next;
        int pathToBlock = 0;
        //check win first
        int check = checkWin();
        if (check != 0) {
            //make final move here
            ai.setWin(true);
        } else {
            //get every tile with player
            ArrayList playerPlace = new ArrayList();
            for (int i = 1; i <= 9; i++) {
                if (i == 1 && t1.getTaken().equals("player")) {
                    playerPlace.add(t1);
                }
                if (i == 2 && t2.getTaken().equals("player")) {
                    playerPlace.add(t2);
                }
                if (i == 3 && t3.getTaken().equals("player")) {
                    playerPlace.add(t3);
                }
                if (i == 4 && t4.getTaken().equals("player")) {
                    playerPlace.add(t4);
                }
                if (i == 5 && t5.getTaken().equals("player")) {
                    playerPlace.add(t5);
                }
                if (i == 6 && t6.getTaken().equals("player")) {
                    playerPlace.add(t6);
                }
                if (i == 7 && t7.getTaken().equals("player")) {
                    playerPlace.add(t7);
                }
                if (i == 8 && t8.getTaken().equals("player")) {
                    playerPlace.add(t8);
                }
                if (i == 9 && t9.getTaken().equals("player")) {
                    playerPlace.add(t9);
                }
            }
            //check for danger
            for (int i = 0; i < playerPlace.size(); i++) {
                Tile temp = (Tile) playerPlace.get(i);
                int num = 0;
                pathToBlock = 0;
                num = checkHorizontal(temp);
                if (num == 0) {
                    num = checkVertical(temp);
                    if (num == 0) {
                        num = checkDiagonal(temp);
                        if (num == 0) {             //nothing to block
                            int rand = (int) (Math.random() * 9) + 1;
                            if (t1.getPlace() == rand && t1.getTaken().equals("no")) {
                                next = t1;
                            } else if (t2.getPlace() == rand && t2.getTaken().equals("no")) {
                                next = t2;
                            } else if (t3.getPlace() == rand && t3.getTaken().equals("no")) {
                                next = t3;
                            } else if (t4.getPlace() == rand && t4.getTaken().equals("no")) {
                                next = t4;
                            } else if (t5.getPlace() == rand && t5.getTaken().equals("no")) {
                                next = t5;
                            } else if (t6.getPlace() == rand && t5.getTaken().equals("no")) {
                                next = t6;
                            } else if (t7.getPlace() == rand && t5.getTaken().equals("no")) {
                                next = t7;
                            } else if (t8.getPlace() == rand && t5.getTaken().equals("no")) {
                                next = t8;
                            } else if (t9.getPlace() == rand && t5.getTaken().equals("no")) {
                                next = t9;
                            }
                        } else {
                            pathToBlock = num;
                        }
                    } else {
                        pathToBlock = num;
                    }
                } else {
                    pathToBlock = num;
                }
            }
            if (pathToBlock != 0) {
                if (pathToBlock == 1) {
                    if (!t1.getTaken().equals("ai")) {
                        next = t1;
                    } else if (!t2.getTaken().equals("ai")) {
                        next = t2;
                    } else  {
                        next = t3;
                    }
                }
                if (pathToBlock == 2) {
                    if (!t4.getTaken().equals("ai")) {
                        next = t4;
                    } else if (!t5.getTaken().equals("ai")) {
                        next = t5;
                    } else  {
                        next = t6;
                    }
                }
                if (pathToBlock == 3) {
                    if (!t7.getTaken().equals("ai")) {
                        next = t7;
                    } else if (!t8.getTaken().equals("ai")) {
                        next = t8;
                    } else  {
                        next = t9;
                    }
                }
                if (pathToBlock == 4) {
                    if (!t1.getTaken().equals("ai")) {
                        next = t1;
                    } else if (!t4.getTaken().equals("ai")) {
                        next = t4;
                    } else  {
                        next = t7;
                    }
                }
                if (pathToBlock == 5) {
                    if (!t2.getTaken().equals("ai")) {
                        next = t2;
                    } else if (!t5.getTaken().equals("ai")) {
                        next = t5;
                    } else  {
                        next = t8;
                    }
                }
                if (pathToBlock == 6) {
                    if (!t3.getTaken().equals("ai")) {
                        next = t3;
                    } else if (!t6.getTaken().equals("ai")) {
                        next = t6;
                    } else  {
                        next = t9;
                    }
                }
                if (pathToBlock == 7) {
                    if (!t1.getTaken().equals("ai")) {
                        next = t1;
                    } else if (!t5.getTaken().equals("ai")) {
                        next = t5;
                    } else  {
                        next = t9;
                    }
                }
                if (pathToBlock == 8) {
                    if (!t3.getTaken().equals("ai")) {
                        next = t3;
                    } else if (!t5.getTaken().equals("ai")) {
                        next = t5;
                    } else  {
                        next = t7;
                    }
                }
            }
        }
    }

    private int checkWin() {
        int count = 0;
        for (int i = 1; i <= 8; i++) {
            count = 0;
            if (i == 1) { //row1 horizontal
                if (t1.getTaken().equals("ai")) {
                    count++;
                }
                if (t2.getTaken().equals("ai")) {
                    count++;
                }
                if (t3.getTaken().equals("ai")) {
                    count++;
                }
                if (count > 1) {
                    return i;
                }
            }
            if (i == 2) {   //row 2 horizontal
                if (t4.getTaken().equals("ai")) {
                    count++;
                }
                if (t5.getTaken().equals("ai")) {
                    count++;
                }
                if (t6.getTaken().equals("ai")) {
                    count++;
                }
                if (count > 1) {
                    return i;
                }
            }
            if (i == 3) {   //row 3 horizontal
                if (t7.getTaken().equals("ai")) {
                    count++;
                }
                if (t8.getTaken().equals("ai")) {
                    count++;
                }
                if (t9.getTaken().equals("ai")) {
                    count++;
                }
                if (count > 1) {
                    return i;
                }
            }
            if (i == 4) {   //col 1 vertical
                if (t1.getTaken().equals("ai")) {
                    count++;
                }
                if (t4.getTaken().equals("ai")) {
                    count++;
                }
                if (t7.getTaken().equals("ai")) {
                    count++;
                }
                if (count > 1) {
                    return i;
                }
            }
            if (i == 5) {   //col 2 vertical
                if (t2.getTaken().equals("ai")) {
                    count++;
                }
                if (t5.getTaken().equals("ai")) {
                    count++;
                }
                if (t8.getTaken().equals("ai")) {
                    count++;
                }
                if (count > 1) {
                    return i;
                }
            }
            if (i == 6) {   //col 3 vertical
                if (t3.getTaken().equals("ai")) {
                    count++;
                }
                if (t6.getTaken().equals("ai")) {
                    count++;
                }
                if (t9.getTaken().equals("ai")) {
                    count++;
                }
                if (count > 1) {
                    return i;
                }
            }
            if (i == 7) {   //diagonal 1
                if (t1.getTaken().equals("ai")) {
                    count++;
                }
                if (t5.getTaken().equals("ai")) {
                    count++;
                }
                if (t9.getTaken().equals("ai")) {
                    count++;
                }
                if (count > 1) {
                    return i;
                }
            }
            if (i == 8) {   //diagonal 2
                if (t3.getTaken().equals("ai")) {
                    count++;
                }
                if (t5.getTaken().equals("ai")) {
                    count++;
                }
                if (t7.getTaken().equals("ai")) {
                    count++;
                }
                if (count > 1) {
                    return i;
                } else {
                    count = 0;
                }
            }
        }
        return count;
    }
    private int checkHorizontal(Tile t) {
        int num = t.getPlace();
        int path = 0;
        if (num < 4) {      //row 1
            if (!t1.getTaken().equals("ai") && !t2.getTaken().equals("ai") && !t3.getTaken().equals("ai")) {        //not blocked
                if (t1.getPlace() != num && t1.getTaken().equals("player")) {
                    path = 1; //path 1
                }
                if (t2.getPlace() != num && t2.getTaken().equals("player")) {
                    path = 1; //path 1
                }
                if (t3.getPlace() != num && t3.getTaken().equals("player")) {
                    path = 1; //path 1
                }
            }
        } else if (num < 7) {   //row 2
            if (!t4.getTaken().equals("ai") && !t5.getTaken().equals("ai") && !t6.getTaken().equals("ai")) {        //not blocked
                if (t4.getPlace() != num && t4.getTaken().equals("player")) {
                    path = 2; //path 2
                }
                if (t5.getPlace() != num && t5.getTaken().equals("player")) {
                    path = 2; //path 2
                }
                if (t6.getPlace() != num && t6.getTaken().equals("player")) {
                    path = 2; //path 2
                }
            }
        }
        else if (num < 10) {
            if (!t7.getTaken().equals("ai") && !t8.getTaken().equals("ai") && !t9.getTaken().equals("ai")) {        //not blocked
                if (t7.getPlace() != num && t7.getTaken().equals("player")) {
                    path = 3; //path 3
                }
                if (t8.getPlace() != num && t8.getTaken().equals("player")) {
                    path = 3; //path 3
                }
                if (t9.getPlace() != num && t9.getTaken().equals("player")) {
                    path = 3; //path 3
                }
            }
        }
        return path;
    }

    private int checkVertical(Tile t) {
        int num = t.getPlace();
        int path = 0;
        if (num == 1 || num == 4 || num == 7) {      //row 1
            if (!t1.getTaken().equals("ai") && !t4.getTaken().equals("ai") && !t4.getTaken().equals("ai")) {        //not blocked
                if (t1.getPlace() != num && t1.getTaken().equals("player")) {
                    path = 4; //path 4
                }
                if (t4.getPlace() != num && t4.getTaken().equals("player")) {
                    path = 4; //path 4
                }
                if (t7.getPlace() != num && t7.getTaken().equals("player")) {
                    path = 4; //path 4
                }
            }
        } else if (num == 2 || num == 5 || num == 8) {   //row 2
            if (!t2.getTaken().equals("ai") && !t5.getTaken().equals("ai") && !t8.getTaken().equals("ai")) {        //not blocked
                if (t2.getPlace() != num && t2.getTaken().equals("player")) {
                    path = 5; //path 5
                }
                if (t5.getPlace() != num && t5.getTaken().equals("player")) {
                    path = 5; //path 5
                }
                if (t8.getPlace() != num && t8.getTaken().equals("player")) {
                    path = 5; //path 5
                }
            }
        }
        else if (num == 3 || num == 6 || num == 9) {
            if (!t3.getTaken().equals("ai") && !t6.getTaken().equals("ai") && !t9.getTaken().equals("ai")) {        //not blocked
                if (t3.getPlace() != num && t3.getTaken().equals("player")) {
                    path = 6; //path 6
                }
                if (t6.getPlace() != num && t6.getTaken().equals("player")) {
                    path = 6; //path 6
                }
                if (t9.getPlace() != num && t9.getTaken().equals("player")) {
                    path = 6; //path 6
                }
            }
        }
        return path;
    }

    private int checkDiagonal(Tile t) {
        int num = t.getPlace();
        int path = 0;
        if (num == 1 || num == 5 ||num == 9) {      //dia 1
            if (!t1.getTaken().equals("ai") && !t5.getTaken().equals("ai") && !t9.getTaken().equals("ai")) {        //not blocked
                if (t1.getPlace() != num && t1.getTaken().equals("player")) {
                    path = 7; //path 7
                }
                if (t5.getPlace() != num && t5.getTaken().equals("player")) {
                    path = 7; //path 7
                }
                if (t9.getPlace() != num && t9.getTaken().equals("player")) {
                    path = 7; //path 7
                }
            }
        } else if (num == 3 ||  num == 5 ||num == 7) {   //dia 2
            if (!t3.getTaken().equals("ai") && !t5.getTaken().equals("ai") && !t7.getTaken().equals("ai")) {        //not blocked
                if (t3.getPlace() != num && t3.getTaken().equals("player")) {
                    path = 8; //path 8
                }
                if (t5.getPlace() != num && t5.getTaken().equals("player")) {
                    path = 8; //path 8
                }
                if (t7.getPlace() != num && t7.getTaken().equals("player")) {
                    path = 8; //path 8
                }
            }
        }
        return path;
    }

    public void reset() {
        gameWindow.dispose();
    }

}
