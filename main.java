
public class main {
    public static void main(String[] args) {
        frame newFrame = new frame("LTO Tracker");

        CustomButton adminButton = newFrame.addButtonToBodyPanel("ADMIN", 400, 450, 300, 80);
        adminButton.addActionListener(e -> {
            AdminFrame userFrame = new AdminFrame();       
        });


        CustomButton userButton = newFrame.addButtonToBodyPanel("USER", 800, 450, 300, 80);

        userButton.addActionListener(e -> {  
            
        });


    }
}
