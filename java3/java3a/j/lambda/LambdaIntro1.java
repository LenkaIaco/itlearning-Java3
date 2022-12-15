package sk.itlearning.java3.java3a.j.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LambdaIntro1 {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setSize(300, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//operacia abz sa okno neskrzlo ale zavrelo

		JButton b = new JButton("Click");
		
		JPanel jp = new JPanel();
		jp.add(b);

		f.setContentPane(jp);
		
		b.addActionListener(new ActionListener() {//anonzmna vnutorna trieda: ideme konstruktovat interface co nejde ale akobz doplnime praydne telo triedz  + implementacia
			@Override
			public void actionPerformed(ActionEvent e) {//aby sme nemuseli triedu manualne overridovat, tak ak trieda (nasa anonymna abstraktna)ma iba jeden parameter, pouzijeme lambdu
				b.setText(b.getText() + "X");
			} }
		);
		
//		b.addActionListener(e -> b.setText(b.getText() + "Y"))); //bud napiseme manualny override metody override ako hore alebo cez lambdu

	}

}
