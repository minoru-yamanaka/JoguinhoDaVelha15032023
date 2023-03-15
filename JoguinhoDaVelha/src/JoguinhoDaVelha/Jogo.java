package JoguinhoDaVelha;

import java.awt.Font;
import java.awt.event.ActionEvent;


import javax.swing.*;/*Já importa tudo de swing*/

public class Jogo extends JFrame {
	JButton[] bt = new JButton[9];
	JLabel placar = new JLabel("PLACAR");
	JLabel px = new JLabel("[ X ] O");
	JLabel po = new JLabel("[ O ] O");
	JButton novo = new JButton("NEW GAME");
	JButton restart = new JButton("RESTART");
	int PX = 0;
	int PO = 0;
	boolean xo = false;
	boolean[] click = new boolean[9];
	
	public Jogo() {
		setVisible(true);
		setTitle("Joguinho da velha <https://github.com/minoru-yamanaka>");
		setDefaultCloseOperation(3);
		setLayout(null);
		setBounds(250,100,700,500);
		add(placar);
		add(px);
		add(po);
		add(novo);
		add(restart);
		placar.setBounds(425,40,100,30);
		po.setBounds(425,75,100,30);
		px.setBounds(500,75,100,30);
		novo.setBounds(425,130,140,30);
		restart.setBounds(425,170,140,30);
		
		novo.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		restart.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PO = 0;
				PX = 0;
				placar();
			}
		});
		int cont =0;
		for (int i =0 ; i<3 ; i++) {
			for (int j =0 ; j<3 ; j++) {
				bt[cont] = new JButton();
				add(bt[cont]);//add elemento botão
				bt[cont].setBounds((100*i)+50, (100*j)+50, 95 ,95);//posição do botão
				bt[cont].setFont(new Font("Arial", Font.BOLD ,70));
				cont++ ;//for add 1
			}
		}
		//valor para cada posição 
		for (int i =0; i < 9; i++){
		click[1] = false;
		}
		//ações do botão
		bt[0].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[0]==false) {
					click[0] = true;
					alterar(	bt[0]);	
				}
			}
		});
		
		bt[1].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[1]==false) {
					click[1] = true;
					alterar(	bt[1]);	
				}
			}
		});
		
		bt[2].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[2]==false) {
					click[2] = true;
					alterar(	bt[2]);	
				}
			}
		});
		
		bt[3].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[3]==false) {
					click[3] = true;
					alterar(	bt[3]);	
				}
			}
		});
		
		bt[4].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[4]==false) {
					click[4] = true;
					alterar(	bt[4]);	
				}
			}
		});
		
		bt[5].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[5]==false) {
					click[5] = true;
					alterar(	bt[5]);	
				}
			}
		});
		
		bt[6].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[6]==false) {
					click[6] = true;
					alterar(	bt[6]);	
				}
			}
		});
		
		bt[7].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[7]==false) {
					click[7] = true;
					alterar(	bt[7]);	
				}
			}
		});
		
		bt[8].addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[8]==false) {
					click[8] = true;
					alterar(	bt[8]);	
				}
			}
		});
		
		
	}
	public void alterar(JButton btn) {//esse metodo vai alternar 
		if(xo) {
			btn.setText("O");
			xo = false;
		}else {
			btn.setText("X");
			xo = true;
		}
		verificacao();
	}
	public void placar() {
		px.setText("[ X ]  "+PX);
		po.setText("[ O ]  "+PO);
	}
	
	
	public void verificacao() {
		
		//quantos botoes foram pressionados
		int cont = 0;
		for (int i =0 ; i<9 ; i++) {
			if(click[i]==true) {
				cont++;
			}
		}
		if(( bt[0].getText()=="X" && bt[1].getText()=="X" && bt[2].getText()=="X")||
		   ( bt[3].getText()=="X" && bt[4].getText()=="X" && bt[5].getText()=="X")||
		   ( bt[6].getText()=="X" && bt[7].getText()=="X" && bt[8].getText()=="X")||
		   ( bt[0].getText()=="X" && bt[3].getText()=="X" && bt[6].getText()=="X")||
		   ( bt[1].getText()=="X" && bt[4].getText()=="X" && bt[7].getText()=="X")||
		   ( bt[2].getText()=="X" && bt[5].getText()=="X" && bt[8].getText()=="X")||
		   ( bt[0].getText()=="X" && bt[4].getText()=="X" && bt[8].getText()=="X")||
		   ( bt[6].getText()=="X" && bt[4].getText()=="X" && bt[2].getText()=="X")){
			JOptionPane.showMessageDialog(null, "[X] GANHOU");
			PX++;
			placar();
			limpar();
		}else if  (( bt[0].getText()=="O" && bt[1].getText()=="O" && bt[2].getText()=="O")||
				   ( bt[3].getText()=="o" && bt[4].getText()=="O" && bt[5].getText()=="O")||
				   ( bt[6].getText()=="O" && bt[7].getText()=="O" && bt[8].getText()=="O")||
				   ( bt[0].getText()=="O" && bt[3].getText()=="O" && bt[6].getText()=="O")||
				   ( bt[1].getText()=="O" && bt[4].getText()=="O" && bt[7].getText()=="O")||
				   ( bt[2].getText()=="O" && bt[5].getText()=="O" && bt[8].getText()=="O")||
				   ( bt[0].getText()=="O" && bt[4].getText()=="O" && bt[8].getText()=="O")||
				   ( bt[6].getText()=="O" && bt[4].getText()=="O" && bt[2].getText()=="O")){
					JOptionPane.showMessageDialog(null, "[O] GANHOU");
					PO++;
					placar();
					limpar();
				} else if(cont == 9){
					JOptionPane.showMessageDialog(null, "EMPATE");
					limpar();
				}
	}
	public void limpar() {
		for (int i =0; i < 9; i++){
			bt[i].setText("null");
			click[i] = false; 
		}
	}
	
	public static void main(String[] args) {
		new Jogo();

	}

}
