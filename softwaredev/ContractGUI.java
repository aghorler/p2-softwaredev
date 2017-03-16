/* Aaron Horler - s3481341 */

package softwaredev;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.util.List;

@SuppressWarnings("serial")
public class ContractGUI extends JFrame implements ActionListener{
	//ArrayLists
	private ArrayList<Developer> developers;
	private ArrayList<Client> clients;
	private ArrayList<Team> teams;
	private ArrayList<Contract> contracts;
	
	//GUI components
	private JTabbedPane tabs;
	private JPanel pnlDeveloper, pnlDevInput, pnlDevDisplay, pnlDevButtons, pnlClient, pnlClientInput, pnlClientDisplay, pnlClientButtons, pnlTeam, pnlTeamInput, pnlTeamDisplay, pnlTeamButtons, 
	pnlContract, pnlContractInput, pnlContractDisplay, pnlContractButtons;
	private JScrollPane scrollDeveloperPanel, scrollClientPanel, scrollTeamPanel, scrollContractPanel;
	
	//Developer panel
	private JLabel lblDevName, lblDevEmail, lblDevPhone, lblExpertise, lblExperience;
	private JTextField txtDevName, txtDevEmail, txtDevPhone, txtExpertise, txtExperience;
	private JList<Developer> listDisplayDev;
	private DefaultListModel<Developer> modelDisplayDev;
	private JScrollPane scrollDevs;
	private JButton btnAddDeveloper, btnListDevlopers, btnRemoveDeveloper;
	
	//Client panel
	private JLabel lblClientName, lblClientEmail, lblClientPhone, lblIndustry, lblProjectName;
	private JTextField txtClientName, txtClientEmail, txtClientPhone, txtIndustry, txtProjectName;
	private JList<Client> listDisplayClient;
	private DefaultListModel<Client> modelDisplayClient;
	private JScrollPane scrollClients;
	private JButton btnAddClient, btnListClients, btnRemoveClient;
	
	//Team panel
	private JLabel lblTeamName, lblDateCreated;
	private JTextField txtTeamName, txtDateCreated;
	private JList<Developer> listDevSelection;
	private JList<Team> listDisplayTeam;
	private DefaultListModel<Developer> modelDevSelection;
	private DefaultListModel<Team> modelDisplayTeam;
	private JScrollPane scrollDevSelection, scrollTeams;
	private JButton btnAddTeam, btnShowDevelopers, btnListTeams, btnRemoveTeam;
	
	//Contract panel
	private JLabel lblContractCost, lblContractDuration;
	private JTextField txtContractCost, txtContractDuration;
	private JList<Client> listSelectClient;
	private JList<Team> listSelectTeam;
	private JList<Contract> listDisplayContract;
	private DefaultListModel<Client> modelSelectClient;
	private DefaultListModel<Team> modelSelectTeam;
	private DefaultListModel<Contract> modelDisplayContract;
	private JScrollPane scrollClientSelection, scrollTeamSelection, scrollContractDisplay;
	private JButton btnAddContract, btnShowClients, btnShowTeams, btnListContracts, btnRemoveContract, btnSaveContracts, btnReadContracts;
	
	//constructor
	public ContractGUI(){
		super("Contract GUI");
		developers = new ArrayList<Developer>();
		clients = new ArrayList<Client>();
		teams = new ArrayList<Team>();
		contracts = new ArrayList<Contract>();
		
		//Load Developers and Clients
		Developer d1 = new Developer("Ada Lovelace", "ada@lovelace.org", 1300123456, "Mathematics", 200);
		developers.add(d1);
		Developer d2 = new Developer("Linus Torvalds", "torvalds@linux-foundation.org", 157239709, "Linux kernal", 25);
		developers.add(d2);
		Developer d3 = new Developer("Steve Wozniak", "TeamWoz@Woz.org", 12345678, "C", 27);
		developers.add(d3);
		Client c1 = new Client("Jane Doe", "jane@gmail.com", 0400000001, "Real Estate", "Houses Online");
		clients.add(c1);
		Client c2 = new Client("Chris Pyne", "info@pyneonline.com.au", 84312277, "Government", "Redacted");
		clients.add(c2);
		
		//tabs
		tabs = new JTabbedPane();
		add(tabs);
		
		pnlDeveloper = new JPanel();
		pnlDeveloper.setLayout(new BorderLayout());
		pnlDeveloper.setPreferredSize(new Dimension(600, 700));
		scrollDeveloperPanel = new JScrollPane(pnlDeveloper);
		tabs.addTab("Developers", scrollDeveloperPanel);
		
		pnlClient = new JPanel();
		pnlClient.setLayout(new BorderLayout());
		pnlClient.setPreferredSize(new Dimension(600, 700));
		scrollClientPanel = new JScrollPane(pnlClient);
		tabs.addTab("Clients", scrollClientPanel);
		
		pnlTeam = new JPanel();
		pnlTeam.setLayout(new BorderLayout());
		pnlTeam.setPreferredSize(new Dimension(600, 700));
		scrollTeamPanel = new JScrollPane(pnlTeam);
		tabs.addTab("Teams", scrollTeamPanel);
		
		pnlContract = new JPanel();
		pnlContract.setLayout(new BorderLayout());
		pnlContract.setPreferredSize(new Dimension(600, 700));
		scrollContractPanel = new JScrollPane(pnlContract);
		tabs.addTab("Contracts", scrollContractPanel);
		
		//Developer input panel
		pnlDevInput = new JPanel();
		pnlDevInput.setLayout(new GridLayout(5, 1, 10, 10));
		pnlDevInput.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		lblDevName = new JLabel("Full name");
		lblDevEmail = new JLabel("Email: ");
		lblDevPhone = new JLabel("Phone: ");
		lblExpertise = new JLabel("Expertise: ");
		lblExperience = new JLabel("Experience: ");
		txtDevName = new JTextField(30);
		txtDevEmail = new JTextField(30);
		txtDevPhone = new JTextField(30);
		txtExpertise = new JTextField(30);
		txtExperience = new JTextField(30);
		pnlDevInput.add(lblDevName);
		pnlDevInput.add(txtDevName);
		pnlDevInput.add(lblDevEmail);
		pnlDevInput.add(txtDevEmail);
		pnlDevInput.add(lblDevPhone);
		pnlDevInput.add(txtDevPhone);
		pnlDevInput.add(lblExpertise);
		pnlDevInput.add(txtExpertise);
		pnlDevInput.add(lblExperience);
		pnlDevInput.add(txtExperience);
		pnlDeveloper.add(pnlDevInput, BorderLayout.NORTH);
		
		//Developer display panel
		pnlDevDisplay = new JPanel();
		modelDisplayDev = new DefaultListModel<Developer>();
		listDisplayDev = new JList<Developer>(modelDisplayDev);
		listDisplayDev.setBorder(new TitledBorder("List of Developers"));
		scrollDevs = new JScrollPane(listDisplayDev);
		scrollDevs.setPreferredSize(new Dimension(872, 525));
		pnlDevDisplay.add(scrollDevs);
		pnlDeveloper.add(pnlDevDisplay, BorderLayout.CENTER);
		
		//Developer button panel
		pnlDevButtons = new JPanel();
		btnAddDeveloper = new JButton("Add Developer");
		btnListDevlopers = new JButton("List Developers");
		btnRemoveDeveloper = new JButton("Remove Developer/s");
		pnlDevButtons.add(btnAddDeveloper);
		pnlDevButtons.add(btnListDevlopers);
		pnlDevButtons.add(btnRemoveDeveloper);
		pnlDeveloper.add(pnlDevButtons, BorderLayout.SOUTH);
		btnAddDeveloper.addActionListener(this);
		btnListDevlopers.addActionListener(this);
		btnRemoveDeveloper.addActionListener(this);
		
		//Client input panel
		pnlClientInput = new JPanel();
		pnlClientInput.setLayout(new GridLayout(5, 1, 10, 10));
		pnlClientInput.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		lblClientName = new JLabel("Full name: ");
		lblClientEmail = new JLabel("Email: ");
		lblClientPhone = new JLabel("Phone: ");
		lblIndustry = new JLabel("Industry: ");
		lblProjectName = new JLabel("Project name: ");
		txtClientName = new JTextField(30);
		txtClientEmail = new JTextField(30);
		txtClientPhone = new JTextField(30);
		txtIndustry = new JTextField(30);
		txtProjectName = new JTextField(30);
		pnlClientInput.add(lblClientName);
		pnlClientInput.add(txtClientName);
		pnlClientInput.add(lblClientEmail);
		pnlClientInput.add(txtClientEmail);
		pnlClientInput.add(lblClientPhone);
		pnlClientInput.add(txtClientPhone);
		pnlClientInput.add(lblIndustry);
		pnlClientInput.add(txtIndustry);
		pnlClientInput.add(lblProjectName);
		pnlClientInput.add(txtProjectName);
		pnlClient.add(pnlClientInput, BorderLayout.NORTH);
		
		//Client display panel
		pnlClientDisplay = new JPanel();
		modelDisplayClient = new DefaultListModel<Client>();
		listDisplayClient = new JList<Client>(modelDisplayClient);
		listDisplayClient.setBorder(new TitledBorder("List of Clients"));
		scrollClients = new JScrollPane(listDisplayClient);
		scrollClients.setPreferredSize(new Dimension(872, 525));
		pnlClientDisplay.add(scrollClients);
		pnlClient.add(pnlClientDisplay, BorderLayout.CENTER);
		
		//Client button panel
		pnlClientButtons = new JPanel();
		btnAddClient = new JButton("Add Client");
		btnListClients = new JButton("List Clients");
		btnRemoveClient = new JButton("Remove Client/s");
		pnlClientButtons.add(btnAddClient);
		pnlClientButtons.add(btnListClients);
		pnlClientButtons.add(btnRemoveClient);
		pnlClient.add(pnlClientButtons, BorderLayout.SOUTH);
		btnAddClient.addActionListener(this);
		btnListClients.addActionListener(this);
		btnRemoveClient.addActionListener(this);
		
		//Team input panel
		pnlTeamInput = new JPanel();
		pnlTeamInput.setLayout(new GridLayout(2, 1, 10, 10));
		pnlTeamInput.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		lblTeamName = new JLabel("Team name: ");
		lblDateCreated = new JLabel("Date created: ");
		txtTeamName = new JTextField(30);
		txtDateCreated = new JTextField(30);
		pnlTeamInput.add(lblTeamName);
		pnlTeamInput.add(txtTeamName);
		pnlTeamInput.add(lblDateCreated);
		pnlTeamInput.add(txtDateCreated);
		pnlTeam.add(pnlTeamInput, BorderLayout.NORTH);
		
		//Team display panel
		pnlTeamDisplay = new JPanel();
		modelDevSelection = new DefaultListModel<Developer>();
		listDevSelection = new JList<Developer>(modelDevSelection);
		listDevSelection.setBorder(new TitledBorder("Select Developers for team"));
		scrollDevSelection = new JScrollPane(listDevSelection);
		scrollDevSelection.setPreferredSize(new Dimension(872, 310));
		pnlTeamDisplay.add(scrollDevSelection);
		modelDisplayTeam = new DefaultListModel<Team>();
		listDisplayTeam = new JList<Team>(modelDisplayTeam);
		listDisplayTeam.setBorder(new TitledBorder("List of Teams"));
		scrollTeams = new JScrollPane(listDisplayTeam);
		scrollTeams.setPreferredSize(new Dimension(872, 310));
		pnlTeamDisplay.add(scrollTeams);
		pnlTeam.add(pnlTeamDisplay, BorderLayout.CENTER);
		
		//Team button panel
		pnlTeamButtons = new JPanel();
		btnShowDevelopers = new JButton("List Developers");
		btnAddTeam = new JButton("Add Team");
		btnListTeams = new JButton("List Teams");
		btnRemoveTeam = new JButton("Remove Team/s");
		pnlTeamButtons.add(btnShowDevelopers);
		pnlTeamButtons.add(btnAddTeam);
		pnlTeamButtons.add(btnListTeams);
		pnlTeamButtons.add(btnRemoveTeam);
		pnlTeam.add(pnlTeamButtons, BorderLayout.SOUTH);
		btnShowDevelopers.addActionListener(this);
		btnAddTeam.addActionListener(this);
		btnListTeams.addActionListener(this);
		btnRemoveTeam.addActionListener(this);
		
		//Contract input panel
		pnlContractInput = new JPanel();
		pnlContractInput.setLayout(new GridLayout(2, 1, 10, 10));
		pnlContractInput.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		lblContractCost = new JLabel("Cost: ");
		lblContractDuration = new JLabel("Duration: ");
		txtContractCost = new JTextField(30);
		txtContractDuration = new JTextField(30);
		pnlContractInput.add(lblContractCost);
		pnlContractInput.add(txtContractCost);
		pnlContractInput.add(lblContractDuration);
		pnlContractInput.add(txtContractDuration);
		pnlContract.add(pnlContractInput, BorderLayout.NORTH);
		
		//Contract display panel
		pnlContractDisplay = new JPanel();
		modelSelectClient = new DefaultListModel<Client>();
		listSelectClient = new JList<Client>(modelSelectClient);
		listSelectClient.setBorder(new TitledBorder("Select a Client"));
		scrollClientSelection = new JScrollPane(listSelectClient);
		scrollClientSelection.setPreferredSize(new Dimension(872, 200));
		pnlContractDisplay.add(scrollClientSelection);
		modelSelectTeam = new DefaultListModel<Team>();
		listSelectTeam = new JList<Team>(modelSelectTeam);
		listSelectTeam.setBorder(new TitledBorder("Select a Team"));
		scrollTeamSelection = new JScrollPane(listSelectTeam);
		scrollTeamSelection.setPreferredSize(new Dimension(872, 200));
		pnlContractDisplay.add(scrollTeamSelection);
		modelDisplayContract = new DefaultListModel<Contract>();
		listDisplayContract = new JList<Contract>(modelDisplayContract);
		listDisplayContract.setBorder(new TitledBorder("List of Contracts"));
		scrollContractDisplay = new JScrollPane(listDisplayContract);
		scrollContractDisplay.setPreferredSize(new Dimension(872, 200));
		pnlContractDisplay.add(scrollContractDisplay);
		pnlContract.add(pnlContractDisplay, BorderLayout.CENTER);
		
		//Contract button panel
		pnlContractButtons = new JPanel();
		btnAddContract = new JButton("Add Contract");
		btnShowClients = new JButton("Display Clients");
		btnShowTeams = new JButton("Display Teams");
		btnListContracts = new JButton("Display Contracts");
		btnRemoveContract = new JButton("Remove Contract/s");
		btnSaveContracts = new JButton("Save");
		btnReadContracts = new JButton("Read");
		pnlContractButtons.add(btnShowClients);
		pnlContractButtons.add(btnShowTeams);
		pnlContractButtons.add(btnAddContract);
		pnlContractButtons.add(btnListContracts);
		pnlContractButtons.add(btnRemoveContract);
		pnlContractButtons.add(btnSaveContracts);
		pnlContractButtons.add(btnReadContracts);
		pnlContract.add(pnlContractButtons, BorderLayout.SOUTH);
		btnAddContract.addActionListener(this);
		btnShowClients.addActionListener(this);
		btnShowTeams.addActionListener(this);
		btnListContracts.addActionListener(this);
		btnRemoveContract.addActionListener(this);
		btnSaveContracts.addActionListener(this);
		btnReadContracts.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnAddDeveloper){
			try{
				String devName = txtDevName.getText();
				String devEmail = txtDevEmail.getText();
				int devPhone = Integer.parseInt(txtDevPhone.getText());
				String devExpertise = txtExpertise.getText();
				int devExperience = Integer.parseInt(txtExperience.getText());
				
				Developer dv = new Developer(devName, devEmail, devPhone, devExpertise, devExperience);
				developers.add(dv);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(new JFrame(), ex, "Input Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == btnListDevlopers){
			modelDisplayDev.clear();
			for(Developer dev: developers){
				modelDisplayDev.addElement(dev);
			}
		}
		else if(e.getSource() == btnRemoveDeveloper){
			List<Developer> selected = listDisplayDev.getSelectedValuesList();
			for(Developer dev: selected){
				developers.remove(dev);
			}
			modelDisplayDev.clear();
			for(Developer dev: developers){
				modelDisplayDev.addElement(dev);
			}
		}
		else if(e.getSource() == btnAddClient){
			try{
				String clientName = txtClientName.getText();
				String clientEmail = txtClientEmail.getText();
				int clientPhone = Integer.parseInt(txtClientPhone.getText());
				String clientIndustry = txtIndustry.getText();
				String clientProjectName = txtProjectName.getText();
				
				Client cl = new Client(clientName, clientEmail, clientPhone, clientIndustry, clientProjectName);
				clients.add(cl);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(new JFrame(), ex, "Input Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == btnListClients){
			modelDisplayClient.clear();
			for(Client cl: clients){
				modelDisplayClient.addElement(cl);
			}
		}
		else if(e.getSource() == btnRemoveClient){
			List<Client> selected = listDisplayClient.getSelectedValuesList();
			for(Client cl: selected){
				clients.remove(cl);
			}
			modelDisplayClient.clear();
			for(Client cl: clients){
				modelDisplayClient.addElement(cl);
			}
		}
		else if(e.getSource() == btnShowDevelopers){
			modelDevSelection.clear();
			for(Developer dev: developers){
				modelDevSelection.addElement(dev);
			}
		}
		else if(e.getSource() == btnAddTeam){
			try{
				String teamName = txtTeamName.getText();
				String dateCreated = txtDateCreated.getText();
				
				Collection<Developer> selected = listDevSelection.getSelectedValuesList();
				
				Team te = new Team(teamName, dateCreated, selected);
				teams.add(te);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(new JFrame(), ex, "Input Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == btnListTeams){
			modelDisplayTeam.clear();
			for(Team te: teams){
				modelDisplayTeam.addElement(te);
			}
		}
		else if(e.getSource() == btnRemoveTeam){
			List<Team> selected = listDisplayTeam.getSelectedValuesList();
			for(Team te: selected){
				teams.remove(te);
			}
			modelDisplayTeam.clear();
			for(Team te: teams){
				modelDisplayTeam.addElement(te);
			}
		}
		else if(e.getSource() == btnShowClients){
			modelSelectClient.clear();
			for(Client cl: clients){
				modelSelectClient.addElement(cl);
			}
		}
		else if(e.getSource() == btnShowTeams){
			modelSelectTeam.clear();
			for(Team te: teams){
				modelSelectTeam.addElement(te);
			}
		}
		else if(e.getSource() == btnAddContract){
			try{
				double cost = Double.parseDouble(txtContractCost.getText());
				double duration = Double.parseDouble(txtContractDuration.getText());
				
				Client client = listSelectClient.getSelectedValue();
				Team team = listSelectTeam.getSelectedValue();
				
				Contract co = new Contract(cost, duration, client, team);
				contracts.add(co);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(new JFrame(), ex, "Input Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(e.getSource() == btnListContracts){
			modelDisplayContract.clear();
			for(Contract c: contracts){
				modelDisplayContract.addElement(c);
			}
		}
		else if(e.getSource() == btnRemoveContract){
			List<Contract> selected = listDisplayContract.getSelectedValuesList();
			for(Contract c: selected){
				contracts.remove(c);
			}
			modelDisplayContract.clear();
			for(Contract c: contracts){
				modelDisplayContract.addElement(c);
			}
		}
		else if(e.getSource() == btnSaveContracts){
			/* I assume, by this, you want just Contracts to be saved. */ 
			JFileChooser fileSaver = new JFileChooser();
			int returnValue = fileSaver.showSaveDialog(null);
			if(returnValue == JFileChooser.APPROVE_OPTION){
				File selectedFile = fileSaver.getSelectedFile();
				
				FileOutputStream fos = null;
				ObjectOutputStream oos = null;
			   
				try{
					fos = new FileOutputStream(selectedFile);
					oos = new ObjectOutputStream(fos);
			    
					for(Contract c: contracts){
						oos.writeObject(c);
					}
				}
				catch(Exception ex){
					System.err.println("Error in saving: " + ex.getMessage());
				}
				finally{
					try{
						fos.close();
						oos.close();
					}
					catch(Exception fe){
						System.err.println("Error: " + fe.getMessage());
					} 
				}
			}
		}
		else if(e.getSource() == btnReadContracts){
			/* Likewise, I assume you want just Contracts to be read. */
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);
			if(returnValue == JFileChooser.APPROVE_OPTION){
				File selectedFile = fileChooser.getSelectedFile();
				FileInputStream fis = null;
				ObjectInputStream ois = null;
			  
				try{
					fis = new FileInputStream(selectedFile);
					ois = new ObjectInputStream(fis);
			   
					Contract c = null;
					while(true){
						try{
							Object obj = ois.readObject();
							c = (Contract)obj;
							contracts.add(c);
						}
						catch(EOFException eofe){
							break;
						}
					}
				}
				catch(Exception ex){
					System.err.println("Error: " + ex.getMessage());
				}
				finally{
					try{
						fis.close();
						ois.close();
					}
					catch(Exception fe){
						System.err.println("Error: " + fe.getMessage());
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		ContractGUI fr = new ContractGUI();
		fr.setSize(920, 800); //This may be too large on a low resolution display. Tabs are scrollable, if that is the case.
		fr.setVisible(true);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
