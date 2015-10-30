import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {

    public JButton printCurrentStateButton;
    public JButton printPostsButton;
    public JButton printCurrentUsersButton;
    public JButton printPostsFromDateButton;
    public JButton deletePostButton;
    public JButton printUsersPostsButton;
    public JButton blockUserButton;
    public JButton unBlockUserButton;
    public JButton setGeoLocationButton;
    public JButton printUserButton;
    public JButton changeFileTypeButton;
    public JButton incorrectFileTypeButton;
    
    public JTextField getDate;
    public JTextField getPost;
    public JTextField getGeoLocation;
    
    JLabel title;
    JLabel dateLabel;
    JLabel userLabel;
    JLabel postLabel;
    JLabel spacer;
    JLabel spacer1;
    JLabel spacer2;
    JLabel spacer3;
    JLabel geoLocationLabel;
    JLabel fileTypeLabel;
    
    JComboBox<Post> postsComboBox = new JComboBox<Post>();
    JComboBox<User> userComboBox = new JComboBox<User>();
    JComboBox<User> userBlockComboBox = new JComboBox<User>();
    JComboBox<String> fileTypeComboBox = new JComboBox<String>();
    
    public GUI(){
        JFrame frame = new JFrame("Social Network GUI");
        //JPanel panel = new JPanel();
        frame.setLayout(new GridLayout(7, 3, 3, 3));
        
        dateLabel = new JLabel("Enter date: (e.g. 12/10/2015)");
        userLabel = new JLabel("Enter a username:");
        postLabel = new JLabel("Select a user then a post to peform various operations: ");
        spacer = new JLabel(" ");
        spacer1 = new JLabel(" ");
        spacer2 = new JLabel(" ");
        spacer3 = new JLabel(" ");
        geoLocationLabel = new JLabel("Enter Geo-Location: ");
        fileTypeLabel = new JLabel("Enter file type: (e.g. jpeg, mp3)");
        
        printCurrentStateButton = new JButton();
        printCurrentStateButton.setText("Print current state");
        
        printPostsButton = new JButton();
        printPostsButton.setText("Print all posts");
        //printPostsButton.setPreferredSize(new Dimension(50,50));
        
        printCurrentUsersButton =  new JButton();
        printCurrentUsersButton.setText("Print all users");
        
        printPostsFromDateButton = new JButton();
        printPostsFromDateButton.setText("Print posts from date");
        
        deletePostButton = new JButton();
        deletePostButton.setText("Delete Post");
        
        printUsersPostsButton = new JButton();
        printUsersPostsButton.setText("Print selected users posts");
        
        blockUserButton = new JButton();
        blockUserButton.setText("Block user from 2nd list \n by user from first list");
        
        unBlockUserButton = new JButton();
        unBlockUserButton.setText("Unblock");
        
        setGeoLocationButton = new JButton();
        setGeoLocationButton.setText("Set Geo-Location");
        
        printUserButton = new JButton();
        printUserButton.setText("Print user details");
        
        changeFileTypeButton = new JButton();
        changeFileTypeButton.setText("Change file type");
        
        incorrectFileTypeButton = new JButton();
        incorrectFileTypeButton.setText("Test user creating post with incorrect file type");
        
        getDate = new JTextField(10);
        getPost = new JTextField(10);
        getGeoLocation = new JTextField(10);
        
        for (Post p : SocialNetwork.getAllPosts()){
            postsComboBox.addItem(p);
        }
        postsComboBox.setSelectedItem(null);
        
        for (User u : SocialNetwork.getCurrentUsers()){
            userComboBox.addItem(u);
            userBlockComboBox.addItem(u);
        }
        userComboBox.setSelectedItem(null);
        userBlockComboBox.setSelectedItem("Choose user to block!");
        
        
        fileTypeComboBox.addItem("jpeg");
        fileTypeComboBox.addItem("png");
        fileTypeComboBox.addItem("gif");
        fileTypeComboBox.addItem("wav");
        fileTypeComboBox.addItem("mp3");
        fileTypeComboBox.addItem("wma");
        fileTypeComboBox.addItem("mp4");
        fileTypeComboBox.addItem("avi");
        fileTypeComboBox.setSelectedItem(null);
        
        frame.add(printCurrentStateButton);
        frame.add(printPostsButton);
        frame.add(printCurrentUsersButton);
        //frame.add(spacer);
        frame.add(dateLabel);
        frame.add(getDate);
        frame.add(printPostsFromDateButton);
        //frame.add(spacer1);
        
        //frame.add(spacer2);
        frame.add(postLabel);
        frame.add(userComboBox);
        frame.add(postsComboBox);
        frame.add(printUserButton);
        frame.add(printUsersPostsButton);
        frame.add(deletePostButton);
        frame.add(geoLocationLabel);
        frame.add(getGeoLocation);
        frame.add(setGeoLocationButton);
        frame.add(userBlockComboBox);
        frame.add(blockUserButton);
        frame.add(unBlockUserButton);
        frame.add(fileTypeComboBox);
        frame.add(changeFileTypeButton);
        frame.add(incorrectFileTypeButton);
        
        frame.setSize(1500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    public void updateComboBoxes(){
        postsComboBox.removeAllItems();
        for (Post p : SocialNetwork.getAllPosts()){
            postsComboBox.addItem(p);
        }
        
        userComboBox.removeAllItems();
        for (User u : SocialNetwork.getCurrentUsers()){
            userComboBox.addItem(u);
        }
    }
}
