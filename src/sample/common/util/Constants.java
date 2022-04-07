package sample.common.util;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Constants {

    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((str != null) && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }

    public static boolean isNumber(String str)
    {
        return str.matches("[0-9]*");
    }

    public static void numericOnly(final TextField field) {
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    field.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
    public FXMLLoader loadPage(String page,String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Views/"+page+".fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        Image image = new Image("sample/common/icons/icons8-accounting-64.png");
        stage.getIcons().add(image);
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
        return loader;
    }

}
