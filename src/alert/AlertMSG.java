package alert;

import javafx.scene.control.Alert;

public class AlertMSG {
        
        public static void sendAlert(String msg, String type) {
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                if (type == "error")
                        alert.setTitle("Falha!");
                
                else if (type == "success")
                        alert.setTitle("Sucesso!");
                
                alert.setContentText(" ");
                alert.setHeaderText(msg);
                alert.showAndWait();
        }
}
