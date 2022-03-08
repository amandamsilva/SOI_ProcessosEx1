package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		int opcao = 0;
		RedesController redesController = new RedesController();

		while (opcao != 3) {
			opcao = Integer
					.parseInt(JOptionPane.showInputDialog(null, "1 - Mostrar IPv4 \n2 - Mostrar ping \n3 - Finalizar"));

			switch (opcao) {
			case 1:
				redesController.ip();
				break;
			case 2:
				redesController.ping();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Aplicação finalizada.");
				break;
			default :
				JOptionPane.showMessageDialog(null, "Opção inválida.");
			}
		}
	}

}
