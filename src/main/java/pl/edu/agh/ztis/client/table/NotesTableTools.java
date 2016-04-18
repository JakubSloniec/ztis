package pl.edu.agh.ztis.client.table;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.edu.agh.ztis.entity.TaggedNote;

/**
 * Created by kkicinger on 18/04/16.
 */
public class NotesTableTools {

    public static TableColumn createIdColumn() {
        return createColumn("ID", 100.0, "sourceId");
    }

    public static TableColumn createLanguageColumn() {
        return createColumn("Język", 100.0, "language");
    }

    public static TableColumn createCountryColumn() {
        return createColumn("Kraj", 100.0, "country");
    }

    public static TableColumn createMagazineColumn() {
        return createColumn("Czasopismo", 100.0, "magazine");
    }


    public static TableColumn createTimeColumn() {
        return createColumn("Data", 250.0, "time");
    }

    public static TableColumn createTitleColumn() {
        return createColumn("Tytuł", 300.0, "title");
    }

    public static TableColumn createContentColumn() {
        return createColumn("Treść", 400.0, "content");
    }

    private static TableColumn createColumn(String title, double minWidth, String property) {
        TableColumn column = new TableColumn<>();
        column.setText(title);
        column.setMinWidth(minWidth);
        column.setCellValueFactory(new PropertyValueFactory<TaggedNote, String>(property));
        return column;
    }

}
