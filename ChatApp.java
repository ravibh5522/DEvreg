import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatApp extends Frame {
    private TextField inputField;
    private TextArea chatArea;
    private OpenAIChat openAIChat;

    public ChatApp() {
        super("Chat with OpenAI");
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Initialize OpenAIChat
        openAIChat = new OpenAIChat();

        // Input field
        inputField = new TextField();
        inputField.addActionListener(new InputFieldListener());

        // Chat area
        chatArea = new TextArea();
        chatArea.setEditable(false);

        // Send button
        Button sendButton = new Button("Send");
        sendButton.addActionListener(new InputFieldListener());

        // Panel for input field and send button
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add components to the frame
        add(chatArea, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Set close operation
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private class InputFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userMessage = inputField.getText();
            chatArea.append("You: " + userMessage + "\n");

            // Get OpenAI response
            String assistantMessage = openAIChat.getOpenAIResponse(userMessage);
            chatArea.append("Assistant: " + assistantMessage + "\n");

            // Clear the input field
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        ChatApp chatApp = new ChatApp();
        chatApp.setVisible(true);
    }
}
