package IntroToHashMaps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	public static void main(String[] args) {
		new LogSearch();
	}
	HashMap<Integer, String> entries;
	JFrame frame;
	public LogSearch() {
		entries = new HashMap<>();
		frame = new JFrame() {{
			add(new JPanel() {{
				add(new JButton("Add Entry") {{
					addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String id = JOptionPane.showInputDialog("ID");
							try {
								entries.put(Integer.valueOf(id), JOptionPane.showInputDialog("Name"));
							} catch(Exception ex) {
								JOptionPane.showMessageDialog(frame, "ID must be a valid number");
							}
						}
					});
				}});
				add(new JButton("Lookup Entry") {{
					addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String id = JOptionPane.showInputDialog("ID");
							try {
								String result = entries.get(Integer.valueOf(id));
								JOptionPane.showMessageDialog(frame, result == null ? "Unknown ID" : result);
							} catch(Exception ex) {
								JOptionPane.showMessageDialog(frame, "ID must be a valid number");
							}
						}
					});
				}});
				add(new JButton("View Entries") {{
					addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String s = "";
							for(Entry<Integer, String> entry : entries.entrySet()) {
								s += String.format("ID: %-15s Name: %s", entry.getKey(), entry.getKey());
							}
							JOptionPane.showMessageDialog(frame, s.isEmpty() ? "No entries": s.replaceFirst("\n$", ""));
						}
					});
				}});
				add(new JButton("Remove Entry") {{
					addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								String name = entries.remove(Integer.valueOf(JOptionPane.showInputDialog("ID")));
								JOptionPane.showMessageDialog(frame, name == null ? "Unknown ID" : String.format("Removed %s", name));
							} catch(Exception ex) {
								JOptionPane.showMessageDialog(frame, "ID must be a valid number");
							}
							
						}
					});
				}});
			}});
			pack();
			setVisible(true);
		}};
	}
}
