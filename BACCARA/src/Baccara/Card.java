package Baccara;

import java.util.Random;

// draw > 3번째 카드 전부 초기화, 카드 난수로 초기화
public class Card{
    // 1 : 스페이드
    // 2 : 하트
    // 3 : 클로버
    // 4 : 다이아몬드
    // 카드[x][0] = 카드 숫자 비교
    // 카드[x][1] = 카드 종류 비교

    Random random = new Random();

    private String id; // 플레이어 아이디
    private String alarm = "최근 알림 없음";
    private String alarm2 = " ";
    private String alarm3 = " ";
    private String alarm4 = " ";
    private String alarm5 = " ";
    private long logMoney; // 로그 돈
    private long playerMoney; // 돈 초기화
    private long bettingMoney = 0; // 배팅 금액
    private int betting; // 배팅 구역
    /*
    * 1 = player
    * 2 = banker
    * 3 = tie
    * 4 = p-pair
    * 5 = b-pair
    */
    public boolean openPlayer = false; // 카드 두 장 확인 완료
    public boolean openBanker = false;
    private boolean Third = false;
    private int[][] bankerCard; // 최초의 두 장
    private int[][] playerCard;
    private int[] playerExtra; // 세번째 장
    private int[] bankerExtra;

    private int playerSum = 0, bankerSum = 0;

    public Card(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public void draw(int betting, long bettingMoney) {
        this.bettingMoney += bettingMoney; // 금액 초기화
        playerMoney -= bettingMoney;

        this.betting = betting;

        while(true) {
            playerSum = 0;
            bankerSum = 0;
            playerExtra = null;
            bankerExtra = null;
            openBanker = false;
            openPlayer = false;
            Third = false;

            playerCard = new int[][] {{random.nextInt(13)+1, random.nextInt(4)+1}, {random.nextInt(13)+1, random.nextInt(4)+1}};
            bankerCard = new int[][] {{random.nextInt(13)+1, random.nextInt(4)+1}, {random.nextInt(13)+1, random.nextInt(4)+1}};

            if (playerCard[0] == playerCard[1] || playerCard[0] == bankerCard[0] || playerCard[1] == bankerCard[0] || playerCard[0] == bankerCard[1] || playerCard[1] == bankerCard[1] || bankerCard[0] == bankerCard[1]) { // 중복 초기화
                continue;
            }

            for (int i=0; i<playerCard.length; i++) { // 2번째 카드까지 합계
                if (playerCard[i][0] >= 10) {
                    playerSum += 0;
                } else {
                    playerSum += playerCard[i][0];
                }
                if (playerSum >= 10) {
                    playerSum -= 10;
                }
            }
            for (int i=0; i<bankerCard.length; i++) {
                if (bankerCard[i][0] >= 10) {
                    bankerSum += 0;
                } else {
                    bankerSum += bankerCard[i][0];
                }
                if (bankerSum >= 10) {
                    bankerSum -= 10;
                }
            }
            alarm = ("카드 분배가 완료되었습니다");
            break;
        } // while
    } // draw class

    public void showCard1() { //showPlayer
        System.out.print("[플레이어] "+ 1 +"번째 카드 : ");
        switch(playerCard[0][1]) {
            case 1:
                System.out.print("♠ ");
                break;
            case 2:
                System.out.print("♡ ");
                break;
            case 3:
                System.out.print("♣ ");
                break;
            case 4:
                System.out.print("◇ ");
                break;
        }
        if (playerCard[0][0] > 10) {
            switch (playerCard[0][0]) {
                case 11:
                    System.out.println("J");
                    break;
                case 12:
                    System.out.println("Q");
                    break;
                case 13:
                    System.out.println("K");
                    break;
            }
        } else {
            System.out.println(playerCard[0][0]);
        }
        showBanker1();
        System.out.println();

    }

    public void showCard2() {
        openPlayer = true;
        System.out.print("[플레이어] "+ 2 +"번째 카드 : ");
        switch(playerCard[1][1]) {
            case 1:
                System.out.print("♠ ");
                break;
            case 2:
                System.out.print("♡ ");
                break;
            case 3:
                System.out.print("♣ ");
                break;
            case 4:
                System.out.print("◇ ");
                break;
        }
        if (playerCard[1][0] > 10) {
            switch (playerCard[1][0]) {
                case 11:
                    System.out.println("J");
                    break;
                case 12:
                    System.out.println("Q");
                    break;
                case 13:
                    System.out.println("K");
                    break;
            }
        } else {
            System.out.println(playerCard[1][0]);
        }
        showBanker2();
        System.out.println();

    }
    public void showCard3() {
        if (playerExtra != null) {
            System.out.print("[플레이어] "+ 3 +"번째 카드 : ");
            switch(playerExtra[1]) {
                case 1:
                    System.out.print("♠ ");
                    break;
                case 2:
                    System.out.print("♡ ");
                    break;
                case 3:
                    System.out.print("♣ ");
                    break;
                case 4:
                    System.out.print("◇ ");
                    break;
            }
            if (playerExtra[0] > 10) {
                switch (playerExtra[0]) {
                    case 11:
                        System.out.println("J");
                        break;
                    case 12:
                        System.out.println("Q");
                        break;
                    case 13:
                        System.out.println("K");
                        break;
                }
            } else {
                System.out.println(playerExtra[0]);
            }
            showBanker3();

        } else {
            System.out.println("[플레이어] 3번째 카드가 없습니다.");
            showBanker3();
        }
    }

    private void showBanker1() { // showBanker
        System.out.print("[뱅커] "+ 1 +"번째 카드 : ");
        switch(bankerCard[0][1]) {
            case 1:
                System.out.print("♠ ");
                break;
            case 2:
                System.out.print("♡ ");
                break;
            case 3:
                System.out.print("♣ ");
                break;
            case 4:
                System.out.print("◇ ");
                break;
        }
        if (bankerCard[0][0] > 10) {
            switch (bankerCard[0][0]) {
                case 11:
                    System.out.println("J");
                    break;
                case 12:
                    System.out.println("Q");
                    break;
                case 13:
                    System.out.println("K");
                    break;
            }
        } else {
            System.out.println(bankerCard[0][0]);
        }
    }
    private void showBanker2() {
        openBanker = true;
        System.out.print("[뱅커] "+ 2 +"번째 카드 : ");
        switch(bankerCard[1][1]) {
            case 1:
                System.out.print("♠ ");
                break;
            case 2:
                System.out.print("♡ ");
                break;
            case 3:
                System.out.print("♣ ");
                break;
            case 4:
                System.out.print("◇ ");
                break;
        }
        if (bankerCard[1][0] > 10) {
            switch (bankerCard[1][0]) {
                case 11:
                    System.out.println("J");
                    break;
                case 12:
                    System.out.println("Q");
                    break;
                case 13:
                    System.out.println("K");
                    break;
            }
        } else {
            System.out.println(bankerCard[1][0]);
        }
    }
    private void showBanker3() {
        if (bankerExtra != null) {
            System.out.print("[뱅커] "+ 3 +"번째 카드 : ");
            switch(bankerExtra[1]) {
                case 1:
                    System.out.print("♠ ");
                    break;
                case 2:
                    System.out.print("♡ ");
                    break;
                case 3:
                    System.out.print("♣ ");
                    break;
                case 4:
                    System.out.print("◇ ");
                    break;
            }
            if (bankerExtra[0] > 10) {
                switch (bankerExtra[0]) {
                    case 11:
                        System.out.println("J");
                        break;
                    case 12:
                        System.out.println("Q");
                        break;
                    case 13:
                        System.out.println("K");
                        break;
                }
            } else {
                System.out.println(bankerExtra[0]);
            }
        } else {
            System.out.println("[뱅커] 3번째 카드가 없습니다.");
        }
        System.out.println();
    }

    public void giveThirdCard() {
            int playerExtraChange = 0;
            if (openPlayer && openBanker) {
                if (playerCard[0][0] == playerCard[1][0]) { // 페어
                    if (bankerCard[0][0] == bankerCard[1][0]) {
                        alarm = ("[PAIR] 플레이어 페어, 최초의 카드가 똑같습니다.");
                        alarm2 = ("[PAIR] 뱅커 페어, 최초의 카드가 똑같습니다.");
                        return;
                    } else {
                        alarm = ("[PAIR] 플레이어 페어, 최초의 카드가 똑같습니다.");
                        return;
                    }
                } else if (bankerCard[0][0] == bankerCard[1][0]) {
                    alarm = ("[PAIR] 뱅커 페어, 최초의 카드가 똑같습니다.");
                    return;
                }

                if(bankerSum >= 8 && bankerSum <= 9) {
                    alarm = ("[NATURAL] 뱅커 내추럴");
                    if (playerSum >= 8 && playerSum <= 9) {
                        alarm2 = ("[NATURAL] 플레이어 내추럴");
                        return;
                    }
                    return;
                } else if (playerSum >= 8 && playerSum <= 9) {
                    alarm = ("[NATURAL] 플레이어 내추럴");
                    return;
                }

                Third = true;
                if (playerSum >= 0 && playerSum <= 5) {
                    alarm = ("[DRAW] 플레이어의 두 카드의 합이 "+ playerSum + "이여서 세 번째 카드를 받았습니다.");
                    playerExtra = new int[] {random.nextInt(13)+1, random.nextInt(4)+1};
                    if (playerExtra[0] >= 10) {
                        playerExtraChange = 0;
                    } else {
                        playerExtraChange = playerExtra[0];
                    }
                } else if (playerSum >= 6 && playerSum <= 7) {
                    alarm = ("[STAND] 플레이어 스탠드, 세 번째 카드를 받지않고 진행합니다.");
                }

                if (playerExtraChange >= 0 && playerExtraChange <= 9 && playerExtra != null) {
                    if (bankerSum >= 0 && bankerSum <= 2) {
                        alarm2 = ("[DRAW] 뱅커의 두 카드의 합이 " + bankerSum + "이여서 세 번째 카드를 받았습니다.");
                        bankerExtra = new int[]{random.nextInt(13) + 1, random.nextInt(4) + 1};
                    } else if (bankerSum == 3 && playerExtraChange != 8) {
                        alarm2 = ("[DRAW] 뱅커가 플레이어의 세 번째 카드 값[" + playerExtra[0] + "]에 따라 세 번째 카드를 받았습니다. [NOT 8]");
                        bankerExtra = new int[]{random.nextInt(13) + 1, random.nextInt(4) + 1};
                    } else if (bankerSum == 4 && playerExtraChange >= 2 && playerExtraChange <= 7) {
                        alarm2 = ("[DRAW] 뱅커가 플레이어의 세 번째 카드 값[" + playerExtra[0] + "]에 따라 세 번째 카드를 받았습니다. [IN 2~7]");
                        bankerExtra = new int[]{random.nextInt(13) + 1, random.nextInt(4) + 1};
                    } else if (bankerSum == 5 && playerExtraChange >= 4 && playerExtraChange <= 7) {
                        alarm2 = ("[DRAW] 뱅커가 플레이어의 세 번째 카드 값[" + playerExtra[0] + "]에 따라 세 번째 카드를 받았습니다. [IN 4~7]");
                        bankerExtra = new int[]{random.nextInt(13) + 1, random.nextInt(4) + 1};
                    } else if (bankerSum == 6 && playerExtraChange >= 6 && playerExtraChange <= 7) {
                        alarm2 = ("[DRAW] 뱅커가 플레이어의 세 번째 카드 값[" + playerExtra[0] + "]에 따라 세 번째 카드를 받았습니다. [IN 6~7]");
                        bankerExtra = new int[]{random.nextInt(13) + 1, random.nextInt(4) + 1};
                    } else {
                        alarm2 = ("[STAND] 뱅커 스탠드, 뱅커가 세 번째 카드를 받지않고 진행합니다.");
                    }
                } else {
                    if (bankerSum >= 0 && bankerSum <= 2) {
                        alarm2 = ("[DRAW] 뱅커의 두 카드의 합이 " + bankerSum + "이여서 세 번째 카드를 받았습니다.");
                        bankerExtra = new int[]{random.nextInt(13) + 1, random.nextInt(4) + 1};
                    } else {
                        alarm2 = ("[STAND] 뱅커 스탠드, 뱅커가 세 번째 카드를 받지않고 진행합니다.");
                    }
                }
                if(playerExtra != null) {
                    sumInExtraCardPlayer(playerExtraChange);
                }
                if(bankerExtra != null) {
                    sumInExtraCardBanker();
                }
            }
    }
    private void sumInExtraCardPlayer(int playerExtraChange) {
        playerSum += playerExtraChange;
        if (playerSum >= 10) {
            playerSum -= 10;
        }
    }
    private void sumInExtraCardBanker() {
        if (bankerExtra[0] >= 10) {
            bankerSum += 0;
        } else {
            bankerSum += bankerExtra[0];
        }
        if (bankerSum >= 10) {
            bankerSum -= 10;
        }
    }
    public void result() {
        if (playerSum >= 8 && playerSum <= 9 && !Third) {
            if (playerCard[0][0] == playerCard[1][0]) { // 페어
                if (bankerCard[0][0] == bankerCard[1][0]) {
                    alarm = ("[TIE] 무승부, 뱅커와 플레이어가 둘 다 페어입니다.");
                    tieWin();
                } else {
                    alarm = ("[PLAYER-PAIR WIN] 플레이어의 최초 두 카드가 동일합니다.");
                    pPairWin();
                }
            } else if (bankerCard[0][0] == bankerCard[1][0]) {
                alarm = ("[BANKER-PAIR WIN] 뱅커의 최초 두 카드가 동일합니다.");
                bPairWin();
            } else if (bankerSum >= 8 && bankerSum <= 9) {
                alarm = ("[COMPARE] 플레이어와 뱅커 내추럴, 플레이어와 뱅커가 각각 두 카드의 합을 비교합니다.\n >> ");
                if (bankerSum == playerSum) {
                    alarm = ("[TIE] 무승부, 뱅커와 플레이어의 카드의 합이 똑같습니다.");
                    tieWin();
                } else if (bankerSum > playerSum) {
                    alarm = ("[BANKER WIN] 플레이어의 카드 합이 "+playerSum+",  뱅커의 카드 합이 "+bankerSum+", 뱅커의 카드가 플레이어보다 높아 뱅커가 이겼습니다.");
                    bankerWin();
                } else if (bankerSum < playerSum) {
                    alarm = ("[PLAYER WIN] 플레이어의 카드 합이 "+playerSum+",  뱅커의 카드 합이 "+bankerSum+", 플레이어의 카드가 뱅커보다 높아 플레이어가 이겼습니다.");
                    playerWin();
                }
            } else {
                alarm = ("[PLAYER WIN] 플레이어만 내추럴이므로, 플레이어의 승리입니다.");
                playerWin();
            }
        } else if (bankerSum >= 8 && bankerSum <= 9 && !Third) {
            alarm = ("[BANKER WIN] 뱅커만 내추럴이므로, 뱅커의 승리입니다.");
            bankerWin();
        } else if (playerSum == bankerSum) { // 타이
            alarm = ("[TIE] 무승부, 뱅커와 플레이어의 카드의 합이 똑같습니다.");
            tieWin();
        } else if (bankerSum > playerSum) {
            alarm = ("[BANKER WIN] 플레이어의 카드 합이 "+playerSum+",  뱅커의 카드 합이 "+bankerSum+", 뱅커의 카드가 플레이어보다 높아 뱅커가 이겼습니다.");
            bankerWin();
        } else if (bankerSum < playerSum) {
            alarm = ("[PLAYER WIN] 플레이어의 카드 합이 "+playerSum+",  뱅커의 카드 합이 "+bankerSum+", 플레이어의 카드가 뱅커보다 높아 플레이어가 이겼습니다.");
            playerWin();
        }
    }
    private void playerWin() {
        alarm2 = ("\n[선택한 배팅 : ");
        alarm5 = ("PLAYER");
        switch(betting) {
            case 1:
                alarm3 = ("PLAYER");
                break;
            case 2:
                alarm3 = ("BANKER");
                break;
            case 3:
                alarm3 = ("TIE");
                break;
            case 4:
                alarm3 = ("PLAYER-PAIR");
                break;
            case 5:
                alarm3 = ("BANKER-PAIR");
                break;
        } if (betting == 1) {
            alarm4 = ("] : 당신의 승리입니다.\n환급액[2배] >> "+bettingMoney*2);
            bettingMoney *= 2;
            logMoney = bettingMoney - (bettingMoney/2);
        } else if (betting != 1){
            logMoney = bettingMoney;
            alarm4 = ("] : 당신의 패배입니다. 배팅액이 사라집니다.");
            bettingMoney = 0;
        }
    }
    private void bankerWin() {
        alarm2 = ("\n[선택한 배팅 : ");
        alarm5 = ("BANKER");
        switch(betting) {
            case 1:
                alarm3 = ("PLAYER");
                break;
            case 2:
                alarm3 = ("BANKER");
                break;
            case 3:
                alarm3 = ("TIE");
                break;
            case 4:
                alarm3 = ("PLAYER-PAIR");
                break;
            case 5:
                alarm3 = ("BANKER-PAIR");
                break;
        } if (betting == 2) {
            logMoney = bettingMoney;
            alarm4 = ("] : 당신의 승리입니다.\n환급액[2배, 커미션 5% 차감] >> "+(int)(bettingMoney*1.95));
            bettingMoney = (int)(bettingMoney*1.95);
            logMoney = bettingMoney - logMoney;
        } else if (betting != 2) {
            logMoney = bettingMoney;
            alarm4 = ("] : 당신의 패배입니다. 배팅액이 사라집니다.");
            bettingMoney = 0;
        }
    }
    private void tieWin() {
        alarm2 = ("\n[선택한 배팅 : ");
        alarm5 = ("TIE");
        switch(betting) {
            case 1:
                alarm3 = ("PLAYER");
                break;
            case 2:
                alarm3 = ("BANKER");
                break;
            case 3:
                alarm3 = ("TIE");
                break;
            case 4:
                alarm3 = ("PLAYER-PAIR");
                break;
            case 5:
                alarm3 = ("BANKER-PAIR");
                break;
        } if (betting == 3) {
            alarm4 = ("] : 당신의 승리입니다.\n환급액[8배] >> "+bettingMoney*8);
            bettingMoney *= 8;
            logMoney = bettingMoney - (bettingMoney/8);
        } else if (betting != 3) {
            logMoney = bettingMoney;
            alarm4 = ("] : 당신의 패배입니다. 배팅액이 사라집니다.");
            bettingMoney = 0;
        }
    }

    private void pPairWin() {
        alarm2 = ("\n[선택한 배팅 : ");
        alarm5 = ("PLAYER-PAIR");
        switch(betting) {
            case 1:
                alarm3 = ("PLAYER");
                break;
            case 2:
                alarm3 = ("BANKER");
                break;
            case 3:
                alarm3 = ("TIE");
                break;
            case 4:
                alarm3 = ("PLAYER-PAIR");
                break;
            case 5:
                alarm3 = ("BANKER-PAIR");
                break;
        } if (betting == 4) {
            alarm4 = ("] : 당신의 승리입니다.\n환급액[11배] >> "+bettingMoney*11);
            bettingMoney *= 11;
            logMoney = bettingMoney - (bettingMoney/11);
        } else if (betting != 4) {
            logMoney = bettingMoney;
            alarm4 = ("] : 당신의 패배입니다. 배팅액이 사라집니다.");
            bettingMoney = 0;
        }
    }
    private void bPairWin() {
        alarm2 = ("\n[선택한 배팅 : ");
        alarm5 = ("BANKER-PAIR");
        switch(betting) {
            case 1:
                alarm3 = ("PLAYER");
                break;
            case 2:
                alarm3 = ("BANKER");
                break;
            case 3:
                alarm3 = ("TIE");
                break;
            case 4:
                alarm3 = ("PLAYER-PAIR");
                break;
            case 5:
                alarm3 = ("BANKER-PAIR");
                break;
        } if (betting == 5) {
            alarm4 = ("] : 당신의 승리입니다.\n환급액[11배] >> "+bettingMoney*11);
            bettingMoney *= 11;
            logMoney = bettingMoney - (bettingMoney/11);
        } else if (betting != 5) {
            logMoney = bettingMoney;
            alarm4 = ("] : 당신의 패배입니다. 배팅액이 사라집니다.");
            bettingMoney = 0;
        }
    }
    public void importBettingMoney() {
        playerMoney += bettingMoney;
        bettingMoney = 0;
    }


    public long getBettingMoney() {
        return bettingMoney;
    }


    public String getAlarm() {
        return alarm;
    }


    public int[][] getBankerCard() {
        return bankerCard;
    }

    public int[][] getPlayerCard() {
        return playerCard;
    }

    public int[] getPlayerExtra() {
        return playerExtra;
    }

    public int[] getBankerExtra() {
        return bankerExtra;
    }

    public String getAlarm2() {
        return alarm2;
    }

    public void setAlarm2(String alarm2) {
        this.alarm2 = alarm2;
    }

    public String getAlarm3() {
        return alarm3;
    }

    public void setAlarm3(String alarm3) {
        this.alarm3 = alarm3;
    }

    public String getAlarm4() {
        return alarm4;
    }

    public void setAlarm4(String alarm4) {
        this.alarm4 = alarm4;
    }

    public long getPlayerMoney() {
        return playerMoney;
    }

    public String getAlarm5() {
        return alarm5;
    }

    public long getLogMoney() {
        return logMoney;
    }

    public void setPlayerMoney(long playerMoney) {
        this.playerMoney = playerMoney;
    }
} // class : Card
