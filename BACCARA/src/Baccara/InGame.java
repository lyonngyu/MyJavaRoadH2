package Baccara;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class InGame extends JFrame{
    public Card card = new Card(3000000);
    private DecimalFormat formatter = new DecimalFormat("###,###");

    private boolean chbet1 = false, chbet2 = false, chbet3 = false, chbet4= false, chbet5 = false, chbetAll = false;
    private boolean betNone = true;
    private boolean playGame = false, buttonPlay = true;
    private boolean fiveCard = false;
    private boolean bettingRepeat1 = true, bettingRepeat2 = true, bettingRepeat3 = true, bettingRepeat4 = true, bettingRepeat5 = true, bettingRepeat6 = true;
    private int chkCard = 0;
    private int bet1 = 5000000;
    private int bet2 = 1000000;
    private int bet3 = 500000;
    private int bet4 = 100000;
    private int bet5 = 50000;
    private long bettingMoney = 0;
    private long seeMoney = card.getPlayerMoney();
    private String resultAlarm;
    private char resultPlusMinus;
    public static String[] inLog = {"", "", "", "", "", "", "", "", "", "",};
    // south
    private final JPanel southPanel = new JPanel(new BorderLayout());
    private final JPanel southBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JPanel southMoneyPanel = new JPanel(new BorderLayout());
    private final JPanel southAlarmPanel = new JPanel(new BorderLayout());
    private final JPanel southBettingPanel = new JPanel(new BorderLayout());
    private final JPanel southMoneyDummyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JPanel southInMoneyDummyPanel = new JPanel(new BorderLayout());
    private final JPanel southInMoneyWestDummyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JPanel southBettingDummyPanel1 = new JPanel(new BorderLayout());
    private final JPanel southBettingDummyPanel2 = new JPanel(new BorderLayout());
    private final JPanel southBettingDummyPanel3 = new JPanel(new BorderLayout());
    private final JPanel southBettingDummyPanel4 = new JPanel(new BorderLayout());

    //center
    private final JPanel centerPanel = new JPanel(new BorderLayout());
    private final JPanel centerDummyPanel = new JPanel(new BorderLayout());
    private final JPanel centerEastPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JPanel centerWestPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private final JPanel centerBettingPanel = new JPanel(new GridLayout(1,5));
    private final JPanel centerNorthDummyPanel = new JPanel(new BorderLayout());
    private final JPanel centerEastDummyPanel = new JPanel(new BorderLayout());
    private final JPanel centerWestDummyPanel = new JPanel(new BorderLayout());
    private final JPanel centerTwoNorthLbDummyPanel = new JPanel(new BorderLayout());
    private final JPanel centerNorthLbDummyPanelPlayer = new JPanel(new BorderLayout());
    private final JPanel centerNorthLbDummyPanelBanker = new JPanel(new BorderLayout());
    private final JPanel centerNorthPlusDummyPanelPlayer1 = new JPanel(new BorderLayout());
    private final JPanel centerNorthPlusDummyPanelPlayer2 = new JPanel(new BorderLayout());
    private final JPanel centerNorthPlusDummyPanelBanker1 = new JPanel(new BorderLayout());
    private final JPanel centerNorthPlusDummyPanelBanker2 = new JPanel(new BorderLayout());
    private final JPanel centerInCenterPanel = new JPanel(new BorderLayout());
    private final JPanel alarmPanel = new JPanel(new BorderLayout());

    private final JPanel northPanel = new JPanel(new BorderLayout());

    private final JLabel lbPlayerPrint = new JLabel("PLAYER", JLabel.CENTER);
    private final JLabel lbBankerPrint = new JLabel("BANKER", JLabel.CENTER);
    private final JLabel lbPlayerCard1 = new JLabel(" ");
    private final JLabel lbPlayerCard2 = new JLabel(" ");
    private final JLabel lbPlayerCard3 = new JLabel(" ");
    private final JLabel lbBankerCard1 = new JLabel(" ");
    private final JLabel lbBankerCard2 = new JLabel(" ");
    private final JLabel lbBankerCard3 = new JLabel(" ");
    private final JLabel lbBettingCoin = new JLabel(new ImageIcon("src/res/X.png"));
    private final JLabel lbBettingMoney = new JLabel("현재 배팅액 : " + formatter.format(bettingMoney), JLabel.CENTER);
    private final JLabel lbAlarm = new JLabel("최근 알림이 없음", JLabel.CENTER);
    private final JLabel lbPlayerMoney = new JLabel( "잔액 : "+ formatter.format(seeMoney),JLabel.LEFT);

    private final JButton btnLog = new JButton("내역");
    private final JButton btnGoExit = new JButton("종료하기");
    private final JButton btnAllIn = new JButton("올인");
    private final JButton btnDoBetting = new JButton("+");
    private final JButton btnUndoBetting = new JButton("-");
    private final JButton btnBetting1 = new JButton("500만");
    private final JButton btnBetting2 = new JButton("100만");
    private final JButton btnBetting3 = new JButton("50만");
    private final JButton btnBetting4 = new JButton("10만");
    private final JButton btnBetting5 = new JButton("5만");
    private final JButton btnBettingNone = new JButton("반환");
    private final JButton btnCenterRealBetting1 = new JButton("P-PAIR");
    private final JButton btnCenterRealBetting2 = new JButton("PLAYER");
    private final JButton btnCenterRealBetting3 = new JButton("TIE");
    private final JButton btnCenterRealBetting4 = new JButton("BANKER");
    private final JButton btnCenterRealBetting5 = new JButton("B-PAIR");

    public InGame() {
        setFrame();
        setComponent();
        onClickBetting();
    }

    private void setFrame() {
        setTitle("BACCARA");
        setSize(1360, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
        seeBettingCoin();
    }

    private void setComponent() {
        southPanel.setPreferredSize(new Dimension(1360, 180));
        southAlarmPanel.setPreferredSize(new Dimension(350, 100));
        southMoneyPanel.setPreferredSize(new Dimension(350, 100));
        southMoneyDummyPanel.setPreferredSize(new Dimension(50, 100));
        southBettingDummyPanel3.setPreferredSize(new Dimension(400, 30));
        southBettingDummyPanel4.setPreferredSize(new Dimension(400, 30));
        centerNorthDummyPanel.setPreferredSize(new Dimension(1360, 30));
        centerEastDummyPanel.setPreferredSize(new Dimension(100, 10));
        centerWestDummyPanel.setPreferredSize(new Dimension(100, 10));
        centerNorthPlusDummyPanelPlayer1.setPreferredSize(new Dimension(10, 150));
        centerNorthPlusDummyPanelPlayer2.setPreferredSize(new Dimension(250, 10));
        centerNorthPlusDummyPanelBanker1.setPreferredSize(new Dimension(10, 150));
        centerNorthPlusDummyPanelBanker2.setPreferredSize(new Dimension(250, 10));
        btnCenterRealBetting1.setPreferredSize(new Dimension(100, 50));
        btnGoExit.setPreferredSize(new Dimension(150,30));

        centerTwoNorthLbDummyPanel.setBackground(new Color(0,75,10));
        southPanel.setBackground(new Color(0,75,10));
        southBettingPanel.setBackground(new Color(0,75,10));
        southBtnPanel.setBackground(new Color(0,75,10));
        southAlarmPanel.setBackground(new Color(0,75,10));
        southMoneyDummyPanel.setBackground(new Color(0,75,10));
        southBettingDummyPanel3.setBackground(new Color(0, 75, 10));
        southBettingDummyPanel4.setBackground(new Color(0, 75, 10));
        southInMoneyDummyPanel.setBackground(new Color(255, 255, 255));
        southInMoneyWestDummyPanel.setBackground(new Color(255, 255, 255));
        centerPanel.setBackground(new Color(255, 255 ,255));

        southInMoneyDummyPanel.setBorder(new LineBorder(Color.BLACK,3));
        centerTwoNorthLbDummyPanel.setBorder(new LineBorder(Color.BLACK,3));
        southPanel.setBorder(new LineBorder(Color.BLACK,3));

        btnDoBetting.setFont(new Font("돋움",Font.BOLD, 16));
        btnUndoBetting.setFont(new Font("돋움",Font.BOLD, 16));
        btnAllIn.setFont(new Font("돋움",Font.BOLD, 16));
        btnBetting1.setFont(new Font("돋움",Font.BOLD, 16));
        btnBetting2.setFont(new Font("돋움",Font.BOLD, 16));
        btnBetting3.setFont(new Font("돋움",Font.BOLD, 16));
        btnBetting4.setFont(new Font("돋움",Font.BOLD, 16));
        btnBetting5.setFont(new Font("돋움",Font.BOLD, 16));
        btnBettingNone.setFont(new Font("돋움",Font.BOLD, 16));
        lbAlarm.setFont(new Font("돋움", Font.BOLD, 17));
        lbPlayerMoney.setFont(new Font("돋움",Font.BOLD, 17));
        lbPlayerPrint.setFont(new Font("돋움", Font.BOLD, 17));
        lbBankerPrint.setFont(new Font("돋움", Font.BOLD, 17));
        lbBettingMoney.setFont(new Font("돋움",Font.BOLD, 20));
        lbBettingMoney.setForeground(Color.white);
        lbAlarm.setForeground(new Color(0, 75, 10));



        southBtnPanel.add(btnAllIn);
        southBtnPanel.add(btnBetting1);
        southBtnPanel.add(btnBetting2);
        southBtnPanel.add(btnBetting3);
        southBtnPanel.add(btnBetting4);
        southBtnPanel.add(btnBetting5);
        southBtnPanel.add(btnBettingNone);

        southPanel.add(southBtnPanel, BorderLayout.SOUTH);
        southPanel.add(southAlarmPanel, BorderLayout.EAST);
        southPanel.add(southBettingPanel, BorderLayout.NORTH);
        southPanel.add(southMoneyPanel, BorderLayout.WEST);
        southPanel.add(lbBettingCoin, BorderLayout.CENTER);


        southInMoneyDummyPanel.add(lbPlayerMoney, BorderLayout.CENTER);
        southInMoneyDummyPanel.add(southInMoneyWestDummyPanel, BorderLayout.WEST);

        southMoneyPanel.add(southMoneyDummyPanel, BorderLayout.WEST);
        southMoneyPanel.add(southInMoneyDummyPanel, BorderLayout.CENTER);

        southBettingPanel.add(southBettingDummyPanel1, BorderLayout.WEST);
        southBettingPanel.add(lbBettingMoney, BorderLayout.CENTER);
        southBettingPanel.add(southBettingDummyPanel2, BorderLayout.EAST);

        southBettingDummyPanel2.add(southBettingDummyPanel4, BorderLayout.EAST);
        southBettingDummyPanel2.add(btnUndoBetting, BorderLayout.CENTER);

        southBettingDummyPanel1.add(southBettingDummyPanel3, BorderLayout.WEST);
        southBettingDummyPanel1.add(btnDoBetting, BorderLayout.CENTER);

        centerPanel.add(centerBettingPanel, BorderLayout.SOUTH);
        centerBettingPanel.add(btnCenterRealBetting1);
        centerBettingPanel.add(btnCenterRealBetting2);
        centerBettingPanel.add(btnCenterRealBetting3);
        centerBettingPanel.add(btnCenterRealBetting4);
        centerBettingPanel.add(btnCenterRealBetting5);

        centerPanel.add(centerDummyPanel, BorderLayout.CENTER);
        centerPanel.add(centerNorthDummyPanel, BorderLayout.NORTH);
        centerPanel.add(centerEastDummyPanel, BorderLayout.EAST);
        centerPanel.add(centerWestDummyPanel, BorderLayout.WEST);

        centerDummyPanel.add(centerInCenterPanel, BorderLayout.CENTER);
        centerDummyPanel.add(centerWestPanel, BorderLayout.WEST);
        centerDummyPanel.add(centerEastPanel, BorderLayout.EAST);

        northPanel.add(alarmPanel, BorderLayout.CENTER);
        alarmPanel.add(lbAlarm, BorderLayout.CENTER);

        centerWestPanel.add(lbPlayerCard1);
        centerWestPanel.add(lbPlayerCard2);
        centerWestPanel.add(lbPlayerCard3);

        centerEastPanel.add(lbBankerCard1);
        centerEastPanel.add(lbBankerCard2);
        centerEastPanel.add(lbBankerCard3);;

        northPanel.add(centerTwoNorthLbDummyPanel,BorderLayout.NORTH);
        northPanel.add(centerNorthLbDummyPanelPlayer, BorderLayout.WEST);
        northPanel.add(centerNorthLbDummyPanelBanker, BorderLayout.EAST);

        centerTwoNorthLbDummyPanel.add(btnGoExit, BorderLayout.WEST);
        centerTwoNorthLbDummyPanel.add(btnLog, BorderLayout.EAST);

        centerNorthLbDummyPanelPlayer.add(lbPlayerPrint,BorderLayout.CENTER);
        centerNorthLbDummyPanelPlayer.add(centerNorthPlusDummyPanelPlayer1, BorderLayout.NORTH);
        centerNorthLbDummyPanelPlayer.add(centerNorthPlusDummyPanelPlayer2, BorderLayout.WEST);

        centerNorthLbDummyPanelBanker.add(lbBankerPrint,BorderLayout.CENTER);
        centerNorthLbDummyPanelBanker.add(centerNorthPlusDummyPanelBanker1, BorderLayout.NORTH);
        centerNorthLbDummyPanelBanker.add(centerNorthPlusDummyPanelBanker2, BorderLayout.EAST);

        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void onClickBetting() {
        btnDoBetting.addActionListener(e -> {
            if(!playGame) {
                if (chbet1) {
                    if (seeMoney < bet1) {
                        return;
                    }
                    bettingMoney += bet1;
                    seeMoney -= bet1;
                    updateCash();
                } else if (chbet2) {
                    if (seeMoney < bet2) {
                        return;
                    }
                    bettingMoney += bet2;
                    seeMoney -= bet2;
                    updateCash();
                } else if (chbet3) {
                    if (seeMoney < bet3) {
                        return;
                    }
                    bettingMoney += bet3;
                    seeMoney -= bet3;
                    updateCash();
                } else if (chbet4) {
                    if (seeMoney < bet4) {
                        return;
                    }
                    bettingMoney += bet4;
                    seeMoney -= bet4;
                    updateCash();
                } else if (chbet5) {
                    if (seeMoney < bet5) {
                        return;
                    }
                    bettingMoney += bet5;
                    seeMoney -= bet5;
                    updateCash();
                }
            }
            });


            btnUndoBetting.addActionListener(e -> {
                if (!playGame) {
                    if (chbet1) {
                        if (bettingMoney < bet1) {
                            return;
                        }
                        bettingMoney -= bet1;
                        seeMoney += bet1;
                        updateCash();
                    } else if (chbet2) {
                        if (bettingMoney < bet2) {
                            return;
                        }
                        bettingMoney -= bet2;
                        seeMoney += bet2;
                        updateCash();
                    } else if (chbet3) {
                        if (bettingMoney < bet3) {
                            return;
                        }
                        bettingMoney -= bet3;
                        seeMoney += bet3;
                        updateCash();
                    } else if (chbet4) {
                        if (bettingMoney < bet4) {
                            return;
                        }
                        bettingMoney -= bet4;
                        seeMoney += bet4;
                        updateCash();
                    } else if (chbet5) {
                        if (bettingMoney < bet5) {
                            return;
                        }
                        bettingMoney -= bet5;
                        seeMoney += bet5;
                        updateCash();
                    }
                }
            });
        btnAllIn.addActionListener(e -> {
            chbetAll = true;
            chbet1 = false;
            chbet2 = false;
            chbet3 = false;
            chbet4 = false;
            chbet5 = false;
            betNone = false;
            if(!playGame) {
                bettingMoney += seeMoney;
                seeMoney = 0;
                updateCash();
                seeBettingCoin();
            }
        });
        btnBetting1.addActionListener(e -> {
            chbet1 = true;
            chbet2 = false;
            chbet3 = false;
            chbet4 = false;
            chbet5 = false;
            betNone = false;
            chbetAll = false;
            seeBettingCoin();
        });
        btnBetting2.addActionListener(e -> {
            chbet1 = false;
            chbet2 = true;
            chbet3 = false;
            chbet4 = false;
            chbet5 = false;
            betNone = false;
            chbetAll = false;
            seeBettingCoin();
        });
        btnBetting3.addActionListener(e -> {
            chbet1 = false;
            chbet2 = false;
            chbet3 = true;
            chbet4 = false;
            chbet5 = false;
            betNone = false;
            chbetAll = false;;
            seeBettingCoin();
        });
        btnBetting4.addActionListener(e -> {
            chbet1 = false;
            chbet2 = false;
            chbet3 = false;
            chbet4 = true;
            chbet5 = false;
            betNone = false;
            chbetAll = false;
            seeBettingCoin();
        });
        btnBetting5.addActionListener(e -> {
            chbet1 = false;
            chbet2 = false;
            chbet3 = false;
            chbet4 = false;
            chbet5 = true;
            betNone = false;
            chbetAll = false;
            seeBettingCoin();
        });
        btnBettingNone.addActionListener(e -> {
            chbet1 = false;
            chbet2 = false;
            chbet3 = false;
            chbet4 = false;
            chbet5 = false;
            betNone = true;
            chbetAll = false;
            if (!playGame) {
                card.importBettingMoney();
                strongUpdateCash();
                bettingMoney = 0;
                seeBettingCoin();
            }
        });

        btnCenterRealBetting1.addActionListener(e -> {
            if(buttonPlay) {
                if (bettingMoney <= 0) {
                    return;
                }
                card.draw(5, bettingMoney);
                updateAlarmProgress();
                if(!playGame) {
                    chkCard = 0;
                    fiveCard = false;
                    lbPlayerCard3.setVisible(false);
                    lbBankerCard3.setVisible(false);
                }
                playGame = true;
                buttonPlay = false;
                goBetting();
            }

        });
        btnCenterRealBetting2.addActionListener(e -> {
            if(buttonPlay) {
                if (bettingMoney <= 0) {
                    return;
                }
                card.draw(1, bettingMoney);
                updateAlarmProgress();
                if(!playGame) {
                    chkCard = 0;
                    fiveCard = false;
                    lbPlayerCard3.setVisible(false);
                    lbBankerCard3.setVisible(false);
                }
                playGame = true;
                buttonPlay = false;
                goBetting();
            }

        });
        btnCenterRealBetting3.addActionListener(e -> {
            if(buttonPlay) {
                if (bettingMoney <= 0) {
                    return;
                }
                card.draw(3, bettingMoney);
                updateAlarmProgress();
                if(!playGame) {
                    chkCard = 0;
                    fiveCard = false;
                    lbPlayerCard3.setVisible(false);
                    lbBankerCard3.setVisible(false);
                }
                playGame = true;
                buttonPlay = false;

                goBetting();
            }
        });
        btnCenterRealBetting4.addActionListener(e -> {
            if(buttonPlay) {
                if (bettingMoney <= 0) {
                    return;
                }
                card.draw(2, bettingMoney);
                updateAlarmProgress();
                if(!playGame) {
                    chkCard = 0;
                    fiveCard = false;
                    lbPlayerCard3.setVisible(false);
                    lbBankerCard3.setVisible(false);
                }
                playGame = true;
                buttonPlay = false;
                goBetting();
            }

        });
        btnCenterRealBetting5.addActionListener(e -> {
            if(buttonPlay) {
                if (bettingMoney <= 0) {
                    return;
                }
                card.draw(4, bettingMoney);
                updateAlarmProgress();
                if(!playGame) {
                    chkCard = 0;
                    fiveCard = false;
                    lbPlayerCard3.setVisible(false);
                    lbBankerCard3.setVisible(false);
                }
                playGame = true;
                buttonPlay = false;
                goBetting();
            }

        });

        btnGoExit.addActionListener(e -> {
            if(!playGame) {
                card.setPlayerMoney(card.getPlayerMoney()+bettingMoney);
                seeMoney = card.getPlayerMoney();
                bettingMoney = 0;
                setVisible(false);
            }
        });

        btnLog.addActionListener(e -> {
            new Log();
        });

        lbPlayerCard1.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String nameAddress = "";
                if(card.getPlayerCard() != null) {
                    switch(card.getPlayerCard()[0][1]) {
                        case 1:
                            nameAddress = "space/";
                            break;
                        case 2:
                            nameAddress = "heart/";
                            break;
                        case 3:
                            nameAddress = "clover/";
                            break;
                        case 4:
                            nameAddress = "crystal/";
                            break;
                    }
                    lbPlayerCard1.setIcon(new ImageIcon("src/res/"+nameAddress+card.getPlayerCard()[0][0]+".png"));
                    if (bettingRepeat1) {
                        chkCard++;
                        bettingRepeat1 = false;
                    }
                    if(playGame) {
                        bettingThird();
                    }
                }
            }
        }));
        lbPlayerCard2.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String nameAddress = "";
                if(card.getPlayerCard() != null) {
                    switch(card.getPlayerCard()[1][1]) {
                        case 1:
                            nameAddress = "space/";
                            break;
                        case 2:
                            nameAddress = "heart/";
                            break;
                        case 3:
                            nameAddress = "clover/";
                            break;
                        case 4:
                            nameAddress = "crystal/";
                            break;
                    }
                    lbPlayerCard2.setIcon(new ImageIcon("src/res/"+nameAddress+card.getPlayerCard()[1][0]+".png"));
                    if (bettingRepeat2) {
                        chkCard++;
                        bettingRepeat2 = false;
                    }
                    if(playGame) {
                        bettingThird();
                    }
                }

            }
        }));
        lbBankerCard1.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String nameAddress = "";
                if(card.getBankerCard() != null) {
                    switch(card.getBankerCard()[0][1]) {
                        case 1:
                            nameAddress = "space/";
                            break;
                        case 2:
                            nameAddress = "heart/";
                            break;
                        case 3:
                            nameAddress = "clover/";
                            break;
                        case 4:
                            nameAddress = "crystal/";
                            break;
                    }
                    lbBankerCard1.setIcon(new ImageIcon("src/res/"+nameAddress+card.getBankerCard()[0][0]+".png"));
                    if (bettingRepeat3) {
                        chkCard++;
                        bettingRepeat3 = false;
                    }
                    if(playGame) {
                        bettingThird();
                    }
                }

            }
        }));
        lbBankerCard2.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String nameAddress = "";
                if(card.getBankerCard() != null) {
                    switch(card.getBankerCard()[1][1]) {
                        case 1:
                            nameAddress = "space/";
                            break;
                        case 2:
                            nameAddress = "heart/";
                            break;
                        case 3:
                            nameAddress = "clover/";
                            break;
                        case 4:
                            nameAddress = "crystal/";
                            break;
                    }
                    lbBankerCard2.setIcon(new ImageIcon("src/res/"+nameAddress+card.getBankerCard()[1][0]+".png"));
                    if (bettingRepeat4) {
                        chkCard++;
                        bettingRepeat4 = false;
                    }
                    if(playGame) {
                        bettingThird();
                    }
                }
            }
        }));
        lbPlayerCard3.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String nameAddress = "";
                if(card.getPlayerExtra() != null) {
                    switch(card.getPlayerExtra()[1]) {
                        case 1:
                            nameAddress = "space/";
                            break;
                        case 2:
                            nameAddress = "heart/";
                            break;
                        case 3:
                            nameAddress = "clover/";
                            break;
                        case 4:
                            nameAddress = "crystal/";
                            break;
                    }
                    lbPlayerCard3.setIcon(new ImageIcon("src/res/"+nameAddress+card.getPlayerExtra()[0]+".png"));
                    if (bettingRepeat5) {
                        chkCard++;
                        bettingRepeat5 = false;
                    }
                    if(playGame) {
                        bettingThird();
                    }
                }
            }
        }));
        lbBankerCard3.addMouseListener((new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String nameAddress = "";
                if(card.getBankerExtra() != null) {
                    switch(card.getBankerExtra()[1]) {
                        case 1:
                            nameAddress = "space/";
                            break;
                        case 2:
                            nameAddress = "heart/";
                            break;
                        case 3:
                            nameAddress = "clover/";
                            break;
                        case 4:
                            nameAddress = "crystal/";
                            break;
                    }
                    lbBankerCard3.setIcon(new ImageIcon("src/res/"+nameAddress+card.getBankerExtra()[0]+".png"));
                    if (bettingRepeat6) {
                        chkCard++;
                        bettingRepeat6 = false;
                    }
                    if(playGame) {
                        bettingThird();
                    }
                }
            }
        }));
    }

    private void seeBettingCoin() {
            if(chbet1) {
                lbBettingCoin.setIcon(new ImageIcon("src/res/chip500.png"));
            } else if(chbet2) {
                lbBettingCoin.setIcon(new ImageIcon("src/res/chip100.png"));
            } else if(chbet3) {
                lbBettingCoin.setIcon(new ImageIcon("src/res/chip50.png"));
            } else if(chbet4) {
                lbBettingCoin.setIcon(new ImageIcon("src/res/chip10.png"));
            } else if(chbet5) {
                lbBettingCoin.setIcon(new ImageIcon("src/res/chip5.png"));
            } else if(betNone) {
                lbBettingCoin.setIcon(new ImageIcon("src/res/X.png"));
            } else if(chbetAll) {
                lbBettingCoin.setIcon(new ImageIcon("src/res/allIn.png"));
            }
    }
    private void goBetting() {
        lbPlayerCard1.setIcon(new ImageIcon("src/res/backCard.png"));
        lbPlayerCard2.setIcon(new ImageIcon("src/res/backCard.png"));
        lbBankerCard1.setIcon(new ImageIcon("src/res/backCard.png"));
        lbBankerCard2.setIcon(new ImageIcon("src/res/backCard.png"));
    }
    private void bettingThird() {
        if (chkCard == 3) {
            if(!lbPlayerCard1.getIcon().toString().equals("src/res/backCard.png") && !lbPlayerCard2.getIcon().toString().equals("src/res/backCard.png") && !lbBankerCard1.getIcon().toString().equals("src/res/backCard.png") && !lbBankerCard2.getIcon().toString().equals("src/res/backCard.png")) {
                chkCard = 4;
            }
        }
        if(chkCard == 4) {
            card.openPlayer = true;
            card.openBanker = true;
            card.giveThirdCard();
            updateAlarmProgress();
            if(card.getBankerExtra() != null) {
                lbBankerCard3.setVisible(true);
                lbBankerCard3.setIcon(new ImageIcon("src/res/backCard.png"));
            } else {
                fiveCard = true;
                lbBankerCard3.setVisible(false);
            }
            if(card.getPlayerExtra() != null) {
                lbPlayerCard3.setVisible(true);
                lbPlayerCard3.setIcon(new ImageIcon("src/res/backCard.png"));
            } else {
                fiveCard = true;
                lbPlayerCard3.setVisible(false);
            }
        }
        if (chkCard == 6) {
            card.result();
            updateAlarmResult();
            gameSet();
        } else if (fiveCard) {
            if (card.getPlayerExtra() == null && card.getBankerExtra() == null) {
                card.result();
                updateAlarmResult();
                gameSet();
            }
            if (chkCard == 5) {
                card.result();
                updateAlarmResult();
                gameSet();
            }
        }
    }

    private void updateCash() {
        lbBettingMoney.setText("현재 배팅액 : " + formatter.format(bettingMoney));
        lbPlayerMoney.setText("잔액 : "+ formatter.format(seeMoney));
    }
    private void strongUpdateCash() {
        seeMoney = card.getPlayerMoney();
        lbBettingMoney.setText("현재 배팅액 : " + formatter.format(card.getBettingMoney()));
        lbPlayerMoney.setText("잔액 : "+ formatter.format(seeMoney));
    }

    private void updateAlarmProgress() {
        lbAlarm.setText(
                "<html>" +
                        "<body style='text-align:center;'>"
                        +card.getAlarm()+"<br><br>"+
                        card.getAlarm2()+card.getAlarm3()+
                        card.getAlarm4()+
                        "</body>" +
                        "</html>");
        card.setAlarm2(" ");
        card.setAlarm3(" ");
        card.setAlarm4(" ");
    }
    private void updateAlarmResult() {
        lbAlarm.setText(
                "<html>" +
                "<body style='text-align:center;'>"+
                    card.getAlarm()+"<br><br>"+
                    "<div style='color:red'>"+
                        card.getAlarm2()+card.getAlarm3()+card.getAlarm4()+
                        "</div>"+
                "</body>" +
                "</html>");
        correctLog();
        card.setAlarm2(" ");
        card.setAlarm3(" ");
        card.setAlarm4(" ");
    }
    private void gameSet() {
        bettingMoney = card.getBettingMoney();
//        seeMoney = card.getPlayerMoney(); // 배팅금 전환부분 문제 생기면 얘탓
        chkCard = 0;
        updateCash();
        playGame = false;
        buttonPlay = true;
        bettingRepeat1 = true;
        bettingRepeat2 = true;
        bettingRepeat3 = true;
        bettingRepeat4 = true;
        bettingRepeat5 = true;
        bettingRepeat6 = true;
    }
    private void correctLog() {
        for(int i=0; i<inLog.length; i++) {
            if (inLog[9] != null) {
                for(int j=1; j<inLog.length; j++) {
                    inLog[j] = inLog[j-1];
                    Log.colors[j] = Log.colors[j-1];
                }
                inLog[0] = null;
                Log.colors[0] = null;
            }
            if (inLog[i] == null) {
                if(card.getAlarm3().equals(card.getAlarm5())) {
                    resultAlarm = "승리";
                    Log.colors[i] = new Color(255,0,50);
                    resultPlusMinus = '+';
                } else {
                    resultAlarm = "패배";
                    Log.colors[i] = new Color(0,100,255);
                    resultPlusMinus = '-';
                }
                inLog[i] = "["+resultAlarm+"] 게임 결과 : "+card.getAlarm5()+"\t "+card.getAlarm2()+card.getAlarm3()+"] ("+resultPlusMinus+" "+formatter.format(card.getLogMoney())+")";
                Log.setColors();
                break;
            }
        }
    }

    public String[] getInLog() {
        return inLog;
    }
}
