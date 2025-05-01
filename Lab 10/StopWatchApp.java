import javax.swing.*;
import java.awt.*;

public class StopWatchApp extends JFrame {

    private int elapsedSeconds = 0;
    private Timer timer;
    private JLabel timeLabel;
    private JButton startBtn, stopBtn, resetBtn;

    public StopWatchApp() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Time display
        timeLabel = new JLabel("0", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        add(timeLabel, BorderLayout.CENTER);

        // Buttons
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        resetBtn = new JButton("Reset");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startBtn);
        buttonPanel.add(stopBtn);
        buttonPanel.add(resetBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // Timer updates every second
        timer = new Timer(1000, e -> {
            elapsedSeconds++;
            timeLabel.setText(String.valueOf(elapsedSeconds));
        });

        // Button actions
        startBtn.addActionListener(e -> {
            if (!timer.isRunning()) {
                timer.start();
            }
        });

        stopBtn.addActionListener(e -> timer.stop());

        resetBtn.addActionListener(e -> {
            timer.stop();
            elapsedSeconds = 0;
            timeLabel.setText("0");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StopWatchApp();
    }
}
