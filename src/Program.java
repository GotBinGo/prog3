
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;

public class Program {

	static void addComponentsToMenu(Container pane) {
		JLabel label;
		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		label = new JLabel("Kvízjáték");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		Font labelFont = label.getFont();
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 40));

		pane.add(label, c);

		button = new JButton("Start");
		button.addActionListener(new StartButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(button, c);

		button = new JButton("Toplista");
		button.addActionListener(new ToplistaButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(button, c);

		button = new JButton("Beállítások");
		button.addActionListener(new SettingsButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(button, c);

		button = new JButton("Kilépés");
		button.addActionListener(new ExitButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(button, c);
	}

	static void addComponentsToJatek(Container pane) {

		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		JButton button;
		JLabel label;
		label = new JLabel("Kvízjáték");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		Font labelFont = label.getFont();
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 40));

		pane.add(label, c);

		button = new JButton("Válasz 1");
		button.addActionListener(new Answer1ButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(button, c);

		button = new JButton("Válasz 2");
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(button, c);

		button = new JButton("Válasz 3");
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(button, c);

		label = new JLabel("Hátralevő kérdések: X");
		c.weightx = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 4;
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		pane.add(label, c);
		

	}

	static void addComponentsToTopl(Container pane) {

		JButton button = new JButton("Vissza");
		button.addActionListener(new ToplistaBackButtonActionListener());
		pane.add(button, BorderLayout.SOUTH);
		
		String[] columnNames = {"Helyezés", "Név", "Pontszám", "Idő"};

		ArrayList<ScoreRecord> tmp = tl.getArray();
		
		
		Object[][] data = new Object[tmp.size()][3];
		Object[][] data2 = new Object[20][3];
		
		for(int i = 0; i < tmp.size(); i ++)
		{
			data[i] = new Object[] {0, tmp.get(i).getName(),tmp.get(i).getScore(),tmp.get(i).getTime()};
		}
		Arrays.sort(data, (a, b) -> ((Long)a[3]).compareTo((Long)b[3]));
		Arrays.sort(data, (a, b) -> ((Integer)b[2]).compareTo((Integer)a[2]));
		
		for(int i = 0; i < 20; i ++)
		{
			Object[] tm = data[i];
			tm[0] = i+1;
			tm[3] = Math.round(((long)tm[3])/1000000.0f)/1000.0f;
			data2[i] = tm;
		}
		JTable table = new JTable(data2, columnNames);
		pane.add(table.getTableHeader(), BorderLayout.PAGE_START);
		pane.add(table, BorderLayout.CENTER);

	}

	static void addComponentsToBeall(Container pane) {
		JLabel label;
		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(40, 40, 10, 10);
		label = new JLabel("Beállítások");
		c.gridwidth = 3;
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		Font labelFont = label.getFont();
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 35));
		pane.add(label, c);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 30));
		label = new JLabel("Másodperc kérdésenként: ");
		pane.add(label, c);
		c.gridwidth = 1;
		c.gridx = 2;
		String[] times = {
		         "3",
		         "4",
		         "5",
		         "6",
		         "7",
		         "8",
		         "9",
		         "10"
		};
		timeselect = new JComboBox(times);
		timeselect.setSelectedIndex(st.getMaxtime()-3);
		pane.add(timeselect, c);
	
		button = new JButton("Mentés");
		button.addActionListener(new SettingsBackButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.CENTER;
		c.gridwidth = 3;


		c.gridx = 0;
		c.gridy = 2;
		pane.add(button, c);
	}
	static void kerdesFriss(){
		
		jatekPanel.removeAll();
		kerdesHanyadik++;
	
		if(kerdesHanyadik == questions.size()) //nincs tobb kerdes
		{
			//GameEnd();
			estimatedTime = System.nanoTime() - startTime;
			jatekPanel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(10, 10, 10, 10);
			JButton button;
			JLabel label;
			label = new JLabel("Pontszám: " + score);

			Font labelFont = label.getFont();
			label.setFont(new Font(labelFont.getName(), Font.PLAIN, 40));
			
			c.gridwidth = 3;
			c.gridx = 0;
			c.gridy = 0;
			jatekPanel.add(label, c);
			
			label = new JLabel("Játékidő: " +  Math.round((estimatedTime)/1000000.0f)/1000.0f);

			labelFont = label.getFont();
			label.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
			
			c.gridwidth = 3;
			c.gridx = 0;
			c.gridy = 1;
			jatekPanel.add(label, c);
			
			
			label = new JLabel("Név: ");
			label.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
			
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 2;
			jatekPanel.add(label, c);
			
			jt = new JTextField(10);
			
			Font font = jt.getFont().deriveFont((float)20);
			jt.setFont(font);
			c.gridwidth = 2;
			c.gridx = 1;
			c.gridy = 2;
			jatekPanel.add(jt, c);
			
			button = new JButton("Mentés");
			button.addActionListener(new SaveButtonActionListener());
			button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
			c.insets = new Insets(40, 20, 20, 20);
			c.gridwidth = 3;
			c.gridx = 0;
			c.gridy = 6;
			jatekPanel.add(button, c);
			return;
		}
		
		jatekPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		JButton button;
		JLabel label;
		label = new JLabel(" ");
		timelabel = label;
		c.weightx = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		Font labelFont = label.getFont();
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 40));
		jatekPanel.add(label, c);
		
		label = new JLabel(questions.get(kerdesHanyadik).getQuestion());
		c.weightx = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		jatekPanel.add(label, c);
		
		
		button = new JButton(questions.get(kerdesHanyadik).getAnswer(0));
		button.addActionListener(new Answer1ButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		//lehetseges poziciok 2, 4, 6
		int rand = 1 + new Random().nextInt(3);
		c.gridy = rand * 2;
		jatekPanel.add(button, c);

		button = new JButton(questions.get(kerdesHanyadik).getAnswer(1));
		button.addActionListener(new Answer2ButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		jatekPanel.add(button, c);

		button = new JButton(questions.get(kerdesHanyadik).getAnswer(2));
		button.addActionListener(new Answer2ButtonActionListener());
		button.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 5;
		jatekPanel.add(button, c);

		
		label = new JLabel("Hátralevő: "+(3-kerdesHanyadik) + "       " + "Pontszám: " + score);//kérdések.length-kerdesHanyadik
		c.weightx = 0.5;
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 7;
		label.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
		jatekPanel.add(label, c);
		
		
		frame.invalidate();
		frame.validate();
		frame.repaint();
		timeleft = st.getMaxtime();
		
		timelabel.setText(" " + timeleft);
		
		 int delay = 1000;
		  ActionListener taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		    	  timeleft --;
		    	  timelabel.setText(" " + timeleft);
		    	  if(timeleft == 0)
		    	  {
		    		  new Answer2ButtonActionListener().actionPerformed(evt);
		    	  }
		    	  else
		    	  {
		    		  timer.start();
		    	  }
		      }
		  };
		  
		  timer = new Timer(delay, taskPerformer);
		  timer.setRepeats(false);
		  timer.start();
	}

	static int kerdesHanyadik = -1;
	static int score = 0;
	static JTextField jt;
	static JFrame frame;
	static JPanel menuPanel;
	static JPanel jatekPanel;
	static JPanel toplPanel;
	static JPanel beallPanel;
	static JLabel timelabel;
	static JComboBox timeselect;
	
	static Questionlist ql;
	static Toplist tl;
	static Settings st;
	
	static int timeleft = 0;
	static Timer timer;
	static long startTime;
	static long estimatedTime;

	static java.util.List<Question> questions;


	public static void main(String[] args) {

		ql = new Questionlist();
		ql.readList();
		
		tl = new Toplist();
		tl.readList();
		
		st = new Settings();
		st.readSettings();
	
		
		frame = new JFrame("Kvízjáték");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setResizable(false);
		menuPanel = new JPanel(new BorderLayout());
		jatekPanel = new JPanel(new BorderLayout());
		toplPanel = new JPanel(new BorderLayout());
		beallPanel = new JPanel(new BorderLayout());
		addComponentsToMenu(menuPanel);
		addComponentsToJatek(jatekPanel);
		addComponentsToTopl(toplPanel);
		addComponentsToBeall(beallPanel);
		frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
		frame.setVisible(true);

	}
	static private class Answer1ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// válasz1 katt
			timer.stop();
			score++;
			kerdesFriss();
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
	}
	static private class Answer2ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// válasz2 katt
			timer.stop();
			score--;
			kerdesFriss();
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
	}
	static private class SaveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// ment katt
			String name = jt.getText();
			if(name.equals(""))
				name = "UnnamedPlayer";
			//save record
			tl.addRecord(new ScoreRecord(name, score, estimatedTime));
			tl.writeList();
			GameEnd();
		}
	}

	static private class ExitButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// kilépés gomb nyomás
			System.exit(0);
		}
	}

	static private class StartButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Start gomb nyomás
			startTime = System.nanoTime();
			score = 0;
			questions = ql.getArray();
			Collections.shuffle(questions);
			kerdesHanyadik = -1;
			frame.getContentPane().remove(menuPanel);
			frame.getContentPane().add(jatekPanel, BorderLayout.CENTER);
			kerdesFriss();
			frame.setVisible(true);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
	}	

	static class SettingsButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Beállítások gomb nyomás
			frame.getContentPane().remove(menuPanel);
			frame.getContentPane().add(beallPanel, BorderLayout.CENTER);
			frame.setVisible(true);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
	}

	static class SettingsBackButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Beállítások vissza gomb nyomás
			//savesettings
			st.setMaxtime(Integer.parseInt((String)(timeselect.getSelectedItem())));
			st.writeSettings();
			System.out.print(timeselect.getSelectedItem());
			frame.getContentPane().remove(beallPanel);
			frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
			frame.setVisible(true);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
	}
	

	static void GameEnd( ) {
			// Beállítások vissza gomb nyomás
			frame.getContentPane().remove(jatekPanel);
			frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
			frame.setVisible(true);
			frame.invalidate();
			frame.validate();
			frame.repaint();
	}
	

	static class ToplistaButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Toplista gomb nyomás
			toplPanel.removeAll();
			addComponentsToTopl(toplPanel);
			frame.getContentPane().remove(menuPanel);
			frame.getContentPane().add(toplPanel, BorderLayout.CENTER);
			frame.setVisible(true);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
	}

	static class ToplistaBackButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Toplista vissza gomb nyomás
			frame.getContentPane().remove(toplPanel);
			frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
			frame.setVisible(true);
			frame.invalidate();
			frame.validate();
			frame.repaint();
		}
	}}