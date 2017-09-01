package IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame;
	List<String> names;
	public static void main(String[] args) {
		new GuestBook();
	}
	public GuestBook() {
		names = new ArrayList<>();
		frame = new JFrame();
		frame.add(new JPanel() {{
			add(new JButton("Add Name") {{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						names.add(JOptionPane.showInputDialog("Name"));
					}
				});
			}});
			add(new JButton("View Names") {{
				addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s = "";
						for(String name : names) {
							s += name + "\n";
						}
						JOptionPane.showMessageDialog(frame, s.isEmpty() ?  "No names" : s.replaceFirst("\n$", ""));
					}
				});
			}});
		}});
		frame.pack();
		frame.setVisible(true);
	}
}
